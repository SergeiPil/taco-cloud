package com.piliugin.tacocloud.repository;

import com.piliugin.tacocloud.model.security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String userName);
}
