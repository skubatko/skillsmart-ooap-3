package ru.skubatko.dev.skillsmart.ooap3.repositories;

import ru.skubatko.dev.skillsmart.ooap3.domain.Book;

public class BookRepository extends Repository<Book, Long> {

    @Override
    public void save(Long id, Book entity) {
        entity.setId(id);
        super.save(id, entity);
    }
}
