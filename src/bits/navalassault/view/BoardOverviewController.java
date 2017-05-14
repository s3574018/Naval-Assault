package bits.navalassault.view;

import bits.navalassault.MainApp;
import bits.navalassault.model.Grid;
import bits.navalassault.model.OpponentController;
import bits.navalassault.model.SoundPlayer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;

public class BoardOverviewController {

	public static Button[][] player = new Button[10][10];
	public static Button[][] computer = new Button[10][10];

	// creates the images for the "hit" "miss" and "Cursor"
	public static Image explosionImg = new Image("bits/navalassault/resources/explosion.png");
	public static Image waterImg = new Image("bits/navalassault/resources/water.png");
	public static Image cursorImg = new Image("bits/navalassault/resources/crosshairs.png");

	// sound files required
	static AudioClip hit = new AudioClip(
			BoardOverviewController.class.getResource("../resources/sounds/Hit.mp3").toExternalForm());
	static AudioClip miss = new AudioClip(
			BoardOverviewController.class.getResource("../resources/sounds/Miss.mp3").toExternalForm());

	@FXML
	private AnchorPane boardPane;

	@FXML
	private AnchorPane statusPane;

	// Reference to the main application.
	private MainApp mainApp;

	// constructor
	public BoardOverviewController() {
	}

	@FXML
	private void initialize() {
		
		Grid pGrid = new Grid(50, 90, 150);
		GridPane playerBoard = (GridPane) pGrid.createGrid(player);

		Grid cGrid = new Grid(50, 690, 150);
		GridPane computerBoard = (GridPane) cGrid.createGrid(computer);

		computerBoard.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mainApp.scene.setCursor(new ImageCursor(cursorImg));
			}
		});

		computerBoard.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mainApp.scene.setCursor(new ImageCursor(null));
			}
		});

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
		SoundPlayer.getSoundEnabled();
		if (SoundPlayer.getSoundEnabled() == true) {
			hit.play();
		}
	}

	// Method to put the "Miss" image on a button
	public static void setMiss(Button button) {
		button.setGraphic(new ImageView(waterImg));
		SoundPlayer.getSoundEnabled();
		if (SoundPlayer.getSoundEnabled() == true) {
			miss.play();
		}
	}
}