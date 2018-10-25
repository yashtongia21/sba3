package com.verizon.isp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.isp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
