package Exception;
/**
 * @date 14.05.2017
 * @author You Hao s3583715
 * @version 2.0
 * @Description TooFewAthleteException
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TooFewAthleteException extends Exception { //inspect number of athletes which is lower than 4
	public TooFewAthleteException() {//set attributes of interface
		Stage  TooFewAthlete = new Stage();
		TooFewAthlete.initModality(Modality.APPLICATION_MODAL);
		TooFewAthlete.setMinWidth(320);
		TooFewAthlete.setMinHeight(120);
		
		Label  TooFew = new Label();
		TooFew.setText("Each game should have 4 or more athletes!");
		Button close = new Button("Close");
		
		close.setOnAction(e -> TooFewAthlete.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(TooFew, close);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		TooFewAthlete.setScene(scene);
		TooFewAthlete.showAndWait();
	}
}
