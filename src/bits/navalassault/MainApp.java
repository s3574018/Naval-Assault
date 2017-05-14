package bits.navalassault;

import java.io.IOException;
import bits.navalassault.model.OpponentController;
import bits.navalassault.model.PlayerController;
import bits.navalassault.model.StartTurns;
import bits.navalassault.view.AboutScreenController;
import bits.navalassault.view.BattleshipSunkController;
import bits.navalassault.view.BoardOverviewController;
import bits.navalassault.view.CarrierSunkController;
import bits.navalassault.view.CruiserSunkController;
import bits.navalassault.view.DestroyerSunkController;
import bits.navalassault.view.RootLayoutController;
import bits.navalassault.view.RulesScreenController;
import bits.navalassault.view.StartScreenController;
import bits.navalassault.view.SubSunkController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	
    private Stage primaryStage;
    private BorderPane rootLayout;
    public Scene scene;
    
   @Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Naval Assault");
		
		initRootLayout();
		showStartScreen();
	}
	
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showStartScreen() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/StartScreen.fxml"));
			AnchorPane startScreen = (AnchorPane) loader.load();
			
			rootLayout.setCenter(startScreen);
			
			StartScreenController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showBoardOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/BoardOverview.fxml"));
			AnchorPane boardScreen = (AnchorPane) loader.load();			
			
			rootLayout.setCenter(boardScreen);
			
			PlayerController.setShips();
			PlayerController.setCarrier();
			
			OpponentController.setShips();
			OpponentController.setCarrier();
			
			StartTurns.takeTurns();
			
			BoardOverviewController controller = (BoardOverviewController) loader.getController();
			controller.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showRules() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RulesScreen.fxml"));
			AnchorPane rulesScreen = (AnchorPane) loader.load();
			
			Stage rulesStage = new Stage();
			rulesStage.setTitle("Rules for Naval Assault");
			rulesStage.initModality(Modality.WINDOW_MODAL);
	        rulesStage.initOwner(primaryStage);
	        Scene scene = new Scene(rulesScreen);
	        rulesStage.setScene(scene);
	        
	        RulesScreenController controller = loader.getController();
	        controller.setRulesStage(rulesStage);
	        
	        rulesStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showAbout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/AboutScreen.fxml"));
			AnchorPane aboutScreen = (AnchorPane) loader.load();
			
			Stage aboutStage = new Stage();
			aboutStage.setTitle("About Naval Assault");
			aboutStage.initModality(Modality.WINDOW_MODAL);
	        aboutStage.initOwner(primaryStage);
	        Scene scene = new Scene(aboutScreen);
	        aboutStage.setScene(scene);
	        
	        AboutScreenController controller = loader.getController();
	        controller.setAboutStage(aboutStage);
	        
	        aboutStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showBattleshipSunk() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/CarrierSunk.fxml"));
			AnchorPane battleshipSunk = (AnchorPane) loader.load();
			
			Stage battleshipStage = new Stage();
			battleshipStage.setTitle("Alert");
			battleshipStage.initModality(Modality.WINDOW_MODAL);
			battleshipStage.initOwner(primaryStage);
	        Scene scene = new Scene(battleshipSunk);
	        battleshipStage.setScene(scene);
	        
	        BattleshipSunkController controller = loader.getController();
	        controller.setBattleshipStage(battleshipStage);
	        
	        battleshipStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showCarrierSunk() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/CarrierSunk.fxml"));
			AnchorPane carrierSunk = (AnchorPane) loader.load();
			
			Stage carrierStage = new Stage();
			carrierStage.setTitle("Alert");
			carrierStage.initModality(Modality.WINDOW_MODAL);
			carrierStage.initOwner(primaryStage);
	        Scene scene = new Scene(carrierSunk);
	        carrierStage.setScene(scene);
	        
	        CarrierSunkController controller = loader.getController();
	        controller.setCarrierStage(carrierStage);
	        
	        carrierStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showCrusierSunk() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/CarrierSunk.fxml"));
			AnchorPane cruiserSunk = (AnchorPane) loader.load();
			
			Stage cruiserStage = new Stage();
			cruiserStage.setTitle("Alert");
			cruiserStage.initModality(Modality.WINDOW_MODAL);
			cruiserStage.initOwner(primaryStage);
	        Scene scene = new Scene(cruiserSunk);
	        cruiserStage.setScene(scene);
	        
	        CruiserSunkController controller = loader.getController();
	        controller.setCruiserStage(cruiserStage);
	        
	        cruiserStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showDestroyerSunk() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/CarrierSunk.fxml"));
			AnchorPane destroyerSunk = (AnchorPane) loader.load();
			
			Stage destroyerStage = new Stage();
			destroyerStage.setTitle("Alert");
			destroyerStage.initModality(Modality.WINDOW_MODAL);
			destroyerStage.initOwner(primaryStage);
	        Scene scene = new Scene(destroyerSunk);
	        destroyerStage.setScene(scene);
	        
	        DestroyerSunkController controller = loader.getController();
	        controller.setDestroyerStage(destroyerStage);
	        
	        destroyerStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showSubSunk() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/CarrierSunk.fxml"));
			AnchorPane subSunk = (AnchorPane) loader.load();
			
			Stage subStage = new Stage();
			subStage.setTitle("Alert");
			subStage.initModality(Modality.WINDOW_MODAL);
			subStage.initOwner(primaryStage);
	        Scene scene = new Scene(subSunk);
	        subStage.setScene(scene);
	        
	        SubSunkController controller = loader.getController();
	        controller.setSubStage(subStage);
	        
	        subStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
