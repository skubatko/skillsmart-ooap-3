package ru.skubatko.dev.skillsmart.ooap3.repositories;

public abstract class Repository<T, ID> {

    // >> запросы
    // предусловие: элемент с id существует
    public abstract T findById(ID id);


    // >> команды
    // постусловие: элемент добавлен в хранилище
    public abstract void save(T entity);

    // предусловие: элемент с id существует
    // постусловие: элемент с id обновлён
    public abstract void update(ID id, T entity);

    // предусловие: элемент с id существует
    // постусловие: элемент с id удалён
    public abstract void delete(ID id);


    // >> запросы статусов
    public abstract int getFindStatus(); // успешно / не найден

    public abstract int getUpdateStatus(); // успешно / элемент с id не существует

    public abstract int getDeleteStatus(); // успешно / элемент с id не существует
}
