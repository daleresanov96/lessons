import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class j02 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stg)throws Exception{
		Group g01=new Group();
		Scene sn=new Scene(g01,800,600,Color.SILVER);
		int cx=362,cy=305;
		int[] angle = new int[125];
		for ( int i = 0;i < angle.length;i++ ) {
			angle[i] = i;
		}
		int distance = 40;
		Circle crc1=new Circle(395,295,5);
		
		for ( int i = 0;i < angle.length;i++ ) {
			if(distance<=200) {
			distance+=2;
			}else {distance+=0.4;}
			angle[i]*=10;
			Circle crc=new Circle();
			double rad = Math.toRadians(angle[i]);
			int rx = (int)(Math.cos(rad) * distance) + cx;
			int ry = (int)(Math.sin(rad) * distance) + cy;
			crc.setCenterX(rx-10);
			crc.setCenterY(ry-10);
			crc.setRadius(5);
			
			if(i%2==0) {
				crc.setFill(Color.PURPLE);
			}else {
				crc.setFill(Color.YELLOW);
			}
			g01.getChildren().add(crc);
		}
		crc1.setFill(Color.BLACK);
		g01.getChildren().add(crc1);
		stg.setScene(sn);
		stg.show();
	}
}