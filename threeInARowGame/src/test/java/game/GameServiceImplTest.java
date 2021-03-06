package game;

import org.example.game.*;
import org.example.gamedb.GameState;
import org.example.gamedb.GameStateDao;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceImplTest {

    GameService gameService = GameServiceImpl.getInstance();

    @Test
    void getWinnerName() {
        gameService.reset();
        assertEquals(Piece.RED.name(),gameService.getWinnerName());
    }

    @Test
    void getTurnPlayerName() {
        gameService.reset();
        assertEquals(Piece.BLUE.name(),gameService.getTurnPlayerName());
        gameService.movePieceTo(0,0,Direction.DOWN);
        assertEquals(Piece.RED.name(),gameService.getTurnPlayerName());
    }

    @Test
    void movePieceTo() {
        gameService.reset();
        gameService.movePieceTo(0,0,Direction.DOWN);
        Board board = new BoardImpl();
        board.swapPieces(0,0,Direction.DOWN);
        assertTrue(equalsBoardState(gameService.getBoardData(),board.getBoardState()));
    }

    public boolean equalsBoardState(Piece[][] board1, Piece[][] board2){
        for(int i=0;i<5;i++){
            for(int j=0; j<4; j++){
                if(!(board1[i][j] == board2[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    void setPlayersName() {
        gameService.reset();
        gameService.setPlayersName("Player1","Player2");
        assertEquals("Player2",gameService.getTurnPlayerName());
    }

    @Test
    void loadState() {
        gameService.reset();
        GameState gameState = GameState.builder()
                .bluePlayerName("Player1")
                .redPlayerName("Player2")
                .created(null).id(999L).state("21210000000000001212").build();
        gameService.loadState(gameState);
        Board board = new BoardImpl();
        assertTrue(equalsBoardState(gameService.getBoardData(),board.getBoardState()));
        assertEquals(gameService.getTurnPlayerName(),"Player1");
    }
    
}