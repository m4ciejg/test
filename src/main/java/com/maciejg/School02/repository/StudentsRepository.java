package com.maciejg.School02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School02.model.Students;

public interface StudentsRepository extends JpaRepository<Students, Long> {

}
