package com.dating_app.repository;

import com.dating_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByGenderNot(String gender);
}
