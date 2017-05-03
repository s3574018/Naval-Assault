package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.*;

public class Board extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("BoardView.fxml"));
		//BoardViewController controller = (BoardViewController)loader.getController();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("board.css").toExternalForm());
		primaryStage.setTitle("Naval Assault");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	
}