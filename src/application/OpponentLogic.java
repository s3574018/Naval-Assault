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
            
            // below code is now broken. still investigating. maybe use switch?
            if (OpponentController.getState(yAxis, xAxis) == OpponentController.fleet[0] ||
                    OpponentController.getState(yAxis, xAxis) == OpponentController.fleet[1] ||
                    OpponentController.getState(yAxis, xAxis) == OpponentController.fleet[2] ||
                    OpponentController.getState(yAxis, xAxis) == OpponentController.fleet[3] ||
                    OpponentController.getState(yAxis, xAxis) == OpponentController.fleet[4]) {
                OpponentController.setHit(yAxis, xAxis);
                tryAgain = false;
                System.out.println("Hit");
                Stats.increaseHitCount();
                Stats.increaseShotCount();
            } else if (OpponentController.getState(yAxis,
                    xAxis) == null) {
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
