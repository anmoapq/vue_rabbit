package com.example.Model;

import java.util.List;

public class Game {
    private String gameId;
    private List<Position> snakePositions;
    private Position foodPosition;
    private int score;

    public Game(String gameId, List<Position> snakePositions, Position foodPosition, int score) {
        this.gameId = gameId;
        this.snakePositions = snakePositions;
        this.foodPosition = foodPosition;
        this.score = score;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public List<Position> getSnakePositions() {
        return snakePositions;
    }

    public void setSnakePositions(List<Position> snakePositions) {
        this.snakePositions = snakePositions;
    }

    public Position getFoodPosition() {
        return foodPosition;
    }

    public void setFoodPosition(Position foodPosition) {
        this.foodPosition = foodPosition;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
