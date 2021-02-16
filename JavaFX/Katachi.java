
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Katachi extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stg)throws Exception{
		Group g01=new Group();
		Scene sn=new Scene(g01,400,300);

						//01
		Rectangle rec01 = new Rectangle(150,125,25,50);
		rec01.setFill(Color.BLUE);
		
						//02
		Rectangle rec02 = new Rectangle(175,100,50,25);
		rec02.setFill(Color.SILVER);
		
						//03
		Rectangle rec03 = new Rectangle(225,125,25,50);
		rec03.setFill(Color.GOLD);
		
						//04
		Rectangle rec04 = new Rectangle(175,175,50,25);
		rec04.setFill(Color.RED);
		
						//05
		Circle crc=new Circle(200,150,25);
		crc.setFill(Color.PURPLE);


		g01.getChildren().add(crc);
		g01.getChildren().add(rec01);
		g01.getChildren().add(rec02);
		g01.getChildren().add(rec03);
		g01.getChildren().add(rec04);

		stg.setScene(sn);
		stg.show();

	}
}