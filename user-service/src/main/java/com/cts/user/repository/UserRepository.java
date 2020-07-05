package com.cts.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.user.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	Optional<User> findByUsernameAndPassword(String username, String password);

}
