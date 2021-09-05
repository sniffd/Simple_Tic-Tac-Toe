package tictactoe;

import java.util.Scanner;

public class Main {
    private static char currentSymbol = 'X';
    private static final char[][] grid = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static int movesCounter = 0;

    public static void main(String[] args) {
        printField();
        while (true) {
            makeMove();
            printField();
            if (isSymbolWins('X')) {
                System.out.println("X wins");
                return;
            } else if (isSymbolWins('O')) {
                System.out.println("O wins");
                return;
            } else if (movesCounter == 9) {
                System.out.println("Draw");
            }
        }
    }

    private static boolean isSymbolWins(char symbol) {
        return grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol ||
                grid[2][0] == symbol && grid[1][1] == symbol && grid[0][2] == symbol ||
                grid[0][0] == symbol && grid[0][1] == symbol && grid[0][2] == symbol ||
                grid[1][0] == symbol && grid[1][1] == symbol && grid[1][2] == symbol ||
                grid[2][0] == symbol && grid[2][1] == symbol && grid[2][2] == symbol ||
                grid[0][0] == symbol && grid[1][0] == symbol && grid[2][0] == symbol ||
                grid[0][1] == symbol && grid[1][1] == symbol && grid[2][1] == symbol ||
                grid[0][2] == symbol && grid[1][2] == symbol && grid[2][2] == symbol;
    }

    private static void printField() {
        int index = 0;

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++, index++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static void makeMove() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                int i = sc.nextInt() - 1;
                int j = sc.nextInt() - 1;
                if (grid[i][j] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                grid[i][j] = currentSymbol;
                movesCounter++;
                if (currentSymbol == 'X') {
                    currentSymbol = 'O';
                } else if (currentSymbol == 'O') {
                    currentSymbol = 'X';
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
    }
}
