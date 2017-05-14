package bits.navalassault.model;

import java.awt.Point;
import java.util.Random;

import bits.navalassault.view.BoardOverviewController;
import javafx.scene.image.ImageView;

public class OpponentLogic {

	static int yAxis;
	static int xAxis;
	static Random randomNum = new Random();
	static boolean tryAgain = true;
	static boolean hit;
	static boolean shipSunk;

	public static void shipHit() {
		Point[] shotSelect = new Point[4];
		
	}

	public static void takeShot() {
		do {
			randomShot();
		} while (tryAgain == true);
	}

	// generates random grid coordinates and takes a shot. hit/miss status is
	// updated for the square chosen
	public static void randomShot() {
		yAxis = randomNum.nextInt(10);
		xAxis = randomNum.nextInt(10);
		if ((PlayerController.getState(xAxis, yAxis) != PlayerController.fleet[5])
				&& (PlayerController.getState(xAxis, yAxis) != PlayerController.fleet[6])) {

			if (PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[0]
					|| PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[1]
					|| PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[2]
					|| PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[3]
					|| PlayerController.getState(xAxis, yAxis) == PlayerController.fleet[4]) {

				PlayerController.setHit(xAxis, yAxis);
				BoardOverviewController.player[xAxis][yAxis]
						.setGraphic(new ImageView(BoardOverviewController.explosionImg));

				tryAgain = true;
				Stats.increaseHitCount();
				Stats.increaseShotCount();
			}
			if (PlayerController.getState(xAxis, yAxis) == null) {
				PlayerController.setMiss(xAxis, yAxis);
				BoardOverviewController.player[xAxis][yAxis]
						.setGraphic(new ImageView(BoardOverviewController.waterImg));
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
			System.out.println(tryAgain);
			System.out.println(xAxis + " " + yAxis);
		}
		else {
			tryAgain = true;
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
