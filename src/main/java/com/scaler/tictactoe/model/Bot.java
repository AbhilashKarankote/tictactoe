package com.scaler.tictactoe.model;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    Bot(String name, String symbol, BotDifficultyLevel botDifficultyLevel){
        super(name,symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
