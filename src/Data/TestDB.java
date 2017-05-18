package Data;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 2.0
 * @Description TestDB
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Athletes;
import Data.Cyclists;
import Data.Official;
import OzlympicGames.Cycling;
import OzlympicGames.Games;
import OzlympicGames.Ozlympic;
import OzlympicGames.Running;
import OzlympicGames.Swimming;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import Data.Sprinters;
import Data.SuperAthletes;
import Data.Swimmers;

public class TestDB {
    //create connection with database
	private Connection connect() {     
    String path = "jdbc:sqlite:participant.sqlite";
    Connection connecting = null;
        try {
            connecting = DriverManager.getConnection(path); 
            
        	
        } catch (SQLException e) {
            System.out.println("Cannot load DB, system will load txt file to run");
         
           
        } 
        return connecting;
    }
    //load data via the SQL query to connect with database
	public void loadData() {
    String query = "SELECT id, type,name , age, state, point FROM participant"; //SQl query
      try (Connection connecting = this.connect();
       Statement sqlCommand  = connecting.createStatement();
       ResultSet getData    = sqlCommand.executeQuery(query)){
            while (getData.next()) { //assign which type of data will be gotten from database 
            String id = getData.getString("id"); 
            String type = getData.getString("type"); 
            String name = getData.getString("name");
            int age = getData.getInt("age");
            String state = getData.getString("state");
            int point = getData.getInt("point");
            Athletes participantDB = new Athletes(id, type,name, age, state, point); //create a role which has same attributes that db's table has
            if (participantDB.getType().equals("cyclist")) {          //use type to be a key to find the particular data from database and store into ArrayList				
            Cyclists cyclistsDB = new Cyclists(id, type,name, age, state, point);
            Ozlympic.athletes.add(cyclistsDB );				
                       			}
            else if (participantDB.getType().equals("swimmer")) {
                       				Swimmers swimmerDB = new Swimmers(id, type,name, age, state, point);
                       				Ozlympic.athletes.add(swimmerDB);				
                       			}
                       			
                       			else if (participantDB.getType().equals("sprinter")) {				
                       				Sprinters sprinterDB = new Sprinters(id, type,name, age, state, point);
                       				Ozlympic.athletes.add(sprinterDB);				
                       			}
                       			else if (participantDB.getType().equals("super")) {
                       				SuperAthletes superathleteDB = new SuperAthletes(id, type,name, age, state, point);
                       				Ozlympic.athletes.add(superathleteDB);		
                       			} else if (participantDB.getType().equals("officer")) {
                       				Official officerDB = new Official(id, type,name, age, state, point);
                       				Ozlympic.officials.add(officerDB);				
                       			}
            }	
           
        } catch (SQLException e) {
        	
        	
        } 
    }


	
}