import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

public class Test2 extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start (Stage stage)throws Exception{
		String[] msg={"Hello","Java","Ok"};
		// Label h01 = new Label(msg[0]+msg[1]);
		TextField f=new TextField();
		Label h01=new Label (msg[1]);
		Label h02=new Label (msg[0]);
		Button b1=new Button(msg[2]);
			b1.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e){
					// String m=f.getText();
					// h01.setText(msg[1]+m);
					int i=0;
					if (i%2==0) {
						h01.setText(msg[0]);
					}else{
						h01.setText(msg[1]);
					}
					i++;
				}
			});
		CheckBox cb=new CheckBox("SS");
		BorderPane pn = new BorderPane();
		pn.setRight(h01);
		pn.setLeft(h02);
		pn.setCenter(cb);
		pn.setBottom(b1);
		Scene sn = new Scene(pn,400,300);
		stage.setScene(sn);
		stage.show();

	}
}