package com.socialnetwork.socialNetwork;

import com.socialnetwork.socialNetwork.session.UsersSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialNetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialNetworkApplication.class, args);
        System.out.println("Iniciado");
        
        /*
        for(int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(2000);
                UsersSession.printAllSession();
            } catch(Exception er) {
                
            }
        }*/
    }

}
