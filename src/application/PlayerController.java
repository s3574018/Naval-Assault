package application;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PlayerController {

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

    // creates the images for that make up the battleship.
    static Image battleship1Img = new Image("application/battleship1.png");
    static Image battleship2Img = new Image("application/battleship2.png");
    static Image battleship3Img = new Image("application/battleship3.png");
    static Image battleship4Img = new Image("application/battleship4.png");
    
    static Image carrier1Img = new Image("application/carrier1.png");
    static Image carrier2Img = new Image("application/carrier2.png");
    static Image carrier3Img = new Image("application/carrier3.png");
    static Image carrier4Img = new Image("application/carrier4.png");
    static Image carrier5Img = new Image("application/carrier5.png");
    
    static Image sub1Img = new Image("application/sub1.png");
    static Image sub2Img = new Image("application/sub2.png");
    static Image sub3Img = new Image("application/sub3.png");
    
    static Image cruiser1Img = new Image("application/cruiser1.png");
    static Image cruiser2Img = new Image("application/cruiser2.png");
    static Image cruiser3Img = new Image("application/cruiser3.png");
    
    static Image destroyer1Img = new Image("application/destroyer1.png");
    static Image destroyer2Img = new Image("application/destroyer2.png");
    

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
    	   for (int yAxis = 0; yAxis < PlayAndrew.player.length; yAxis++) {
    	       	for (int xAxis = 0; xAxis < PlayAndrew.player.length; xAxis++) {
    	       	Button button = PlayAndrew.player[xAxis][yAxis];
    	    	    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
    	    		   @Override
    	    		   public void handle(MouseEvent event) {
    	    				   	int x = (int) button.getLayoutX();
    	    				   	int y = (int) button.getLayoutY();
    	    				   	placeCarrier(x/40,y/40);
    	    				   	setBattleship();
    	    		   			}
    	    	    });
    	       	}
    	   }
    	   }    
    
    public static void setBattleship() {
    for (int yAxis = 0; yAxis < PlayAndrew.player.length; yAxis++) {
        for (int xAxis = 0; xAxis < PlayAndrew.player.length; xAxis++) {
        	Button button = PlayAndrew.player[xAxis][yAxis];
     	    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
     		   @Override
     		   public void handle(MouseEvent event) {
     			   int x = (int) button.getLayoutX();
     			   int y = (int) button.getLayoutY();
     			   System.out.print(x);System.out.println(y);
     			   placeBattleship(x/40,y/40);
     			   setSub();
               }
            });
        }
    }
    }

    public static void setSub() {
        for (int yAxis = 0; yAxis < PlayAndrew.player.length; yAxis++) {
            for (int xAxis = 0; xAxis < PlayAndrew.player.length; xAxis++) {
            	Button button = PlayAndrew.player[xAxis][yAxis];
         	    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
         		   @Override
         		   public void handle(MouseEvent event) {
         			   int x = (int) button.getLayoutX();
         			   int y = (int) button.getLayoutY();
         			   placeSub(x/40,y/40);
         			   setCruiser();
                   }
                });
            }
        }
        }
    
    public static void setCruiser() {
        for (int yAxis = 0; yAxis < PlayAndrew.player.length; yAxis++) {
            for (int xAxis = 0; xAxis < PlayAndrew.player.length; xAxis++) {
            	Button button = PlayAndrew.player[xAxis][yAxis];
         	    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
         		   @Override
         		   public void handle(MouseEvent event) {
         			   int x = (int) button.getLayoutX();
         			   int y = (int) button.getLayoutY();
         			   placeCruiser(x/40,y/40);
         			   setDestroyer();
                   }
                });
            }
        }
        }

    public static void setDestroyer() {
        for (int yAxis = 0; yAxis < PlayAndrew.player.length; yAxis++) {
            for (int xAxis = 0; xAxis < PlayAndrew.player.length; xAxis++) {
            	Button button = PlayAndrew.player[xAxis][yAxis];
         	    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
         		   @Override
         		   public void handle(MouseEvent event) {
         			   int x = (int) button.getLayoutX();
         			   int y = (int) button.getLayoutY();
         			   placeDestroyer(x/40,y/40);      
         			   allPlaced();
                   }
                });
            }
        }
        }
    
    public static void allPlaced() {
        for (int yAxis = 0; yAxis < PlayAndrew.player.length; yAxis++) {
            for (int xAxis = 0; xAxis < PlayAndrew.player.length; xAxis++) {
            	Button button = PlayAndrew.player[xAxis][yAxis];
         	    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
         		   @Override
         		   public void handle(MouseEvent event) {
         			 Alert alert = new Alert(AlertType.INFORMATION);
         			 alert.setTitle("All Ships Placed");
         			 alert.setContentText("All your ships have been ssuccessfully placed"
         			 		+ " on the board!  Please choose your next shot on the opponents board.");
         			 alert.showAndWait();      			   
                   }
                });
            }
        }
        }
   
   public static void placeCarrier(int x, int y) {
       gameBoard[x][y] = fleet[4];
       PlayAndrew.player[x][y].setGraphic(new ImageView(carrier1Img));
       gameBoard[x + 1][y] = fleet[4];
       PlayAndrew.player[x + 1][y].setGraphic(new ImageView(carrier2Img));
       gameBoard[x + 2][y] = fleet[4];
       PlayAndrew.player[x + 2][y].setGraphic(new ImageView(carrier3Img));
       gameBoard[x + 3][y] = fleet[4];
       PlayAndrew.player[x + 3][y].setGraphic(new ImageView(carrier4Img));
       gameBoard[x + 4][y] = fleet[4];
       PlayAndrew.player[x + 4][y].setGraphic(new ImageView(carrier5Img));
       
   }  
   
   public static void placeBattleship(int x, int y) {
        gameBoard[x][y] = fleet[3];
        PlayAndrew.player[x][y].setGraphic(new ImageView(battleship1Img));
        gameBoard[x + 1][y] = fleet[3];
        PlayAndrew.player[x + 1][y].setGraphic(new ImageView(battleship2Img));
        gameBoard[x + 2][y] = fleet[3];
        PlayAndrew.player[x + 2][y].setGraphic(new ImageView(battleship3Img));
        gameBoard[x + 3][y] = fleet[3];
        PlayAndrew.player[x + 3][y].setGraphic(new ImageView(battleship4Img));
    }

   
   public static void placeSub(int x, int y) {
       gameBoard[x][y] = fleet[1];
       PlayAndrew.player[x][y].setGraphic(new ImageView(sub1Img));
       gameBoard[x + 1][y] = fleet[1];
       PlayAndrew.player[x + 1][y].setGraphic(new ImageView(sub2Img));
       gameBoard[x + 2][y] = fleet[1];
       PlayAndrew.player[x + 2][y].setGraphic(new ImageView(sub3Img));
   }
   
   public static void placeCruiser(int x, int y) {
       gameBoard[x][y] = fleet[2];
       PlayAndrew.player[x][y].setGraphic(new ImageView(cruiser1Img));
       gameBoard[x + 1][y] = fleet[2];
       PlayAndrew.player[x + 1][y].setGraphic(new ImageView(cruiser2Img));
       gameBoard[x + 2][y] = fleet[2];
       PlayAndrew.player[x + 2][y].setGraphic(new ImageView(cruiser3Img));
   }
   
   public static void placeDestroyer(int x, int y) {
       gameBoard[x][y] = fleet[0];
       PlayAndrew.player[x][y].setGraphic(new ImageView(destroyer1Img));
       gameBoard[x + 1][y] = fleet[0];
       PlayAndrew.player[x + 1][y].setGraphic(new ImageView(destroyer2Img));
   }
	
}
