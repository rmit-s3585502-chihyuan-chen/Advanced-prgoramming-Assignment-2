package Gui;

import OzlympicGames.Ozlympic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Animation extends Application {
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Animation.fxml"));
		Scene scene = new Scene (root);
		stage.setScene(scene);
		stage.show();
	}

	

}