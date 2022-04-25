package com.example.emt.repository;

import com.example.emt.model.Author;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
