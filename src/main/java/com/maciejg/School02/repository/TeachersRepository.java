package com.maciejg.School02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School02.model.Teacher;

public interface TeachersRepository extends JpaRepository<Teacher, Long> {

}
