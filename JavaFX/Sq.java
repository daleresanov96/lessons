
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class Sq extends Application {
    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        final Label label = new Label("-");
        final Button button = new Button("Hello World");
        button.setOnMouseClicked(ev -> heavyMethod(label));
        final VBox vbox = new VBox(button, label);
        final Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setWidth(200);
        stage.setTitle(getClass().getSimpleName());
        stage.show();
    }

    private void heavyMethod(Label label) {
        try {
            label.setText("begin: " + LocalDateTime.now());
            Thread.sleep(3000);
            label.setText("end: " + LocalDateTime.now());
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}