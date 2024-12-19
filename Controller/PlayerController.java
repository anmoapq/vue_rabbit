package com.example.Controller;

import com.example.Model.Player;
import com.example.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerPlayer(@Valid @RequestBody Player player) {
        try {
            playerService.registerPlayer(player);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginPlayer(@RequestParam String player_id, @RequestParam String password) {
        try {
            playerService.loginPlayer(player_id, password);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}

------------------------------------

package com.example.Service;

import com.example.Model.Player;
import com.example.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, BCryptPasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerPlayer(Player player) throws Exception {
        if (playerRepository.existsById(player.getId())) {
            throw new Exception("Player already exists");
        }
        player.setPassword(passwordEncoder.encode(player.getPassword()));
        playerRepository.save(player);
    }

    public void loginPlayer(String player_id, String password) throws Exception {
        Player player = playerRepository.findById(player_id)
                .orElseThrow(() -> new Exception("Player not found"));
        if (!passwordEncoder.matches(password, player.getPassword())) {
            throw new Exception("Invalid credentials");
        }
        // Perform additional login operations if necessary
    }
}

------------------------------------

package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Player {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

------------------------------------

package com.example.Repository;

import com.example.Model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, String> {
}

------------------------------------

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
