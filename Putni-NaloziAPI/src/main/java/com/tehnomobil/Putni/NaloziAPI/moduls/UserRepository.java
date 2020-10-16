package com.tehnomobil.Putni.NaloziAPI.moduls;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {


    Optional<User> findByEMail(String EMail);
    List<User> findByRoles(String Roles);



}
