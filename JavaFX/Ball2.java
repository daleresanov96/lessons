import java.util.ArrayList;
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

public class Ball2 extends Application{
	private Ball ball;
	private Key key;
	private Bt bt;
	public boolean left;
	public boolean right;
	public static void main(String[]args){
		launch(args);
	}
	@Override
	public void start(Stage stage){
		ball=new Ball();
		key=new Key();
		Pane pane=new Pane();
		Scene scene=new Scene(pane);
		stage.setScene(scene);

		ArrayList<String>input=new ArrayList<String>();

		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				String code=e.getCode().toString();
				if(!input.contains(code))input.add(code);
			}
		});
		scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				String code=e.getCode().toString();
				input.remove(code);
			}
		});
		key.keyPressed(input);
		Canvas canvas=new Canvas(1280,960);
		GraphicsContext gc=canvas.getGraphicsContext2D();
		pane.getChildren().add(canvas);
		bt=new Bt(gc);
		bt.start();
		stage.show();
	}
}
class Bt extends AnimationTimer{
	private GraphicsContext gc;
	private Ball ball;
	public Bt(GraphicsContext gc){
		this.gc=gc;
		ball=new Ball();
	}
	@Override
	public void handle(long time){
		gc.clearRect(0,0,1280,960);
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
		xx=px;
		System.out.println(px);
	}

	public void draw(GraphicsContext gc){
		gc.setFill(Color.RED);
		gc.fillOval(x,y,20,20);
		gc.setFill(Color.BLUE);
		gc.fillRect(xx,yy,150,30);
	}
	public void move(){
		this.x+=this.xs;this.y+=this.ys;
		if(x>=1280)xs=-20;
		if(y>=960)ys=-20;
		if(x<=0)xs=20;
		if(y<=0)ys=20;
	}
}
class Key {
	private boolean left;
	private boolean right;
	private Ball ball;
	public void keyPressed(ArrayList input) {
		ball=new Ball();
		if(input.contains("LEFT")||input.contains("A"))
			ball.setPosition(-20);
		if(input.contains("RIGHT")||input.contains("D"))
			ball.setPosition(20);
	}
}