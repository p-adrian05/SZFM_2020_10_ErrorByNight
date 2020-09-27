package org.example.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

import java.util.List;


@Slf4j
public class GameController {


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
    public void initialize() {
        displayGameState();
    }
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
    private void initImages(){
        red = new Image(getClass().getResource("/images/red.png").toExternalForm());
        blue = new Image(getClass().getResource("/images/blue.png").toExternalForm());
        empty = new Image(getClass().getResource("/images/empty.png").toExternalForm());
        pmoves = new Image(getClass().getResource("/images/possibleMove.png").toExternalForm());
    }

    @FXML
    public void savedBtnClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void savedGameStatesBtnClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void newGameBtnClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void addNamesBtnClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void continueButtonClicked()  {

    }
}
