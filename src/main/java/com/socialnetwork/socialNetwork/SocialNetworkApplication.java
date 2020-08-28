package com.socialnetwork.socialNetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

/**
 * Classe service = regra de negocio
 * Classe controllers = classe para API, intermediário entre frond end e back-end
 * Classes requestObject = padrões que serão utilizados em requisicoes do cliente, contendo os dados de JSON (dados de json no objeto)
 * Classes responseObject = responsável por controlar quais informações serão devolvidas - 
 * Um objeto do tipo responseObject servirá como resposta ao cliente em forma de JSON
 */
public class SocialNetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialNetworkApplication.class, args);
        System.out.println("Iniciado");
        /*
        new Thread() {
            public void run() {
                try {
                    boolean loop = true;
                    while(loop) {
                        System.out.println("abcv");
                        Thread.sleep(1000);
                    }
                } catch(Exception er) {
                    
                }
            }
        }.start();
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
