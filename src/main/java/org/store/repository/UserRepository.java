package org.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.store.domain.User;

/**
 * Created by hoyounglee on 2016. 5. 18..
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
}
