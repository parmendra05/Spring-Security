package com.pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByUserName(String username);

}
