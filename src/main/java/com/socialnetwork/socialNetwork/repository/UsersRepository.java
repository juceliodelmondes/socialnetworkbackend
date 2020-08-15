package com.socialnetwork.socialNetwork.repository;

import com.socialnetwork.socialNetwork.models.Users;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jucelio
 */
public interface UsersRepository extends CrudRepository<Users, Long>{
    public Users findByUser(String nameParams);
}
