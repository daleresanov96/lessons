package animator;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextExample extends Application {
   @Override
   public void start(Stage stage) {
      //Creating a Text object
      Text text = new Text();
      text.setFont(Font.font("Verdana",50));

      //Setting the text to be added.
      text.setText("Hello how are you");

      //setting the position of the text
      text.setX(50);
      text.setY(50);

      TranslateTransition anm01 = new TranslateTransition(Duration.seconds(2),text);
		anm01.setFromX(0);anm01.setToX(525);
		anm01.setFromY(0);anm01.setToY(525);
		anm01.setCycleCount(Animation.INDEFINITE);
		anm01.setAutoReverse(true);
		anm01.play();


      //Creating a Group object
      Group root = new Group(text);

      //Creating a scene object
      Scene scene = new Scene(root, 1200, 600);

      //Setting title to the Stage
      stage.setTitle("Sample Application");

      //Adding scene to the stage
      stage.setScene(scene);

      //Displaying the contents of the stage
      stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}