package net.proselyte.springbootdemo.repository;

import org.springframework.data.jpa.repository.Query;
import net.proselyte.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username")
    User findUserByUsername(String username);
}
