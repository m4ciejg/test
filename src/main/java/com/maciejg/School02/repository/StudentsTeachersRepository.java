package com.maciejg.School02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School02.model.StudentsTeachersEntity;

public interface StudentsTeachersRepository extends JpaRepository<StudentsTeachersEntity, Long> {

}
