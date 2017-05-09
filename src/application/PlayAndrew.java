package application;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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

public class PlayAndrew extends Application {

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

    // creates the background Image.
    Image backGroundImg = new Image("application/Background.jpg");
    ImageView iv1 = new ImageView();
    HBox box = new HBox();

    // Background Music

    //
    // Media music = new Media("application/Background_Music.mp3");
    //
    // MediaPlayer playMusic = new MediaPlayer(music);

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


        
        // calls method to set computer ships locations then runs through the
        // ship object array and sets buttons to either a hit or miss image
        PlayerController.setShips();
        
        PlayerController.setCarrier();  

        for (int yAxis = 0; yAxis < player.length; yAxis++) {
            for (int xAxis = 0; xAxis < player.length; xAxis++) {
                if (PlayerController.getState(yAxis,
                        xAxis) == PlayerController.fleet[0]
                        || PlayerController.getState(yAxis,
                                xAxis) == PlayerController.fleet[1]
                        || PlayerController.getState(yAxis,
                                xAxis) == PlayerController.fleet[2]
                        || PlayerController.getState(yAxis,
                                xAxis) == PlayerController.fleet[3]
                        || PlayerController.getState(yAxis,
                                xAxis) == PlayerController.fleet[4]);                
            }
        }
        

        // calls method to set computer ships locations then runs through the
        // ship object array and sets buttons to either a hit or miss image
        OpponentControllerAndrew.setShips();
        for (int yAxis = 0; yAxis < computer.length; yAxis++) {
            for (int xAxis = 0; xAxis < computer.length; xAxis++) {
                Button button = computer[yAxis][xAxis];
                if (OpponentControllerAndrew.getState(yAxis,
                        xAxis) == OpponentControllerAndrew.fleet[0]
                        || OpponentControllerAndrew.getState(yAxis,
                                xAxis) == OpponentControllerAndrew.fleet[1]
                        || OpponentControllerAndrew.getState(yAxis,
                                xAxis) == OpponentControllerAndrew.fleet[2]
                        || OpponentControllerAndrew.getState(yAxis,
                                xAxis) == OpponentControllerAndrew.fleet[3]
                        || OpponentControllerAndrew.getState(yAxis,
                                xAxis) == OpponentControllerAndrew.fleet[4]) {
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
                            // player misses. will substitute this method call
                            // for the starting point of the computer logic in
                            // final version
                            OpponentLogicAndrew.randomShot();
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

        // // About Menu
        // menuAbout.setOnAction(new EventHandler<ActionEvent>()
        // {
        // public void handle(ActionEvent t)
        // {
        // Parent root;
        // try {
        // root = FXMLLoader.load(getClass().getResource("BoardView.fxml"));
        // Scene scene = new Scene(root);
        // scene.getStylesheets().add(getClass().getResource("board.css").toExternalForm());
        // primaryStage.setTitle("Naval Assault");
        // primaryStage.setScene(scene);
        // primaryStage.show();
        // primaryStage.setResizable(false);
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        //
        //
        //
        //
        // }
        // });
        primaryStage.setScene(new Scene(root, 1280, 720));

        // sets cursor image to crosshairs
        root.setCursor(new ImageCursor(cursorImg));
        // //starts music
        // playMusic.play();
        
        primaryStage.show();
        
        


        // loops a random shot. for testing only
        // int numberShots = 5;
        // for (int i = 1; i < numberShots; i++) {
        // OpponentLogic.randomShot();
        // }

    }

    public static void main(String[] args) {
        launch(args);
        
    }
}
