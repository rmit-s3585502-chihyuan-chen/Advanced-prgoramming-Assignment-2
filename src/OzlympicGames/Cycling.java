package OzlympicGames;
/**
 * @date 14.05.2017
 * @author You Hao s3583715
 * @version 2.0
 * @Description Use cycling class to connect driver and get random number of cyclists  
 */


import java.util.ArrayList;

import Data.Athletes;
import Data.Cyclists;
import Data.SuperAthletes;
import Data.Sprinters;


//inherit attributes from Games
public class Cycling extends Games{
	
	//constructor of cycling game
	public Cycling() {
		super();
		setGameType("Cycling");
		setGameId("C0"+getGameRound());
	}
	
public ArrayList<Athletes> loadAthletes(ArrayList<Athletes> athletes){ //load data list to store data which contains cyclists and suepratheletes
		ArrayList<Athletes> playersData = new ArrayList<Athletes>(); 
		for (int i=0; i < athletes.size(); i++) {			
			Athletes players = athletes.get(i);		
			if	(players instanceof SuperAthletes|| players instanceof Cyclists) {
				playersData.add(players);
				} 
			}		
		return playersData;
	}
}
