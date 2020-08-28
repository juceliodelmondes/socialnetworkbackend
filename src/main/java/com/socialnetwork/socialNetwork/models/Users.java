package com.socialnetwork.socialNetwork.models;

import com.socialnetwork.socialNetwork.SocialNetworkConfiguration;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *
 * @author Jucelio
 */
@Entity
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true, length = SocialNetworkConfiguration.maxUserName)
    private String user;
    @Column(length = SocialNetworkConfiguration.maxPassword)
    private String password;
    @Column(length = 1024)
    private String token;
    
    public long getId() {
        return this.id;
    }
    
    public void setid(long idParams) {
        this.id = idParams;
    }
    
    public String getUser() {
        return this.user;
    }
    
    public void setUser(String userParams) {
        this.user = userParams;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String passwordParams) {
        this.password = passwordParams;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public void setToken(String tokenParams) {
        this.token = tokenParams;
    }
}
