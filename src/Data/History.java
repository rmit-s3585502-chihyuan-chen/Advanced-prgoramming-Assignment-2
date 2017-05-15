package Data;
/**
 * @date 03.04.2017
 * @author Chih Yuan Chen S3585502
 * @version 1.0
 * @Description  setting the attributes of history for storing all temporary game result
 */
public class History {
	public String GameID;  //set GamID parameter
	public String OfficialName;//set officialName parameter
	public String[] temporaryID = new String[8]; //set array to store ID
	public String[] temporaryName = new String[8];//set array to store Name
	public String[] temporaryResult = new String[8];//set array to store Result
	public String[] temporaryRank = new String[8]; //set array to store Rank
	
	//constructor of temporary history to define its attributes
	public History(String GameID,String OfficialName,String[]temporaryID,String[]temporaryName,String[]temporaryResult,String[]temporaryRank){
		this.GameID=GameID;
		this.OfficialName=OfficialName;
		this.temporaryID=temporaryID;
		this.temporaryName=temporaryName;
		this.temporaryResult=temporaryResult;
		this.temporaryRank=temporaryRank;
	}
	
	public String getGameID() {
		return GameID;
	}
	public String getOfficialName() {
		return OfficialName;
	}
	public String[] getTemporaryID() {
		return  temporaryID;
	}
	public String[] getTemporaryName() {
		return temporaryName;
	}
	public String[] getTemporaryResult() {
		return temporaryResult;
	}
	public String[] getTemporaryRank() {
		return temporaryRank;
	}
}
