package newi;

import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

public class CollorAfina extends Application {
	public static void main(String[]args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) {
		View v=new View();
		Scene scene=new Scene(v,400,300);
		stage.setScene(scene);
		stage.show();
	}
}
class View extends Group{
	public View() {
		Canvas cvs=new Canvas(400,300);
		getChildren().add(cvs);
		GraphicsContext g=cvs.getGraphicsContext2D();
		AnimationTimer timer=new AnimationTimer() {
			double angle=0;
			double hue=-1;
			@Override
			public void handle(long now){
				g.clearRect(0,0,400,300);
				Affine af=new Affine();
				af.appendRotation(angle,200,150);
				g.setTransform(af);
				g.setFill(Color.BLUE);
				g.fillRect(100,100,200,100);
				ColorAdjust ca=new ColorAdjust();
				ca.setHue(hue);
				Bloom b=new Bloom(0);
				b.setInput(ca);
				g.applyEffect(b);
				angle++;
				hue+=0.01;
				if(hue>1.0)hue=-1.0;
			}
		};
		timer.start();
	}
}
