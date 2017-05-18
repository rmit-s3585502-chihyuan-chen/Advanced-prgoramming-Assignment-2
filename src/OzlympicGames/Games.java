package OzlympicGames;
/**
 * @date 14.05.2017
 * @author You Hao s3583715
 * @version 2.0
 * @Description setting game environment 
 */
import java.util.ArrayList;
import java.util.Random;
import Data.Official;
import Data.Athletes;
import Data.Cyclists;
import Data.Swimmers;
import Data.Sprinters;
import Data.SuperAthletes;
public class Games {
	static int[] temprank = new int[8];
	private static String GameType;
	private static String GameId;	
	private static int GameRound;
	private Athletes  player;
	private Official offical;
	public ArrayList<Athletes> athletes= new ArrayList<Athletes>(); //assign game id and game officer
	public void playGame (ArrayList<Athletes> addAthletes, Games gameinfo, ArrayList<Official>official){//assign attributes for each game
		this.setGameId(GameId);		
		String superName = GameType;
	}
	public ArrayList<Athletes> loadAthletes(ArrayList<Athletes> athletes){ //load athletes
		this.athletes = athletes;
		return athletes;
	}
	
	public Athletes getaddAthletes(){ //get player that user add into list
		return player;
	}
	public String GameType() {	  //return game type
		return GameType;
	}

	public String getGameId() {//get game id
		return GameId;
	}
	
	public void setGameId(String GameId) { //set game id
		this.GameId = GameId;
	}

	public void setGameType(String GameType) {//set game type
		this.GameType = GameType;
	}

	public static int getGameRound() { //get game round
		GameRound ++;
		return GameRound;
	}

	public static void setGameRound(int GameRound) { //set game round
		Games.GameRound = GameRound;
	}
	public static void ReduceGameRound(int GameRound) { //reduce the game round
		Games.GameRound -= GameRound;
	}

	public Official getOfficial() { //get official info
		return offical;
	}

	public void setOfficial(Official offical) { //set official
		this.offical = offical;
	}
}