package Gui;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 1.0
 * @Description animation
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import OzlympicGames.Ozlympic;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller implements Initializable {
	public static int[] result = new int[Ozlympic.addAthletes.size()];
	public static int[] ranklist = new int[Ozlympic.addAthletes.size()];
	@FXML
	private JFXButton ath1, ath2, ath3, ath4, ath5, ath6, ath7, ath8;
	@FXML
	private JFXButton gtp;
	@FXML
	private JFXButton gid;
	@FXML
	private JFXButton gre;
	@Override
	public void initialize(URL location, ResourceBundle resources) {//accord data to run the animation
		gtp.setText(Ozlympic.gameinfo.GameType());
		gid.setText("GameID: "+Ozlympic.gameinfo.getGameId());
		gre.setText("Referee: No. "+Ozlympic.gameinfo.getOfficial().getId());
		for(int i = 0; i<Ozlympic.addAthletes.size(); i++){	
			result[i]=Ozlympic.addAthletes.get(i).compete(Ozlympic.gameinfo.GameType());  
		}
		for (int i = 0; i<Ozlympic.addAthletes.size(); i++){
			ranklist[i]=1;
				for (int j=0; j < Ozlympic.addAthletes.size(); j++){
				if(result[i]>result[j]){
					ranklist[i] = ranklist[i] + 1;}
			}
		}
		if (Ozlympic.addAthletes.size() == 7) {
			ath8.setTextFill(Color.TRANSPARENT);
			if (Ozlympic.gameinfo.GameType().equals("Cycling")){
				SwimRun7();
			}
			else {
				SwimRun7();
			}
		}
		else if (Ozlympic.addAthletes.size() == 6) {
			ath8.setTextFill(Color.TRANSPARENT);
			ath7.setTextFill(Color.TRANSPARENT);
			if (Ozlympic.gameinfo.GameType().equals("Cycling")){
				SwimRun6();
			}
			else {
				SwimRun6();
			}
			
		}
		else if (Ozlympic.addAthletes.size() == 5) {
			ath8.setTextFill(Color.TRANSPARENT);
			ath7.setTextFill(Color.TRANSPARENT);
			ath6.setTextFill(Color.TRANSPARENT);
			if (Ozlympic.gameinfo.GameType().equals("Cycling")){
				SwimRun5();
			}
			else {
				SwimRun5();
			}
		}
		else if (Ozlympic.addAthletes.size() == 4) {
			ath8.setTextFill(Color.TRANSPARENT);
			ath7.setTextFill(Color.TRANSPARENT);
			ath6.setTextFill(Color.TRANSPARENT);
			ath5.setTextFill(Color.TRANSPARENT);
			if (Ozlympic.gameinfo.GameType().equals("Cycling")){
				SwimRun4();
			}
			else {
				SwimRun4();
			}
		}
		else {
			if (Ozlympic.gameinfo.GameType().equals("Cycling")){
				SwimRun8();
			}
			else {
				SwimRun8();
			
			}
		}
		}		
	
	
	@FXML
	private void SwimRun8() {
		TranslateTransition transition1 = new TranslateTransition();
		transition1.setDuration(Duration.seconds(result[0]/25));
		ath1.setText(Ozlympic.addAthletes.get(0).getName());
		transition1.setNode(ath1);
		transition1.setToX(500);
		transition1.play();
		TranslateTransition transition2 = new TranslateTransition();
		transition2.setDuration(Duration.seconds(result[1]/25));
		ath2.setText(Ozlympic.addAthletes.get(1).getName());
		transition2.setNode(ath2);
		transition2.setToX(500);
		transition2.play();
		TranslateTransition transition3 = new TranslateTransition();
		transition3.setDuration(Duration.seconds(result[2]/25));
		ath3.setText(Ozlympic.addAthletes.get(2).getName());
		transition3.setNode(ath3);
		transition3.setToX(500);
		transition3.play();
		TranslateTransition transition4 = new TranslateTransition();
		transition4.setDuration(Duration.seconds(result[3]/25));
		ath4.setText(Ozlympic.addAthletes.get(3).getName());
		transition4.setNode(ath4);
		transition4.setToX(500);
		transition4.play();
		TranslateTransition transition5 = new TranslateTransition();
		transition5.setDuration(Duration.seconds(result[4]/25));
		ath5.setText(Ozlympic.addAthletes.get(4).getName());
		transition5.setNode(ath5);
		transition5.setToX(500);
		transition5.play();
		TranslateTransition transition6 = new TranslateTransition();
		transition6.setDuration(Duration.seconds(result[5]/25));
		ath6.setText(Ozlympic.addAthletes.get(5).getName());
		transition6.setNode(ath6);
		transition6.setToX(500);
		transition6.play();
		TranslateTransition transition7 = new TranslateTransition();
		transition7.setDuration(Duration.seconds(result[6]/25));
		ath7.setText(Ozlympic.addAthletes.get(6).getName());
		transition7.setNode(ath7);
		transition7.setToX(500);
		transition7.play();
		TranslateTransition transition8 = new TranslateTransition();
		transition8.setDuration(Duration.seconds(result[7]/25));
		ath8.setText(Ozlympic.addAthletes.get(7).getName());
		transition8.setNode(ath8);
		transition8.setToX(500);
		transition8.play();
	}
	@FXML
	private void SwimRun7() {
		TranslateTransition transition1 = new TranslateTransition();
		transition1.setDuration(Duration.seconds(result[0]/25));
		ath1.setText(Ozlympic.addAthletes.get(0).getName());
		transition1.setNode(ath1);
		transition1.setToX(500);
		transition1.play();
		TranslateTransition transition2 = new TranslateTransition();
		transition2.setDuration(Duration.seconds(result[1]/25));
		ath2.setText(Ozlympic.addAthletes.get(1).getName());
		transition2.setNode(ath2);
		transition2.setToX(500);
		transition2.play();
		TranslateTransition transition3 = new TranslateTransition();
		transition3.setDuration(Duration.seconds(result[2]/25));
		ath3.setText(Ozlympic.addAthletes.get(2).getName());
		transition3.setNode(ath3);
		transition3.setToX(500);
		transition3.play();
		TranslateTransition transition4 = new TranslateTransition();
		transition4.setDuration(Duration.seconds(result[3]/25));
		ath4.setText(Ozlympic.addAthletes.get(3).getName());
		transition4.setNode(ath4);
		transition4.setToX(500);
		transition4.play();
		TranslateTransition transition5 = new TranslateTransition();
		transition5.setDuration(Duration.seconds(result[4]/25));
		ath5.setText(Ozlympic.addAthletes.get(4).getName());
		transition5.setNode(ath5);
		transition5.setToX(500);
		transition5.play();
		TranslateTransition transition6 = new TranslateTransition();
		transition6.setDuration(Duration.seconds(result[5]/25));
		ath6.setText(Ozlympic.addAthletes.get(5).getName());
		transition6.setNode(ath6);
		transition6.setToX(500);
		transition6.play();
		TranslateTransition transition7 = new TranslateTransition();
		transition7.setDuration(Duration.seconds(result[6]/25));
		ath7.setText(Ozlympic.addAthletes.get(6).getName());
		transition7.setNode(ath7);
		transition7.setToX(500);
		transition7.play();
	}
	@FXML
	private void SwimRun6() {
		TranslateTransition transition1 = new TranslateTransition();
		transition1.setDuration(Duration.seconds(result[0]/25));
		ath1.setText(Ozlympic.addAthletes.get(0).getName());
		transition1.setNode(ath1);
		transition1.setToX(500);
		transition1.play();
		TranslateTransition transition2 = new TranslateTransition();
		transition2.setDuration(Duration.seconds(result[1]/25));
		ath2.setText(Ozlympic.addAthletes.get(1).getName());
		transition2.setNode(ath2);
		transition2.setToX(500);
		transition2.play();
		TranslateTransition transition3 = new TranslateTransition();
		transition3.setDuration(Duration.seconds(result[2]/25));
		ath3.setText(Ozlympic.addAthletes.get(2).getName());
		transition3.setNode(ath3);
		transition3.setToX(500);
		transition3.play();
		TranslateTransition transition4 = new TranslateTransition();
		transition4.setDuration(Duration.seconds(result[3]/25));
		ath4.setText(Ozlympic.addAthletes.get(3).getName());
		transition4.setNode(ath4);
		transition4.setToX(500);
		transition4.play();
		TranslateTransition transition5 = new TranslateTransition();
		transition5.setDuration(Duration.seconds(result[4]/25));
		ath5.setText(Ozlympic.addAthletes.get(4).getName());
		transition5.setNode(ath5);
		transition5.setToX(500);
		transition5.play();
		TranslateTransition transition6 = new TranslateTransition();
		transition6.setDuration(Duration.seconds(result[5]/25));
		ath6.setText(Ozlympic.addAthletes.get(5).getName());
		transition6.setNode(ath6);
		transition6.setToX(500);
		transition6.play();
	}
	@FXML
	private void SwimRun5() {
		TranslateTransition transition1 = new TranslateTransition();
		transition1.setDuration(Duration.seconds(result[0]/25));
		ath1.setText(Ozlympic.addAthletes.get(0).getName());
		transition1.setNode(ath1);
		transition1.setToX(500);
		transition1.play();
		TranslateTransition transition2 = new TranslateTransition();
		transition2.setDuration(Duration.seconds(result[1]/25));
		ath2.setText(Ozlympic.addAthletes.get(1).getName());
		transition2.setNode(ath2);
		transition2.setToX(500);
		transition2.play();
		TranslateTransition transition3 = new TranslateTransition();
		transition3.setDuration(Duration.seconds(result[2]/25));
		ath3.setText(Ozlympic.addAthletes.get(2).getName());
		transition3.setNode(ath3);
		transition3.setToX(500);
		transition3.play();
		TranslateTransition transition4 = new TranslateTransition();
		transition4.setDuration(Duration.seconds(result[3]/25));
		ath4.setText(Ozlympic.addAthletes.get(3).getName());
		transition4.setNode(ath4);
		transition4.setToX(500);
		transition4.play();
		TranslateTransition transition5 = new TranslateTransition();
		transition5.setDuration(Duration.seconds(result[4]/25));
		ath5.setText(Ozlympic.addAthletes.get(4).getName());
		transition5.setNode(ath5);
		transition5.setToX(500);
		transition5.play();
	}
	@FXML
	private void SwimRun4() {
		TranslateTransition transition1 = new TranslateTransition();
		transition1.setDuration(Duration.seconds(result[0]/25));
		ath1.setText(Ozlympic.addAthletes.get(0).getName());
		transition1.setNode(ath1);
		transition1.setToX(500);
		transition1.play();
		TranslateTransition transition2 = new TranslateTransition();
		transition2.setDuration(Duration.seconds(result[1]/25));
		ath2.setText(Ozlympic.addAthletes.get(1).getName());
		transition2.setNode(ath2);
		transition2.setToX(500);
		transition2.play();
		TranslateTransition transition3 = new TranslateTransition();
		transition3.setDuration(Duration.seconds(result[2]/25));
		ath3.setText(Ozlympic.addAthletes.get(2).getName());
		transition3.setNode(ath3);
		transition3.setToX(500);
		transition3.play();
		TranslateTransition transition4 = new TranslateTransition();
		transition4.setDuration(Duration.seconds(result[3]/25));
		ath4.setText(Ozlympic.addAthletes.get(3).getName());
		transition4.setNode(ath4);
		transition4.setToX(500);
		transition4.play();
	}
	@FXML
	private void gameresult(ActionEvent event) throws IOException { //lead user to next step
		Parent gameresultPage =FXMLLoader.load(getClass().getResource("GameResult.fxml"));
		Scene gameresultPageScene = new Scene(gameresultPage);
		Stage gameresultPageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		gameresultPageStage.setScene(gameresultPageScene);
		gameresultPageStage.show();
	}
}
