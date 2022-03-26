package ru.skubatko.dev.skillsmart.ooap3.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository<T, ID> {

    protected final Map<ID, T> storage = new HashMap<>();

    private int findStatus = FIND_NIL;
    private int updateStatus = UPDATE_NIL;
    private int deleteStatus = DELETE_NIL;

    static final int FIND_NIL = 0;
    static final int FIND_OK = 1;
    static final int FIND_ERR = 2;

    static final int UPDATE_NIL = 0;
    static final int UPDATE_OK = 1;
    static final int UPDATE_ERR = 2;

    static final int DELETE_NIL = 0;
    static final int DELETE_OK = 1;
    static final int DELETE_ERR = 2;


    // >> запросы
    // предусловие: элемент с id существует
    public T findById(ID id) {
        T entity = storage.get(id);
        findStatus = entity != null ? FIND_OK : FIND_ERR;
        return entity;
    }

    public Collection<T> findAll() {
        return storage.values();
    }

    // >> команды
    // постусловие: элемент добавлен в хранилище
    public void save(ID id, T entity) {
        storage.put(id, entity);
    }

    // предусловие: элемент с id существует
    // постусловие: элемент с id обновлён
    public void update(ID id, T entity) {
        T persisted = storage.get(id);
        if (persisted != null) {
            storage.put(id, entity);
            updateStatus = UPDATE_OK;
        } else {
            updateStatus = UPDATE_ERR;
        }
    }

    // предусловие: элемент с id существует
    // постусловие: элемент с id удалён
    public void delete(ID id) {
        T persisted = storage.get(id);
        if (persisted != null) {
            storage.remove(id);
            deleteStatus = DELETE_OK;
        } else {
            deleteStatus = DELETE_ERR;
        }
    }


    // >> запросы статусов
    // успешно / не найден
    public int getFindStatus() {
        return findStatus;
    }

    // успешно / элемент с id не существует
    public int getUpdateStatus() {
        return updateStatus;
    }

    // успешно / элемент с id не существует
    public int getDeleteStatus() {
        return deleteStatus;
    }
}
