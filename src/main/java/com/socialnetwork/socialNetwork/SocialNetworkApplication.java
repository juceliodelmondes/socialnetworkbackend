package com.socialnetwork.socialNetwork;

import com.socialnetwork.socialNetwork.utils.UsersSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialNetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialNetworkApplication.class, args);
        System.out.println("Iniciado");
    }

}
