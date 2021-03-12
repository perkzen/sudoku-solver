package com.domen;

public class Sudoku {
    private final int[][] board;

    public Sudoku(int[][] board) {
        this.board = board;
    }

    public void printBoard() {

        int zeros_found = 0;
        for (int[] ints : board) {
            for (int j = 0; j < board.length; j++) {
                if (ints[j] == 0) {
                    zeros_found++;
                }
            }
        }

        System.out.println();
        if (zeros_found == 0) {
            System.out.printf("%21s", "Solved Sudoku");
        } else {
            System.out.printf("%22s", "Unsolved Sudoku");
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {

            if (i % 3 == 0 && i != 0) {
                for (int line = 0; line < board.length * 3 + 1; line++) {
                    System.out.print("-");
                }
                System.out.println();
            }

            for (int j = 0; j < board.length; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("|");
                }
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[] find_empty() {

        int[] position = new int[2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return null;
    }

    public boolean isValid(int[] position, int[][] board, int number) {

        int row_pos = position[0];
        int col_pos = position[1];

        // is the number in row
        for (int col = 0; col < board.length; col++) {
            if (board[row_pos][col] == number && col != col_pos) {
                return false;
            }
        }
        // is the number in col
        for (int row = 0; row < board.length; row++) {
            if (board[row][col_pos] == number && row != row_pos) {
                return false;
            }
        }
        // is the number in the box
        int box_y = position[0] / 3;
        int box_x = position[1] / 3;

        for (int i = box_y * 3; i < box_y * 3 + 3; i++) {
            for (int j = box_x * 3; j < box_x * 3 + 3; j++) {
                if (board[i][j] == number && i != row_pos && j != col_pos) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve() {

        int[] emptyPosition = find_empty();

        if (emptyPosition == null) {
            // board is solved
            return true;
        }

        // backtracking algorithm
        for (int number = 1; number < 10; number++) {
            if (isValid(emptyPosition, board, number)) {
                board[emptyPosition[0]][emptyPosition[1]] = number;
                if (solve()) {
                    return true;
                } else {
                    board[emptyPosition[0]][emptyPosition[1]] = 0;
                }
            }
        }
        return false;
    }
}
