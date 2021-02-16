import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;

public class BreakoutMain extends Application {
	private BreakoutThread breakoutthread;
	public static void main( String[] args ) {
		launch( args );
	}
	@Override
	public void start( Stage stage ) {
		stage.setTitle( "Breakout" );   
		Pane pane = new Pane();
		Scene scene = new Scene( pane );
		stage.setScene( scene );
		Canvas canvas = new Canvas( 640, 480 );
		GraphicsContext gc = canvas.getGraphicsContext2D();
		pane.getChildren().add( canvas );
		breakoutthread = new BreakoutThread( gc );
		breakoutthread.start();
		stage.show();
	}
}
class BreakoutThread extends AnimationTimer {
	private GraphicsContext gc;
	public BreakoutThread( GraphicsContext gc ){
		this.gc = gc;
	@Override
	public void handle( long time ) {
		gc.claerRect( 0, 0, 640, 480 );
		int ball_radius = 20;
		int ball_x = 0;
		int ball_y = 0;
		gc.setFill( Color.BLUE );
		gc.fillOval( ball_x, ball_y, 20, 20 );
	}
}