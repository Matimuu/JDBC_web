package com.admin.JDBC_try.dao;

import com.admin.JDBC_try.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Mendoza Perez Omar Enrique
* @date 2024/06/02 00:50
*/
@Repository
public class DAO_Game_Impl implements DAO_Game{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addGame(Game game) {
        String sql = "INSERT INTO Game (title, genre, price, release_date) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, game.getTitle(), game.getGenre(), game.getPrice(), game.getReleaseDate());
    }

    @Override
    public int updateGame(Game game) {
        String sql = "UPDATE Game SET title = ?, genre = ?, price = ?, release_date = ? WHERE game_id = ?";
        return jdbcTemplate.update(sql, game.getTitle(), game.getGenre(), game.getPrice(), game.getReleaseDate(), game.getId());
    }

    @Override
    public int deleteGame(int gameId) {
        String sql = "DELETE FROM Game WHERE game_id = ?";
        return jdbcTemplate.update(sql, gameId);
    }

    @Override
    public Game getGameById(int gameId) {
        String sql = "SELECT * FROM Game WHERE game_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Game.class), gameId);
    }

    @Override
    public List<Game> getAllGames() {
        String sql = "SELECT * FROM Game";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Game.class));
    }
}
