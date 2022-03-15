package ru.skubatko.dev.skillsmart.ooap3.domain;

public class Book {
    private Long id;
    private String name;
    private String author;


    // >> запросы
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }


    // >> команды
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
