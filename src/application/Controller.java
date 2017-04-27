package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class Controller {

    @FXML
    private MenuItem menuStart;

    @FXML
    private MenuItem menuAudioOn;

    @FXML
    private MenuItem menuAudioOff;

    @FXML
    private MenuItem menuRestart;

    @FXML
    private MenuItem menuExit;

    @FXML
    private MenuItem menuAbout;

    @FXML
    private MenuItem menuRules;

    @FXML
    void onMenuAboutClick(ActionEvent event) {
    	System.out.println("You Clicked About");
    }

    @FXML
    void onMenuAudioOffClick(ActionEvent event) {
    	System.out.println("You Clicked Audio Off");
    }

    @FXML
    void onMenuAudioOnClick(ActionEvent event) {
    	System.out.println("You Clicked Audio On");
    }

    @FXML
    void onMenuExitClick(ActionEvent event) {
    	System.out.println("You Clicked Exit");
    }

    @FXML
    void onMenuRestartClick(ActionEvent event) {
    	System.out.println("You Clicked Restart");

    }

    @FXML
    void onMenuRulesClick(ActionEvent event) {
    	System.out.println("You Clicked Rules");
    }

    @FXML
    void onMenuStartClick(ActionEvent event) {
    	System.out.println("You Clicked Start");
    }

}
