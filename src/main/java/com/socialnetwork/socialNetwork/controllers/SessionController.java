package com.socialnetwork.socialNetwork.controllers;

import com.socialnetwork.socialNetwork.session.SessionInformation;
import com.socialnetwork.socialNetwork.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jucelio
 */
@CrossOrigin //allow cors
@RestController
@RequestMapping(value = "/session")
public class SessionController {
    
    @Autowired
    SessionService service;
    
    @RequestMapping(value = "/validate")
    public boolean validate(@RequestBody SessionInformation information) {
        System.out.println("Validando usuário: "+information.getUser());
        return service.validateSession(information);
    }
    
    @RequestMapping(value = "/invalidate")
    public boolean invalidate(@RequestBody SessionInformation information) {
        return service.invalidateSession(information);
    }
    
    @RequestMapping(value = "/show")
    public void show() {
        //Debug
        service.printAllSession();
    }
}
