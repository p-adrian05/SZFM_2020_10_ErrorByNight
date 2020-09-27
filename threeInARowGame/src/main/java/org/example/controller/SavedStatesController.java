package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.extern.slf4j.Slf4j;
import org.example.gamedb.GameState;
import java.time.ZonedDateTime;


@Slf4j
public class SavedStatesController {
    @FXML
    private TableView<GameState> savedGamesTable;

    @FXML
    private TableColumn<GameState, String> redPlayer;

    @FXML
    private TableColumn<GameState, String> bluePlayer;

    @FXML
    private TableColumn<GameState, ZonedDateTime> created;
    @FXML
    private Button loadButton;

    @FXML
    private void initialize(){
        log.debug("Loading saved games...");
        displayList();
    }

    private void displayList(){
    }

    @FXML
    private void deleteSelectedGame() {
    }

    @FXML
    public void loadSelectedGame(){
    }
    @FXML
    public void backBtnClicked(ActionEvent actionEvent) {
    }
}
