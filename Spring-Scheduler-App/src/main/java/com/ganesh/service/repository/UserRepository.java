package com.ganesh.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
