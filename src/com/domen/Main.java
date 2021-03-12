package com.domen;

public class Main {

    public static void main(String[] args) {

        int[][] board =
                {
                        {0, 0, 9, 0, 0, 0, 0, 0, 0},
                        {0, 4, 8, 0, 0, 9, 0, 0, 3},
                        {0, 0, 0, 7, 8, 0, 0, 0, 9},
                        {0, 0, 0, 8, 0, 0, 2, 6, 0},
                        {0, 0, 4, 0, 0, 0, 1, 0, 0},
                        {0, 8, 7, 0, 0, 3, 0, 0, 0},
                        {7, 0, 0, 0, 2, 4, 0, 0, 0},
                        {8, 0, 0, 9, 0, 0, 5, 2, 0},
                        {0, 0, 0, 0, 0, 0, 7, 0, 0}
                };

        Sudoku game = new Sudoku(board);
        game.printBoard();
        game.solve();
        game.printBoard();

    }
}

