package bits.navalassault.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutScreenController {
	
	private Stage aboutStage;
	
	@FXML
	private Button okayButton;
	
	@FXML
	private void handleOkayClicked() {
		aboutStage.close();
	}
    
    //constructor
    public AboutScreenController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
	public void setAboutStage(Stage aboutStage) {
		this.aboutStage = aboutStage;
	}
}