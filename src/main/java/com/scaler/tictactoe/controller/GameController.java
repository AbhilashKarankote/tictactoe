package com.scaler.tictactoe.controller;

import com.scaler.tictactoe.model.Game;
import com.scaler.tictactoe.model.GameState;
import com.scaler.tictactoe.model.Player;

import java.util.List;

public class GameController {

    public Game createGame(int dimension, List<Player> playerList){
        Game game = Game.getBuilder().setDimension(dimension).setPlayers(playerList).build();
        return game;
    }

    public void undo(Game game){

    }

    public void executeNextMove(Game game){

    }

    public String getWinner(Game game){
        return game.getPlayerWinner();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }
}
