package application;

import java.util.Random;
import java.util.Scanner;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class OpponentController {


    private static final Ship[][] gameBoard = new Ship[10][10];
    public static final Ship fleet[] = new Ship[8];


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
    
    public static boolean checkOverlap(int x, int y) {
    	if (getState(x,y) == fleet[0]) {
    		return true;
    	}
    	else if (getState(x,y) == fleet[1]) {
    		return true;
    	}
    	else if (getState(x,y) == fleet[2]) {
    		return true;
    	}
    	else if (getState(x,y) == fleet[3]) {
    		return true;
    	}
    	else if (getState(x,y) == fleet[4]) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    static Image carrier1Img = new Image("application/carrier1.png");
    static Image carrier2Img = new Image("application/carrier2.png");
    static Image carrier3Img = new Image("application/carrier3.png");
    static Image carrier4Img = new Image("application/carrier4.png");
    static Image carrier5Img = new Image("application/carrier5.png");
    
    static Image carrier6Img = new Image("application/carrier6.png");
    static Image carrier7Img = new Image("application/carrier7.png");
    static Image carrier8Img = new Image("application/carrier8.png");
    static Image carrier9Img = new Image("application/carrier9.png");
    static Image carrier10Img = new Image("application/carrier10.png");
    
    static Image battleship1Img = new Image("application/battleship1.png");
    static Image battleship2Img = new Image("application/battleship2.png");
    static Image battleship3Img = new Image("application/battleship3.png");
    static Image battleship4Img = new Image("application/battleship4.png");
    
    static Image battleship5Img = new Image("application/battleship5.png");
    static Image battleship6Img = new Image("application/battleship6.png");
    static Image battleship7Img = new Image("application/battleship7.png");
    static Image battleship8Img = new Image("application/battleship8.png");
    
    static Image sub1Img = new Image("application/sub1.png");
    static Image sub2Img = new Image("application/sub2.png");
    static Image sub3Img = new Image("application/sub3.png");
    
    static Image sub4Img = new Image("application/sub4.png");
    static Image sub5Img = new Image("application/sub5.png");
    static Image sub6Img = new Image("application/sub6.png");
    
    
    static Image cruiser1Img = new Image("application/cruiser1.png");
    static Image cruiser2Img = new Image("application/cruiser2.png");
    static Image cruiser3Img = new Image("application/cruiser3.png");
    
    static Image cruiser4Img = new Image("application/cruiser4.png");
    static Image cruiser5Img = new Image("application/cruiser5.png");
    static Image cruiser6Img = new Image("application/cruiser6.png");
    
    
    static Image destroyer1Img = new Image("application/destroyer1.png");
    static Image destroyer2Img = new Image("application/destroyer2.png");
    
    static Image destroyer3Img = new Image("application/destroyer3.png");
    static Image destroyer4Img = new Image("application/destroyer4.png");


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

    }   
    
    public static void setCarrier() {
    	int xAxis, yAxis, alignment;
    	Random randomNum = new Random();
    	alignment = randomNum.nextInt(2);
    	yAxis = randomNum.nextInt(10);
        xAxis = randomNum.nextInt(10);
        if (alignment == 0) {
        	placeCarrier(xAxis,yAxis);
        }
        else {
        	placeCarrierVertical(xAxis,yAxis);
        }
 	 }
    
    public static void setBattleship() {
    	int xAxis, yAxis, alignment;
    	Random randomNum = new Random();
    	alignment = randomNum.nextInt(2);
    	yAxis = randomNum.nextInt(10);
        xAxis = randomNum.nextInt(10);
        if (alignment == 0) {
        	placeBattleship(xAxis,yAxis);
        }
        else {
        	placeBattleshipVertical(xAxis,yAxis);
        }
 	 }
    
     public static void setSub() {
    	int xAxis, yAxis, alignment;
    	Random randomNum = new Random();
    	alignment = randomNum.nextInt(2);
    	yAxis = randomNum.nextInt(10);
        xAxis = randomNum.nextInt(10);
        if (alignment == 0) {
        	placeSub(xAxis,yAxis);
        }
        else {
        	placeSubVertical(xAxis,yAxis);
        }
 	 }
     
     public static void setCruiser() {
     	int xAxis, yAxis, alignment;
     	Random randomNum = new Random();
     	alignment = randomNum.nextInt(2);
     	yAxis = randomNum.nextInt(10);
         xAxis = randomNum.nextInt(10);
         if (alignment == 0) {
         	placeCruiser(xAxis,yAxis);
         }
         else {
         	placeCruiserVertical(xAxis,yAxis);
         }
  	 }
     
     public static void setDestroyer() {
      	int xAxis, yAxis, alignment;
      	Random randomNum = new Random();
      	alignment = randomNum.nextInt(2);
      	yAxis = randomNum.nextInt(10);
          xAxis = randomNum.nextInt(10);
          if (alignment == 0) {
          	placeDestroyer(xAxis,yAxis);
          }
          else {
          	placeDestroyerVertical(xAxis,yAxis);
          }
   	 }
    
    public static void placeCarrier(int x, int y) {
 	   if (x + 4 > 9) {
 		   setCarrier();
 	   }
 	   else {
 		   gameBoard[x][y] = fleet[4];
 		   gameBoard[x + 1][y] = fleet[4];
 		   gameBoard[x + 2][y] = fleet[4];
 		   gameBoard[x + 3][y] = fleet[4];
 		   gameBoard[x + 4][y] = fleet[4];
 		   setBattleship();
 	   }
    }  
    
    public static void placeCarrierVertical(int x, int y) {
 	   if (y + 4 > 9) {
 		   setCarrier();
 	   }
 	   else {
 		   gameBoard[x][y] = fleet[4];
 		   gameBoard[x][y + 1] = fleet[4];
 		   gameBoard[x][y + 2] = fleet[4];
 		   gameBoard[x][y + 3] = fleet[4];
 		   gameBoard[x][y + 4] = fleet[4];
 		   setBattleship();
 	   }
    }  
    
    public static void placeBattleship(int x, int y) {
 	   if (x + 3 > 9) {
 		   	setBattleship();
 	   }
 	   else if (checkOverlap(x,y) == true ||
 			    checkOverlap(x + 1, y) == true ||
 			    checkOverlap(x + 2, y) == true ||
 			    checkOverlap(x + 3, y) == true) {
 		   			setBattleship();
 	   }
 	   else {
 	   		gameBoard[x][y] = fleet[3];
 	   		gameBoard[x + 1][y] = fleet[3];
 	   		gameBoard[x + 2][y] = fleet[3];
 	   		gameBoard[x + 3][y] = fleet[3];
 	   		setSub();
 	   }
     }
    
    public static void placeBattleshipVertical(int x, int y) {
 	   if (y + 3 > 9) {
 		   	setBattleship();
 	   }
 	   else if (checkOverlap(x,y) == true ||
 			    checkOverlap(x, y + 1) == true ||
 			    checkOverlap(x, y + 2) == true ||
 			    checkOverlap(x, y + 3) == true) { 
 		   			setBattleship();
 	   }
 	 	else {
 	   		gameBoard[x][y] = fleet[3];
 	   		gameBoard[x][y + 1] = fleet[3];
 	   		gameBoard[x][y + 2] = fleet[3];
 	   		gameBoard[x][y + 3] = fleet[3];
 	   		setSub();
 	   }
     }
    
    public static void placeSub(int x, int y) {
 	   if (x + 2 > 9) {
 		   	setSub();
 	   }
 	   else if (checkOverlap(x,y) == true ||
 			    checkOverlap(x + 1, y) == true ||
 			    checkOverlap(x + 2, y) == true) {
 		   			setSub();
 	   }
 	   else {
 		   gameBoard[x][y] = fleet[1];
 		   gameBoard[x + 1][y] = fleet[1];
 		   gameBoard[x + 2][y] = fleet[1];
 		   setCruiser();
 	   }
    }
    
    public static void placeSubVertical(int x, int y) {
 	   if (y + 2 > 9) {
 		   	setSub();
 	   }
 	   else if (checkOverlap(x,y) == true ||
 			    checkOverlap(x, y + 1) == true ||
 			    checkOverlap(x, y + 2) == true) { 
 		   			setSub();
 	   }
 	   else {
 		   gameBoard[x][y] = fleet[1];
 		   gameBoard[x][y + 1] = fleet[1];
 		   gameBoard[x][y + 2] = fleet[1];
 		   setCruiser();
 	   }
    }

    public static void placeCruiser(int x, int y) {
 	   if (x + 2 > 9) {
 		   	setCruiser();
 	   }
 	   else if (checkOverlap(x,y) == true ||
 			    checkOverlap(x + 1, y) == true ||
 			    checkOverlap(x + 2, y) == true) {
 		   			setCruiser();
 	   }
 	   else {
 		   gameBoard[x][y] = fleet[2];
 		   gameBoard[x + 1][y] = fleet[2];
 		   gameBoard[x + 2][y] = fleet[2];
 		   setDestroyer();
 	   }
    }
    
    public static void placeCruiserVertical(int x, int y) {
 	   if (y + 2 > 9) { 
 		   	setCruiser();
 	   }
 	   else if (checkOverlap(x,y) == true ||
 			    checkOverlap(x, y + 1) == true ||
 			    checkOverlap(x, y + 2) == true) { 
 		   			setCruiser();
 	   }
 	   else {
 		   gameBoard[x][y] = fleet[2];
 		   gameBoard[x][y + 1] = fleet[2];
 		   gameBoard[x][y + 2] = fleet[2];
 		   setDestroyer();
 	   }
    }
    
    public static void placeDestroyer(int x, int y) {
 	   if (x + 1 > 9) {
 		   	setDestroyer();
 	   }
 	   else if (checkOverlap(x,y) == true ||
 			    checkOverlap(x + 1, y) == true) {
 		   			setDestroyer();
 	   }
 	   else {
 		   gameBoard[x][y] = fleet[0];
 		   gameBoard[x + 1][y] = fleet[0];
 	   }
    }
    
    public static void placeDestroyerVertical(int x, int y) {
 	   if (y + 1 > 9) {
 		   	setDestroyer();
 	   }
 	   else if (checkOverlap(x,y) == true ||
 			    checkOverlap(x, y + 1) == true) { 
 		   			setDestroyer();
 	   }
 	   else {
 		   gameBoard[x][y] = fleet[0];
 		   gameBoard[x][y + 1] = fleet[0];
 	   }
    }

}
