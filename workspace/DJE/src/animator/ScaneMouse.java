package animator;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ScaneMouse extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
//	public void start(Stage primaryStage) throws Exception {
//		Scene scene = new Scene(new Group(), 400, 300);
//		primaryStage.setScene(scene);
//		primaryStage.show();
//
//
//		//マウス操作を検出
//		scene.setOnMouseClicked(e -> System.out.println("マウスがクリックされました。"));
//		scene.setOnMouseDragged(e -> System.out.println("マウスがドラッグされました。"));
//		scene.setOnMousePressed(e -> System.out.println("マウスボタンが押し下げられました。"));
//		scene.setOnMouseReleased(e -> System.out.println("マウスボタンが離されました。"));
//		scene.setOnMouseMoved(e -> System.out.println("マウスが移動されました。"));
//	}
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new Group(), 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
 
 
		scene.setOnMouseClicked(this::mouseClicked);
	}
 
	//マウスクリックを検出
	private void mouseClicked(MouseEvent e) {
		System.out.println("X="+e.getX()+"::Y="+e.getY());
	}
}