package ru.skubatko.dev.skillsmart.ooap3;

import ru.skubatko.dev.skillsmart.ooap3.domain.User;
import ru.skubatko.dev.skillsmart.ooap3.reporting.Report;
import ru.skubatko.dev.skillsmart.ooap3.reporting.ReportGenerator;
import ru.skubatko.dev.skillsmart.ooap3.reporting.strategy.DailyReportStrategy;
import ru.skubatko.dev.skillsmart.ooap3.repositories.Repository;
import ru.skubatko.dev.skillsmart.ooap3.repositories.UserRepository;
import ru.skubatko.dev.skillsmart.ooap3.services.UserFactory;

public class LibraryApp {

    public static void main(String[] args) {
        UserFactory.INSTANCE.build("admin");
        User admin = UserFactory.INSTANCE.get();
        System.out.println("user created: " + admin);

        Repository<User, Long> userRepository = new UserRepository();
        userRepository.save(1L, admin);
        System.out.println("user persisted: " + admin);

        ReportGenerator.INSTANCE.generate(new DailyReportStrategy());
        Report report = ReportGenerator.INSTANCE.getReport();
        System.out.println("report built: " + report);
    }
}
