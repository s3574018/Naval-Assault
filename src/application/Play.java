package application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
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
	
	//Basic code for taking a shot 
	//I have Hard Coded some ships and attempted shot at the bottom of this file
	public void takeShot(Button shot) {
		if(shot.getText() == "SH") {
			shot.setText("X");
			shot.setFont(Font.font("Ariel", 16));
		}
		else {
			shot.setText("O");
			shot.setFont(Font.font("Ariel", 16));
		}
	}

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grid Demo");
        
        //Creates a new root node
        Group root = new Group();
        
        //creates a 2D array of buttons for the player and computer grid
        Button[][] player = new Button[10][10];
        Button[][] computer = new Button[10][10];
        
        
        //new GameGrid created for the player
        GameGrid playerGrid = new GameGrid(40,190,160);
        //createGrid method used to put playerGrid on root node
        root.getChildren().add(playerGrid.createGrid(player));
        
        //new GameGrid created for the computer
        GameGrid computerGrid = new GameGrid(40,690,160);
        //createGrid method used to put computerGrid on root node
        root.getChildren().add(computerGrid.createGrid(computer));
        
        
        //following code used to Hard Code ships on player grid
        player[1][1].setText("SH");
        player[1][2].setText("SH");
        player[1][3].setText("SH");
        player[1][4].setText("SH");
        player[1][5].setText("SH");
        
        player[4][1].setText("SH");
        player[5][1].setText("SH");
        player[6][1].setText("SH");
        player[7][1].setText("SH");
        
        player[4][8].setText("SH");
        player[5][8].setText("SH");
        player[6][8].setText("SH");

        player[4][3].setText("SH");
        player[4][4].setText("SH");
        player[4][5].setText("SH");
        
        player[8][5].setText("SH");
        player[8][6].setText("SH");
        
        //Hard Coded shot on the player board
        takeShot(player[3][3]);
        takeShot(player[4][4]);
        takeShot(player[5][5]);
        takeShot(player[6][6]);
        takeShot(player[7][7]);

        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();      
        
    } 
                     
}
