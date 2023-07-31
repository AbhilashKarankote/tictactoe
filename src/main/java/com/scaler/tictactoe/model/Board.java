package com.scaler.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> board = new ArrayList<>();

    Board(int dimension){
        for(int i = 0; i< dimension; i++){
            board.add(new ArrayList<>());
            for(int j = 0; j < dimension; j++){
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void displayBoard() {
        for(int i = 0; i < board.size(); i++)
            for(int j= 0; j < board.size(); j++){
                if(board.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    System.out.print("|   |");
                } else {
                    System.out.print("| "+board.get(i).get(j).getPlayer().getSymbol()+" |");
                }
            }
        System.out.println();
    }
}
