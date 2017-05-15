package OzlympicGames;
import java.io.BufferedReader;
/**
 * @date 15.05.2017
 * @author You Hao s3583715
 * @version 1.0
 * @Description ReadFile
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Data.Athletes;
import Data.Cyclists;
import Data.Official;
import Data.Sprinters;
import Data.SuperAthletes;
import Data.Swimmers;


public class ReadFile {
	BufferedReader input;
	public void ReadFile() {
		try {
			input = new BufferedReader(new FileReader("participant.txt"));
		} catch (Exception e) {
			System.out.println("Could not find info.txt");
		}
	}
	
	public ArrayList<Official> loadOfficersTxt(ArrayList<Official> officials) throws IOException {
		ArrayList<Official> officerData = new ArrayList<Official>();
        String next = input.readLine();
        while (next != null) {
            String[] data = next.split(", ");
            String id = data[0];
            String type = data[1];
			String name = data[2];
			int age = Integer.valueOf(data[3]);
			String state = data[4];
			int point = 0;
			Official test = new Official(id,type,name, age, state, point);
			if (test.getType().equals("officer")) {
				Official officers = new Official(id,type,name, age, state, point);
				officials.add(officers);				
			}
			next = input.readLine();
			}
        input.close();
		return officerData;	
		}
         
	public ArrayList<Athletes> loadAthletesTxt (ArrayList<Athletes> athletes) throws IOException {
		ArrayList<Athletes> athletesData = new ArrayList<Athletes>(); 
		String next = input.readLine();
        while (next != null) {
            String[] data = next.split(", ");
            String id = data[0];
            String type = data[1];
			String name = data[2];
			int age = Integer.valueOf(data[3]);
			String state = data[4];
			int point = 0;
			Athletes test = new Athletes(id,type,name,age,state,point);
			if (test.getType().equals("cyclist")) {				
				Cyclists cyclist = new Cyclists(id,type,name,age,state,point);
				athletes.add(cyclist);				
			}
			else if (test.getType().equals("swimmer")) {
				Swimmers swimmer = new Swimmers(id,type,name,age,state,point);
				athletes.add(swimmer);				
			}
			else if (test.getType().equals("sprinter")) {				
				Sprinters sprinter = new Sprinters(id,type,name,age,state,point);
				athletes.add(sprinter);				
			}
			else if (test.getType().equals("super")) {
				SuperAthletes superAthletes = new SuperAthletes(id,type,name,age,state,point);
				athletes.add(superAthletes);				
			}	
			next = input.readLine();
		}
	input.close();
	return athletesData;
	}
}
