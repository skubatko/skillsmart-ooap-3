package ru.skubatko.dev.skillsmart.ooap3.repositories;

import ru.skubatko.dev.skillsmart.ooap3.domain.User;

public class UserRepository extends Repository<User, Long> {

    @Override
    public void save(Long id, User entity) {
        entity.setId(id);
        super.save(id, entity);
    }
}
