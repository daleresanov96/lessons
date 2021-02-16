import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;

public class Balltest extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage){
		stage.setTitle("ballTest");
		Pane pane=new Pane();
		Scene scene=new Scene(pane);
		stage.setScene(scene);
		Canvas canvas=new Canvas(1280,960);
		GraphicsContext gc=canvas.getGraphicsContext2D();
		pane.getChildren().add(canvas);
		breakoutThread=new BreakoutThread(gc);
		breakouttThread.start();
		stage.show();
	}
	public  BreakoutThread(GraphicsContext gc){
		this.gc=gc;
		ball=new Ball();
	}
	@Override
	public void handle(long time){
		gc.clearRect(0,0,1280,960);
		ball.draw(gc);
	}
}
class Ball{
	private double x;
	private double y;
	public Ball(){
		this.x=20;
		this.y=20;
	}
	public void draw(GraphicsContext gc){
		gc.setFill(Color.RED);
		gc.fillOval(x,y,20,20);
	}
}