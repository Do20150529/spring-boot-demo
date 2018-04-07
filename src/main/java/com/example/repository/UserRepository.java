package com.example.repository;

import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ge.Mao on 2018/4/7
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
