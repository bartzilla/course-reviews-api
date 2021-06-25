package com.bartzilla.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UserRespository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
