package com.maciejg.School02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School02.model.LoginAndPassword;

public interface LoginRepository extends JpaRepository<LoginAndPassword, Long> {
	
}
