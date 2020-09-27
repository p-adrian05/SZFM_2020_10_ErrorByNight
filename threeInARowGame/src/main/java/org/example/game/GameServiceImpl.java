package org.example.game;

import org.example.gamedb.GameState;
import org.example.gamedb.GameStateDao;
import org.example.gamedb.GenericJpaDao;

public class GameServiceImpl implements GameService{


    private Player playerBlue;
    private Player playerRed;
    private Board gameState;
    private final GenericJpaDao<GameState> gameStateDao = GameStateDao.getInstance();
    private static final GameService gameService = new GameServiceImpl();

    private GameServiceImpl(){
        this.playerBlue = new PlayerImpl(Piece.BLUE.name(),Piece.BLUE);
        this.playerRed = new PlayerImpl(Piece.RED.name(),Piece.RED);
        this.gameState = new BoardImpl();
    }

    public static GameService getInstance(){
        return gameService;
    }

    @Override
    public String getWinnerName(){
        if(getTurnPlayerName().equals(playerBlue.getName())){
            return playerRed.getName();
        }
        return playerBlue.getName();
    }

    @Override
    public boolean gameOver(){
        return GameUtils.isEnd(gameState.getBoardState());
    }
    @Override
    public Piece[][] getBoardData(){
        return gameState.getBoardState();
    }
    @Override
    public Piece getNextTurn(){
        return gameState.getTurn();
    }
}
