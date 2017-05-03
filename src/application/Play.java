package application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Play extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//creates the images for that make up the battleship.
    Image battleship1Img = new Image("file:///Users/Andrew/git/Naval-Assault/src/application/battleship1.png");
    Image battleship2Img = new Image("file:///Users/Andrew/git/Naval-Assault/src/application/battleship2.png");
    Image battleship3Img = new Image("file:///Users/Andrew/git/Naval-Assault/src/application/battleship3.png");
    Image battleship4Img = new Image("file:///Users/Andrew/git/Naval-Assault/src/application/battleship4.png");

   
    //creates the images for the "hit" "miss" and "Cursor"    
    Image explosionImg = new Image("file:///Users/Andrew/git/Naval-Assault/src/application/explosion.png");
    Image waterImg = new Image("file:///Users/Andrew/git/Naval-Assault/src/application/water.png");
    Image cursorImg = new Image("file:///Users/Andrew/git/Naval-Assault/src/application/crosshairs.png");
    
    //creates a 2D array of buttons for the player and computer grid.
    Button[][] player = new Button[10][10];
    Button[][] computer = new Button[10][10];
    
    
    //new GameGrid created for the player
    GameGrid playerGrid = new GameGrid(40,190,160);
    GridPane playerBoard = (GridPane) playerGrid.createGrid(player);
    
    //new GameGrid created for the computer
    GameGrid computerGrid = new GameGrid(40,690,160);
    GridPane computerBoard = (GridPane) computerGrid.createGrid(computer);
   
    //Method to put the "Hit" image on a button  
    public void setHit(Button button) {
    	button.setGraphic(new ImageView(explosionImg));
    }    
    
    //Method to put the "Miss" image on a button  
    public void setMiss(Button button) {
    	button.setGraphic(new ImageView(waterImg));
    }    
	
    //Method to put the images of the battleship together on the grid
    //Also sets Id of button to "hasShip"
    public void setBattleship(int startX, int startY) {
    	player[startX][startY].setGraphic(new ImageView(battleship1Img));
    	player[startX][startY].setId("hasShip");
    	player[startX+1][startY].setGraphic(new ImageView(battleship2Img));
    	player[startX+1][startY].setId("hasShip");
    	player[startX+2][startY].setGraphic(new ImageView(battleship3Img));
    	player[startX+2][startY].setId("hasShip");
    	player[startX+3][startY].setGraphic(new ImageView(battleship4Img));
    	player[startX+3][startY].setId("hasShip");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grid Demo");
        
        //Creates a new root node
        Group root = new Group();
        
        //Hard coded battleships on the player grid
        setBattleship(0,0);
        setBattleship(2,2);
        setBattleship(4,4);
        setBattleship(2,6);
        setBattleship(0,8);
        setBattleship(6,7);   
        
        //for loop to put Event Handler on each button
        //If button Id is "hasShip" it will set the "Hit" Image
        //Else it will set "Miss" Image
		for (int x=0; x < player.length; x++) {
			for (int y=0; y < player.length; y++) {		
				Button button = player[x][y];
				if (button.getId() == "hasShip") {
					button.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							setHit(button);
						}});
				}
				else {
					button.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							setMiss(button);
						}});
				}
			}
        }

		//Adds grids to the root node
        root.getChildren().add(computerBoard); 
        root.getChildren().add(playerBoard);
        
        primaryStage.setScene(new Scene(root, 1280, 720));
        
        //sets cursor image to crosshairs
        root.setCursor(new ImageCursor(cursorImg));
        primaryStage.show();      
        
    } 
                     
}
