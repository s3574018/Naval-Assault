package bits.navalassault.model;

import bits.navalassault.MainApp;
import bits.navalassault.model.OpponentController;
import bits.navalassault.model.OpponentLogic;
import bits.navalassault.model.Ship;
import bits.navalassault.model.Stats;
import bits.navalassault.view.BoardOverviewController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class StartTurns {
	
	// Reference to the main application.
	private static MainApp mainApp;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public static void takeTurns() {

		for (int yAxis = 0; yAxis < BoardOverviewController.computer.length; yAxis++) {
			for (int xAxis = 0; xAxis < BoardOverviewController.computer.length; xAxis++) {
				Ship currentSquare = OpponentController.getState(yAxis, xAxis);
				Button button = BoardOverviewController.computer[yAxis][xAxis];
				if (OpponentController.getState(yAxis, xAxis) == OpponentController.fleet[0]
						|| OpponentController.getState(yAxis, xAxis) == OpponentController.fleet[1]
						|| OpponentController.getState(yAxis, xAxis) == OpponentController.fleet[2]
						|| OpponentController.getState(yAxis, xAxis) == OpponentController.fleet[3]
						|| OpponentController.getState(yAxis, xAxis) == OpponentController.fleet[4]) {
					button.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							BoardOverviewController.setHit(button);
							currentSquare.decreaseHealth();
							Stats.increaseHitCount();
							Stats.increaseShotCount();
							Stats.addHitValue();

							// test code
							if (currentSquare != null) {
								if (currentSquare.getHealth() == 0) {
									if (currentSquare.getShipID() == "destroyer") {
										Alert alert = new Alert(AlertType.INFORMATION);
										alert.setTitle("Ship Sunk");
										alert.setContentText("You have sunk the enemy Destroyer, take another shot!");
										alert.showAndWait();
									}
									if (currentSquare.getShipID() == "submarine") {
										Alert alert = new Alert(AlertType.INFORMATION);
										alert.setTitle("Ship Sunk");
										alert.setContentText("You have sunk the enemy Submarine, take another shot!");
										alert.showAndWait();
									}
									if (currentSquare.getShipID() == "cruiser") {
										Alert alert = new Alert(AlertType.INFORMATION);
										alert.setTitle("Ship Sunk");
										alert.setContentText("You have sunk the enemy Cruiser, take another shot!");
										alert.showAndWait();								
									}
									if (currentSquare.getShipID() == "battleship") {
										Alert alert = new Alert(AlertType.INFORMATION);
										alert.setTitle("Ship Sunk");
										alert.setContentText("You have sunk the enemy Battleship, take another shot!");
										alert.showAndWait();
									}
									if (currentSquare.getShipID() == "carrier") {
										Alert alert = new Alert(AlertType.INFORMATION);
										alert.setTitle("Ship Sunk");
										alert.setContentText("You have sunk the enemy Carrier, take another shot!");
										alert.showAndWait();
									}
									System.out.println("Ship sunk is: " + currentSquare.getShipID());
									currentSquare.setSinkStatusSent(true);
								}
							}
							if (currentSquare != null) {
								if (currentSquare.getHealth() == 0 && currentSquare.getIsAShip()) {
									OpponentController.decreaseShipsRemaining();
								}
							}
							if (OpponentController.getShipsRemaining() == 0) {
								OpponentController.setAllShipsSunk(true);
							}

							System.out.println("getShipID: " + currentSquare.getShipID());
							System.out.println("getHealth: " + currentSquare.getHealth());
							System.out.println("getHitCount: " + currentSquare.getHitCount());
							System.out.println("getShipsRemaining: " + OpponentController.getShipsRemaining());
							System.out.println("allShipsSunk: " + OpponentController.isAllShipsSunk());
							System.out.println();

							// test code only. to be removed before final
							// System.out.println("Hit Count: " +
							// Stats.getHitCount());
							// System.out.println("Miss Count: " +
							// Stats.getMissCount());
							// System.out.println("Shot Count: " +
							// Stats.getShotCount());
							// System.out.printf("Hit Percentage: %.2f%%\n",
							// ((double) Stats.getHitCount() /
							// Stats.getShotCount()) * 100);
							// System.out.printf("Miss Percentage: %.2f%%\n",
							// ((double) Stats.getMissCount() /
							// Stats.getShotCount()) * 100);
							// System.out.println("Consecutive Misses : " +
							// Stats.countConsecutiveMisses());
							// System.out.println("Consecutive Hits : " +
							// Stats.countConsecutiveHits());
							// Stats.printArray();
						}
					});
				} else {
					button.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							BoardOverviewController.setMiss(button);
							// OpponentController.setMiss(xAxis, yAxis);
							Stats.increaseMissCount();
							Stats.increaseShotCount();
							Stats.addMissValue();

							// test code only. to be removed before final
							// System.out.println("Hit Count: " +
							// Stats.getHitCount());
							// System.out.println("Miss Count: " +
							// Stats.getMissCount());
							// System.out.println("Shot Count: " +
							// Stats.getShotCount());
							// System.out.printf("Hit Percentage: %.2f%%\n",
							// ((double) Stats.getHitCount() /
							// Stats.getShotCount()) * 100);
							// System.out.printf("Miss Percentage: %.2f%%\n",
							// ((double) Stats.getMissCount() /
							// Stats.getShotCount()) * 100);
							// System.out.println("Consecutive Misses : " +
							// Stats.countConsecutiveMisses());
							// System.out.println("Consecutive Hits : " +
							// Stats.countConsecutiveHits());
							// Stats.printArray();

							// starts the computers turn
							OpponentLogic.computerStart();
						}
					});
				}
			}
		}
	}
}