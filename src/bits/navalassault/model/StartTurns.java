package bits.navalassault.model;

import bits.navalassault.view.BoardOverviewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class StartTurns {
	
	public static void takeTurns() {
		for (int yAxis = 0; yAxis < BoardOverviewController.computer.length; yAxis++) {
            for (int xAxis = 0; xAxis < BoardOverviewController.computer.length; xAxis++) {
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
                        }
                    });
                } else {
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                    	public void handle(ActionEvent event) {
                        	BoardOverviewController.setMiss(button);
                            
                            // prompts computer to take a random shot once
                            OpponentLogic.randomShot();
                        }
                    });
                }
            }
		}
	}
}
