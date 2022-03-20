package ru.skubatko.dev.skillsmart.ooap3.reporting.strategy;

import ru.skubatko.dev.skillsmart.ooap3.reporting.Report;

public abstract class AbstractReportStrategy implements ReportStrategy {

    private int getReportStatus = GET_REPORT_NIL;
    protected int buildReportStatus = BUILD_REPORT_NIL;

    protected Report report;

    @Override
    public Report getReport() {
        if (buildReportStatus == BUILD_REPORT_OK) {
            getReportStatus = GET_REPORT_OK;
            return report;
        } else {
            getReportStatus = GET_REPORT_ERR;
            return null;
        }
    }

    @Override
    public int getGetReportStatus() {
        return getReportStatus;
    }

    @Override
    public int getBuildReportStatus() {
        return buildReportStatus;
    }
}
