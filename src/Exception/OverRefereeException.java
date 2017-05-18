package Exception;
/**
 * @date 14.05.2017
 * @author You Hao s3583715
 * @version 2.0
 * @Description OverRefereeException
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OverRefereeException extends Exception{ //inspect add too much official
	public OverRefereeException() {//set attributes of interface
		Stage OverReferee = new Stage();
		OverReferee.initModality(Modality.APPLICATION_MODAL);
		OverReferee.setMinWidth(320);
		OverReferee.setMinHeight(120);
		
		Label OverRef = new Label();
		OverRef.setText("Each game only can have one officer!");
		Button close = new Button("Close");
		
		close.setOnAction(e -> OverReferee.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(OverRef, close);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		OverReferee.setScene(scene);
		OverReferee.showAndWait();
	}
}
