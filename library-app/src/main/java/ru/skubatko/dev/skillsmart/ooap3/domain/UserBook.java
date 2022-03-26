package ru.skubatko.dev.skillsmart.ooap3.domain;

import java.util.Objects;

public class UserBook {
    private Long id;
    private Long managerId;
    private Long readerId;
    private Long bookId;

    // конструктор
    public UserBook(Long managerId, Long readerId, Long bookId) {
        this.managerId = managerId;
        this.readerId = readerId;
        this.bookId = bookId;
    }

    // >> запросы
    public Long getId() {
        return id;
    }

    public Long getManagerId() {
        return managerId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public Long getBookId() {
        return bookId;
    }

    // >> команды
    public void setId(Long id) {
        this.id = id;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof UserBook)) {return false;}

        UserBook book = (UserBook) o;

        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserBook{" +
            "id=" + id +
            ", managerId=" + managerId +
            ", readerId=" + readerId +
            ", bookId=" + bookId +
            '}';
    }
}
