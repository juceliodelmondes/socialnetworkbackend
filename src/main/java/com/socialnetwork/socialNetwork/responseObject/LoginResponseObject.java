/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.socialNetwork.responseObject;

/**
 *
 * @author Jucelio
 */
public class LoginResponseObject {
    private String user, message, token;
    private boolean success;

    public String getUser() {
        return this.user;
    }

    public void setUser(String userParams) {
        this.user = userParams;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean successParams) {
        this.success = successParams;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String messageParams) {
        this.message = messageParams;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String tokenParams) {
        this.token = tokenParams;
    }
}
