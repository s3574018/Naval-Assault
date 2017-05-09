package application;

import java.util.Scanner;

public class OpponentControllerAndrew {


    private static final Ship[][] gameBoard = new Ship[10][10];
    public static final Ship fleet[] = new Ship[8];

//    public static void main(String[] args) { 
//        clearGrid();
//        setShips();
//        printGrid();
//
//        // allows user to prompt opponent to take another turn through turns and
//        // prints updated board. is being used during development only
//        String userInput;
//        Scanner sc = new Scanner(System.in);
//        do {
//            System.out.print("\nN for next turn or X to stop: ");
//            userInput = sc.nextLine().toUpperCase();
//            if (userInput.equals("X") == false) {
//                System.out.println("Next turn\n");
//                OpponentLogic.randomShot();
//                printGrid();
//            } else {
//                System.out.println("Game Statistics");
//                System.out.printf("Hit Percentage: %.2f%%",
//                        ((double) Stats.getHitCount() / Stats.getShotCount())
//                                * 100);
//                System.out.printf("\nMiss Percentage: %.2f%%",
//                        ((double) Stats.getMissCount() / Stats.getShotCount())
//                                * 100);
//            }
//        } while (userInput.charAt(0) != 'X');
//        sc.close();
//    }

    // gets current state for gameBoard coordinate
    public static Ship getState(int xAxis, int yAxis) {
        return gameBoard[xAxis][yAxis];
    }

    // sets gameBoard coordinate to hit state
    public static void setHit(int xAxis, int yAxis) {
        gameBoard[xAxis][yAxis] = fleet[5];
    }

    // sets gameBoard coordinate to miss state
    public static void setMiss(int xAxis, int yAxis) {
        gameBoard[xAxis][yAxis] = fleet[6];
    }

    // resets all fields in array with empty ship object
    public static void clearGrid() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = fleet[7];
            }
        }
    }

    // prints current state of game board
//    public static void printGrid() {
//        System.out.println("   0 1 2 3 4 5 6 7 8 9");
//        System.out.print("----------------------");
//        for (int i = 0; i < gameBoard.length; i++) {
//            System.out.println();
//            System.out.print(i + "| ");
//            for (int j = 0; j < gameBoard[i].length; j++) {
//                if (gameBoard[i][j] == null) {
//                    System.out.print(". ");
//                } else if (gameBoard[i][j] == fleet[5]) {
//                    System.out.print("X ");
//                } else if (gameBoard[i][j] == fleet[6]) {
//                    System.out.print("O ");
//
//                } else {
//                    System.out.print(". ");
//                }
//            }
//        }
//    }

    // hard-coding of ship locations
    public static void setShips() {
        fleet[0] = new Ship("destroyer", 2);
        fleet[1] = new Ship("submarine", 3);
        fleet[2] = new Ship("cruiser", 3);
        fleet[3] = new Ship("battleship", 4);
        fleet[4] = new Ship("carrier", 5);
        fleet[5] = new Ship("hit", -1);
        fleet[6] = new Ship("miss", -1);
        fleet[7] = new Ship("empty", -1);

        // destroyer (2)
        gameBoard[1][0] = fleet[0];
        gameBoard[1][1] = fleet[0];

        // submarine (3)
        gameBoard[5][6] = fleet[1];
        gameBoard[6][6] = fleet[1];
        gameBoard[7][6] = fleet[1];

        // cruiser (3)
        gameBoard[7][2] = fleet[2];
        gameBoard[7][3] = fleet[2];
        gameBoard[7][4] = fleet[2];

        // battleship (4)
        gameBoard[0][8] = fleet[3];
        gameBoard[1][8] = fleet[3];
        gameBoard[2][8] = fleet[3];
        gameBoard[3][8] = fleet[3];

        // carrier (5)
        gameBoard[3][1] = fleet[4];
        gameBoard[3][2] = fleet[4];
        gameBoard[3][3] = fleet[4];
        gameBoard[3][4] = fleet[4];
        gameBoard[3][5] = fleet[4];
    }

}
