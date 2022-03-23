package ru.skubatko.dev.skillsmart.ooap3.reporting;

public class Report {
    private String name;
    private String content;

    // конструктор
    public Report(String name) {
        this.name = name;
    }

    // >> запросы
    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }


    // >> команды
    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Report{" +
            "name='" + name + '\'' +
            '}';
    }
}
