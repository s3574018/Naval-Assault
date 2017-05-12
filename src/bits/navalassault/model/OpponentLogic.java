package bits.navalassault.model;

import java.util.Random;

import bits.navalassault.view.BoardOverviewController;
import javafx.scene.image.ImageView;

public class OpponentLogic {

	static int yAxis;
	static int xAxis;
	static Random randomNum = new Random();
	static boolean tryAgain = true;

	// generates random grid coordinates and takes a shot. hit/miss status is
	// updated for the square chosen
	public static void randomShot() {
		yAxis = randomNum.nextInt(10);
		xAxis = randomNum.nextInt(10);
		if (PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[0]
				|| PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[1]
				|| PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[2]
				|| PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[3]
				|| PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[4]) {

			PlayerController.setHit(xAxis, yAxis);
			BoardOverviewController.player[xAxis][yAxis]
					.setGraphic(new ImageView(BoardOverviewController.explosionImg));
			tryAgain = true;
			// System.out.println("Hit");
			Stats.increaseHitCount();
			Stats.increaseShotCount();
		} else if (PlayerController.getState(xAxis, yAxis) == null) {
			PlayerController.setMiss(xAxis, yAxis);
			BoardOverviewController.player[xAxis][yAxis].setGraphic(new ImageView(BoardOverviewController.waterImg));
			tryAgain = false;
			// System.out.println("Miss");
			Stats.increaseMissCount();
			Stats.increaseShotCount();
			// System.out.println(" xAxis is : " + xAxis);
			// System.out.println(" yAxis is : " + yAxis);
			// System.out.println(" Hit Count: " + Stats.getHitCount());
			// System.out.println("Miss Count: " + Stats.getMissCount());
			// System.out.println("Shot Count: " + Stats.getShotCount());
		}
		if (tryAgain == true) {
			randomShot();
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
