/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.socialNetwork.utils;

import com.socialnetwork.socialNetwork.SocialNetworkConfiguration;

/**
 *
 * @author Jucelio
 * Demais utilidades relacionadas a usuário, exemplo: verificar se um nome é valido
 */
public class UsersUtils {
    public static boolean verifyName(String userNameParams) {
        //Verify all strings, range [a-z, 0-9], string length max: 60
        if(!userNameParams.isEmpty() && userNameParams.length() >= SocialNetworkConfiguration.minUserName && userNameParams.length() <= SocialNetworkConfiguration.maxUserName) {
            for(int i = 0; i < userNameParams.length(); i++) {
                String charS = userNameParams.charAt(i)+"";
                String charAllowedString = SocialNetworkConfiguration.charAllowed;
                for(int j = 0; j < charAllowedString.length(); j++) {
                    String charAllowed = charAllowedString.charAt(j)+"";
                    if(charS.compareToIgnoreCase(charAllowed) == 0) { //if equals 
                        break;
                    } else if(j == charAllowedString.length()-1) return false;
                }
            }
            return true;
        } else return false;
    }
    
    public static boolean verifyPassword(String passwordParams) {
        //Verify all strings, string length max: 60 
        if(!passwordParams.isEmpty() && passwordParams.length() >= SocialNetworkConfiguration.minPassword && passwordParams.length() <= SocialNetworkConfiguration.maxPassword) return true;
        else return false;
    }
}
