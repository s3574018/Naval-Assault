package bits.navalassault.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BattleshipSunkController {
	
	private Stage battleshipStage;
	
	@FXML
	private TextField statusLabel;
	
	@FXML
	private AnchorPane statusPane;
	
	@FXML
	private Button okayButton;
	
	@FXML
	private void handleOkayClicked() {
		battleshipStage.close();
	}
    
    //constructor
    public BattleshipSunkController() {
    }
    	
    @FXML
    private void initialize() {
	}
    
	public void setBattleshipStage(Stage battleshipStage) {
		this.battleshipStage = battleshipStage;
	}
}