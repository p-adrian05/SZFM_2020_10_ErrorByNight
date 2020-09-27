package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.extern.slf4j.Slf4j;
import org.example.game.GameService;
import org.example.game.GameServiceImpl;
import org.example.gamedb.GameState;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;


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

    private final GameService gameService = GameServiceImpl.getInstance();
    
    @FXML
    private void initialize(){
        log.debug("Loading saved games...");
        displayList();
    }

    private void displayList(){
        List<GameState> savedGames = gameService.getAllSavedGameStates();

        redPlayer.setCellValueFactory(new PropertyValueFactory<>("redPlayerName"));
        bluePlayer.setCellValueFactory(new PropertyValueFactory<>("bluePlayerName"));
        created.setCellValueFactory(new PropertyValueFactory<>("created"));

        created.setCellFactory(column -> {
            TableCell<GameState, ZonedDateTime> cell = new TableCell<>() {
                private final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

                @Override
                protected void updateItem(ZonedDateTime item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.format(formatter));
                    }
                }
            };
            return cell;
        });

        ObservableList<GameState> observableList = FXCollections.observableArrayList();
        observableList.addAll(savedGames);

        savedGamesTable.setItems(observableList);
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
