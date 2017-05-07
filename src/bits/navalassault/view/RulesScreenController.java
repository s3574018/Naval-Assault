package bits.navalassault.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RulesScreenController {
	
	private Stage rulesStage;
	
	@FXML
	private Button okayButton;
	
	@FXML
	private void handleOkayClicked() {
		rulesStage.close();
	}
    
    //constructor
    public RulesScreenController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
	public void setRulesStage(Stage rulesStage) {
		this.rulesStage = rulesStage;
	}
}