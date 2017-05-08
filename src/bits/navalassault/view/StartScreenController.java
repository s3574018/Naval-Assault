package bits.navalassault.view;

import bits.navalassault.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartScreenController {
	
	@FXML
	private Button startButton;
	
	@FXML
	private void handleStartClicked() {
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