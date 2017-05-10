package bits.navalassault.view;

import javafx.application.Platform;
import bits.navalassault.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.media.AudioClip;

public class RootLayoutController {

	// Reference to the main application.
	private MainApp mainApp;
	AudioClip playBGM = new AudioClip(getClass().getResource("Background_Music.mp3").toExternalForm());
	public Boolean soundEnabled = true;

	// constructor
	public RootLayoutController() {
	}

	@FXML
	private MenuItem soundToggle;

	@FXML
	private void initialize() {
		playBGM.setCycleCount(AudioClip.INDEFINITE);
		playBGM.play();
	}

	@FXML
	private void handleRestartGameClicked() {
		mainApp.showStartScreen();
	}

	@FXML
	private void handleToggleSound() {
		if (soundEnabled == true) {
			playBGM.stop();
			soundEnabled = false;
			soundToggle.setText("Sound On (toggle)");
		} else {
			playBGM.setCycleCount(AudioClip.INDEFINITE);
			playBGM.play();
			soundEnabled = true;
			soundToggle.setText("Sound Off (toggle)");
		}
	}

	@FXML
	private void handleExitClicked() {
		Platform.exit();
	}

	@FXML
	private void handleRulesClicked() {
		mainApp.showRules();
	}

	@FXML
	private void handleAboutClicked() {
		mainApp.showAbout();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}