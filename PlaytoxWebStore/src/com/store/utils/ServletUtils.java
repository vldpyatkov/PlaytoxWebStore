package com.store.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/4/13
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServletUtils {

    public static final String ALGORITHM = "MD5";

    public static String camelToSnake(String camel) {
        String camelString = camel.trim();
        StringBuilder snakeSb = new StringBuilder();
        for (char c : camelString.toCharArray()) {
            if (snakeSb.length() > 0 && c >= 'A' && c <= 'Z') {
                snakeSb.append('_');
            }
            snakeSb.append(c);
        }
        return snakeSb.toString().toLowerCase();
    }

    public static String snakeToCamel(String snake) {
        String snakeString = snake.trim().toLowerCase();
        StringBuilder camelSb = new StringBuilder();
        char previous='\0';
        for (char c : snakeString.toCharArray()) {
            if (c != '_') {
                camelSb.append((previous == '_')?Character.toUpperCase(c):c);
            }
            previous = c;
        }
        camelSb.setCharAt(0, Character.toUpperCase(camelSb.charAt(0)));
        return camelSb.toString();

    }

    public static String getSecurePassword(String passwordToHash) throws NoSuchAlgorithmException {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            //Add password bytes to digest
            //md.update(salt.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static boolean isNullOrEmpty(String s) {
        return s==null || s.trim().isEmpty();
    }

}
