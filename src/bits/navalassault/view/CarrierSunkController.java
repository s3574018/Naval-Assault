package bits.navalassault.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CarrierSunkController {
	
	private Stage carrierStage;
	
	@FXML
	private TextField statusLabel;
	
	@FXML
	private AnchorPane statusPane;
	
	@FXML
	private Button okayButton;
	
	@FXML
	private void handleOkayClicked() {
		carrierStage.close();
	}
    
    //constructor
    public CarrierSunkController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
	public void setCarrierStage(Stage carrierStage) {
		this.carrierStage = carrierStage;
	}
}