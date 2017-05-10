package bits.navalassault.view;

import bits.navalassault.MainApp;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BoardOverviewController {

	public Button[][] player = new Button[10][10];
	public Button[][] computer = new Button[10][10];

	// creates the images for the "hit" "miss" and "Cursor"
	Image explosionImg = new Image(getClass().getResource("../resources/explosion.png").toExternalForm());
	Image waterImg = new Image(getClass().getResource("../resources/water.png").toExternalForm());
	Image cursorImg = new Image(getClass().getResource("../resources/crosshairs.png").toExternalForm());

	@FXML
	public GridPane playerGrid;
	@FXML
	public GridPane computerGrid;
	@FXML
	public Label statusLabel;
	@FXML
	private Pane statusPane;

	// Reference to the main application.
	private MainApp mainApp;

	// constructor
	public BoardOverviewController() {
	}

	@FXML
	private void initialize() {
		showPlayerGrid();
		showComputerGrid();
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

	public void showPlayerGrid() {
		statusLabel.setText("Take a shot");
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				player[x][y] = new Button();
				player[x][y].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				playerGrid.add(player[x][y], x, y);
			}
		}
	}

	public void showComputerGrid() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				computer[x][y] = new Button();
			    computer[x][y].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				playerGrid.add(computer[x][y], x, y);
			}
		}
	}

	// Method to put the "Hit" image on a button
	public void setHit(Button button) {
		button.setGraphic(new ImageView(explosionImg));
	}

	// Method to put the "Miss" image on a button
	public void setMiss(Button button) {
		button.setGraphic(new ImageView(waterImg));
	}
}