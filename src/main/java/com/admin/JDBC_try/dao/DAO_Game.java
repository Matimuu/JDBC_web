package com.admin.JDBC_try.dao;

import com.admin.JDBC_try.model.Game;
import java.util.List;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/02 00:37
 */
public interface DAO_Game {
    int addGame(Game g);

    int updateGame(Game g);

    int deleteGame(int id);

    Game getGameById(int id);

    List<Game> getAllGames();
}
