package com.socialnetwork.socialNetwork.repository;

import com.socialnetwork.socialNetwork.models.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositório para a entidade Users
 * @author Jucelio
 */
public interface UsersRepository extends CrudRepository<Users, Long>{
    public Users findByUser(String userParams);
}
