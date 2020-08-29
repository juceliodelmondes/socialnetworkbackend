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
    
    /**
     * Verifica e retorna se uma sessão é valida
     * @param information
     * @return 
     */
    @RequestMapping(value = "/validate")
    public boolean validate(@RequestBody SessionInformation information) {
        System.out.println("Validando usuário: "+information.getUser());
        return service.validateSession(information);
    }
    
    /**
     * Imprime no console todas as sessões ativas
     */
    @RequestMapping(value = "/show")
    public void show() {
        service.printAllSession();
    }
    
}
