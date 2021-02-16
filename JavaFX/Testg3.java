import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Testg3 extends Application{
	private BreakoutThread breakoutthread;
	private Key key;

	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage stage){
		stage.setTitle("Testg3");
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		Canvas canvas = new Canvas(640,480);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		pane.getChildren().add(canvas);

		key = new Key();

		scene.setOnKeyPressed(
			new EventHandler<KeyEvent>(){
				public void handle(KeyEvent e){
					key.key_pressed(e);
				}
			}
		);

		scene.setOnKeyReleased(
			new EventHandler<KeyEvent>(){
				public void handle(KeyEvent e){
					key.key_released(e);
				}
			}
		);

		breakoutthread = new BreakoutThread(gc,key);
		breakoutthread.start();

		stage.show();
	}
}

class BreakoutThread extends AnimationTimer{
	private GraphicsContext gc;
	private Key key;
	private Ball ball;
	private Bar bar;
	private Field field;
	private CollisionDetection cd;
	private GameOver gameover;
	private int game_state;

	BreakoutThread(GraphicsContext gc,Key key){
		this.gc = gc;
		this.key = key;
		Font theFont = Font.font("Serif",FontWeight.BOLD,20);
		gc.setFont(theFont);
		ball = new Ball();
		field = new Field();
		gameover = new GameOver();
		bar = new Bar(field,key);
		cd = new CollisionDetection(this,ball,bar,field);
		game_state = 0;
	}

	@Override
	public void handle(long time){
		gc.clearRect(0,0,640,480);
		key.calc_key_count();

		switch(game_state){
		case 0:
			game_state = 5;
			break;
		case 5:
			ball.move();
			bar.move();
			cd.move();
			ball.draw(gc);
			bar.draw(gc);
			field.draw(gc);
			break;
		case 10:
			bar.draw(gc);
			field.draw(gc);
			gameover.draw(gc);
			break;
		default:
			break;
		}
	}

	void set_game_state(int game_state){
		this.game_state = game_state;
	}
}

abstract class Base{
	protected int width,height;
	protected int x,y;
	protected int x_speed;
	protected int y_speed;
	
	Base(){
		width = 0;
		height = 0;
		x = 0;
		y = 0;
		x_speed = 0;
		y_speed = 0;
	}

	int get_width(){
		return width;
	}

	int get_height(){
		return height;
	}

	void set_x(int x){
		this.x = x;
	}

	void set_y(int y){
		this.y = y;
	}

	int get_x(){
		return x;
	}

	int get_y(){
		return y;
	}

	abstract void init();
	abstract void move();
	abstract void draw(GraphicsContext gc);	
}

class Define{
	private Define(){}
	public static final int BALL_R = 5;
	public static final int BALL_SPEED = 5;
	public static final int BAR_SPEED = 5;
	public static final int BAR_WIDTH = 50;
	public static final int BAR_HEIGHT = 10;
	public static final int FIELD_WIDTH = 300;
	public static final int FIELD_HEIGHT = 480;
	public static final int BALL_FIRST_X = BAR_WIDTH / 2;
	public static final int BALL_FIRST_Y = FIELD_HEIGHT - (BAR_HEIGHT + BALL_R);
	public static final int BAR_FIRST_X = 0;
	public static final int BAR_FIRST_Y = FIELD_HEIGHT - BAR_HEIGHT;
	public static final int X_POSI = 170;
}

class Ball extends Base{
	private int r;

	Ball(){
		r = Define.BALL_R;
		x = Define.BALL_FIRST_X;
		y = Define.BALL_FIRST_Y;
		x_speed = Define.BALL_SPEED;
		y_speed = Define.BALL_SPEED;
	}

	void init(){}

	int get_r(){
		return r;
	}

	void ch_x_speed(){
		x_speed *= -1;
	}
	
	void ch_y_speed(){
		y_speed *= -1;
	}

	void move(){
		x += x_speed;
		y += y_speed;
	}

	void draw(GraphicsContext gc){
		gc.setStroke(Color.BLACK);
		gc.strokeOval(Define.X_POSI + x - r,y - r,
			r * 2,r * 2);
	}
}

class Bar extends Base{
	private Field field;
	private Key key;

	Bar(Field field,Key key){
		this.field = field;
		this.key = key;
		width = Define.BAR_WIDTH;
		height = Define.BAR_HEIGHT;
		x = Define.BAR_FIRST_X;
		y = Define.BAR_FIRST_Y;
		x_speed = Define.BAR_SPEED;
	}

	void init(){}

	void move(){
		if(key.get_right() > 0 && (x + width) < field.get_width()){
			x += x_speed;
		}
		if(key.get_left() > 0 && x > 0){
			x -= x_speed;
		}
	}

	void draw(GraphicsContext gc){
		gc.setFill(Color.RED);
		gc.fillRect(Define.X_POSI + x,y,width,height);
	} 
}

class Field extends Base{
	Field(){
		width = Define.FIELD_WIDTH;
		height = Define.FIELD_HEIGHT;
	}

	void init(){}
	void move(){}

	void draw(GraphicsContext gc){
		gc.setStroke(Color.BLACK);
		gc.strokeRect(Define.X_POSI + 0,0,width,height);
	} 
}

class CollisionDetection{
	private BreakoutThread breakoutthread;
	private Ball ball;
	private Bar bar;
	private Field field;

	CollisionDetection(BreakoutThread breakoutthread,Ball ball,Bar bar,Field field){
		this.breakoutthread = breakoutthread;
		this.ball = ball;
		this.bar = bar;
		this.field = field;
	}

	void move(){
		if(ball.get_x() >= field.get_width()){
			ball.set_x(field.get_width() - ball.get_r());
			ball.ch_x_speed();
		}
		if(ball.get_x() <= 0){
			ball.set_x(ball.get_r());
			ball.ch_x_speed();
		}
		if(ball.get_y() <= 0){
			ball.set_y(ball.get_r());
			ball.ch_y_speed();
		}
		if(ball.get_y() >= field.get_height()){
			breakoutthread.set_game_state(10);
		}
		if (ball.get_x() > bar.get_x() && ball.get_x() < (bar.get_x() + bar.get_width()) &&
			 ball.get_y() >= bar.get_y()){
			ball.set_y(ball.get_y() - ball.get_r());
			ball.ch_y_speed();
		}
	}
}

class GameOver{
	GameOver(){}

	void draw(GraphicsContext gc){
		gc.setFill(Color.BLACK);
		gc.fillText("GAME OVER",255,240);
	}
}

class Key{
	private boolean left,right;
	private int left_count,right_count;

	void key_pressed(KeyEvent e){
		switch(e.getCode()){
		case LEFT:
			left = true;
			break;
		case RIGHT:
			right = true;
			break;
		default:
			break;
		}
	}

	void key_released(KeyEvent e){
		switch(e.getCode()){
		case LEFT:
			left = false;
			break;
		case RIGHT:
			right = false;
			break;
		default:
			break;
		}
	}
	
	void calc_key_count(){
		if(left)left_count++;
		else left_count = 0;

		if(right)right_count++;
		else right_count = 0;
	}

	int get_left(){
		return left_count;
	}
	int get_right(){
		return right_count;
	}
}