package bits.navalassault.view;

import bits.navalassault.MainApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WinScreenController {
	
	private Stage winStage;
	
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
    public WinScreenController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
	public void setWinStage(Stage winStage) {
		this.winStage = winStage;
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}