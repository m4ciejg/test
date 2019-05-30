package com.maciejg.School02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciejg.School02.model.GradeEntity;

public interface GradeRepository extends JpaRepository<GradeEntity, Long> {

}
