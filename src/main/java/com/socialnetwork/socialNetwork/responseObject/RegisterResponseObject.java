/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.socialNetwork.responseObject;

/**
 * Padrão de resposta para o cliente ao registrar no sistema
 * @author Jucelio
 */
public class RegisterResponseObject {
        
    private boolean success;
    private String message;

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
}
