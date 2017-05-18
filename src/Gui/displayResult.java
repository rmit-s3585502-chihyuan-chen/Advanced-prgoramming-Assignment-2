package Gui;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 1.0
 * @Description displayResult
 */
import OzlympicGames.Ozlympic;

import java.io.IOException;

import OzlympicGames.Games;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.event.ActionEvent;

public class displayResult { //display past game results
@FXML
private TextArea display;
	@FXML
	private void initialize() { //show past game results via the for loop to get data from the history list
		for (int i = 0; i < Ozlympic.history.size(); i++) {
		String gameresults = Ozlympic.history.get(i);
		display.appendText(gameresults);
	}
}
	@FXML
	private void home(ActionEvent event) throws IOException { //back to main menu
		Parent homePage =FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
		Scene homePageScene = new Scene(homePage);
		Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		homeStage.setScene(homePageScene);
		homeStage.show();		
	}
}