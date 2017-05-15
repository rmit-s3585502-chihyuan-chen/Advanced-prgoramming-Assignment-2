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

import java.io.IOException;

import Data.Athletes;
import OzlympicGames.Games;
import OzlympicGames.Ozlympic;

public class displayAll {
	@FXML
	private Button exit;
	@FXML
	private TextArea dataList;
	@FXML
	private void initialize() { //Prints out stats of all athletes
		dataList.setText("");
		for(int i = 0; i < Ozlympic.athletes.size(); i++) {			
			dataList.appendText("====================\n");
			Athletes allAthlete = Ozlympic.athletes.get(i);						
			dataList.appendText("\nID: " + allAthlete.getId());
			dataList.appendText("\nGameType: " + allAthlete.getType());
			dataList.appendText("\nName: " +allAthlete.getName());
			dataList.appendText("\nAge: " +allAthlete.getAge());
			dataList.appendText("\nState: "+allAthlete.getState());
			dataList.appendText("\nPoint: " +allAthlete.getPoint() + "\n");			
		}
}
	@FXML
	private void exit() {
		Stage exitStage = (Stage) exit.getScene().getWindow();
	    exitStage.close();
	}
	@FXML
	private void home(ActionEvent event) throws IOException {
		Parent homepage =FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
		Scene homePageScene = new Scene(homepage);
		Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		homeStage.setScene(homePageScene);
		homeStage.show();		
	}
	}
