package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import OzlympicGames.Ozlympic;
import OzlympicGames.Games;
import OzlympicGames.Cycling;
import OzlympicGames.Running;
import OzlympicGames.Swimming;
import Data.Official;

import java.io.IOException;

import Data.Athletes;
import Data.Cyclists;
import Data.Swimmers;
import Data.Sprinters;
import Data.SuperAthletes;
public class GameResult {
	@FXML
	private Button home;
	@FXML
	private TextArea showResult;
	@FXML
	private void initialize() {
		showResult.appendText("Game ID:" + Ozlympic.gameinfo.getGameId());
		showResult.appendText("\n");
		showResult.appendText("\nOfficer ID: " + Ozlympic.gameinfo.getOfficial().getId());
		showResult.appendText("\n");
		showResult.appendText("\nChampion is: " + Ozlympic.gameinfo.getChampion()+ " Result: " + Ozlympic.gameinfo.getFirstPlace());
		showResult.appendText("\nSecond   is: " + Ozlympic.gameinfo.getSecond() + " Result: " + Ozlympic.gameinfo.getSecondPlace());
		showResult.appendText("\nThird    is: " + Ozlympic.gameinfo.getThird() + " Result: " + Ozlympic.gameinfo.getThirdPlace());
		}
	
	@FXML
	private void home(ActionEvent event) throws IOException {
		Ozlympic.gameSelect = false;
       	Ozlympic.pastGame();
		Ozlympic.tempAthletes.clear();
		Ozlympic.addAthletes.clear();
       	Parent menuPage =FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
		Scene menuPageScene = new Scene(menuPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(menuPageScene);
		thisStage.show();
		
	}
}
