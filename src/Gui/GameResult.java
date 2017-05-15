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
		String recordLine=null;
		String record = null;
		String date = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
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
			}}
		recordDate=(Ozlympic.gameinfo.getGameId()+" ,"+Ozlympic.gameinfo.getOfficial().getId()+","+date);
		Ozlympic.history.add(recordDate);
		showResult.appendText(Ozlympic.gameinfo.getGameId()+"\t"+","+Ozlympic.gameinfo.getOfficial().getId()+"\t"+","+date);
		for (int j = 1; j < (Ozlympic.addAthletes.size()+1);j++){
			for (int i = 0; i<Ozlympic.addAthletes.size(); i++){
				if (ranklist[i]==j){
				if (j==1){
					Ozlympic.addAthletes.get(i).setPoint(5);
					showResult.appendText("\n"+Ozlympic.addAthletes.get(i).getId()+" ,"+result[i]+","+Ozlympic.addAthletes.get(i).getPoint());
				}
				else if (j==2){
					Ozlympic.addAthletes.get(i).setPoint(2);
					showResult.appendText("\n"+Ozlympic.addAthletes.get(i).getId()+" ,"+result[i]+","+Ozlympic.addAthletes.get(i).getPoint());
				}
				else if (j==3){
					Ozlympic.addAthletes.get(i).setPoint(1);
					showResult.appendText("\n"+Ozlympic.addAthletes.get(i).getId()+" ,"+result[i]+","+Ozlympic.addAthletes.get(i).getPoint());
				}
				else{
					Ozlympic.addAthletes.get(i).setPoint(0);
					showResult.appendText("\n"+Ozlympic.addAthletes.get(i).getId()+" ,"+result[i]+","+Ozlympic.addAthletes.get(i).getPoint());
				}
			}}}for(int i=0; i<Ozlympic.addAthletes.size();i++){
		record =(Ozlympic.addAthletes.get(i).getId()+" ,"+result[i]+","+Ozlympic.addAthletes.get(i).getPoint());		
		Ozlympic.history.add(record);}	
		recordLine=(""+"\n");
		Ozlympic.history.add(recordLine);				
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
