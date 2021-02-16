import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Test extends Application{
	public static void main(String[]args){
		launch(args);
	}
	@Override
	public void start(Stage sg)throws Exception{
		Group root=new Group();
		Scene scene=new Scene(root,400,300);
		Rectangle rect=new Rectangle(170,120,60,60);
		rect.setFill(Color.PURPLE);
		rect.setFill(Color.rgb(0,255,0));
		root.getChildren().add(rect);
		sg.setScene(scene);
		sg.show();
	}
}
