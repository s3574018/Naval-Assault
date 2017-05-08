package bits.navalassault;

import java.io.IOException;

import bits.navalassault.view.AboutScreenController;
import bits.navalassault.view.BoardOverviewController;
import bits.navalassault.view.RootLayoutController;
import bits.navalassault.view.RulesScreenController;
import bits.navalassault.view.StartScreenController;
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
			
			Scene scene = new Scene(rootLayout);
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
			
			BoardOverviewController controller = loader.getController();
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
	
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
