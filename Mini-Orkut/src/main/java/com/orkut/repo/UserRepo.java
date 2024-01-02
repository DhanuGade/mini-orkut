package com.orkut.repo;

import com.orkut.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo extends JpaRepository<User,Integer> {
}
