package bits.navalassault.view;

import bits.navalassault.MainApp;
import bits.navalassault.model.SoundPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;

public class StartScreenController {
	
	AudioClip startClick = new AudioClip(getClass().getResource("../resources/sounds/Start.mp3").toExternalForm());
	
	@FXML
	private Button startButton;
	
	@FXML 
	private AnchorPane logoPane;
	
	@FXML
	private void handleStartClicked() {
		SoundPlayer.getSoundEnabled();
		if (SoundPlayer.getSoundEnabled() == true) {
			startClick.setVolume(0.2);
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