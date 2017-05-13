package application;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.IOException;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Play extends Application {

    // Menu
    MenuBar menuBar = new MenuBar();

    Menu menuGame = new Menu("Game");

    MenuItem menuStartGame = new MenuItem("Start Game");
    MenuItem menuAudioOn = new MenuItem("Audio On");
    MenuItem menuAudioOff = new MenuItem("Audio Off");
    MenuItem menuRestartGame = new MenuItem("Restart Game");
    MenuItem menuExit = new MenuItem("Exit");

    Menu menuHelp = new Menu("Help");
    MenuItem menuAbout = new MenuItem("About Naval Assault");
    MenuItem menuRules = new MenuItem("Game Rules");


    // Background Music

    //
    Media music = new Media(getClass().getResource("Background_Music.mp3").toExternalForm());
    //
    MediaPlayer playMusic = new MediaPlayer(music);

    // creates the images for that make up the battleship.
    Image battleship1Img = new Image("application/battleship1.png");
    Image battleship2Img = new Image("application/battleship2.png");
    Image battleship3Img = new Image("application/battleship3.png");
    Image battleship4Img = new Image("application/battleship4.png");

    // creates the images for the "hit" "miss" and "Cursor"
    static Image explosionImg = new Image("application/explosion.png");
    static Image waterImg = new Image("application/water.png");
    Image cursorImg = new Image("application/crosshairs.png");

    // creates a 2D array of buttons for the player and computer grid.
    static Button[][] player = new Button[10][10];
    static Button[][] computer = new Button[10][10];

    // new GameGrid created for the player
    static GameGrid playerGrid = new GameGrid(40, 190, 160);
    static GridPane playerBoard = (GridPane) playerGrid.createGrid(player);

    // new GameGrid created for the computer
    static GameGrid computerGrid = new GameGrid(40, 690, 160);
    static GridPane computerBoard = (GridPane) computerGrid.createGrid(computer);

    // Method to put the "Hit" image on a button
    public void setHit(Button button) {
        button.setGraphic(new ImageView(explosionImg));
    }

    // Method to put the "Miss" image on a button
    public void setMiss(Button button) {
        button.setGraphic(new ImageView(waterImg));
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grid Demo");

        // Creates a new root node
        Group root = new Group();


        
        
        // ship object array and sets buttons to either a hit or miss image
        PlayerController.setShips();
        
        PlayerController.setHitGridEmpty();
        
        // calls method to let player place carrier
        // this method calls the methods to place other ships
        PlayerController.setCarrier();  


        // calls method to set computer ships locations then runs through the
        // ship object array and sets buttons to either a hit or miss image
        OpponentController.setShips();
        
        OpponentController.setCarrier();
        
        for (int yAxis = 0; yAxis < computer.length; yAxis++) {
            for (int xAxis = 0; xAxis < computer.length; xAxis++) {
                Button button = computer[yAxis][xAxis];
                if (OpponentController.getState(yAxis,
                        xAxis) == OpponentController.fleet[0]
                        || OpponentController.getState(yAxis,
                                xAxis) == OpponentController.fleet[1]
                        || OpponentController.getState(yAxis,
                                xAxis) == OpponentController.fleet[2]
                        || OpponentController.getState(yAxis,
                                xAxis) == OpponentController.fleet[3]
                        || OpponentController.getState(yAxis,
                                xAxis) == OpponentController.fleet[4]) {
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            setHit(button);
                        }
                    });
                } else {
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            setMiss(button);
                            
                            // prompts computer to take a random shot once
//                            OpponentLogic.randomShot();
                            OpponentLogic.computerStart();
                        }
                    });
                }
            }
        }

        // Adds grids to the root node
        root.getChildren().add(computerBoard);
        root.getChildren().add(playerBoard);
        // Menu Bar-------------------------
        menuBar.getMenus().add(menuGame);
        menuGame.getItems().add(menuStartGame);
        menuGame.getItems().add(menuAudioOn);
        menuGame.getItems().add(menuAudioOff);
        menuGame.getItems().add(menuRestartGame);
        menuGame.getItems().add(menuExit);
        menuBar.getMenus().add(menuHelp);
        menuHelp.getItems().add(menuAbout);
        menuHelp.getItems().add(menuRules);
        // ---------------
        root.getChildren().add(menuBar);

        // Exit Menu
        menuExit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        
        menuAudioOff.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent off) {
        		playMusic.stop();
        	}
        });
        
        menuAudioOn.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent off) {
        		playMusic.getStatus();
				if(Status.STOPPED != null) {
        		playMusic.play();
        		}
        	}
        });

        primaryStage.setScene(new Scene(root, 1280, 720));

        // sets cursor image to crosshairs
        root.setCursor(new ImageCursor(cursorImg));
        // //starts music
        playMusic.play();
        
        primaryStage.show();
        
        for (int i = 0; i < 8; i++) {            
            System.out.println(PlayerController.fleet[i].getShipID());
            System.out.println("HitCount: " + PlayerController.fleet[i].getHitCount());
            System.out.println("Health: " + PlayerController.fleet[i].getHealth());
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        launch(args);
        
    }
}
