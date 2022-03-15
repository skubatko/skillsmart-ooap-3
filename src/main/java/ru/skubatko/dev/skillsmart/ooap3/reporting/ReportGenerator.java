package ru.skubatko.dev.skillsmart.ooap3.reporting;

public abstract class ReportGenerator {

    // >> запросы
    // предусловие: отчёт подготовлен
    public abstract Report get();

    // >> команды
    // постусловие: создан отчёт
    public abstract void generate(ReportStrategy reportStrategy);

    // >> запросы статусов
    public abstract int getGetStatus(); // успешно / пользователь не был создан

    public abstract int getGenerateStatus(); // отчёт не создан / отчёт создан
}
