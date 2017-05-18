package Gui;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 1.0
 * @Description GameMenuController
 */
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import OzlympicGames.Ozlympic;

public class GameMenuController  {
	@FXML
	private Button exit;
	@FXML
	private void GameType(ActionEvent event) throws IOException { //button event to lead user to select game type menu
		Parent GameTypePage =FXMLLoader.load(getClass().getResource("GameType.fxml"));
		Scene GameTypePageScene = new Scene(GameTypePage);
		Stage GameTypeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		GameTypeStage.setScene(GameTypePageScene);
		GameTypeStage.show();		
	}
	@FXML
	private void displayresult(ActionEvent event) throws IOException { //button event to lead user to view past game results
		Parent displayresultPage =FXMLLoader.load(getClass().getResource("displayResult.fxml"));
		Scene displayresultPageScene = new Scene(displayresultPage);
		Stage displayresultStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		displayresultStage.setScene(displayresultPageScene);
		displayresultStage.show();		
	}
	@FXML
	private void displayPoint(ActionEvent event) throws IOException { //button event to lead user to view all points of athletes
		Parent displayPointPage =FXMLLoader.load(getClass().getResource("DisplayPoint.fxml"));
		Scene displayPointPageScene = new Scene(displayPointPage);
		Stage displayPointStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		displayPointStage.setScene(displayPointPageScene);
		displayPointStage.show();		
	}
	@FXML
	private void exit() { //leave the system
		Stage exitStage = (Stage) exit.getScene().getWindow();
	    exitStage.close();
	}
}