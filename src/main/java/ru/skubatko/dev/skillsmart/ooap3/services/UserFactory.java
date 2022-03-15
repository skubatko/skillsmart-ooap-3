package ru.skubatko.dev.skillsmart.ooap3.services;

import ru.skubatko.dev.skillsmart.ooap3.domain.User;

public abstract class UserFactory {

    // >> запросы
    // предусловие: пользователь создан
    public abstract User get();


    // >> команды
    // постусловие: создан пользователь заданного типа
    public abstract void build(String type);


    // >> запросы статусов
    public abstract int getGetStatus(); // успешно / пользователь не был создан

    public abstract int getBuildStatus(); // пользователь не создан / пользователь создан
}
