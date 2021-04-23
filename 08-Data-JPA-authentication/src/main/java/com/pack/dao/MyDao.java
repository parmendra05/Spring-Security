package com.pack.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.Users;
@Repository
public interface MyDao extends JpaRepository<Users, Integer> {

	Optional<Users> findByUsername(String username);

}
