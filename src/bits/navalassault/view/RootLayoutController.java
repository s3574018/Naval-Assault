package bits.navalassault.view;

import javafx.application.Platform;
import bits.navalassault.MainApp;
import bits.navalassault.model.OpponentController;
import bits.navalassault.model.PlayerController;
import bits.navalassault.model.SoundPlayer;
import bits.navalassault.model.Stats;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.media.AudioClip;

public class RootLayoutController {

	// Reference to the main application.
	private MainApp mainApp;
	AudioClip playBGM = new AudioClip(getClass().getResource("../resources/sounds/Background_Music.wav").toExternalForm());

	// constructor
	public RootLayoutController() {
	}

	@FXML
	private MenuItem soundToggle;

	@FXML
	private void initialize() {
		playBGM.setCycleCount(AudioClip.INDEFINITE);
		playBGM.setVolume(0.2);
		playBGM.play();
	}

	@FXML
	private void handleRestartGameClicked() {
		Stats.resetStats();
		PlayerController.resetGame();
		OpponentController.resetGame();
		mainApp.showStartScreen();
	}

	@FXML
	private void handleToggleSound() {
		if (SoundPlayer.getSoundEnabled() == true) {
			playBGM.stop();
			SoundPlayer.setSoundEnabled(false);
			soundToggle.setText("Sound On (toggle)");
		} else {
			playBGM.setCycleCount(AudioClip.INDEFINITE);
			playBGM.setVolume(0.2);
			playBGM.play();
			SoundPlayer.setSoundEnabled(true);
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