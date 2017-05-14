package bits.navalassault.view;

import bits.navalassault.MainApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoseScreenController {
	
	private Stage loseStage;
	
	@FXML
	private Button startAgainButton;
	
	@FXML
	private Button quitButton;
	
	private MainApp mainApp;
	
	@FXML
	private void handleStartAgainClicked() {
		mainApp.showStartScreen();
	}
	
	@FXML
	private void handleQuitClicked() {
		Platform.exit();
	}
    
    //constructor
    public LoseScreenController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
	public void setLoseStage(Stage loseStage) {
		this.loseStage = loseStage;
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}