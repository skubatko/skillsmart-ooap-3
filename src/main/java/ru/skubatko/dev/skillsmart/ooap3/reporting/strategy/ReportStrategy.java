package ru.skubatko.dev.skillsmart.ooap3.reporting.strategy;

import ru.skubatko.dev.skillsmart.ooap3.reporting.Report;

public interface ReportStrategy {

    int GET_REPORT_NIL = 0;
    int GET_REPORT_OK = 1;
    int GET_REPORT_ERR = 2;

    int BUILD_REPORT_NIL = 0;
    int BUILD_REPORT_OK = 1;
    int BUILD_REPORT_ERR = 2;


    // >> запросы
    // предусловие: отчёт создан
    Report getReport();


    // >> команды
    // постусловие: создан отчёт
    void buildReport();


    // >> запросы статусов
    // успешно / отчёт не был создан
    int getGetReportStatus();

    int getBuildReportStatus(); // отчёт не создан / отчёт создан
}
