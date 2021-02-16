
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class Run extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	GraphicsContext g;
	@Override
	public void start(Stage stage) {
		Animators anm = new Animators();
		Scene scene = new Scene(anm, 1200,600);
		stage.setScene(scene);
		stage.show();
	}
}