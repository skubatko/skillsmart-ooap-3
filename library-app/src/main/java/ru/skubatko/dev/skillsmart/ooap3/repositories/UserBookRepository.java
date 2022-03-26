package ru.skubatko.dev.skillsmart.ooap3.repositories;

import ru.skubatko.dev.skillsmart.ooap3.domain.UserBook;

import java.util.Objects;

public class UserBookRepository extends Repository<UserBook, Long> {

    @Override
    public void save(Long id, UserBook entity) {
        entity.setId(id);
        super.save(id, entity);
    }

    public void deleteByReaderAndBook(Long readerId, Long bookId) {
        storage.values().stream()
            .filter(userBook -> Objects.equals(userBook.getReaderId(), readerId) &&
                Objects.equals(userBook.getBookId(), bookId))
            .findFirst()
            .ifPresent(it -> storage.remove(it.getId()));
    }
}
