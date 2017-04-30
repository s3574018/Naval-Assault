package application;

import java.util.Random;

public class OpponentLogic {

    // public static void main(String[] args) {
    //
    // }

    // generates random grid coordinates and takes a shot. hit/miss status is
    // updated for the square chosen
    public static void randomShot() {
        int xAxis, yAxis;
        Random randomNum = new Random();
        boolean tryAgain = true;
        do {
            xAxis = randomNum.nextInt(10);
            yAxis = randomNum.nextInt(10);
            if (OpponentController.getState(yAxis, xAxis) == "1") {
                OpponentController.setHit(yAxis, xAxis);
                tryAgain = false;
                System.out.println("Hit");
                Stats.increaseHitCount();
                Stats.increaseShotCount();
            } else if (OpponentController.getState(yAxis, xAxis) == ".") {
                OpponentController.setMiss(yAxis, xAxis);
                tryAgain = false;
                System.out.println("Miss");
                Stats.increaseMissCount();
                Stats.increaseShotCount();
            } else {
                System.out.println("Trying Again");
            }
            System.out.println(" xAxis is : " + xAxis);
            System.out.println(" yAxis is : " + yAxis);
            System.out.println(" Hit Count: " + Stats.getHitCount());
            System.out.println("Miss Count: " + Stats.getMissCount());
            System.out.println("Shot Count: " + Stats.getShotCount());
        } while (tryAgain == true);
    }
}
