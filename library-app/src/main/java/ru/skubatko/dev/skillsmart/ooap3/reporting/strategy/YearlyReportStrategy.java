package ru.skubatko.dev.skillsmart.ooap3.reporting.strategy;

import ru.skubatko.dev.skillsmart.ooap3.reporting.Report;

public class YearlyReportStrategy extends AbstractReportStrategy {

    @Override
    public void buildReport() {
        report = new Report("Yearly report");
        buildReportStatus = BUILD_REPORT_OK;
    }
}
