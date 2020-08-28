/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.socialNetwork.service;

import com.socialnetwork.socialNetwork.controllers.RegisterAndLogin;
import com.socialnetwork.socialNetwork.models.Users;
import com.socialnetwork.socialNetwork.repository.UsersRepository;
import com.socialnetwork.socialNetwork.requestObject.LoginRequestObject;
import com.socialnetwork.socialNetwork.responseObject.LoginResponseObject;
import com.socialnetwork.socialNetwork.session.SessionInformation;
import com.socialnetwork.socialNetwork.utils.UsersUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jucelio
 * Regra de negócio para Login
*/
@Service
public class LoginService {
    
    @Autowired
    UsersRepository repo;
    
    @Autowired
    SessionService sessionService;
    
    public LoginResponseObject login(LoginRequestObject information) {
        LoginResponseObject returnInformation = new LoginResponseObject();
        try {
            if(UsersUtils.verifyName(information.getUser()) && UsersUtils.verifyPassword(information.getPassword())) {
                Users userResult = repo.findByUser(information.getUser());
                if(userResult != null) { //user exists
                    if(userResult.getPassword().equals(information.getPassword())) {
                        SessionInformation sessionInformation = sessionService.newSession(userResult);
                        returnInformation.setUser(userResult.getUser());
                        returnInformation.setMessage("Logado com sucesso!");
                        returnInformation.setSuccess(true);
                        returnInformation.setToken(sessionInformation.getTokenSession());
                    } else {
                        returnInformation.setMessage("Verifique as informações!");
                        returnInformation.setSuccess(false);
                    }
                } else {
                    returnInformation.setMessage("Verifique as informações!");
                    returnInformation.setSuccess(false);
                }
            } else {
                returnInformation.setMessage("Verifique as informações!");
                returnInformation.setSuccess(false);
            }
        } catch(Exception er) {
            returnInformation.setMessage("Verifique as informações!");
            returnInformation.setSuccess(false);
        }
        return returnInformation;
    }
}
