package OzlympicGames;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @date 15.05.2017
 * @author You Hao s3583715
 * @version 2.0
 * @Description Ozlympic
 */
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Data.Official;
import Data.Athletes;
import Data.Cyclists;
import Data.Swimmers;
import Data.Sprinters;
import Data.SuperAthletes;

public class Ozlympic extends Application {

	public static ArrayList<Athletes> athletes = new ArrayList<Athletes>(); 
	public static ArrayList<Official> officials = new ArrayList<Official>();
	public static ArrayList<String> history = new ArrayList<String>(); 
	public static ArrayList<Athletes> tempAthletes = new ArrayList<Athletes>(); 
	public static ArrayList<Athletes> addAthletes = new ArrayList<Athletes>();
	
	public static boolean gameSelect = false; 
	public static Games gameinfo = new Games();
	static PrintWriter out = null;
	public static Stage primaryStage;
	public void start(Stage primaryStage) {
		try {
			Parent Ozlympic=FXMLLoader.load(getClass().getResource("/Gui/GameMenu.fxml"));
			Scene Mainscene = new Scene(Ozlympic);
			primaryStage.setScene(Mainscene);
			primaryStage.setTitle("Ozlympic");
			primaryStage.getIcons().add(new Image("/images/Olympics.png"));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		loadingTxt();
		launch(args);
	}
	public static void loadingTxt() {
		try {	
			ReadFile loading = new ReadFile();
			loading.ReadFile();	
			loading.loadAthletesTxt(athletes);
			loading.ReadFile();
			loading.loadOfficersTxt(officials);
		
			
		}catch (Exception e) {
			System.out.println("Cannot load txt file");
			}	
		}
	

	static void displayGames(ArrayList<Athletes> comp, ArrayList<Athletes> loadArray, ArrayList<Official> official, ArrayList<String> history) {
		
		for (int i = 0; i < history.size(); i++) {
			String test = history.get(i);
		System.out.println(test);
		} 	

	}
	public static Games selectGame(int selection) {
		Games newGame = new Games();
		switch(selection) {
			case 1: newGame = new Swimming();
				newGame.setGameType("Swimming");
				gameSelect = true;	
				break;					
			case 2:newGame = new Cycling(); 
			newGame.setGameType("Cycling");
			gameSelect = true;	
				break;
			case 3:	newGame = new Running();	
			newGame.setGameType("Running");
			gameSelect = true;	
				break;
			default:
				System.out.println("Invalid!");
		}
		return newGame;
	}
	public static void saving(){
		FileWriter writer = null;
		try {
			writer = new FileWriter("gameResults.txt", true);
			for (int i = 0; i < Ozlympic.history.size(); i++){
			writer.write(Ozlympic.history.get(i));
			}
			writer.write("-------------------------------------");
			writer.write(System.getProperty("line.separator"));
			writer.close();// flushes the stream.
		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
	}
	
}
