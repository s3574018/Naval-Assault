package application;

import java.util.Scanner;

public class OpponentController {

    private static final String[][] gameBoard = new String[10][10];

    public static void main(String[] args) {
        clearGrid();
        setShips();
        printGrid();

        // allows user to prompt opponent to take another turn through turns and
        // prints updated board. is being used during development only
        String userInput;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("\nN for next turn or X to stop: ");
            userInput = sc.nextLine().toUpperCase();
            if (userInput.equals("X") == false) {
                System.out.println("Next turn\n");
                OpponentLogic.randomShot();
                printGrid();
            } else {
                System.out.println("Exiting the program...");
            }
        } while (userInput.charAt(0) != 'X');
        sc.close();
    }

    // resets all fields in array with 0's
    public static void clearGrid() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ".";
            }
        }
    }

    // prints current state of game board
    public static void printGrid() {
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        System.out.println("----------------------");
        int yAxis = 0;
        for (String[] i : gameBoard) {
            System.out.print(yAxis + "| ");
            yAxis++;
            for (String j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // hard-coding of ship locations
    public static void setShips() {

        // destroyer (2)
        gameBoard[1][0] = "1";
        gameBoard[1][1] = "1";

        // submarine (3)
        gameBoard[5][6] = "1";
        gameBoard[6][6] = "1";
        gameBoard[7][6] = "1";

        // cruiser (3)
        gameBoard[7][2] = "1";
        gameBoard[7][3] = "1";
        gameBoard[7][4] = "1";

        // battleship (4)
        gameBoard[0][8] = "1";
        gameBoard[1][8] = "1";
        gameBoard[2][8] = "1";
        gameBoard[3][8] = "1";

        // carrier (5)
        gameBoard[3][1] = "1";
        gameBoard[3][2] = "1";
        gameBoard[3][3] = "1";
        gameBoard[3][4] = "1";
        gameBoard[3][5] = "1";
    }

    // gets current state for gameBoard coordinate
    public static String getState(int yAxis, int xAxis) {
        return gameBoard[yAxis][xAxis];
    }

    // sets gameBoard coordinates to hit state
    public static void setHit(int yAxis, int xAxis) {
        gameBoard[yAxis][xAxis] = "X";
    }

    // sets gameBoard coordinates to miss state
    public static void setMiss(int yAxis, int xAxis) {
        gameBoard[yAxis][xAxis] = "O";
    }

}
