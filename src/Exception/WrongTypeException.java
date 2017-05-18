package Exception;
/**
 * @date 14.05.2017
 * @author You Hao s3583715
 * @version 2.0
 * @Description WrongTypeException
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WrongTypeException extends Exception { //wrong game type exception interface to show the error window
	public WrongTypeException() {//set attributes of interface
		Stage WrongType = new Stage();
		WrongType.initModality(Modality.APPLICATION_MODAL);
		WrongType.setMinWidth(320);
		WrongType.setMinHeight(120);
		
		Label Wrong = new Label();
		Wrong.setText("Type of the athlete is wrong!");
		Button close = new Button("Close");
		
		close.setOnAction(e -> WrongType.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(Wrong, close);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		WrongType.setScene(scene);
		WrongType.showAndWait();
	}
}
