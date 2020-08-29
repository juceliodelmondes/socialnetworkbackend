/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.socialNetwork.controllers;

import com.socialnetwork.socialNetwork.requestObject.RegisterRequestObject;
import com.socialnetwork.socialNetwork.responseObject.RegisterResponseObject;
import com.socialnetwork.socialNetwork.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/user")
public class RegisterController {
    
    @Autowired
    RegisterService service;
    
    /**
     * Registra um novo usuário
     * @param information
     * @return 
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterResponseObject register (@RequestBody RegisterRequestObject information) {
        return service.register(information);
    }
}
