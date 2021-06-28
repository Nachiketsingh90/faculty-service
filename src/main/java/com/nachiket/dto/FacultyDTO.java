package com.nachiket.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nachiket.model.Faculty;

public interface FacultyDTO extends JpaRepository<Faculty, Integer>{

}
