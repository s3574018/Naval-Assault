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
import javafx.util.Duration;

 
public class sounds extends Application {
	
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sounds Demo!");
                     
        Button missButton = new Button();
        missButton.setText("Miss");
        missButton.setLayoutX(20);
        missButton.setLayoutY(20);
        missButton.setPrefSize(100, 20);
        missButton.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Miss!");
                Media miss = new Media("file:///Users/Andrew/git/Naval-Assault/src/Miss.mp3");
                MediaPlayer playMiss = new MediaPlayer(miss);
                playMiss.play();
            }
        });
        
        Button hitButton = new Button();
        hitButton.setText("Hit");
        hitButton.setLayoutX(20);
        hitButton.setLayoutY(60);
        hitButton.setPrefSize(100, 20);
        hitButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hit!");
                Media hit = new Media("file:///Users/Andrew/git/Naval-Assault/src/Hit.mp3");
                MediaPlayer playHit = new MediaPlayer(hit);
                playHit.setStopTime(Duration.seconds(2.5));
                playHit.play();
            }
        });
        
        Button startButton = new Button();
        startButton.setText("Start");
        startButton.setLayoutX(20);
        startButton.setLayoutY(100);
        startButton.setPrefSize(100, 20);
        startButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Start!");
                Media start = new Media("file:///Users/Andrew/git/Naval-Assault/src/Start_Game.mp3");
                MediaPlayer playStart = new MediaPlayer(start);
                playStart.play();
            }
        });
        
        Button musicOn = new Button();
        musicOn.setText("Music On");
        musicOn.setLayoutX(20);
        musicOn.setLayoutY(140);
        musicOn.setPrefSize(100, 20);
        musicOn.setOnAction(new EventHandler<ActionEvent>() {
        Boolean test = false;
        
        Media music = new Media("file:///Users/Andrew/git/Naval-Assault/src/Background_Music.mp3");
		MediaPlayer playMusic = new MediaPlayer(music);
        
            @Override
            public void handle(ActionEvent event) {
            	if (test == false) {
            		System.out.println("Music On");         		
            		playMusic.play();
            		musicOn.setText("Music Off");
            		test = true;
            	}
            	else {
            		System.out.println("Music Off");
            		playMusic.stop();
            		musicOn.setText("Music On");
            		test = false;
            	}
            }
        });
                
        Group root = new Group();
        root.getChildren().addAll(missButton,hitButton,startButton,musicOn);
        primaryStage.setScene(new Scene(root, 140, 180));
        primaryStage.show();
    }
}