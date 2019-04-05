package com.roman.springbootapril.dao;

import com.roman.springbootapril.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
