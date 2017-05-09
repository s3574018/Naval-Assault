package bits.navalassault.view;

import bits.navalassault.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BoardOverviewController {
	
	@FXML 
	private GridPane playerGrid;
	
	@FXML
	private GridPane computerGrid;
	
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
    	showPlayerGrid();
    	showComputerGrid();
	}
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void showPlayerGrid() {
    	for (int y=0; y < 10; y++) {
	       	for (int x=0; x < 10; x++) {
	       		Button button = new Button();
	       		button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	       		playerGrid.add(button, x, y);
	       	}
    	}
    }
    
    public void showComputerGrid() {
    	for (int y=0; y < 10; y++) {
	       	for (int x=0; x < 10; x++) {
	       		Button button = new Button();
	       		button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	       		computerGrid.add(button, x, y);
	       	}
    	}
    }
}