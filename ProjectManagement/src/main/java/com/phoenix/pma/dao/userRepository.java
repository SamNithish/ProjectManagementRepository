package com.phoenix.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.phoenix.pma.entities.users;

public interface userRepository extends CrudRepository<users, Long> {

}
