package animator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Dvijok extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane p = new Pane();
		Scene scene = new Scene(p, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();


		//今どこにいるか表示(横に文字キャンバスを5つ並べる)
		for ( int i = 0;i < 5;i++ ) {
			//Text t = new Text("ここのX座標は"+i * 200+"です");
			Canvas c = new Canvas(400,300);
			c.setTranslateX(i*400);
			c.setTranslateY(0);
			GraphicsContext g = c.getGraphicsContext2D();
			g.setFont(new Font(20));
			if ( i%2==0 ) {
				g.setFill(Color.BLACK);
				g.fillRect(0,0,400,300);
				g.setFill(Color.WHITE);
				g.fillText("ここのX座標は"+ (i * 400 + 200) +"です", 100, 100);
			} else {
				g.setFill(Color.WHITE);
				g.fillRect(0,0,400,300);
				g.setFill(Color.BLACK);
				g.fillText("ここのX座標は"+ (i * 400 + 200) +"です", 100, 100);
			}
			g.setStroke(Color.RED);
			g.setLineWidth(5);
			g.strokeLine(200, 0, 200, 300);
			p.getChildren().add(c);
		}

		//カメラの設置
		PerspectiveCamera camera = new PerspectiveCamera();
		scene.setCamera(camera);

		//カメラのX座標を2000まで移動させるアニメーション
		TranslateTransition moveAnimation = new TranslateTransition(Duration.seconds(8), camera);
		moveAnimation.setFromX(0);
		moveAnimation.setToX(2000);
		moveAnimation.play();
	}
}
