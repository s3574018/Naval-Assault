package application;

import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
//import javafx.scene.control.Button;

public class BoardViewController implements Initializable {
	
	@FXML
	private StackPane statusPane;
	
	@FXML
	private StackPane shipsPane;
	
	@FXML
	private StackPane logoPane;
	
	@FXML
	private Label statusBar;
		
	@Override
	public void initialize(URL url, ResourceBundle rb) 
	{
		/*menuButton.setOnAction(event ->
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
	    	        
	    });*/
	}
	public void setStatus(String status) {
		statusBar.setText(status);
	}
	
	
}

