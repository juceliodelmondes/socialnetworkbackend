package com.socialnetwork.socialNetwork.session;

import com.socialnetwork.socialNetwork.session.SessionInformation;
import com.socialnetwork.socialNetwork.models.Users;
import java.util.ArrayList;
import java.util.Random;

public class UsersSession {
    //This class validate all users session with token generated in Java
    private static final String charAllowedToken = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int tokenLength = 1024;
    private static final int tokenSessionLength = 255;
    private static final ArrayList<SessionInformation> userSession = new ArrayList<>();    
        
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
    
    private static String generateTokenSession() {
        String finalToken = "";
        Random random = new Random();
        for(int i = 0; i < tokenSessionLength; i++) {
            finalToken += charAllowedToken.charAt(random.nextInt(charAllowedToken.length()));
        }
        return finalToken;
    }
    
    public static SessionInformation newSession(Users user) {
        SessionInformation sessionInformation = new SessionInformation();
        String tokenSession = generateTokenSession();
        
        sessionInformation.setUser(user.getUser());
        sessionInformation.setTokenSession(tokenSession);
        userSession.add(sessionInformation);
        System.out.println("New session: "+sessionInformation.getUser()+" token: "+tokenSession);
        return sessionInformation;
    }
    
    public static boolean validateSession(SessionInformation information) {
        //validate user session with username and token
        for(int i = 0; i < userSession.size(); i++) {
            if(userSession.get(i).getTokenSession().equals(information.getTokenSession()) && 
                    userSession.get(i).getUser().equals(information.getUser())) return true; 
        }
        return false;
    }
    
    public static boolean invalidateSession(SessionInformation information) {
        for(int i = 0; i < userSession.size(); i++) {
            if(userSession.get(i).getTokenSession().equals(information.getTokenSession()) && 
                    userSession.get(i).getUser().equals(information.getUser())) {
                userSession.remove(i);
                System.out.println("Closed session: "+information.getUser()+" token: "+information.getTokenSession());
                return true;
            }
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
    
    public static void closeAllUserSession(Users user) {
        for(int i = 0; i < userSession.size(); i++) {
            if(userSession.get(i).getUser().equals(user.getUser())) userSession.remove(i);
        }
    }
    
    public static void closeAllSession() {
        for(int i = 0; i < userSession.size(); i++) userSession.remove(i);
    }
    
    public static void printAllSession() {
        System.out.println("===================");
        for(int i = 0; i < userSession.size(); i++) {
            System.out.println("User session "+userSession.get(i).getUser()+" token: "+userSession.get(i).getTokenSession());
        }
        System.out.println("===================");
    }
}
