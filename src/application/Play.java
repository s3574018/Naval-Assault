package application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Play extends Application {

	public static void main(String[] args) {
		launch(args);
	}

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grid Demo");
        
        //Creates a new root node
        Group root = new Group();
        
        GameGrid player = new GameGrid(10,40,150,200);
        root.getChildren().add(player.createGrid());
        
        GameGrid computer = new GameGrid(10,40,650,200);
        root.getChildren().add(computer.createGrid());
        
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();
        
    } 
    
                 
}
