package bits.navalassault.view;

import bits.navalassault.MainApp;
import bits.navalassault.model.SoundPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;

public class StartScreenController {
	
	AudioClip startClick = new AudioClip(getClass().getResource("../resources/sounds/Start.mp3").toExternalForm());
	
	@FXML
	private Button startButton;
	
	@FXML
	private void handleStartClicked() {
		SoundPlayer.getSoundEnabled();
		if (SoundPlayer.getSoundEnabled() == true) {
			startClick.play();
		}
		mainApp.showBoardOverview();
	}
	
	// Reference to the main application.
    private MainApp mainApp;
    
    //constructor
    public StartScreenController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}