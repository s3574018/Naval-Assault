package application;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class GameGrid {

	private int boardSize;
	private int buttonSize;
	private int startX;
	private int startY;
	public boolean hasShip;
	
	public GameGrid (int boardSize, int buttonSize, int startX, int startY){
		this.boardSize = boardSize;
		this.buttonSize = buttonSize;
		this.startX = startX;
		this.startY = startY;
	}
	
	public Node createGrid() {
		Button[][] button = new Button[boardSize][boardSize];
		Group grid = new Group();
		for (int y=0; y < button.length; y++) {
        	for (int x=0; x < button.length; x++) {
        		button[x][y] = new Button();
        		button[x][y].setPrefSize(buttonSize,buttonSize);
        		button[x][y].setLayoutX(x * buttonSize + startX);
        		button[x][y].setLayoutY(y * buttonSize + startY);
        		button[x][y].setText(".");
        	    grid.getChildren().add(button[x][y]);
        	}
        }
		return grid; 		
	}

	
}
