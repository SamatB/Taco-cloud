package ru.beganov.tacos.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.beganov.tacos.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername (String username);
}
