package application;

import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class BoardViewController implements Initializable {
	
	@FXML
	private StackPane statusPane;
	
	@FXML
	private Text statusBar;
		
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		setLabelText();
	}
	public void setLabelText() {
		statusBar.setText("This is starting text");
	}
}

