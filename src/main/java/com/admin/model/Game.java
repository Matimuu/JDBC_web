package com.admin.model;

import java.sql.Date;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/01 17:34
 */
public class Game {
    private Integer game_id;
    private String title;
    private String genre;
    private Float price;
    private Date release_date;

    public Game(Integer game_id, String title, String genre, Float price, Date release_date) {
        this.game_id = game_id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.release_date = release_date;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Float getPrice() {
        return price;
    }

    public Date getRelease_date() {
        return release_date;
    }
}
