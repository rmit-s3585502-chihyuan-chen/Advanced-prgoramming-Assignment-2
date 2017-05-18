package OzlympicGames;
/**
 * @date 14.05.2017
 * @author You Hao s3583715
 * @version 2.0
 * @Description Use swimming class to connect driver and get random number of swimmers  
 */
import java.util.*;
import Data.Official;
import Data.Athletes;
import Data.Cyclists;
import Data.Swimmers;
import Data.Sprinters;
import Data.SuperAthletes;

//inherit attributes from Games
public class Swimming extends Games {
	//constructor of Swimming game
	public Swimming() {
		super();
		setGameType("Swimming");
		setGameId("S0"+getGameRound());
	}

public ArrayList<Athletes> loadAthletes(ArrayList<Athletes> athletes){ //load data list to store data which contains swimmers and suepratheletes
		ArrayList<Athletes> playersData = new ArrayList<Athletes>();
		for (int i=0; i < athletes.size(); i++) {			
			Athletes players = athletes.get(i);		
			if	(players instanceof SuperAthletes|| players instanceof Swimmers) {
				playersData.add(players);
				} 
			}		
		return playersData;
	}
}