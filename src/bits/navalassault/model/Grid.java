package bits.navalassault.model;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class Grid {
		
	private int buttonSize;
	private int startX;
	private int startY;
	
	public Grid (int buttonSize, int startX, int startY) {
		this.buttonSize = buttonSize;
		this.startX = startX;
		this.startY = startY;
	}
		
	public Node createGrid(Button[][] button) {
		GridPane grid = new GridPane(); 						
		for (int y=0; y < button.length; y++) {
	       	for (int x=0; x < button.length; x++) {
	       		button[x][y] = new Button();
	       		button[x][y].setPrefSize(buttonSize,buttonSize);
	       		button[x][y].setLayoutX(x * buttonSize + startX);
	      		button[x][y].setLayoutY(y * buttonSize + startY);
	       		button[x][y].setPadding(new Insets(0,0,0,0));
	       	    grid.add(button[x][y], x, y);
	       	    grid.setLayoutX(startX);
	       	    grid.setLayoutY(startY);
	       	}
	       }
		Button[][] player = new Button[10][10];
	    Button[][] computer = new Button[10][10];
	    
	    //new GameGrid created for the player
	    Grid playerGrid = new Grid(40,190,160);
	    GridPane playerBoard = (GridPane) playerGrid.createGrid(player);
	    
	    //new GameGrid created for the computer
	    Grid computerGrid = new Grid(40,690,160);
	    GridPane computerBoard = (GridPane) computerGrid.createGrid(computer);
	    
	    grid.getChildren().add(computerBoard); 
	    grid.getChildren().add(playerBoard);
		return grid; 		
	}
}
