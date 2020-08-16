/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.socialNetwork.controllers;

import com.socialnetwork.socialNetwork.SocialNetworkConfiguration;
import com.socialnetwork.socialNetwork.models.Users;
import com.socialnetwork.socialNetwork.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.SQLWarningException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jucelio
 */
@CrossOrigin //allow cors
@RestController
public class RegisterAndLogin {
    @Autowired
    UsersRepository repo;
    
    private char charAllowedUserName[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9'};
    
    static class RegisterInformation {
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
    
    class ReturnInformation {
        //An class of return information to user
        
        public ReturnInformation() {
            
        }
        
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
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ReturnInformation register(@RequestBody RegisterInformation information) {
        ReturnInformation returnInformation = new ReturnInformation();
        try {
            if(verifyName(information.getUser())) {
                if(userExists(information.getUser())) {
                    //If user exists
                    returnInformation.setMessage("Usuário indisponível!");
                    returnInformation.setSuccess(false);
                } else {
                    //If user not exists
                    if(verifyPassword(information.getPassword())) {
                        Users newUser = new Users();
                        newUser.setUser(information.getUser());
                        newUser.setPassword(information.getPassword());
                        long result = repo.save(newUser).getId();
                        if(result > 0) {
                            returnInformation.setMessage("Cadastrado com sucesso!");
                            returnInformation.setSuccess(true);
                        } else {
                            returnInformation.setMessage("Erro ao cadastrar!");
                            returnInformation.setSuccess(false);
                        }
                    } else {
                        returnInformation.setMessage("Verifique a senha");
                        returnInformation.setSuccess(false);
                    }
                }
            } else {
                returnInformation.setMessage("Verifique o nome de usuário!");
                returnInformation.setSuccess(false);
            }
        } catch(Exception er) {
            returnInformation.setMessage("Erro ao cadastrar!");
            returnInformation.setSuccess(false);
        }
        return returnInformation;
    }
    
    private boolean userExists (String userParams) {
        Users user = repo.findByUser(userParams);
        if(user == null) return false; else return true;
    }
    
    private boolean verifyName(String userNameParams) {
        //Verify all strings, range [a-z, 0-9], string length max: 60
        if(!userNameParams.isEmpty() && userNameParams.length() >= SocialNetworkConfiguration.minUserName && userNameParams.length() <= SocialNetworkConfiguration.maxUserName) {
            for(int i = 0; i < userNameParams.length(); i++) {
                String charS = userNameParams.charAt(i)+"";
                String charAllowedString = SocialNetworkConfiguration.charAllowed;
                for(int j = 0; j < charAllowedString.length(); j++) {
                    String charAllowed = charAllowedString.charAt(j)+"";
                    if(charS.compareToIgnoreCase(charAllowed) == 0) { //if equals 
                        break;
                    } else if(j == charAllowedString.length()-1) return false;
                }
            }
            return true;
        } else return false;
    }
    
    private boolean verifyPassword(String passwordParams) {
        //Verify all strings, string length max: 60 
        if(!passwordParams.isEmpty() && passwordParams.length() >= SocialNetworkConfiguration.minPassword && passwordParams.length() <= SocialNetworkConfiguration.maxPassword) return true;
        else return false;
    }
}
