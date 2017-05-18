package Gui;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 1.0
 * @Description StartGame
 */
import java.io.IOException;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import Data.Official;
import Data.Athletes;
import Data.Cyclists;
import Data.Swimmers;
import Data.Sprinters;
import Data.SuperAthletes;
import OzlympicGames.Running;
import OzlympicGames.Swimming;
import OzlympicGames.Cycling;
import OzlympicGames.Games;
import OzlympicGames.Ozlympic;

public class StartGame {
	@FXML
	private TextArea gameInfo;
	@FXML
	private Button start;
	@FXML
	private Button home;
	@FXML
	private Button exit;
	@FXML
	private void initialize() {
		displayInfo();
		}
	@FXML
	private void displayInfo(){ //show the information of the game that will start 
		if(Ozlympic.gameSelect==true){
		gameInfo.appendText("The official is ");
		gameInfo.appendText(Ozlympic.gameinfo.getOfficial().getName() + "\n");
		gameInfo.appendText("GameType: " +  Ozlympic.gameinfo.GameType() + "\n" +"GameID:"+Ozlympic.gameinfo.getGameId());
		for(int i = 0; i < Ozlympic.addAthletes.size(); i++) {			
			Athletes players = Ozlympic.addAthletes.get(i);						
			gameInfo.appendText("\nAthletes Name: " +players.getName());
			}
		}
	}

	@FXML
	private void startGame(ActionEvent event) throws IOException { //lead user to real time simulation page
		Parent animationPage =FXMLLoader.load(getClass().getResource("Animation.fxml"));
		Scene animationScene = new Scene(animationPage);
		Stage animationStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		animationStage.setScene(animationScene);
		animationStage.show();
	}
	@FXML
	private void home(ActionEvent event) throws IOException {//restore default setting and lead user to main menu
		gameInfo.clear();
		Games.ReduceGameRound(Games.getGameRound());
		Ozlympic.gameSelect=false;
		Ozlympic.tempAthletes.clear();
		Ozlympic.addAthletes.clear();
		Parent homepage =FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
		Scene homePageScene = new Scene(homepage);
		Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		homeStage.setScene(homePageScene);
		homeStage.show();		
	}
	@FXML
	private void exit(ActionEvent event) throws IOException {//lead user to leave the system
		Stage exitStage = (Stage) exit.getScene().getWindow();
		exitStage.close();
	}
}
