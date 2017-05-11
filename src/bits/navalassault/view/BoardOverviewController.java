package bits.navalassault.view;

import bits.navalassault.MainApp;
import bits.navalassault.model.Grid;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BoardOverviewController {

	public static Button[][] player = new Button[10][10];
	public static Button[][] computer = new Button[10][10];

	// creates the images for the "hit" "miss" and "Cursor"
	public static Image explosionImg = new Image("bits/navalassault/resources/explosion.png");
	public static Image waterImg = new Image("bits/navalassault/resources/water.png");
	public static Image cursorImg = new Image("bits/navalassault/resources/crosshairs.png");
	
	@FXML
	private AnchorPane boardPane;
	@FXML
	private Label statusLabel;
	@FXML
	private Pane statusPane;

	// Reference to the main application.
	private MainApp mainApp;

	// constructor
	public BoardOverviewController() {
	}

	@FXML
	private void initialize() {
	    Grid cGrid = new Grid(50, 90, 150);
	    GridPane computerBoard = (GridPane) cGrid.createGrid(player);
				
	    Grid pGrid = new Grid(50, 690, 150);
	    GridPane playerBoard = (GridPane) pGrid.createGrid(player);
		
		boardPane.getChildren().addAll(playerBoard);
		boardPane.getChildren().addAll(computerBoard);
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void handleMouseEntry() {
		mainApp.scene.setCursor(new ImageCursor(cursorImg));
	}

	public void handleMouseExit() {
		mainApp.scene.setCursor(null);
	}

	// Method to put the "Hit" image on a button
	public static void setHit(Button button) {
		button.setGraphic(new ImageView(explosionImg));
	}

	// Method to put the "Miss" image on a button
	public static void setMiss(Button button) {
		button.setGraphic(new ImageView(waterImg));
	}
}