package bits.navalassault.view;

import javafx.application.Platform;
import bits.navalassault.MainApp;
import javafx.fxml.FXML;

public class RootLayoutController {

	// Reference to the main application.
    private MainApp mainApp;
    
    //constructor
    public RootLayoutController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
	@FXML 
	private void handleRestartGameClicked() {
		mainApp.showStartScreen();
	}
	
	@FXML
	private void handleToggleSound() {
		//TODO
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