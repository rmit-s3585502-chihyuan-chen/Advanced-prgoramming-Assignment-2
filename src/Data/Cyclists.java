package Data;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 2.0
 * @Description setting the role of athletes 
 */


import java.util.Random; //import random function to set compete time 

public class Cyclists extends Athletes { //inherent superclass Athletes

//Set the attribute of cyclists and inherit attributes from Athletes
	public Cyclists(String id, String type,String name, int age, String state,int point) {
		super(id,type,name, age, state,point);
	}
	//Restrict time and set parameter game type to check athlete type to compete which game
	public int compete(String GameType) {
		int max=800; //set the max game time 
		int min=500; //set the min game time 
		Random random = new Random(); //Create random variable
		int time = random.nextInt(max)%(max-min+1) + min;
		return time;
	}
}
