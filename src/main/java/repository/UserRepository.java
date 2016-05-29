package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by hoyounglee on 2016. 5. 18..
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findbyEmail(String email);
}
