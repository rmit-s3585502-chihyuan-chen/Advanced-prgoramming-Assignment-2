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
	private void GameType(ActionEvent event) throws IOException {
		Parent alertPage =FXMLLoader.load(getClass().getResource("GameType.fxml"));
		Scene alertPageScene = new Scene(alertPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(alertPageScene);
		thisStage.show();		
	}
	@FXML
	private void displayresult(ActionEvent event) throws IOException {
		Parent alertPage =FXMLLoader.load(getClass().getResource("displayResult.fxml"));
		Scene alertPageScene = new Scene(alertPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(alertPageScene);
		thisStage.show();		
	}
	@FXML
	private void displayPoint(ActionEvent event) throws IOException {
		Parent alertPage =FXMLLoader.load(getClass().getResource("DisplayPoint.fxml"));
		Scene alertPageScene = new Scene(alertPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(alertPageScene);
		thisStage.show();		
	}
	@FXML
	private void exit() {
		Stage exitStage = (Stage) exit.getScene().getWindow();
	    exitStage.close();
	}
}