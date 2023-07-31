package com.scaler.tictactoe.model;

import com.scaler.tictactoe.exception.InvalidDimensionException;
import com.scaler.tictactoe.exception.InvalidNoOfPlayersException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> Moves;
    private int nextPlayerIndex;
    private String playerWinner;

    private GameState gameState;

    private Game(){

    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return Moves;
    }

    public void setMoves(List<Move> moves) {
        Moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public String getPlayerWinner() {
        return playerWinner;
    }

    public void setPlayerWinner(String playerWinner) {
        this.playerWinner = playerWinner;
    }

    public static Builder getBuilder(){
        return new Builder();
    }


    public static class Builder{
        private int dimension;
        private List<Player> players;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private boolean isValid() throws InvalidDimensionException, InvalidNoOfPlayersException {
            if(dimension < 3){
               throw new InvalidDimensionException("Game dimensions must be greater than or equal to 3");
            }
            if(players.size() != dimension - 1){
               throw new InvalidNoOfPlayersException("Number of players must be 1 less then dimension");
            }
            return true;
        }

        public Game build(){
            try {
                isValid();
            } catch (InvalidDimensionException | InvalidNoOfPlayersException e) {
                System.out.println(e.getMessage());
            }
            Game game = new Game();
            game.setBoard(new Board(dimension));
            game.setMoves(new ArrayList<>());
            game.setPlayers(players);
            game.setNextPlayerIndex(0);
            game.setGameState(GameState.IN_PROGRESS);
            return game;
        }

    }
}
