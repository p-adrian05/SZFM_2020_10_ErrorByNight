package org.example.gamedb;

import javax.persistence.Persistence;

public class GameStateDao extends GenericJpaDao<GameState>{

    private GameStateDao() {
        super(GameState.class);
    }
    private static GameStateDao instance;

    public static GameStateDao getInstance() {
        if (instance == null) {
            instance = new GameStateDao();
            instance.setEntityManager(Persistence.createEntityManagerFactory("threeInARowGame").createEntityManager());
        }
        return instance;
    }
}
