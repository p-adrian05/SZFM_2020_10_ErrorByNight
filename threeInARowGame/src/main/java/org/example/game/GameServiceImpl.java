package org.example.game;

import org.example.gamedb.GameState;
import org.example.gamedb.GameStateDao;
import org.example.gamedb.GenericJpaDao;

import java.security.spec.ECField;
import java.util.List;
import java.util.Optional;

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
    public String getTurnPlayerName(){
        String turnPlayerName = playerBlue.getName();
        if(this.gameState.getTurn().equals(Piece.RED)){
            turnPlayerName = playerRed.getName();
        }
        return turnPlayerName;
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

    @Override
    public List<Direction> getPossibleMoves(int clickedRow,int clickedColumn){
        return GameUtils.whereToMove(clickedRow, clickedColumn,gameState.getBoardState());
    }
    @Override
    public void movePieceTo(int clickedRow, int clickedColumn, Direction direction)throws IllegalArgumentException{
        List<Direction> directions = GameUtils.whereToMove(clickedRow, clickedColumn,gameState.getBoardState());
        if(gameState.getBoardState()[clickedRow][clickedColumn]!=gameState.getTurn()){
            throw new IllegalArgumentException();
        }
        if(!directions.contains(direction)){
            throw new IllegalArgumentException();
        }
        gameState.swapPieces(clickedRow, clickedColumn, direction);
        gameState.nextTurn();
    }

    @Override
    public void setPlayersName(String playerRed, String playerBlue){
        this.playerBlue.setName(playerBlue);
        this.playerRed.setName(playerRed);
    }

    public List<GameState> getAllSavedGameStates(){
        return gameStateDao.findAll();
    }

    @Override
    public boolean loadState(GameState savedGameState) {
        try{
            gameState = new BoardImpl(GameUtils.makeValidBoard(savedGameState.getState()));
            setPlayersName(savedGameState.getRedPlayerName(), savedGameState.getBluePlayerName());
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }
}
