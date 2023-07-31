package com.scaler.tictactoe;

import com.scaler.tictactoe.controller.GameController;
import com.scaler.tictactoe.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        System.out.println("Game is starting....");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Game dimensions");
        int dimension = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        int noOfPlayers = dimension - 1;
        System.out.println("Will there be any bots? Y?N");
        String isBot = scanner.next();
        if(isBot.equalsIgnoreCase("Y")){
            noOfPlayers = dimension - 2;
            System.out.println("What is the name of the Bot ");
            String name = scanner.next();
            System.out.println("What is the symbol for Bot ");
            String symbol = scanner.next();
            Bot bot = new Bot(name, symbol, BotDifficultyLevel.EASY);
            players.add(bot);
        }
        for(int i = 0; i < noOfPlayers; i++){
            System.out.println("What is the name of the player "+ (i+1));
            String name = scanner.next();
            System.out.println("What is the symbol for player "+(i+1));
            String symbol = scanner.next();

            Player player = new Player(name, symbol, PlayerType.HUMAN);
            players.add(player);
        }
        GameController gameController = new GameController();
        Game game = gameController.createGame(dimension,players);

        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){

        }
        if(gameController.getGameState(game).equals(GameState.DRAW)){
            System.out.println("Game has Drawn");
        }
        if(gameController.getGameState(game).equals(GameState.ENDED)){
            System.out.println(game.getPlayerWinner()+ " Has won the game");
        }

    }
}
