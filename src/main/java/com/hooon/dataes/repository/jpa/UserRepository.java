package com.hooon.dataes.repository.jpa;

import com.hooon.dataes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
