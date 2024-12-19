package com.example.Model;

// Assuming Position and GameStatus are predefined classes or interfaces.
public class GameResponse {
    private Position newPosition;  // Updated to specific type
    private GameStatus gameStatus; // Updated to specific type
    private long timestamp;

    public GameResponse(Position newPosition, GameStatus gameStatus, long timestamp) {
        this.newPosition = newPosition;
        this.gameStatus = gameStatus;
        this.timestamp = timestamp;
    }

    public Position getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(Position newPosition) {
        this.newPosition = newPosition;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

// For completion, assuming Position and GameStatus classes
class Position {
    // Implementation details of Position class.
}

class GameStatus {
    // Implementation details of GameStatus class.
}
