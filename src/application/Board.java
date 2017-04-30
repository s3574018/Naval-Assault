package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class Board extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("BoardView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("board.css").toExternalForm());
			primaryStage.setTitle("Naval Assault");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setFullScreen(true);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
