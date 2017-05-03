package application;


import java.io.IOException;

import java.util.Random;

import application.Board;
import application.Ship;
import application.Board.Cell;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class mainApp extends Application {
	
    private boolean running = false;
    private Board enemyBoard, playerBoard;

    private int shipsToPlace = 5;

    private boolean enemyTurn = false;

    private Random random = new Random();

//    private Parent createMenu(){
//    	BorderPane root = new BorderPane();
//        root.setPrefSize(1280, 720);
//        
//        Scene scene = new Scene(new VBox(), 400, 350);
//        scene.setFill(Color.OLDLACE);
// 
//        MenuBar menuBar = new MenuBar();
// 
//        // --- Menu File
//        Menu menuFile = new Menu("File");
// 
//        // --- Menu Edit
//        Menu menuEdit = new Menu("Edit");
// 
//        // --- Menu View
//        Menu menuView = new Menu("View");
// 
//        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
// 
// 
//        ((VBox) scene.getRoot()).getChildren().addAll(menuBar);
//       
//        return root;
//     
//    }
    	
    private Parent createContent() {
        BorderPane root = new BorderPane();
        root.setPrefSize(1280, 720);



        enemyBoard = new Board(true, event -> {
            if (!running)
                return;

            Cell cell = (Cell) event.getSource();
            if (cell.wasShot)
                return;

            enemyTurn = !cell.shoot();

            if (enemyBoard.ships == 0) {
                System.out.println("YOU WIN");
                System.exit(0);
            }

            if (enemyTurn)
                enemyMove();
        });

        playerBoard = new Board(false, event -> {
            if (running)
                return;

            Cell cell = (Cell) event.getSource();
            if (playerBoard.placeShip(new Ship(shipsToPlace, event.getButton() == MouseButton.PRIMARY), cell.x, cell.y)) {
                if (--shipsToPlace == 0) {
                    startGame();
                }
            }
        });
        
        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("File");

        Menu menuEdit = new Menu("Edit");

        Menu menuView = new Menu("View");
 
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
        
        
        Image image = new Image("file:///C:/Users/Subrata/git/Naval-Assault/assests/Background.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        HBox box = new HBox();
        
        root.getChildren().add(box);
        box.getChildren().add(iv1);
        
        

        
        VBox vboxPlayer = new VBox(50, playerBoard);
        vboxPlayer.setAlignment(Pos.CENTER);
        
        VBox vboxEnemy = new VBox(50, enemyBoard);
        vboxEnemy.setAlignment(Pos.CENTER);
        
  

        root.setLeft(vboxPlayer);
        root.setRight(vboxEnemy);
        

        return root;
    }

    private void enemyMove() {
        while (enemyTurn) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            Cell cell = playerBoard.getCell(x, y);
            if (cell.wasShot)
                continue;

            enemyTurn = cell.shoot();

            if (playerBoard.ships == 0) {
                System.out.println("YOU LOSE");
                System.exit(0);
            }
        }
    }

    private void startGame() {
        // place enemy ships
        int type = 5;

        while (type > 0) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if (enemyBoard.placeShip(new Ship(type, Math.random() < 0.5), x, y)) {
                type--;
            }
        }

        running = true;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(createContent());  
        //Scene sceneMenu = new Scene(createMenu());
        
       // Scene scene = new Scene(createMenu());
        primaryStage.setTitle("Naval Assault");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}


/*-------------------------------------------------------------------------------------------------------------------------------------------------------------	
 * Old Code Subrata May 1
 * 
 * @Override
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
	}*/
