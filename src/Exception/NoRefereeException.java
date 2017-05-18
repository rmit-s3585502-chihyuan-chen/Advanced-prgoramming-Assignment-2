package Exception;
/**
 * @date 14.05.2017
 * @author You Hao s3583715
 * @version 2.0
 * @Description NoRefereeException
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NoRefereeException extends Exception{ //inspect no official that is added
	public NoRefereeException() {//set attributes of interface
		Stage NoReferee = new Stage();
		NoReferee.initModality(Modality.APPLICATION_MODAL);
		NoReferee.setMinWidth(320);
		NoReferee.setMinHeight(120);
		
		Label NoRef = new Label();
		NoRef.setText("Please assign an officier!");
		Button close = new Button("Close");
		
		close.setOnAction(e -> NoReferee.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(NoRef, close);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		NoReferee.setScene(scene);
		NoReferee.showAndWait();
	}
}
