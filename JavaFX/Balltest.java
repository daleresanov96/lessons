

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

public class Balltest extends Application{
	public double px;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage){
		Key key=new Key();
		stage.setTitle("ballTest");
		Pane pane=new Pane();
		Scene scene=new Scene(pane);
		stage.setScene(scene);
		scene.setOnKeyPressed(
		new EventHandler<KeyEvent>() {
			public void handle( KeyEvent e ) {
			key.keyPressed( e );
			}
		});

		Canvas canvas=new Canvas(1280,960);
		GraphicsContext gc=canvas.getGraphicsContext2D();
		pane.getChildren().add(canvas);

		BreakoutThread breakoutthread=new BreakoutThread(gc);
		breakoutthread.start();

		stage.show();
	}
}
class BreakoutThread extends AnimationTimer{
	private GraphicsContext gc;
	private Ball ball;
	public  BreakoutThread(GraphicsContext gc){
		this.gc=gc;
		ball=new Ball();
	}
	@Override
	public void handle(long time){
		gc.clearRect(0,0,1280,960);
		Ball ball2=new Ball();
		ball.draw(gc);
		ball.move();
	}
}
class Ball{
	private double x;
	private double y;
	private double xs;
	private double ys;
	private double xx=565;
	private double yy=920;
	private Key key;
	public Ball(){
		this.x=20;this.y=20;
		this.xs=20;this.ys=20;
	}
	public void setPosition(double px){
		xx+=px;
	}

	public void draw(GraphicsContext gc){
		gc.setFill(Color.RED);
		gc.fillOval(x,y,20,20);
		gc.setFill(Color.BLUE);
		gc.fillRect(xx,yy,150,30);
	}
	public void move(){
		key=new Key();
		key.keyPressed();
		this.x+=this.xs;this.y+=this.ys;
		if(x>=1280)xs=-20;
		if(y>=960)ys=-20;
		if(x<=0)xs=20;
		if(y<=0)ys=20;
		System.out.println(left);
	}
}
class Key {
	private boolean left;
	private boolean right;
	public void keyPressed( KeyEvent e ) {
		switch( e.getCode() ) {
			case LEFT:
			System.out.println( "LEFT pressed." );
			left=true;
			break;
			case RIGHT:
			System.out.println( "RIGHT pressed." );
			right=true;
			break;
			default:
			break;
		}return;
	}
}