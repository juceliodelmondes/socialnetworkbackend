/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.socialNetwork.session;

/**
 *
 * @author Jucelio
 */
public class SessionInformation {

    private String user, tokenSession;

    public String getUser() {
        return this.user;
    }

    public void setUser(String userParams) {
        this.user = userParams;
    }

    public String getTokenSession() {
        return this.tokenSession;
    }

    public void setTokenSession(String tokenSessionParams) {
        this.tokenSession = tokenSessionParams;
    }

}
