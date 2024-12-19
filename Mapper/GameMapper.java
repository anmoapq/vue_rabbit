package com.example.Model;

public class Game {
    private String game_id;
    private String snake_positions;
    private String food_position;
    private int score;

    // Getters and setters for all fields
    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getSnake_positions() {
        return snake_positions;
    }

    public void setSnake_positions(String snake_positions) {
        this.snake_positions = snake_positions;
    }

    public String getFood_position() {
        return food_position;
    }

    public void setFood_position(String food_position) {
        this.food_position = food_position;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
