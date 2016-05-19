package service;

import domain.User;
import lombok.Data;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by hoyounglee on 2016. 5. 18..
 */
@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
    private final User user;

    public LoginUserDetails(User user){
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }
}
