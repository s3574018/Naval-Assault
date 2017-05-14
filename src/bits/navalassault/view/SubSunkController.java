package bits.navalassault.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SubSunkController {
	
	private Stage subStage;
	
	@FXML
	private TextField statusLabel;
	
	@FXML
	private AnchorPane statusPane;
	
	@FXML
	private Button okayButton;
	
	@FXML
	private void handleOkayClicked() {
		subStage.close();
	}
    
    //constructor
    public SubSunkController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
	public void setSubStage(Stage subStage) {
		this.subStage = subStage;
	}
}