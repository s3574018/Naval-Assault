package application;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


/*My GameGrid class has 3 variable:
  - buttonSize is an integer used to set the size of each grid button
  - startX is the starting X coordinate of the Grid
  - startY is the starting Y coordinate of the Grid.
*/
public class GameGrid {

	private int buttonSize;
	private int startX;
	private int startY;
	
	public GameGrid (int buttonSize, int startX, int startY){
		this.buttonSize = buttonSize;
		this.startX = startX;
		this.startY = startY;
	}
		
/*This method takes a 2D array of buttons then creates a new GridPane
  and place them buttons on the GridPane which is then returned
 */
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
		return grid; 		
	}
}

