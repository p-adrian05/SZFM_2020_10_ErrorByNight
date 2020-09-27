package org.example.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import lombok.extern.slf4j.Slf4j;
import org.example.game.Direction;
import org.example.game.GameService;
import org.example.game.GameServiceImpl;
import org.example.game.Piece;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


@Slf4j
public class GameController implements Initializable {


    @FXML
    private Label turnLabel;
    @FXML
    private GridPane gameGrid;
    @FXML
    private Button saveBtn;
    @FXML
    private Pane addNamesPane;
    @FXML
    private TextField redPlayerName;
    @FXML
    private TextField bluePlayerName;
    @FXML
    private Button continueButton;
    @FXML
    private Label errorLabel;

    private final GameService gameService = GameServiceImpl.getInstance();
    private List<Direction> possibleMoves;
    private boolean isHighlighted = false;
    private int clickedRow, clickedColumn;
    private Image red, blue, empty, pmoves;

    @FXML
    public void handleMovement(MouseEvent mouseEvent){
        if(!gameService.gameOver()){
            handleClicks(mouseEvent);
        } else{
            handleGameEnding();
        }
    }
    private void handleClicks(MouseEvent mouseEvent){
        if(isHighlighted) {
            handleClickIfIsHighlighted(mouseEvent);
        } else{
            highlightLegalMoves(mouseEvent);
        }
    }

    private void handleClickIfIsHighlighted(MouseEvent mouseEvent){
        Node source = (Node) mouseEvent.getSource();
        int row = GridPane.getRowIndex(source);
        int column = GridPane.getColumnIndex(source);
        for(Direction direction:possibleMoves){
            if(row == clickedRow+direction.getDx() && column == clickedColumn+direction.getDy()){
                move(direction);
                break;
            }
            eraseHighlight();
        }
    }

    private void move(Direction direction){
        try {
            gameService.movePieceTo(clickedRow, clickedColumn, direction);
        }catch (IllegalArgumentException e){
            log.error(e.getMessage());
        }
        displayGameState();
        isHighlighted = false;
        if(gameService.gameOver()){
            handleGameEnding();
        }else{
            saveBtn.setDisable(false);
            setTurnLabel(gameService.getTurnPlayerName());
        }
    }

    private void highlightLegalMoves(MouseEvent mouseEvent){
        Node source = (Node) mouseEvent.getSource();
        clickedRow = GridPane.getRowIndex(source);
        clickedColumn = GridPane.getColumnIndex(source);
        log.debug("Cell ({}, {}) is pressed", clickedRow, clickedColumn);
        Piece piece = gameService.getBoardData()[clickedRow][clickedColumn];
        if(!piece.equals(Piece.EMPTY) && piece.equals(gameService.getNextTurn())) {
            possibleMoves = gameService.getPossibleMoves(clickedRow,clickedColumn);
            for (Direction direction : possibleMoves) {
                ImageView view = (ImageView) gameGrid.getChildren().get((clickedRow + direction.getDx()) * 4 + clickedColumn + direction.getDy());
                view.setImage(pmoves);
            }
            isHighlighted = true;
        }
    }

    private void eraseHighlight(){
        for (Direction direction : possibleMoves) {
            ImageView view = (ImageView) gameGrid.getChildren().get((clickedRow + direction.getDx()) * 4 + clickedColumn + direction.getDy());
            view.setImage(empty);
        }
        isHighlighted = false;
    }

    public void displayGameState() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                ImageView view = (ImageView) gameGrid.getChildren().get(i * 4 + j);
                if (view.getImage() != null) {
                    log.trace("Image({}, {}) = {}", i, j, view.getImage().getUrl());
                }
                if(gameService.getBoardData()[i][j].equals(Piece.RED)) {
                    view.setImage(red);
                }else if(gameService.getBoardData()[i][j].equals(Piece.BLUE)){
                    view.setImage(blue);
                } else {
                    view.setImage(empty);
                }
            }
        }
    }
    private void handleGameEnding(){
        String winnerName = gameService.getWinnerName();
        turnLabel.setText(winnerName+" Nyertes");
        log.info("{} nyert.", winnerName);
    }
    private void setTurnLabel(String playerName){
        turnLabel.setText(playerName + " következik");
    }
    private void initImages(){
        red = new Image(getClass().getResource("/images/red.png").toExternalForm());
        blue = new Image(getClass().getResource("/images/blue.png").toExternalForm());
        empty = new Image(getClass().getResource("/images/empty.png").toExternalForm());
        pmoves = new Image(getClass().getResource("/images/possibleMove.png").toExternalForm());
    }

    @FXML
    public void savedBtnClicked(ActionEvent actionEvent) {
        if(gameService.saveGameState()){
            saveBtn.setDisable(true);
        }else{
          addNamesBtnClicked();
        }
    }
    @FXML
    public void savedGameStatesBtnClicked(ActionEvent actionEvent) {
        try {
            ThreeInARowApplication.setRoot("savedGames");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void newGameBtnClicked(ActionEvent actionEvent) {
        gameService.reset();
        initialize();
    }
    @FXML
    public void addNamesBtnClicked(ActionEvent actionEvent) {
        addNamesPane.setDisable(false);
        addNamesPane.setVisible(true);
    }

    @FXML
    public void continueButtonClicked()  {
        if(redPlayerName.getText().isEmpty() || bluePlayerName.getText().isEmpty()){
            errorLabel.setText("Enter your names!!");
        } else{
            gameService.setPlayersName(redPlayerName.getText(),bluePlayerName.getText());
            addNamesPane.setDisable(true);
            addNamesPane.setVisible(false);
            setTurnLabel(gameService.getTurnPlayerName());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initImages();
        setTurnLabel(gameService.getTurnPlayerName());
        displayGameState();
    }
}
