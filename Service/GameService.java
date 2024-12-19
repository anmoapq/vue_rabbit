package com.example.Service;

import com.example.Mapper.GameMapper;
import com.example.Mapper.PlayerMapper;
import com.example.Model.Game;
import com.example.Model.GameRequest;
import com.example.Model.GameResponse;
import com.example.Model.Player;
import com.example.Utils.DirectionUtils;
import com.example.Utils.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private PlayerMapper playerMapper;

    public void registerPlayer(Player player) {
        playerMapper.insertPlayer(player);
    }

    public boolean loginPlayer(String player_id, String password) {
        Player player = playerMapper.getPlayerById(player_id);
        if (player != null && player.getPassword().equals(password)) {
            // Logic for successful login
            // e.g., generating a session or token
            return true;
        } else {
            // Handle failed login, logging attempts, etc.
            return false;
        }
    }

    public GameResponse updateSnakePosition(GameRequest gameRequest) {
        Game game = gameMapper.getGameById(gameRequest.getGame_id());
        if (game == null) {
            // Handle game not found
            return new GameResponse("Game not found");
        }

        // Calculate new snake position
        Direction newDirection = gameRequest.getDirection();
        Coordinates newHead = DirectionUtils.calculateNewPosition(game.getSnake().getHead(), newDirection);

        // Check collision with walls or self
        if (isCollision(newHead, game)) {
            // Handle game over
            game.setGameOver(true);
            gameMapper.updateGame(game);
            return new GameResponse(game);
        }

        // Check for food consumption
        if (isFoodAtPosition(newHead, game)) {
            game.getSnake().grow();
            placeNewFood(game);
            game.increaseScore();
        } else {
            game.getSnake().move(newHead);
        }

        gameMapper.updateGame(game);
        return new GameResponse(game);
    }

    private boolean isCollision(Coordinates head, Game game) {
        // Check boundaries and self-collision
        if (head.getX() < 0 || head.getX() >= game.getBoardWidth() ||
            head.getY() < 0 || head.getY() >= game.getBoardHeight()) {
            return true;
        }
        return game.getSnake().getBody().contains(head);
    }

    private boolean isFoodAtPosition(Coordinates head, Game game) {
        return head.equals(game.getFoodPosition());
    }

    private void placeNewFood(Game game) {
        Coordinates newFoodPosition;
        do {
            newFoodPosition = DirectionUtils.generateRandomPosition(game.getBoardWidth(), game.getBoardHeight());
        } while (game.getSnake().getBody().contains(newFoodPosition));
        game.setFoodPosition(newFoodPosition);
    }
}
