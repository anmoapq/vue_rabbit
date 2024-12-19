package com.example.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Player {
    private final String playerId;
    private final String username;
    private final String hashedPassword;

    public Player(String playerId, String username, String password) {
        this.playerId = playerId;
        this.username = username;
        this.hashedPassword = hashPassword(password);
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getUsername() {
        return username;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
