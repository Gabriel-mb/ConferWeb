package com.Confer.ConferWeb.Repository;

import com.Confer.ConferWeb.Model.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}
