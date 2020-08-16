package com.socialnetwork.socialNetwork.controllers;

import com.socialnetwork.socialNetwork.session.SessionInformation;
import com.socialnetwork.socialNetwork.session.UsersSession;
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
public class UserSession {
    
    @RequestMapping(value = "/validate")
    public boolean validate(@RequestBody SessionInformation information) {
        return UsersSession.validateSession(information);
    }
    
    @RequestMapping(value = "/invalidate")
    public boolean invalidate(@RequestBody SessionInformation information) {
        return UsersSession.invalidateSession(information);
    }
}
