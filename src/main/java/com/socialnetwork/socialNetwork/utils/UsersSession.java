package com.socialnetwork.socialNetwork.utils;

import com.socialnetwork.socialNetwork.models.Users;
import java.util.ArrayList;
import java.util.Random;

public class UsersSession {
    //This class validate all users session with token generated in Java
    private static final String charAllowedToken = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int tokenLength = 1024;
    private static final int tokenSessionLength = 255;
    private static final ArrayList<SessionInformation> userSession = new ArrayList<>();    
    
    static class SessionInformation { 
        private String user, password, tokenSession;
        
        private String getUser() {
            return this.user;
        }
        
        private void setUser(String userParams) {
            this.user = userParams;
        }
        
        private String getPassword() {
            return this.password;
        }
        
        private void setPassword(String passwordParams) {
            this.password = passwordParams;
        }
        
        private String getTokenSession() {
            return this.tokenSession;
        }
        
        private void setTokenSession(String tokenSessionParams) {
            this.tokenSession = tokenSessionParams;
        }
        
        
    }
    
    public UsersSession() {
        
    }
    
    public static String generateToken() {
        String finalToken = "";
        Random random = new Random();
        for(int i = 0; i < tokenLength; i++) {
            finalToken += charAllowedToken.charAt(random.nextInt(charAllowedToken.length()));
        }
        return finalToken;
    }
    
    public static String generateTokenSession() {
        String finalToken = "";
        Random random = new Random();
        for(int i = 0; i < tokenSessionLength; i++) {
            finalToken += charAllowedToken.charAt(random.nextInt(charAllowedToken.length()));
        }
        return finalToken;
    }
    
    public static void newSession(Users user) {
        SessionInformation sessionInformation = new SessionInformation();
        sessionInformation.setUser(user.getUser());
        sessionInformation.setPassword(user.getPassword());
        sessionInformation.setTokenSession(generateTokenSession());
        userSession.add(sessionInformation);
    }
    
    public static boolean validateSession(Users user, String tokenSession) {
        for(int i = 0; i < userSession.size(); i++) {
            if(userSession.get(i).getTokenSession().equals(tokenSession) && userSession.get(i).getUser().equals(user.getUser())) return true; 
        }
        return false;
    }
    
    public static boolean closeSession(String tokenSession) {
        for(int i = 0; i < userSession.size(); i++) {
            if(userSession.get(i).getTokenSession().equals(tokenSession)) {
                userSession.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public static void closeAllSession(Users user) {
        for(int i = 0; i < userSession.size(); i++) {
            if(userSession.get(i).getUser().equals(user.getUser())) userSession.remove(i);
        }
    }
    
    public static ArrayList<SessionInformation> returnAllSession() {
        return userSession;
    }
}
