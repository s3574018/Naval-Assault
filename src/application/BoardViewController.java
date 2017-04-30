package application;

import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class BoardViewController implements Initializable {
	
	private Boolean menuClick = false;
	
	@FXML
	private StackPane statusPane;
	
	@FXML
	private StackPane shipsPane;
	
	@FXML
	private StackPane logoPane;
	
	@FXML
	private Label statusBar;
	
	@FXML
	private Button menuButton;
		
	@Override
	public void initialize(URL url, ResourceBundle rb) 
	{
		statusBar.setText("Status Bar");
		menuButton.setOnAction(event ->
	    {
	    	if (menuClick == false)
	        {
	        	menuButton.setText("Clicked");
	        	menuClick = true;
	        }
	        else
	        {
	        	menuButton.setText("Menu");
	        	menuClick = false;
	        }
	    	        
	    });

	}
}

