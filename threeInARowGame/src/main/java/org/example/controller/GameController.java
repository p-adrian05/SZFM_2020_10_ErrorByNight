package org.example.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import lombok.extern.slf4j.Slf4j;


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
    @FXML
    public void initialize() {
        displayGameState();
    }
    @FXML
    public void handleMovement(MouseEvent mouseEvent){
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
