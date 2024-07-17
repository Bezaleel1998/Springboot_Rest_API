package com.Maven.SpringbootDuty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Maven.SpringbootDuty.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByUsername(String username);
}
