package com.centroxy.repository;
import com.centroxy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select k from User k where k.email =: email")
    public User getUserByEmail(@Param("email") String email);
}
