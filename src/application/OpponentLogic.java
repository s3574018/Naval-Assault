package application;

import java.awt.Point;
import java.util.Random;
import javafx.scene.image.ImageView;

public class OpponentLogic {

    public static void computerStart() {
//        Ship lastTurn = PlayerController.fleet[7];
            boolean takeRandomShot = true;
            for (int i = 0; i < PlayerController.getArrayLength(); i++) {
                for (int j = 0; j < PlayerController.getArrayLength(); j++) {
                    
                    //contains ship object for current square
                    Ship currentSquare = PlayerController.getState(i, j);
                    
                    // start of single hit to ship logic
                    // proceeds only if ship on square has been hit just once
                    if (PlayerController.getHitMiss(i, j) == PlayerController.fleet[5] && currentSquare.getHitCount() == 1 ) {
                        Point[] shotOptions = new Point[4];
                        int shotOptionsCount = 0;
                        
                        //ensures selection is in range
                        if (i - 1 >= 0) {
                            
                        //checks if adjacent is empty and if yes adds to array
                            if (PlayerController.getHitMiss(i - 1, j) == PlayerController.fleet[7]) {
                                shotOptions[shotOptionsCount] = new Point(i - 1, j);
                                shotOptionsCount++;
                            }
                        }
                        
                        if (i + 1 <= 9) {
                            if (PlayerController.getHitMiss(i + 1, j) == PlayerController.fleet[7]) {
                                shotOptions[shotOptionsCount] = new Point(i + 1, j);
                                shotOptionsCount++;
                            }
                        }
                        
                        if (j - 1 >= 0) {
                            if (PlayerController.getHitMiss(i, j - 1) == PlayerController.fleet[7]) {
                                shotOptions[shotOptionsCount] = new Point(i, j - 1);
                                shotOptionsCount++;
                            }
                        }
                        
                        if (j + 1 <= 9) {
                            if (PlayerController.getHitMiss(i, j + 1) == PlayerController.fleet[7]) {
                                shotOptions[shotOptionsCount] = new Point(i, j + 1);
                                shotOptionsCount++;
                            }
                        }
                        
                        //selects random array location which contains grid coordinates
                        Random randomNum = new Random();
                        if (shotOptionsCount != 0) {
                            Point chosenShot = shotOptions[randomNum.nextInt(shotOptionsCount)];
                            takeShot((int) chosenShot.getX(),(int) chosenShot.getY());
                            takeRandomShot = false;
                            break;
                        }
                    }                    
                    
                    // start of two or more hit to ship logic
                    // proceeds only if ship on square has been hit more than 
                    // once and if ship health not 0
                    if (PlayerController.getHitMiss(i, j) == PlayerController.fleet[5] && currentSquare.getHitCount() > 1 && currentSquare.getHealth() != 0) {
                        if (currentSquare.getShipVertical() == true) {    
                            boolean otherEnd = true;
                                if (j - 1 >= 0) {
                                    if (PlayerController.getHitMiss(i, j - 1) == PlayerController.fleet[7]) {
                                        takeShot(i, j - 1);
                                        otherEnd = false;
                                    }
                                }
                                 if (j + 1 <= 9 && otherEnd == true) {
                                       if (PlayerController.getHitMiss(i, j + 1) == PlayerController.fleet[7]) {
                                               takeShot(i, j + 1);
                                       }
                               }
                        }
                    }
                }
            }
            
            if (takeRandomShot == true) {
                randomShot();
            }
    }

    // generates random grid coordinates and takes a shot. hit/miss status is
    // updated for the square chosen
    public static Ship randomShot() {
        int yAxis, xAxis;
        Random randomNum = new Random();
        Ship tryAgain;
        do {
            yAxis = randomNum.nextInt(10);
            xAxis = randomNum.nextInt(10);
            tryAgain = takeShot(xAxis, yAxis);
        } while (tryAgain == PlayerController.fleet[5]);
        return tryAgain;
    }

    public static Ship takeShot(int xAxis, int yAxis) {
        Ship currentSquare = PlayerController.getState(xAxis, yAxis);
        if (PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[0]
                || PlayerController.getState(xAxis,yAxis) == PlayerController.fleet[1]
                || PlayerController.getState(xAxis,yAxis) == PlayerController.fleet[2]
                || PlayerController.getState(xAxis,yAxis) == PlayerController.fleet[3]
                || PlayerController.getState(xAxis,yAxis) == PlayerController.fleet[4]) {
            PlayerController.setHit(xAxis, yAxis);
            currentSquare.deacreaseHealth();
//            currentSquare.setShipHit();
            currentSquare.increaseHitCount();
            
            //test code only
            System.out.println(currentSquare.getShipID());
            System.out.println("HitCount: " + currentSquare.getHitCount());
            System.out.println("Health: " + currentSquare.getHealth());
            System.out.println();
            
            Play.player[xAxis][yAxis].setGraphic(new ImageView(Play.explosionImg));

            // remove stats call for computer after testing
            Stats.increaseHitCount();
            Stats.increaseShotCount();

//            pause(400);

            return PlayerController.getState(xAxis, yAxis);
        } else if (PlayerController.getState(xAxis, yAxis) == null) {
            PlayerController.setMiss(xAxis, yAxis);
            Play.player[xAxis][yAxis].setGraphic(new ImageView(Play.waterImg));

            // remove stats call for computer after testing
            Stats.increaseMissCount();
            Stats.increaseShotCount();

//            pause(400);

            return PlayerController.getState(xAxis, yAxis);
        } else {
            return PlayerController.getState(xAxis, yAxis);
        }
    }

    // adds delay
    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
        }
    }
}
