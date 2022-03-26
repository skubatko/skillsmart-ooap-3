package ru.skubatko.dev.skillsmart.ooap3;

import ru.skubatko.dev.skillsmart.ooap3.domain.Book;
import ru.skubatko.dev.skillsmart.ooap3.domain.User;
import ru.skubatko.dev.skillsmart.ooap3.reporting.Report;
import ru.skubatko.dev.skillsmart.ooap3.reporting.ReportGenerator;
import ru.skubatko.dev.skillsmart.ooap3.reporting.strategy.DailyReportStrategy;
import ru.skubatko.dev.skillsmart.ooap3.repositories.BookRepository;
import ru.skubatko.dev.skillsmart.ooap3.repositories.Repository;
import ru.skubatko.dev.skillsmart.ooap3.repositories.UserBookRepository;
import ru.skubatko.dev.skillsmart.ooap3.repositories.UserRepository;
import ru.skubatko.dev.skillsmart.ooap3.services.LibraryService;
import ru.skubatko.dev.skillsmart.ooap3.services.UserFactory;

public class LibraryApp {

    public static void main(String[] args) {
        System.out.println("### Users factory ###");
        UserFactory.INSTANCE.build("admin");
        User admin = UserFactory.INSTANCE.get();
        System.out.println("user created: " + admin);

        UserFactory.INSTANCE.build("manager");
        User manager = UserFactory.INSTANCE.get();
        System.out.println("user created: " + manager);

        UserFactory.INSTANCE.build("reader");
        User reader = UserFactory.INSTANCE.get();
        System.out.println("user created: " + reader);

        System.out.println("\n### Users persistence ###");
        Repository<User, Long> userRepository = new UserRepository();
        userRepository.save(1L, admin);
        System.out.println("user persisted: " + admin);
        userRepository.save(2L, manager);
        System.out.println("user persisted: " + manager);
        userRepository.save(3L, reader);
        System.out.println("user persisted: " + reader);

        System.out.println(">> all users: " + userRepository.findAll());

        System.out.println("\n### Books persistence ###");
        Repository<Book, Long> bookRepository = new BookRepository();
        Book book1 = new Book("Ворона и лисица", "Крылов");
        bookRepository.save(1L, book1);
        System.out.println("book1 persisted: " + book1);
        Book book2 = new Book("Война и мир", "Толстой");
        bookRepository.save(2L, book2);
        System.out.println("book1 persisted: " + book2);

        System.out.println(">> all books: " + bookRepository.findAll());

        System.out.println("\n### Library service ###");
        UserBookRepository userBookRepository = new UserBookRepository();
        LibraryService libraryService = new LibraryService(userBookRepository);
        System.out.println("books at readers: " + (long) userBookRepository.findAll().size());
        libraryService.giveBook(manager, reader, book2);
        System.out.println("book: " + book2 + " is given to " + reader + " by " + manager);
        System.out.println("books at readers: " + (long) userBookRepository.findAll().size());
        libraryService.takeBook(reader, book2);
        System.out.println("book: " + book2 + " is taken from " + reader);
        System.out.println("books at readers: " + (long) userBookRepository.findAll().size());

        System.out.println("\n### Report generator ###");
        ReportGenerator.INSTANCE.generate(new DailyReportStrategy());
        Report report = ReportGenerator.INSTANCE.getReport();
        System.out.println("report built: " + report);
    }
}
