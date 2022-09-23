package com.tyc.commentapp.repository;

import com.tyc.commentapp.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<List<User>> findAllOptionalByOrderByNameAsc();
    Optional<List<User>> findAllOptionalByNameContainingIgnoreCase(String value);
    Optional<List<User>> findAllOptionalByEmailContainingIgnoreCase(String value);
    Optional<List<User>> findAllOptionalByEmailEndingWithIgnoreCase(String value);

    Optional<User> findOptionalByEmailAndPassword(String email, String password);

    @Query("select u from User u where length(u.password) > ?1")
    Optional<List<User>> controlPasswordLength(int value);

    @Query(value = "select u from User u where length(u.password) > :value")
    Optional<List<User>> controlPasswordLength2(@Param("value") int value);

    @Query(value = "select * from tbluser where email = ?1 and password = 2?", nativeQuery = true)
    Optional<User> findOptionalByEmailAndPassword2(String email, String password);
}
