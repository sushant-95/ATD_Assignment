package com.assignment.AtdSpringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.AtdSpringproject.dto.Students;

public interface StudentRepository extends JpaRepository<Students, Integer>{

}
