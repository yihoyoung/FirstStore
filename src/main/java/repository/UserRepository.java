package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import domain.User;
/**
 * Created by hoyounglee on 2016. 5. 18..
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findbyEmail(String email);
}
