package application;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			VBox mainVbox = (VBox) FXMLLoader.load(mainApp.class.getResource("startPage.fxml"));
			primaryStage.setScene(new Scene(mainVbox));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//primaryStage.setScene(new Scene(mainVbox)); 
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
