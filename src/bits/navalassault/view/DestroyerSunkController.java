package bits.navalassault.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DestroyerSunkController {
	
	private Stage destroyerStage;
	
	@FXML
	private TextField statusLabel;
	
	@FXML
	private AnchorPane statusPane;
	
	@FXML
	private Button okayButton;
	
	@FXML
	private void handleOkayClicked() {
		destroyerStage.close();
	}
    
    //constructor
    public DestroyerSunkController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
	public void setDestroyerStage(Stage destroyerStage) {
		this.destroyerStage = destroyerStage;
	}
}