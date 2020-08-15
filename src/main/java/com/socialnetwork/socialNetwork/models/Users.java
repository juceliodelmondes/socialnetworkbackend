package com.socialnetwork.socialNetwork.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
    @Column(unique = true)
    private String user;
    private String password;
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
