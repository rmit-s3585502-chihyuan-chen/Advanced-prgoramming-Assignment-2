package Gui;

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

public class displayResult {
@FXML
private TextArea display;
	@FXML
	private void initialize() {
		for (int i = 0; i < Ozlympic.history.size(); i++) {
		String gameresults = Ozlympic.history.get(i);
		display.appendText(gameresults+"\n"+"========="+"\n");
	}
}
	@FXML
	private void home(ActionEvent event) throws IOException {
		Parent menuPage =FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
		Scene menuPageScene = new Scene(menuPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(menuPageScene);
		thisStage.show();		
	}
	
	}
