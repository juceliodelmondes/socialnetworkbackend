/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.socialNetwork.controllers;

import com.socialnetwork.socialNetwork.requestObject.LoginRequestObject;
import com.socialnetwork.socialNetwork.responseObject.LoginResponseObject;
import com.socialnetwork.socialNetwork.service.LoginService;
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
public class LoginController {
    
    @Autowired
    LoginService service;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponseObject login(@RequestBody LoginRequestObject information) {
        return service.login(information);
    }
}
