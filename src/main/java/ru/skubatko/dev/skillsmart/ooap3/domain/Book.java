package ru.skubatko.dev.skillsmart.ooap3.domain;

import java.util.Objects;

public class Book {
    private Long id;
    private String name;
    private String author;

    // конструктор
    public Book(Long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof Book)) {return false;}

        Book book = (Book) o;

        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", author='" + author + '\'' +
            '}';
    }
}
