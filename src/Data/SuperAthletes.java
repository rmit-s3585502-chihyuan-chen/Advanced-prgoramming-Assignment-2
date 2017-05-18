package Data;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 2.0
 * @Description setting the role of athletes 
 */
import java.util.Random; //import random function to set compete time 

public class SuperAthletes extends Athletes {
	//Set the attribute of SuperAthletes and inherit attributes from Athletes
	public SuperAthletes(String id, String type,String name, int age, String state,int point) {
		super(id,type,name, age, state,point);
	}

	//Restrict time and set parameter game type to check athlete type to compete which game
	public int compete(String GameType) {
		int max=0;//set the max game time
        int min=0;//set the max game time
        if(GameType == "Running") {  //use game type to assign the game to super athletes to compete
			max = 200;
			min = 100;
		} else if (GameType =="Cycling") {
			max = 800;
			min = 500;
		} else if (GameType == "Swimming") {
			max = 200;
			min = 100;
		}	        
        Random random = new Random();
        int time = random.nextInt(max)%(max-min+1) + min;
		return time;
	}
}
