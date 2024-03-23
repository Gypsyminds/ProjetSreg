package com.bezkoder.springjwt.Repositery;

import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String identifiant);

  Boolean existsByUsername(String identifiant);

  Boolean existsByEmail(String email);
  @Query(value = "select count(*) from user;", nativeQuery=true)
  int nubusers();
  @Query(value = " select * from user ORDER BY id DESC LIMIT 1", nativeQuery=true)
  User idlastuser();
}
