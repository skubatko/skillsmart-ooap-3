package ru.skubatko.dev.skillsmart.ooap3.services;

import ru.skubatko.dev.skillsmart.ooap3.domain.User;

import java.util.List;

public class UserFactory {

    public static final UserFactory INSTANCE = new UserFactory();

    private User user;

    private int getStatus = GET_NIL;
    private int buildStatus = BUILD_NIL;

    static final int GET_NIL = 0;
    static final int GET_OK = 1;
    static final int GET_ERR = 2;

    static final int BUILD_NIL = 0;
    static final int BUILD_OK = 1;
    static final int BUILD_ERR = 2;

    private static final List<String> ROLES = List.of("admin", "manager", "reader");

    private UserFactory() {}


    // >> запросы
    // предусловие: пользователь создан
    public User get() {
        if (buildStatus == BUILD_OK) {
            getStatus = GET_OK;
            return user;
        } else {
            getStatus = GET_ERR;
            return null;
        }
    }


    // >> команды
    // постусловие: создан пользователь заданного типа
    public void build(String type) {
        if (ROLES.contains(type)) {
            user = new User(type);
            buildStatus = BUILD_OK;
        } else {
            buildStatus = BUILD_ERR;
        }
    }


    // >> запросы статусов
    // успешно / пользователь не был создан
    public int getGetStatus() {
        return getStatus;
    }

    // пользователь не создан / пользователь создан
    public int getBuildStatus() {
        return buildStatus;
    }
}
