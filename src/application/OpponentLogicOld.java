package application;

import java.util.Random;
import javafx.scene.image.ImageView;

public class OpponentLogicOld {

    // generates random grid coordinates and takes a shot. hit/miss status is
    // updated for the square chosen
    public static void randomShot() {
        int yAxis, xAxis;
        Random randomNum = new Random();
        boolean tryAgain = true;
        do {
            yAxis = randomNum.nextInt(10);
            xAxis = randomNum.nextInt(10);
            if (OpponentControllerOld.getState(xAxis,
                    yAxis) == OpponentControllerOld.fleet[0]
                    || OpponentControllerOld.getState(xAxis,
                            yAxis) == OpponentControllerOld.fleet[1]
                    || OpponentControllerOld.getState(xAxis,
                            yAxis) == OpponentControllerOld.fleet[2]
                    || OpponentControllerOld.getState(xAxis,
                            yAxis) == OpponentControllerOld.fleet[3]
                    || OpponentControllerOld.getState(xAxis,
                            yAxis) == OpponentControllerOld.fleet[4]) {
                OpponentControllerOld.setHit(xAxis, yAxis);
                PlayOld.computer[xAxis][yAxis].setGraphic(new ImageView(PlayOld.explosionImg));
                tryAgain = false;
                // System.out.println("Hit");
                 Stats.increaseHitCount();
                 Stats.increaseShotCount();
            } else if (OpponentControllerOld.getState(xAxis, yAxis) == null) {
                OpponentControllerOld.setMiss(xAxis, yAxis);
                PlayOld.computer[xAxis][yAxis].setGraphic(new ImageView(PlayOld.waterImg));
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
