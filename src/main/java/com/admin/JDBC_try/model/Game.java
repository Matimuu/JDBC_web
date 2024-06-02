package com.admin.JDBC_try.model;

import java.sql.Date;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/02 00:32
 */
public class Game {
    int id;
    String title;
    String genre;
    Float price;
    Date releaseDate;

    public Game(int id, String title, String genre, Float price, Date date) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.releaseDate = date;
    }
    public Game() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date date) {
        this.releaseDate = date;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", date=" + releaseDate +
                '}';
    }
}
