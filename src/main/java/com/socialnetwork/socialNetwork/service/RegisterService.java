/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.socialNetwork.service;

import com.socialnetwork.socialNetwork.controllers.RegisterAndLogin;
import com.socialnetwork.socialNetwork.models.Users;
import com.socialnetwork.socialNetwork.repository.UsersRepository;
import com.socialnetwork.socialNetwork.requestObject.RegisterRequestObject;
import com.socialnetwork.socialNetwork.responseObject.RegisterResponseObject;
import com.socialnetwork.socialNetwork.session.SessionInformation;
import com.socialnetwork.socialNetwork.utils.UsersUtils;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jucelio
 * Regra de negócio para register
 */
@Service
public class RegisterService {
    
    @Autowired
    UsersRepository repo;   
    
    @Autowired
    SessionService sessionService;
    
    public RegisterResponseObject register(RegisterRequestObject information) {
        RegisterResponseObject returnInformation = new RegisterResponseObject();
        try {
            if(UsersUtils.verifyName(information.getUser())) {
                if(userExists(information.getUser())) {
                    //If user exists
                    returnInformation.setMessage("Usuário indisponível!");
                    returnInformation.setSuccess(false);
                } else {
                    //If user not exists
                    if(UsersUtils.verifyPassword(information.getPassword())) {
                        Users newUser = new Users();
                        newUser.setUser(information.getUser().toLowerCase());
                        newUser.setPassword(information.getPassword());
                        newUser.setToken(sessionService.generateToken());
                        long result = repo.save(newUser).getId();
                        if(result > 0) {
                            returnInformation.setMessage("Cadastrado com sucesso!");
                            returnInformation.setSuccess(true);
                        } else {
                            returnInformation.setMessage("Erro ao cadastrar!1");
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
            returnInformation.setMessage("Erro ao cadastrar!2");
            returnInformation.setSuccess(false);
        }
        return returnInformation;
    }
    
    private boolean userExists (String userParams) {
        Users user = repo.findByUser(userParams);
        if(user == null) return false; else return true;
    }
}
