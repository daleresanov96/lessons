import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Example03 extends Application{
	public static void main(String[]args){
		launch(args);
	}
	@Override
	public void start(Stage stage){
		stage.setTitle("Example03");

		Group root=new Group();
		Scene scene=new Scene(root);
		stage.setScene(scene);

		Canvas canvas=new Canvas(512,512);
		root.getChildren().add(canvas);

		GraphicsContext gc=canvas.getGraphicsContext2D();

		Image earth=new Image("earth.png");
		Image sun=new Image("sun.png");
		Image space=new Image("space.png");
	

		final long startNanoTime=System.nanoTime();

		new AnimationTimer(){
			public void handle(long currentNanoTime){
				double t=(currentNanoTime-startNanoTime)/1000000000.0;

				double x=232+200*Math.cos(t);
				double y=232+200*Math.sin(t);

				gc.drawImage(space,0,0);
				gc.drawImage(earth,x,y);
				gc.drawImage(sun,196,196);
			}
		}.start();
		stage.show();
	}
}