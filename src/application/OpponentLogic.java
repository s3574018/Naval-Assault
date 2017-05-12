package application;

import java.awt.Point;
import java.util.Random;
import javafx.scene.image.ImageView;

public class OpponentLogic {

    public static void computerStart() {
        Ship lastTurn = PlayerController.fleet[7];
        do {
            boolean takeRandomShot = true;
            for (int i = 0; i < PlayerController.getArrayLength(); i++) {
                for (int j = 0; j < PlayerController.getArrayLength(); j++) {

                    // start of single hit to ship logic
                    // proceeds only if ship on square has been hit just once
                    if (PlayerController.getState(i,
                            j) == PlayerController.fleet[5]) {
                        Point[] shotOptions = new Point[4];
                        int shotOptionsCount = 0;

                        if (i - 1 >= 0) {
                            if (PlayerController.getState(i - 1,
                                    j) != PlayerController.fleet[5]
                                    && PlayerController.getState(i - 1,
                                            j) != PlayerController.fleet[6]) {
                                shotOptions[shotOptionsCount] = new Point(i - 1, j);
                                shotOptionsCount++;
                            }
                        }

                        if (i + 1 <= 9) {
                            if (PlayerController.getState(i + 1,
                                    j) != PlayerController.fleet[5]
                                    && PlayerController.getState(i + 1,
                                            j) != PlayerController.fleet[6]) {

                                shotOptions[shotOptionsCount] = new Point(i + 1, j);
                                shotOptionsCount++;
                            }
                        }
                        if (j - 1 >= 0) {
                            if (PlayerController.getState(i,
                                    j - 1) != PlayerController.fleet[5]
                                    && PlayerController.getState(i,
                                            j - 1) != PlayerController.fleet[6]) {

                                shotOptions[shotOptionsCount] = new Point(i, j - 1);
                                shotOptionsCount++;
                            }
                        }
                        if (i + 1 <= 9) {
                            if (PlayerController.getState(i,
                                    j + 1) != PlayerController.fleet[5]
                                    && PlayerController.getState(i,
                                            j + 1) != PlayerController.fleet[6]) {

                                shotOptions[shotOptionsCount] = new Point(i, j + 1);
                                shotOptionsCount++;
                            }
                        }
                        Random randomNum = new Random();
                        if (shotOptionsCount != 0) {
                            Point chosenShot = shotOptions[randomNum
                                    .nextInt(shotOptionsCount)];
                            takeShot((int) chosenShot.getX(),
                                    (int) chosenShot.getY());
                            takeRandomShot = false;
                        }

                    }
                    if (takeRandomShot == false) {
                        break;
                    }
                }
            }
            if (takeRandomShot == true) {
                randomShot();
            }

        } while (lastTurn == PlayerController.fleet[5]);

    }

    // generates random grid coordinates and takes a shot. hit/miss status is
    // updated for the square chosen
    public static void randomShot() {
        int yAxis, xAxis;
        Random randomNum = new Random();
        boolean tryAgain;
        do {
            yAxis = randomNum.nextInt(10);
            xAxis = randomNum.nextInt(10);
            tryAgain = takeShot(xAxis, yAxis);
        } while (tryAgain == true);
    }

    public static boolean takeShot(int xAxis, int yAxis) {
        if (PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[0]
                || PlayerController.getState(xAxis,
                        yAxis) == PlayerController.fleet[1]
                || PlayerController.getState(xAxis,
                        yAxis) == PlayerController.fleet[2]
                || PlayerController.getState(xAxis,
                        yAxis) == PlayerController.fleet[3]
                || PlayerController.getState(xAxis,
                        yAxis) == PlayerController.fleet[4]) {
            PlayerController.setHit(xAxis, yAxis);
            Play.player[xAxis][yAxis].setGraphic(new ImageView(Play.explosionImg));

            // remove stats call for computer after testing
            Stats.increaseHitCount();
            Stats.increaseShotCount();

            pause(400);

            return false;
        } else if (PlayerController.getState(xAxis, yAxis) == null) {
            PlayerController.setMiss(xAxis, yAxis);
            Play.player[xAxis][yAxis].setGraphic(new ImageView(Play.waterImg));

            // remove stats call for computer after testing
            Stats.increaseMissCount();
            Stats.increaseShotCount();

            pause(400);

            return false;
        } else {
            return true;
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
