package application;

import java.util.Random;
import javafx.scene.image.ImageView;

public class OpponentLogic {

    // generates random grid coordinates and takes a shot. hit/miss status is
    // updated for the square chosen
    public static void randomShot() {
        int yAxis, xAxis;
        Random randomNum = new Random();
        boolean tryAgain = true;
        do {
            yAxis = randomNum.nextInt(10);
            xAxis = randomNum.nextInt(10);
            if (PlayerController.getState(xAxis,
                    yAxis) == PlayerController.fleet[0]
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
                tryAgain = false;
                // System.out.println("Hit");
                 Stats.increaseHitCount();
                 Stats.increaseShotCount();
            } else if (PlayerController.getState(xAxis, yAxis) == null) {
            	PlayerController.setMiss(xAxis, yAxis);
            	Play.player[xAxis][yAxis].setGraphic(new ImageView(Play.waterImg));
                tryAgain = false;
                // System.out.println("Miss");
                 Stats.increaseMissCount();
                 Stats.increaseShotCount();
            } else {
                // System.out.println("Trying Again");
            }
            // System.out.println(" xAxis is : " + xAxis);
            // System.out.println(" yAxis is : " + yAxis);
            // System.out.println(" Hit Count: " + Stats.getHitCount());
            // System.out.println("Miss Count: " + Stats.getMissCount());
            // System.out.println("Shot Count: " + Stats.getShotCount());
        } while (tryAgain == true);
    }
}
