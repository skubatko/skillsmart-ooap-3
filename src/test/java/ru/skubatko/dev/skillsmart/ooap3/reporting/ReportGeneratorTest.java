package ru.skubatko.dev.skillsmart.ooap3.reporting;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ru.skubatko.dev.skillsmart.ooap3.reporting.ReportGenerator.GENERATE_OK;
import static ru.skubatko.dev.skillsmart.ooap3.reporting.ReportGenerator.GET_REPORT_OK;

import ru.skubatko.dev.skillsmart.ooap3.reporting.strategy.MonthlyReportStrategy;
import ru.skubatko.dev.skillsmart.ooap3.reporting.strategy.ReportStrategy;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Генератор отчётов")
class ReportGeneratorTest {

    private final ReportGenerator reportGenerator = ReportGenerator.INSTANCE;

    @DisplayName("должен генерировать ожидаемый отчёт")
    @SneakyThrows
    @Test
    void shouldGenerateExpectedReport() {
        // given
        ReportStrategy reportStrategy = new MonthlyReportStrategy();

        // when
        reportGenerator.generate(reportStrategy);

        // then
        assertThat(reportGenerator.getGenerateStatus()).isEqualTo(GENERATE_OK);

        Report expected = reportGenerator.getReport();
        assertThat(reportGenerator.getGetReportStatus()).isEqualTo(GET_REPORT_OK);
        assertThat(expected.getName()).isEqualTo("Monthly report");
    }
}
