package com.brody.recaptcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brody.recaptcha.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
