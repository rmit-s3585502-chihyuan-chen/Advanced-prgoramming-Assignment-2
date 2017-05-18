package Exception;
/**
 * @date 14.05.2017
 * @author You Hao s3583715
 * @version 2.0
 * @Description GameFullException
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameFullException extends Exception { //inspect athletes number which is over 8
	public GameFullException() {//set attributes of interface
		Stage  GameFull = new Stage();
		 GameFull.initModality(Modality.APPLICATION_MODAL);
		 GameFull.setMinWidth(320);
		 GameFull.setMinHeight(120);
		
		Label  Full = new Label();
		Full.setText("You can't add more than 8 athletes!");
		Button close = new Button("Close");
		
		close.setOnAction(e -> GameFull.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(Full, close);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		GameFull.setScene(scene);
		GameFull.showAndWait();
	}

}
