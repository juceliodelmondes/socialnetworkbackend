/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.socialNetwork.requestObject;

/**
 * Modelo de informações na requisição do registro
 * @author Jucelio
 */
public class RegisterRequestObject {
    
    private String user, password;

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
}
