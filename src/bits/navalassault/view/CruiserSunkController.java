package bits.navalassault.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CruiserSunkController {
	
	private Stage cruiserStage;
	
	@FXML
	private TextField statusLabel;
	
	@FXML
	private AnchorPane statusPane;
	
	@FXML
	private Button okayButton;
	
	@FXML
	private void handleOkayClicked() {
		cruiserStage.close();
	}
    
    //constructor
    public CruiserSunkController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
	public void setCruiserStage(Stage cruiserStage) {
		this.cruiserStage = cruiserStage;
	}
}