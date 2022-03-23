package ru.skubatko.dev.skillsmart.ooap3.reporting;

import ru.skubatko.dev.skillsmart.ooap3.reporting.strategy.ReportStrategy;

public class ReportGenerator {

    public static final ReportGenerator INSTANCE = new ReportGenerator();

    private Report report;

    private int getReportStatus = GET_REPORT_NIL;
    private int generateStatus = GENERATE_NIL;

    static final int GET_REPORT_NIL = 0;
    static final int GET_REPORT_OK = 1;
    static final int GET_REPORT_ERR = 2;

    static final int GENERATE_NIL = 0;
    static final int GENERATE_OK = 1;
    static final int GENERATE_ERR = 2;

    private ReportGenerator() {}


    // >> запросы
    // предусловие: отчёт подготовлен
    public Report getReport() {
        if (generateStatus == GENERATE_OK) {
            getReportStatus = GET_REPORT_OK;
            return report;
        } else {
            getReportStatus = GET_REPORT_ERR;
            return null;
        }
    }


    // >> команды
    // постусловие: создан отчёт
    public void generate(ReportStrategy reportStrategy) {
        reportStrategy.buildReport();
        report = reportStrategy.getReport();
        if (reportStrategy.getGetReportStatus() == ReportStrategy.GET_REPORT_OK) {
            generateStatus = GENERATE_OK;
        } else {
            generateStatus = GENERATE_ERR;
        }
    }


    // >> запросы статусов
    // успешно / пользователь не был создан
    public int getGetReportStatus() {
        return getReportStatus;
    }

    // отчёт не создан / отчёт создан
    public int getGenerateStatus() {
        return generateStatus;
    }
}
