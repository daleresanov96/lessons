package animator;
import java.io.File;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dvijok02 extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	//閾ｪ繧ｭ繝｣繝ｩ繧ｪ繝悶ず繧ｧ繧ｯ繝�
	ImageView chara = new ImageView(new File("C:\\Users\\200023\\Desktop\\workspace\\DJE\\src\\animator\\nono.gif").toURI().toString());

	//譛ｨ縺ｮ逕ｻ蜒�
	Image ki = new Image(new File("C:\\\\Users\\\\200023\\\\Desktop\\\\workspace\\\\DJE\\\\src\\\\animator\\\\ki.png").toURI().toString());

	//闕峨�ｮ逕ｻ蜒�
	Image kusa = new Image(new File("C:\\\\Users\\\\200023\\\\Desktop\\\\workspace\\\\DJE\\\\src\\\\animator\\\\kusa.png").toURI().toString());

	//闕�2縺ｮ逕ｻ蜒�
	Image kusa2 = new Image(new File("C:\\\\Users\\\\200023\\\\Desktop\\\\workspace\\\\DJE\\\\src\\\\animator\\\\kusa2.png").toURI().toString());

	//螻ｱ縺ｮ逕ｻ蜒�
	Image yama = new Image(new File("C:\\\\Users\\\\200023\\\\Desktop\\\\workspace\\\\DJE\\\\src\\\\animator\\\\yama.png").toURI().toString());

	//遨ｺ縺ｮ逕ｻ蜒�
	Image sora = new Image(new File("C:\\\\Users\\\\200023\\\\Desktop\\\\workspace\\\\DJE\\\\src\\\\animator\\\\sora.png").toURI().toString());

	//蝨ｰ髱｢縺ｮ逕ｻ蜒�
	Image jimen = new Image(new File("C:\\\\Users\\\\200023\\\\Desktop\\\\workspace\\\\DJE\\\\src\\\\animator\\\\jimen.png").toURI().toString());

	//繧ｫ繝｡繝ｩ繧ｪ繝悶ず繧ｧ繧ｯ繝�
	Camera camera = new PerspectiveCamera();

	//繧ｭ繝ｼ繝輔Λ繧ｰ
	boolean isLeft;
	boolean isRight;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group p = new Group();
		Scene scene = new Scene(p, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

		//繧ｫ繝｡繝ｩ縺ｮ險ｭ鄂ｮ
		scene.setCamera(camera);


		//遨ｺ縺ｮ繧ｻ繝�繝�繧｣繝ｳ繧ｰ(讓ｪ縺ｫ繧ｪ繝悶ず繧ｧ繧ｯ繝医ｒ5縺､荳ｦ縺ｹ繧�)
		for ( int i = 0;i < 5;i++ ) {
			ImageView img = new ImageView(sora);
			img.setTranslateX(i*1600-1000);
			img.setTranslateZ(1600);
			img.setTranslateY(-450);
			p.getChildren().add(img);
		}

		//螻ｱ縺ｮ繧ｻ繝�繝�繧｣繝ｳ繧ｰ(讓ｪ縺ｫ繧ｪ繝悶ず繧ｧ繧ｯ繝医ｒ5縺､荳ｦ縺ｹ繧�)
		for ( int i = 0;i < 5;i++ ) {
			ImageView img = new ImageView(yama);
			img.setTranslateX(i*600);
			img.setTranslateZ(600);
			img.setTranslateY(0);
			p.getChildren().add(img);
		}

		//譛ｨ縺ｮ繧ｻ繝�繝�繧｣繝ｳ繧ｰ(讓ｪ縺ｫ繧ｪ繝悶ず繧ｧ繧ｯ繝医ｒ5縺､荳ｦ縺ｹ繧�)
		for ( int i = 0;i < 5;i++ ) {
			ImageView img = new ImageView(ki);
			img.setTranslateX(i*600);
			img.setTranslateZ(200);
			img.setTranslateY(80);
			p.getChildren().add(img);
		}

		//蝨ｰ髱｢縺ｮ繧ｻ繝�繝�繧｣繝ｳ繧ｰ(讓ｪ縺ｫ繧ｪ繝悶ず繧ｧ繧ｯ繝医ｒ100蛟倶ｸｦ縺ｹ繧�)
		for ( int i = 0;i < 100;i++ ) {
			ImageView img = new ImageView(jimen);
			img.setTranslateX(i*50);
			img.setTranslateY(260);
			p.getChildren().add(img);
		}

		//闕峨�ｮ繧ｻ繝�繝�繧｣繝ｳ繧ｰ繝ｩ繝ｳ繝�繝�縺ｫ驟咲ｽｮ(讓ｪ縺ｫ繧ｪ繝悶ず繧ｧ繧ｯ繝医ｒ100蛟倶ｸｦ縺ｹ繧�)
		Random rand = new Random();
		for ( int i = 0;i < 100;i++ ) {
			ImageView img = null;
			int r = rand.nextInt(2);
			if ( r == 0 ) {
				img = new ImageView(kusa);
			} else if ( r == 1 ) {
				img = new ImageView(kusa2);
			} else {
				//菴輔ｂ驟咲ｽｮ縺励↑縺�
				continue;
			}
			img.setTranslateX(i*50);
			img.setTranslateY(210);
			p.getChildren().add(img);
		}

		//繧ｭ繝｣繝ｩ縺ｮ繧ｻ繝�繝�繧｣繝ｳ繧ｰ
		chara.setX(100);
		chara.setY(205);
		chara.setScaleX(-1);//逕ｻ蜒丞渚霆｢
		p.getChildren().add(chara);

		//謫堺ｽ懆ｪｬ譏弱�ｮ繧ｪ繝悶ず繧ｧ繧ｯ繝医ｒ驟咲ｽｮ縺励※縺翫￥
		Rectangle rect = new Rectangle(50,0,100,50);
		Text text = new Text(50, 30, "Button < >");
		text.setFont(new Font(20));
		text.setStroke(null);
		text.setFill(Color.WHITE);
		p.getChildren().add(rect);
		p.getChildren().add(text);


		//繧ｭ繝ｼ繧､繝吶Φ繝医�ｮ逋ｻ骭ｲ
		scene.setOnKeyPressed(this::keyPressed);
		scene.setOnKeyReleased(this::keyReleased);

		//繧ｲ繝ｼ繝�繝ｫ繝ｼ繝励�ｮ襍ｷ蜍�
		new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				gameLoop();
			}
		}.start();
	}

	//繧ｲ繝ｼ繝�繝ｫ繝ｼ繝暦ｼ磯�壼ｸｸ60fps縺ｧ蜻ｼ縺ｳ蜃ｺ縺輔ｌ繧具ｼ�
	private void gameLoop() {
		//繧ｭ繝｣繝ｩ遘ｻ蜍�
		charaMove();

		//繧ｫ繝｡繝ｩ縺ｮ遘ｻ蜍�
		cameraMove();
	}

	//繧ｭ繝｣繝ｩ遘ｻ蜍募�ｦ逅�
	private void charaMove() {
		//蜿ｳ蛛ｴ縺ｫ遘ｻ蜍輔＆縺帙ｋ
		if(isLeft) {
			chara.setX(chara.getX()-2);
		}
		if(isRight) {
			chara.setX(chara.getX()+2);
		}
	}

	//繧ｫ繝｡繝ｩ遘ｻ蜍募�ｦ逅�
	private void cameraMove() {
//		if ( isLeft ) {
			//繧ｫ繝｡繝ｩ繧貞ｷｦ縺ｫ遘ｻ蜍�
//			camera.setTranslateX(camera.getTranslateX()-2);
//		}
//		if ( isRight ) {
			//繧ｫ繝｡繝ｩ繧貞承縺ｫ遘ｻ蜍�
			camera.setTranslateX(camera.getTranslateX()+1.50);
//		}
	}

	//繧ｭ繝ｼ謚ｼ縺嶺ｸ九￡繧､繝吶Φ繝�
	private void keyPressed(KeyEvent e) {
		//荳贋ｸ句ｷｦ蜿ｳ繧ｭ繝ｼ繧呈款縺励◆譎ゅヵ繝ｩ繧ｰ繧丹N縺ｫ縺吶ｋ縲�
		switch(e.getCode()) {
		case LEFT:
			isLeft = true;
			break;
		case RIGHT:
			isRight = true;
			break;
		default:
			break;
		}
	}

	//繧ｭ繝ｼ繧帝屬縺励◆譎ゅ�ｮ繧､繝吶Φ繝�
	private void keyReleased(KeyEvent e) {
		//荳贋ｸ句ｷｦ蜿ｳ繧ｭ繝ｼ繧帝屬縺励◆譎ゅヵ繝ｩ繧ｰ繧丹FF縺ｫ縺吶ｋ縲�
		switch(e.getCode()) {
		case LEFT:
			isLeft = false;
			break;
		case RIGHT:
			isRight = false;
			break;
		default:
			break;
		}
	}
}