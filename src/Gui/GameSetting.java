package Gui;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 1.0
 * @Description GameSetting
 */
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import Data.Official;
import Data.Athletes;
import Data.Cyclists;
import Data.Swimmers;
import Data.Sprinters;
import Data.SuperAthletes;
import OzlympicGames.Ozlympic;
import Exception.ExceptionAlert;
import java.io.IOException;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
public class GameSetting {
@FXML
private Button addAthletes;
@FXML
private Button deleteAthletes;
@FXML
private Button asignOfficial;
@FXML
private Button deleteOfficial;
@FXML
private Button next;
@FXML
private Button back;
@FXML
private Button home;
@FXML
private Button exit;
@FXML
private ListView availableAthletes;
@FXML
private ListView participants;	
@FXML
private ListView officials;
@FXML
private ListView chiefOfficials;
@FXML
private ObservableList<String> athleteList =FXCollections.observableArrayList();
@FXML
private ObservableList<String> participant =FXCollections.observableArrayList();
@FXML
private ObservableList<String> officers =FXCollections.observableArrayList();
@FXML
private ObservableList<String> chiefOfficer =FXCollections.observableArrayList();
private boolean officerSetting;
@FXML
private void home(ActionEvent event) throws IOException {
	athleteList.clear();
	participant.clear();
	Ozlympic.gameSelect=false;
	Ozlympic.tempAthletes.clear();
	Parent homepage =FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
	Scene homePageScene = new Scene(homepage);
	Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	homeStage.setScene(homePageScene);
	homeStage.show();		
}
@FXML
private void back(ActionEvent event) throws IOException {
	Parent back =FXMLLoader.load(getClass().getResource("GameType.fxml"));
	Scene  backPage = new Scene(back);
	Stage  backStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	backStage.setScene(backPage);
	backStage.show();	
	}
@FXML
private void exit() {
	Stage exitStage = (Stage) exit.getScene().getWindow();
    exitStage.close();
}
@FXML
private void initialize(){
	List();
	availableAthletes.setItems(athleteList);
	availableAthletes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	officials.setItems(officers);
	officerSetting = false;
	
}
@FXML
private void List(){	 	
	
	for(int i = 0; i < Ozlympic.tempAthletes.size(); i++) {			
		Athletes players = Ozlympic.tempAthletes.get(i);					
		String insertPlayer = players.getName();
		athleteList.add(insertPlayer);			
	}
	
	for(int j=0;j<Ozlympic.officials.size();j++) { 
		Official officerlist = Ozlympic.officials.get(j);
		String official = officerlist.getName();
		officers.add(official);

	}
	
}
@FXML
private void showSelection() {

	participants.setItems(participant);
	chiefOfficials.setItems(chiefOfficer);
	
}
@FXML
private void Next(ActionEvent event) throws ExceptionAlert {
		try {
		if(officerSetting == false) {
			throw new ExceptionAlert("Please assign an Officier");
		} else { 
			try {
				if(participant.size() < 4) {
						throw new ExceptionAlert("Each game should have 4 or more athletes");					
					} else {				
						for(int i =0;i < Ozlympic.athletes.size(); i++) {
							Athletes players = Ozlympic.athletes.get(i);	
							String playersName = players.getName();					
							for(int j =0; j <participant.size(); j++) {
								String participants = participant.get(j);
									if(participants == playersName){
									Ozlympic.addAthletes.add(players);							
								}
							}
						}
					}
					getAssignOfficer();
					Parent menuPage =FXMLLoader.load(getClass().getResource("StartGame.fxml"));
					Scene menuPageScene = new Scene(menuPage);
					Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					thisStage.setScene(menuPageScene);
					thisStage.show();
					
			} catch (Exception ExceptionAlert) {
					} 
		}
	} catch (Exception ExceptionAlert) {
		
	}
}
@FXML
private void assignOfficier(){		
	try {
		if(officerSetting == true) {
			throw new ExceptionAlert("Each game only can have one officer"); } 
		else {				
			String assignOfficer = (String) officials.getSelectionModel().getSelectedItem();
				
			if(assignOfficer != null) {
				chiefOfficer.add(assignOfficer);
				for(int i = 0; i < officers.size(); i++) {	
					String officerList = officers.get(i);				
					if (assignOfficer.equals(officerList)) {
						officers.remove(officerList);
					}
				}
			}	
		} officerSetting = true;
		
		showSelection();//Refresh list					
} catch(Exception ExceptionAlert) {
		
	}
}
private void getAssignOfficer() {
	for(int i =0;i < Ozlympic.officials.size(); i++) {		
		Official getofficer = Ozlympic.officials.get(i);	
		String OfficerName = getofficer.getName();					
		for(int j =0; j < chiefOfficer.size(); j++) {
			String AssignOfficerName = chiefOfficer.get(j);
				if(AssignOfficerName == OfficerName){
				Ozlympic.gameinfo.setOfficial(getofficer);	}
				}
		}
	}
@FXML
private void addParticipant() {		
	
	try {
		if(participant.size() > 7) {
			throw new ExceptionAlert("Each game can only have 4 to 8 participants"); } 
		else {				
			String addPlayers = (String) availableAthletes.getSelectionModel().getSelectedItem();
				
			if(addPlayers != null) {
				participant.add(addPlayers);
			
			
				for(int i = 0; i < athleteList.size(); i++) {	
					String AthletesList = athleteList.get(i);				
					if (addPlayers.equals(AthletesList)) {
						athleteList.remove(AthletesList);
					}
				}
			}
		}
		showSelection();//Refresh list					

} catch(Exception ExceptionAlert) {
		
	}
}
@FXML
private void deleteParticipant() {	

	String delete = (String) participants.getSelectionModel().getSelectedItem();
	if(delete != null) { 
		participant.remove(delete);
		athleteList.add(delete);	
		showSelection();//Refresh list	
	}
}
@FXML
private void deleteOfficers() {	

	String delete = (String) chiefOfficials.getSelectionModel().getSelectedItem();
	if(delete != null) { 
		chiefOfficer.remove(delete);
		officers.add(delete);	
		officerSetting = false;
		showSelection();//Refresh list	
	}
}
}
