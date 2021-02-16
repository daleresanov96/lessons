import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Example04 extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage){
		stage.setTitle("Example04");

		Group root=new Group();
		Scene scene=new Scene(root);
		stage.setScene(scene);

		Canvas canvas=new Canvas(512-64,256);
		root.getChildren().add(canvas);

		ArrayList<String>input=new ArrayList<String>();

		scene.setOnKeyReleased(
			new EventHandler<KeyEvent>(){
				public void handle(KeyEvent e){
					String code = e.getCode().toString();
					if(!input.remove(code))input.add(code);
				}
			});

		GraphicsContext gc=canvas.getGraphicsContext2D();
		Image left=new Image("left.png");
		Image leftG=new Image("leftG.png");
		Image right=new Image("right.png");
		Image rightG=new Image("rightG.png");

		new AnimationTimer(){
			public void handle(long currentNanoTime){
				gc.clearRect(0,0,512,512);
				if(input.contains("LEFT"))
					gc.drawImage(leftG,50,50);
				else
					gc.drawImage(left,50,50);
				if(input.contains("RIGHT"))
					gc.drawImage(rightG,270,50);
				else
					gc.drawImage(right,270,50);
			}
		}.start();
		stage.show();
	}
}