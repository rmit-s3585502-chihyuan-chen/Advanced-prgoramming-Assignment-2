package Gui;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 1.0
 * @Description GameTypeController
 */
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import OzlympicGames.Games;
import Data.Official;
import Data.Athletes;
import Data.Cyclists;
import Data.Swimmers;
import Data.Sprinters;
import Data.SuperAthletes;
import OzlympicGames.Ozlympic;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.*;
import javafx.event.ActionEvent;
public class GameTypeController {
	@FXML
	private Button swimming;
	@FXML
	private Button cycling;
	@FXML
	private Button running;
	@FXML
	private Button home;
	@FXML
	private Button exit;
	@FXML
	private void swimming(ActionEvent event) throws IOException{ //use type to get different athletes data
		Ozlympic.tempAthletes.clear();
		Games newGames = Ozlympic.selectGame(1);
		ArrayList<Athletes> loadAthletes = new ArrayList<Athletes>();
		loadAthletes = Ozlympic.athletes;
		Ozlympic.tempAthletes =newGames.loadAthletes(loadAthletes);
		Ozlympic.gameinfo = newGames;
		Parent swimmingType =FXMLLoader.load(getClass().getResource("/Gui/GameSet.fxml"));
		Scene swimmingTypePage= new Scene(swimmingType);
		Stage swimmingStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		swimmingStage.setScene(swimmingTypePage);
		swimmingStage.show();	
	}
	@FXML
	private void cycling(ActionEvent event) throws IOException{//use type to get different athletes data
		Ozlympic.tempAthletes.clear();
		Games newGames = Ozlympic.selectGame(2);
		ArrayList<Athletes> loadAthletes = new ArrayList<Athletes>();
		loadAthletes = Ozlympic.athletes;
		Ozlympic.tempAthletes =newGames.loadAthletes(loadAthletes);
		Ozlympic.gameinfo = newGames;
		Parent cyclingType =FXMLLoader.load(getClass().getResource("/Gui/GameSet.fxml"));
		Scene cyclingTypePage= new Scene(cyclingType);
		Stage  cyclingStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		 cyclingStage.setScene(cyclingTypePage);
		 cyclingStage.show();	
	}
	@FXML
	private void running(ActionEvent event) throws IOException{//use type to get different athletes data
		Ozlympic.tempAthletes.clear();
		Games newGames = Ozlympic.selectGame(3);
		ArrayList<Athletes> loadAthletes = new ArrayList<Athletes>();
		loadAthletes = Ozlympic.athletes;
		Ozlympic.tempAthletes =newGames.loadAthletes(loadAthletes);
		Ozlympic.gameinfo = newGames;
		Parent runningType =FXMLLoader.load(getClass().getResource("/Gui/GameSet.fxml"));
		Scene runningTypePage= new Scene(runningType);
		Stage runningStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		runningStage.setScene(runningTypePage);
		runningStage.show();	
	}
	@FXML
	private void exit() {//allow user to leave the system
		Stage exitStage = (Stage) exit.getScene().getWindow();
	    exitStage.close();
	}
	@FXML
	private void home(ActionEvent event) throws IOException { //allow user to back to main menu
		Parent homepage =FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
		Scene homePageScene = new Scene(homepage);
		Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		homeStage.setScene(homePageScene);
		homeStage.show();		
	}
}
