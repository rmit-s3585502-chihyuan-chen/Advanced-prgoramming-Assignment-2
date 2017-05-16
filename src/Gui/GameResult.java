package Gui;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 1.0
 * @Description GameResult
 */
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		String recordDate=null;
		String record = null;
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		int date2 = Integer.valueOf(new SimpleDateFormat("SSS").format(new Date()));
		Ozlympic.gameSelect = true;
		Ozlympic.gameinfo.playGame(Ozlympic.addAthletes, Ozlympic.gameinfo, Ozlympic.officials);
		int[] result = new int[Ozlympic.addAthletes.size()];
		int[] ranklist = new int[Ozlympic.addAthletes.size()];
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
		recordDate=(Ozlympic.gameinfo.getGameId()+", "+Ozlympic.gameinfo.getOfficial().getId()+", "+date+"."+new DecimalFormat("#").format(date2/10));
		Ozlympic.history.add(recordDate);
		Ozlympic.history2.clear();
		Ozlympic.history2.add(recordDate);
		showResult.appendText(Ozlympic.gameinfo.getGameId()+","+"\t"+Ozlympic.gameinfo.getOfficial().getId()+","+"\t"+date+"."+new DecimalFormat("#").format(date2/10));
		
		getresult(Ozlympic.gameinfo.GameType(), result, ranklist, record);				
		}
		
	
	private void getresult(String gameType, int[] result, int[] ranklist, String record) {
		double [] result2 = new double [Ozlympic.addAthletes.size()];
		if (gameType.equals("Running")){
			getrunresult(result2, result, ranklist, record);
		}
		else {
			getotherresult(result, ranklist, record);
		}
		Ozlympic.history.add("\n");
		Ozlympic.history.add("\n");
		Ozlympic.history2.add("\n");
		Ozlympic.history2.add("\n");
		Ozlympic.saving();
	}

	private void getotherresult(int[] result, int[] ranklist, String record) {
		for (int j = 1; j < (Ozlympic.addAthletes.size()+1);j++){
			for (int i = 0; i<Ozlympic.addAthletes.size(); i++){
				if (ranklist[i]==j){
				if (j==1){
					Ozlympic.addAthletes.get(i).setPoint(5);
					record =("\n"+Ozlympic.addAthletes.get(i).getId()+", "+result[i]+", 5");
					showResult.appendText(record);
					Ozlympic.history.add(record);
					Ozlympic.history2.add(record);
				}
				else if (j==2){
					Ozlympic.addAthletes.get(i).setPoint(2);
					record =("\n"+Ozlympic.addAthletes.get(i).getId()+", "+result[i]+", 2");
					showResult.appendText(record);
					Ozlympic.history.add(record);
					Ozlympic.history2.add(record);
				}
				else if (j==3){
					Ozlympic.addAthletes.get(i).setPoint(1);
					record =("\n"+Ozlympic.addAthletes.get(i).getId()+", "+result[i]+", 1");
					showResult.appendText(record);
					Ozlympic.history.add(record);
					Ozlympic.history2.add(record);
				}
				else{
					Ozlympic.addAthletes.get(i).setPoint(0);
					record =("\n"+Ozlympic.addAthletes.get(i).getId()+", "+result[i]+", 0");
					showResult.appendText(record);
					Ozlympic.history.add(record);
					Ozlympic.history2.add(record);
				}
			}
				}
			}
	}

	private void getrunresult(double[] result2, int[] result, int[] ranklist, String record) {
			for (int i = 0; i<Ozlympic.addAthletes.size(); i++){
				result2[i]=result[i];
			}
		for (int j = 1; j < (Ozlympic.addAthletes.size()+1);j++){
			for (int i = 0; i<Ozlympic.addAthletes.size(); i++){
				if (ranklist[i]==j){
				if (j==1){
					Ozlympic.addAthletes.get(i).setPoint(5);
					record =("\n"+Ozlympic.addAthletes.get(i).getId()+", "+result2[i]/10+", 5");
					showResult.appendText(record);
					Ozlympic.history.add(record);
					Ozlympic.history2.add(record);
				}
				else if (j==2){
					Ozlympic.addAthletes.get(i).setPoint(2);
					record =("\n"+Ozlympic.addAthletes.get(i).getId()+", "+result2[i]/10+", 2");
					showResult.appendText(record);
					Ozlympic.history.add(record);
					Ozlympic.history2.add(record);
				}
				else if (j==3){
					Ozlympic.addAthletes.get(i).setPoint(1);
					record =("\n"+Ozlympic.addAthletes.get(i).getId()+", "+result2[i]/10+", 1");
					showResult.appendText(record);
					Ozlympic.history.add(record);
					Ozlympic.history2.add(record);
				}
				else{
					Ozlympic.addAthletes.get(i).setPoint(0);
					record =("\n"+Ozlympic.addAthletes.get(i).getId()+", "+result2[i]/10+", 0");
					showResult.appendText(record);
					Ozlympic.history.add(record);
					Ozlympic.history2.add(record);
				}
			}
				}
			}
		}

	@FXML
	private void home(ActionEvent event) throws IOException {
		Ozlympic.gameSelect = false;
		Ozlympic.tempAthletes.clear();
		Ozlympic.addAthletes.clear();
       	Parent menuPage =FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
		Scene menuPageScene = new Scene(menuPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(menuPageScene);
		thisStage.show();
	}
}
