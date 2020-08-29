package com.socialnetwork.socialNetwork.service;

import com.socialnetwork.socialNetwork.models.Users;
import com.socialnetwork.socialNetwork.requestObject.LogoffRequestObject;
import com.socialnetwork.socialNetwork.session.SessionInformation;
import java.util.ArrayList;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    //This class validate all users session with token generated in Java
    private static final String charAllowedToken = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int tokenLength = 1024;
    private static final int tokenSessionLength = 255;
    private static final ArrayList<SessionInformation> userSession = new ArrayList<>();    
        
    public SessionService() {
        
    }
    
    /**
     * Gera um token
     * @return retorna o token gerado
     */
    public String generateToken() {
        String finalToken = "";
        Random random = new Random();
        for(int i = 0; i < tokenLength; i++) {
            finalToken += charAllowedToken.charAt(random.nextInt(charAllowedToken.length()));
        }
        return finalToken;
    }
    
    /**
     * Inicializa uma nova sessão
     * @param user
     * @return 
     */
    public SessionInformation newSession(Users user) {
        SessionInformation sessionInformation = new SessionInformation();
        String tokenSession = generateToken();        
        sessionInformation.setUser(user.getUser());
        sessionInformation.setTokenSession(tokenSession);
        userSession.add(sessionInformation);
        System.out.println("New session: "+sessionInformation.getUser()+" token: "+tokenSession);
        return sessionInformation;
    }
    /**
     * Verifica se uma sessão é válida
     * @param information
     * @return 
     */
    public boolean validateSession(SessionInformation information) {
        for(int i = 0; i < userSession.size(); i++) {
            if(userSession.get(i).getTokenSession().equals(information.getTokenSession()) && 
                    userSession.get(i).getUser().equals(information.getUser())) return true; 
        }
        return false;
    }
    
    /**
     * Fecha uma determina sessão, identificada com o usuário e token
     * @param information
     * @return 
     */
    
    public boolean closeSession(LogoffRequestObject information) {
        return userSession.removeIf(userSession -> userSession.getUser().equals(information.getUser()) && 
                userSession.getTokenSession().equals(information.getToken()));
    }
    
    /**
     * Encerra uma determina sessão, identificada com o usuário e token
     * @param user
     * @return 
     */
    public boolean closeSession(Users user) {
        return userSession.removeIf(userSession -> userSession.getUser().equals(user.getUser()) && 
                userSession.getTokenSession().equals(user.getToken()));
    }
    
    /**
     * Encerra todas as sessões de um determinado usuário
     * @param user 
     */
    public void closeAllUserSession(Users user) {
        userSession.removeIf(userSession -> userSession.getUser().equals(user.getUser()) && 
                userSession.getTokenSession().equals(user.getToken()));
    }
    
    /**
     * Encerra todas as sessões disponíveis
     */
    
    public void closeAllSessions() {
        userSession.clear();
    }
    
    /**
     * Imprime todas as sessões disponíveis
     */
    public void printAllSession() {
        System.out.println("===================");
        for(int i = 0; i < userSession.size(); i++) {
            System.out.println("User session "+userSession.get(i).getUser()+" token: "+userSession.get(i).getTokenSession());
        }
        System.out.println("===================");
    }
}
