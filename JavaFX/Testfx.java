import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageViem;
import javafx.scene.Layout.Hbox;
import javafx.scene.layout.BorderImage;
import javafx.scene.paint.Color;

public class TestFX extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage)throws Exception{
		Image image=new Image("dada.jpg");
		ImageViem iv1=new ImageViem();
		iv1.setImage(image);
		Group root=new Group();
		Scene scane=new Scene(root);
		// scene.setFill(Color.WHITE);
		Hbox box=new Hbox();
		box.getChildren().add(iv1);
		root.getChildren().add(box);
		stage.setTitle("ImageViem");
		stage.setWidth(200);
		stage.setHeight(100);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}
}