package org.example.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import lombok.extern.slf4j.Slf4j;
import org.example.game.Direction;
import org.example.game.GameService;
import org.example.game.GameServiceImpl;

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

    private void displayGameState() {
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
