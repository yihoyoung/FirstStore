package org.store.domain;

import java.io.Serializable;

/**
 * Created by hoyounglee on 2016. 5. 18..
 */

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private Integer userId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column
    private String socialId;
    @Column
    private String socialType;

    public User(String email, String password, String username) {
        this.email = email;
        this.username = username;
        this.password = password;
    }



}