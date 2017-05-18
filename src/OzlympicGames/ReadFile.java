package OzlympicGames;

/**
 * @date 15.05.2017
 * @author You Hao s3583715
 * @version 1.0
 * @Description ReadFile
 */
import java.io.BufferedReader;
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
	public void ReadFile() { //import txt file
		try {
			input = new BufferedReader(new FileReader("participant.txt"));
		} catch (Exception e) {
			System.out.println("Could not find info.txt");
		}
	}
	
	public ArrayList<Official> loadOfficersTxt(ArrayList<Official> officials) throws IOException { //load officer from txt file
        String next = input.readLine();
        while (next != null) {
            String[] data = next.split(", ");
            String id = data[0];
            String type = data[1];
			String name = data[2];
			String age = data[3];
			String state = data[4];
			int point = 0;
			boolean valid = !(id.equals(" ") || id.equals("") || type.equals("") || type.equals(" ")
					|| name.equals("") || name.equals(" ") || state.equals("") || state.equals(" ")
					|| age.equals("") || age.equals(" "));
			boolean dup = true;
			for (int i = 0; i < officials.size(); i++){
				dup = !(id.equals(officials.get(i).getId()));
			}
			Official test = new Official(id,type,name, Integer.valueOf(data[3]), state, point);
			if (test.getType().equals("officer") && valid && dup) {
				Official officers = new Official(id,type,name, Integer.valueOf(data[3]), state, point);
				officials.add(officers);					
			}
			next = input.readLine();
			}
        input.close();
		return officials;	
		}
         
	public ArrayList<Athletes> loadAthletesTxt (ArrayList<Athletes> athletes) throws IOException {//load players from txt file
		String next = input.readLine();
        while (next != null) {
            String[] data = next.split(", ");
            String id = data[0];
            String type = data[1];
			String name = data[2];
			String age = data[3];
			String state = data[4];
			int point = 0;
			boolean valid = !(id.equals(" ") || id.equals("") || type.equals("") || type.equals(" ")
					|| name.equals("") || name.equals(" ") || state.equals("") || state.equals(" ")
					|| age.equals("") || age.equals(" "));
			boolean dup = true;
			for (int i = 0; i < athletes.size(); i++){
				dup = !(id.equals(athletes.get(i).getId()));
			}
			Athletes test = new Athletes(id,type,name,Integer.valueOf(data[3]),state,point);
			if (test.getType().equals("cyclist")&& valid&& dup) {				
				Cyclists cyclist = new Cyclists(id,type,name,Integer.valueOf(data[3]),state,point);
				athletes.add(cyclist);				
			}
			else if (test.getType().equals("swimmer")&& valid&& dup) {
				Swimmers swimmer = new Swimmers(id,type,name,Integer.valueOf(data[3]),state,point);
				athletes.add(swimmer);				
			}
			else if (test.getType().equals("sprinter")&& valid&& dup) {				
				Sprinters sprinter = new Sprinters(id,type,name,Integer.valueOf(data[3]),state,point);
				athletes.add(sprinter);				
			}
			else if (test.getType().equals("super")&& valid&& dup) {
				SuperAthletes superAthletes = new SuperAthletes(id,type,name,Integer.valueOf(data[3]),state,point);
				athletes.add(superAthletes);				
			}	
			next = input.readLine();
		}
	input.close();
	return athletes;
	}
}
