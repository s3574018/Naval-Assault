package bits.navalassault.view;

import bits.navalassault.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class BoardOverviewController {
	
    @FXML
    private Label statusLabel;
    @FXML
    private Pane statusPane;
    
    // Reference to the main application.
    private MainApp mainApp;
   
    //constructor
    public BoardOverviewController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}