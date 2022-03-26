package ru.skubatko.dev.skillsmart.ooap3.services;

import ru.skubatko.dev.skillsmart.ooap3.domain.Book;
import ru.skubatko.dev.skillsmart.ooap3.domain.User;
import ru.skubatko.dev.skillsmart.ooap3.domain.UserBook;
import ru.skubatko.dev.skillsmart.ooap3.repositories.UserBookRepository;

import java.util.concurrent.atomic.AtomicLong;

public class LibraryService {
    private final UserBookRepository userBookRepository;

    private static final AtomicLong currentId = new AtomicLong();

    public LibraryService(UserBookRepository userBookRepository) {
        this.userBookRepository = userBookRepository;
    }

    public void giveBook(User manager, User reader, Book book){
        userBookRepository.save(currentId.incrementAndGet(),new UserBook(manager.getId(), reader.getId(), book.getId()));
    }

    public void takeBook(User reader, Book book) {
        userBookRepository.deleteByReaderAndBook(reader.getId(), book.getId());
    }
}
