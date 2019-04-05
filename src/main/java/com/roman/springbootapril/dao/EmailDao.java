package com.roman.springbootapril.dao;

import com.roman.springbootapril.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailDao extends JpaRepository<Email,Integer> {
}
