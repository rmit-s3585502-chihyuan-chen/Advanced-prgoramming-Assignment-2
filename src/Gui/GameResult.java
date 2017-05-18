package Gui;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 1.0
 * @Description GameResult
 */
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;
import OzlympicGames.Ozlympic;
import OzlympicGames.Games;
import OzlympicGames.Cycling;
import OzlympicGames.Running;
import OzlympicGames.Swimming;
import Data.Official;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.Athletes;
import Data.Cyclists;
import Data.Swimmers;
import Data.TestDB;
import Data.WriteDB;
import Data.Sprinters;
import Data.SuperAthletes;
public class GameResult {
	
	
	@FXML
	private Button home;
	@FXML
	private TextArea showResult;
	@FXML

	private void initialize() { //conduct each athlete who was selected by user to compete the game automatically and show result
		WriteDB write=new WriteDB();
		String recordDate=null;
		String record = null;
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//set the date attributes of game result
		int date2 = Integer.valueOf(new SimpleDateFormat("SSS").format(new Date()));//set date format to match the requirement
		Ozlympic.gameSelect = true; 
		Ozlympic.gameinfo.playGame(Ozlympic.addAthletes, Ozlympic.gameinfo, Ozlympic.officials);//get attributes that can run the game
		int result[] = new int[Ozlympic.addAthletes.size()]; //store result into arrray
		int[] ranklist = new int[Ozlympic.addAthletes.size()];// store rank into array
		for(int i = 0; i<Ozlympic.addAthletes.size(); i++){	//use for loop to let each players to play the game and produce results to save in array
			result[i]=Ozlympic.addAthletes.get(i).compete(Ozlympic.gameinfo.GameType());  
		}
		for (int i = 0; i<Ozlympic.addAthletes.size(); i++){//user for loop to compare results to sort the rank
			ranklist[i]=1;
				for (int j=0; j < Ozlympic.addAthletes.size(); j++){
				if(result[i]>result[j]){
					ranklist[i] = ranklist[i] + 1;}
			}
		}
		recordDate=(Ozlympic.gameinfo.getGameId()+", "+Ozlympic.gameinfo.getOfficial().getId()+", "+date+"."+new DecimalFormat("#").format(date2/10)); //insert values into record data
		Ozlympic.history.add(recordDate);//use history arraylist to add these data
		Ozlympic.history2.clear();// clear the history2 list
		Ozlympic.history2.add(recordDate);//use history2 arraylist to add these data
		showResult.appendText(Ozlympic.gameinfo.getGameId()+","+"\t"+Ozlympic.gameinfo.getOfficial().getId()+","+"\t"+date+"."+new DecimalFormat("#").format(date2/10));	
		getresult(Ozlympic.gameinfo.GameType(), result, ranklist, record);//output to txt
		write.export();// write into database
		
		}
	
	
	
	private void getresult(String gameType, int[] result, int[] ranklist, String record) { // get result and store into history2 list
	
		
		
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
	

	private void getotherresult(int[] result, int[] ranklist, String record) {//sort rank of athletes to give them points
	
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

	private void getrunresult(double[] result2, int[] result, int[] ranklist, String record) { //sort rank of athletes to give them points and store double type of running result 

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
	private void home(ActionEvent event) throws IOException {//back to home
		Ozlympic.gameSelect = false;
		Ozlympic.tempAthletes.clear();
		Ozlympic.addAthletes.clear();
       	Parent homePage =FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
		Scene homePageScene = new Scene(homePage);
		Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		homeStage.setScene(homePageScene);
		homeStage.show();
	}
}
