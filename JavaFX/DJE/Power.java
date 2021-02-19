import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;


public class Power extends Application{
	private  double positionX;
	private double positionY;
	public static void main(String[] args) {
		launch(args);	
	}
	@Override
	public void start(Stage stage){
		Group root=new Group();
		Scene scene=new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen (true);
		Canvas canvas=new  Canvas(1960,1060);
		root.getChildren().add(canvas);
		GraphicsContext gc=canvas.getGraphicsContext2D();

		ArrayList<String>input=new ArrayList<String>();

		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				String code=e.getCode().toString();
				System.out.println(e.getCode());
				if(!input.contains(code))input.add(code);
			}
		});
		scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				String code=e.getCode().toString();
				input.remove(code);
			}
		});
		gc.fillRect(830,1020,positionX+300,20);
		new AnimationTimer(){
			public void handle(long currentNanoTimer){
				gc.clearRect(0,0,1960,1060);
				if (input.contains("ESCAPE"))
					stage.hide();
				if (input.contains("RINGHT")) 
					positionX=150;
				System.out.println(positionX);
				gc.fill3DRect(830,1020,positionX+300,20,true);
			}
		}.start();
		stage.show();
	}
}