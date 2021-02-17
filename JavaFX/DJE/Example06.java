import java.util.ArrayList;
import java.util.Iterator;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Example06 extends Application{
	public double tx;
	public double ty;

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage){
		stage.setTitle("Example06");

		Group root=new Group();
		Scene scene=new Scene(root);
		stage.setScene(scene);

		Canvas canvas=new Canvas(1000,1000);
		root.getChildren().add(canvas);
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
		GraphicsContext gc=canvas.getGraphicsContext2D();

		Font theFont= Font.font("Helvetica",FontWeight.BOLD,24);
		gc.setFont(theFont);
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
		Image ii=new Image("space.png");
		Sprite briefcase=new Sprite();
		briefcase.setImage("O2.gif");

		ArrayList<Sprite>moneybagList=new ArrayList<Sprite>();
		int dots=2;
		for (int i=0;i<dots;i++){
			Sprite moneybag=new Sprite();
			
			moneybag.setImage("q.gif");
			double px=750*Math.random()+100;
			double py=750*Math.random()+105;

			// px=px*(stage.getWidth()/tx);
			// py=py*(stage.getHeight()/ty);

			moneybag.setPosition(px,py);
			moneybagList.add(moneybag);
		}
		LongValue lastNanoTime=new LongValue(System.nanoTime());
		IntValue score=new IntValue(0);
		new AnimationTimer(){
			public void handle(long currentNanoTime){
				double elapseTime=(currentNanoTime-lastNanoTime.value)/1000000000.0;
				lastNanoTime.value=currentNanoTime;	

				briefcase.setVelocity(0,0);
				if(input.contains("LEFT")||input.contains("A"))
					briefcase.addVelocity(-150,0);
				if(input.contains("RIGHT")||input.contains("D"))
					briefcase.addVelocity(150,0);
				if(input.contains("UP")||input.contains("W"))
					briefcase.addVelocity(0,-150);
				if(input.contains("DOWN")||input.contains("S"))
					briefcase.addVelocity(0,150);

				briefcase.update(elapseTime);
				Iterator<Sprite>moneybagIter=moneybagList.iterator();
				while(moneybagIter.hasNext()){
					Sprite moneybag=moneybagIter.next();
					if(briefcase.intersects(moneybag)){
						moneybagIter.remove();
						score.value++;
						moneybag.setImage("q.gif");
					}
				}
				double ppx=stage.getWidth()-16;
				double ppy=stage.getHeight()-39;
				// System.out.println(tx);
				briefcase.setXY(tx,ty);
				tx=ppx;ty=ppy;

				canvas.setWidth(ppx);canvas.setHeight(ppy);
				gc.clearRect(0,0,512,512);
				gc.drawImage(ii,0,0,ppx,ppy);
				briefcase.render(gc);
				for(Sprite moneybag:moneybagList)
					moneybag.render(gc);
				String pointsText=""+(100*score.value);
				gc.fillText(pointsText,360,36);
				gc.strokeText(pointsText,360,36);
			}
		}.start();
		stage.show();
	}
}