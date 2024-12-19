package com.example.Controller;

import com.example.Model.GameRequest;
import com.example.Model.GameResponse;
import com.example.Model.Player;
import com.example.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/register")
    public ResponseEntity<String> registerPlayer(@RequestBody Player player) {
        try {
            gameService.registerPlayer(player);
            return ResponseEntity.ok("Player registered successfully");
        } catch (Exception e) {
            // Log the exception
            // e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Player registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginPlayer(@RequestBody LoginRequest loginRequest) {
        try {
            gameService.loginPlayer(loginRequest.getPlayerId(), loginRequest.getPassword());
            return ResponseEntity.ok("Player logged in successfully");
        } catch (Exception e) {
            // Log the exception
            // e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }

    @PostMapping("/move")
    public ResponseEntity<GameResponse> moveSnake(@RequestBody GameRequest gameRequest) {
        try {
            GameResponse response = gameService.updateSnakePosition(gameRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception
            // e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // or return a custom error response
        }
    }

    private static class LoginRequest {
        private String playerId;
        private String password;

        public String getPlayerId() {
            return playerId;
        }

        public void setPlayerId(String playerId) {
            this.playerId = playerId;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
