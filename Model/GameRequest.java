package com.example.Model;

public class GameRequest {
    private String playerId;
    private String direction;
    private String gameId;

    public GameRequest(String playerId, String direction, String gameId) {
        this.playerId = playerId;
        this.direction = direction;
        this.gameId = gameId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
