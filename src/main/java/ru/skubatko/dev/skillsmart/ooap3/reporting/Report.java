package ru.skubatko.dev.skillsmart.ooap3.reporting;

public class Report {
    private String name;
    private String content;


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
}
