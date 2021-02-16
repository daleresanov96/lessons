dimport javafx.geometry.Point2D;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Example05 extends Application{
	public static void main(String[]args){
		launch(args);	
	}
	@Override
	public void start(Stage stage){
		stage.setTitle("Example05");

		Group root=new Group();
		Scene scene=new Scene(root);
		stage.setScene(scene);

		Canvas canvas=new Canvas(500,500);
		root.getChildren().add(canvas);

		Circle targetData=new Circle(100,100,32);
		IntValue points=new IntValue(0);
		
		scene.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				if (targetData.containsPoint(e.getX(),e.getY())){
					double x=50+400*Math.random();
					double y=50+400*Math.random();
					targetData.setCenter(x,y);
					points.value++;
				}
			}
		});
		GraphicsContext gc=canvas.getGraphicsContext2D();

		Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
		gc.setFont( theFont );
		gc.setStroke( Color.BLACK );
		gc.setLineWidth(1);
		Image bullseye=new Image("bullseye.png");
		new AnimationTimer(){
			public void handle(long currentNanoTimer){
				gc.setFill(new Color(0.85,0.85,1.0,1.0));
				gc.fillRect(0,0,512,512);
				
				gc.drawImage(bullseye,targetData.getX()-targetData.getRadius(),
					targetData.getY()-targetData.getRadius());
				gc.setFill(Color.RED);
				String pointsText="Points"+points.value;
				gc.fillText(pointsText,360,36);
				gc.strokeText(pointsText,360,36);
			}
		}.start();
		stage.show();
	}
	public class IntValue{
		public int value;
		public IntValue(int i){
			value = i;
		}
	}

	public class Circle
	{
		private Point2D center;
		private double  radius;

		public Circle(double x, double y, double r){
			setCenter(x,y);
			setRadius(r);
		}
		public void setCenter(double x, double y){
			center = new Point2D(x,y);
		}
		public void setRadius(double r){
			radius = r;
		}
		public double getX(){
			return center.getX();
		}
		public double getY(){
			return center.getY();
		}
		public double getRadius(){
			return radius;
		}
		public boolean containsPoint(double x, double y){
			return (center.distance(x,y) < radius);
		}
	}
}
