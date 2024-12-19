package com.example.Service;

import com.example.Mapper.PlayerMapper;
import com.example.Model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerService(PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    public void registerPlayer(Player player) {
        playerMapper.insertPlayer(player);
    }

    public Player getPlayerById(String playerId) {
        return playerMapper.getPlayerById(playerId);
    }

    public boolean loginPlayer(String playerId, String password) {
        Player player = playerMapper.getPlayerById(playerId);
        if (player != null && isPasswordCorrect(player.getPassword(), password)) {
            handleSuccessfulLogin(player);
            return true;
        } else {
            handleFailedLogin(playerId);
            return false;
        }
    }

    private boolean isPasswordCorrect(String storedPassword, String providedPassword) {
        try {
            // Secure comparison to avoid timing attacks
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] storedPasswordHash = md.digest(storedPassword.getBytes());
            byte[] providedPasswordHash = md.digest(providedPassword.getBytes());
            return MessageDigest.isEqual(storedPasswordHash, providedPasswordHash);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception appropriately, maybe log it and/or throw a custom exception
            return false;
        }
    }

    private void handleSuccessfulLogin(Player player) {
        // Generate a login token (simplified example)
        String token = UUID.randomUUID().toString();
        player.setLoginToken(token);
        player.setLastLoginTime(LocalDateTime.now());
        playerMapper.updatePlayer(player);
        // Additional logic can be added here if needed
    }

    private void handleFailedLogin(String playerId) {
        // Logic for failed login: e.g., logging the attempt, reporting an error, etc.
        System.out.println("Failed login attempt for player ID: " + playerId);
        // Additional logic can be added here if needed
    }
}
