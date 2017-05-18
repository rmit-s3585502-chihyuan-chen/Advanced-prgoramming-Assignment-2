package Data;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 2.0
 * @Description WriteDB
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WriteDB {
	public static void export(){
	try {
		String connUrl = "jdbc:sqlite:gameresult.sqlite";//connect with game result database
		java.sql.Connection conn = DriverManager.getConnection(connUrl);
		
		
		FileReader fr = new FileReader("gameResults.txt");//import txt file
        BufferedReader brdFile = new BufferedReader(fr);//use bufferreader to read txt
        String strLine = null;
        while((strLine = brdFile.readLine())!=null){//save each line into database until the line is null  
		String[] array=strLine.split("\n");//use \n to separate data
		String qryInsert="insert into game values(?)";//use sql command to insert values into game table 
		PreparedStatement pstmt= conn.prepareStatement(qryInsert);
		pstmt.setString(1,array[0]);
		pstmt.execute();
		};
	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e){
			// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
