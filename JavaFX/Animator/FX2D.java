
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

	public class FX2D extends Application {

		public static void main(final String... args) {
			launch(args);
		}

		GraphicsContext g;

		@Override
		public void start(final Stage stage) {
			Group root = new Group();


			Canvas cvs = new Canvas(600,600);
			root.getChildren().add(cvs);

			this.g = cvs.getGraphicsContext2D();
			Scene scene = new Scene(root,600,600, Color.WHITE);
			stage.setScene(scene);
			stage.show();

			draw();
		}

		private void draw() {

			g.setFill(Color.BLUE);
			g.strokeLine(50, 100, 350, 200);

			g.setStroke(Color.RED);
			g.strokePolyline(new double[] {50,100,350},
				new double[] {150,200,150}, 3);

			g.setStroke(Color.RED);	g.strokeRect(250, 250, 100, 100);
			g.setFill(Color.RED);	g.fillRect(50, 250, 100, 100);

			g.setStroke(Color.RED);	g.strokeOval(250, 350, 100, 100);
			g.setFill(Color.RED);	g.fillOval(50, 350, 100, 100);

			g.setFill(Color.RED);
			g.fillPolygon(new double[] {50,150,100},
					new double[] {550,550,450}, 3);
			g.setStroke(Color.RED);
			g.strokePolygon(new double[] {250,350,300},
				new double[] {550,550,450}, 3);

			g.setFont(new Font(50));
			g.setStroke(Color.RED);
			g.strokeText("TEST",250,600);
			g.setFill(Color.RED);
			g.fillText("TEST",50,600);

			g.setLineDashes(3);
			g.strokeLine(350, 50, 550, 250);

			g.setLineWidth(7);
			g.strokeLine(350, 80, 550, 280);

		}
	}