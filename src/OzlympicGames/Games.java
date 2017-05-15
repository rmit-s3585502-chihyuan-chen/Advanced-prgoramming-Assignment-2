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
	public ArrayList<Athletes> athletes= new ArrayList<Athletes>();
	public void playGame (ArrayList<Athletes> addAthletes, Games gameinfo, ArrayList<Official>official){
		this.setGameId(GameId);		
		String superName = GameType;
		
	}
	public ArrayList<Athletes> loadAthletes(ArrayList<Athletes> athletes){
		this.athletes = athletes;
		return athletes;				
	}
	
	public Athletes getaddAthletes(){
		return player;
		
	}
	public String GameType() {	
		return GameType;
	}

	public String getGameId() {
		return GameId;
	}
	
	public void setGameId(String GameId) {
		this.GameId = GameId;
	}

	public void setGameType(String GameType) {
		this.GameType = GameType;
	}

	public static int getGameRound() {
		GameRound ++;
		return GameRound;
	}

	public static void setGameRound(int GameRound) {
		Games.GameRound = GameRound;
	}
	public static void ReduceGameRound(int GameRound) {
		Games.GameRound -= GameRound;
	}
	

		public Official getOfficial() {
		return offical;
	}

	public void setOfficial(Official offical) {
		this.offical = offical;
	}
	
		
	}
	
	
	
	

