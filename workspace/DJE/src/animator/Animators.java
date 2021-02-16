package animator;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolatable;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.StringProperty;
import javafx.beans.value.WritableValue;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.shape.Circle;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

class Animators extends Group{
	public Animators() {
		Rectangle[] rect= {new Rectangle(275,275,50,50),new Rectangle(0,0,50,50),
				new Rectangle(0,0,600,600),new Rectangle(600,0,600,600)};


//		Rectangle rect01 = new Rectangle(275,275,50,50);
//		Rectangle rect02 = new Rectangle(0,0,50,50);
//		Rectangle rect03 = new Rectangle(0,0,600,600);
//		Rectangle rect04 = new Rectangle(600,0,600,600);
		Circle crc=new Circle(25,25,50);

		PathTransition anm00 = new PathTransition(Duration.seconds(2),null,crc);
			Path path = new Path();
			MoveTo move1 = new MoveTo();
			move1.setX(125);
			move1.setY(125);
			LineTo line1 = new LineTo();
			line1.setX(125);
			line1.setY(475);
			LineTo line2 = new LineTo();
			line2.setX(475);
			line2.setY(475);
			LineTo line3 = new LineTo();
			line3.setX(475);
			line3.setY(125);
			path.getElements().add(move1);
			path.getElements().add(line1);
			path.getElements().add(line2);
			path.getElements().add(line3);
			path.getElements().add(new ClosePath());
		anm00.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		anm00.setPath(path);

		TranslateTransition anm01 = new TranslateTransition(Duration.seconds(2),rect[1]);
		anm01.setFromX(0);anm01.setToX(525);
		anm01.setFromY(0);anm01.setToY(525);

		FillTransition anm02 = new FillTransition(Duration.seconds(2),rect[1]);
		anm02.setFromValue(Color.PURPLE);
		anm02.setToValue(Color.BLUE);

		ScaleTransition anm03 = new ScaleTransition(Duration.seconds(2),rect[1]);
		anm03.setFromX(1);anm03.setToX(2);
		anm03.setFromY(1);anm03.setToY(2);

		RotateTransition anm04 = new RotateTransition(Duration.seconds(2),rect[0]);
		anm04.setFromAngle(0);
		anm04.setToAngle(360);

		FadeTransition anm05 = new FadeTransition(Duration.seconds(2),crc);
		anm05.setFromValue(0);
		anm05.setToValue(1);

		StrokeTransition anm06 = new StrokeTransition(Duration.seconds(2),rect[0]);
		anm06.setFromValue(Color.RED);
		anm06.setToValue(Color.BLUE);

		// SequentialTransition(ikkozutsu)=ParallelTransition(zenbu)
		// SequentialTransition animation=new SequentialTransition(anm00,anm01,anm02,anm03,anm04,anm05,anm06);
		ParallelTransition animation = new ParallelTransition(anm00,anm01,anm02,anm03,anm04,anm05,anm06);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.setAutoReverse(true);
		animation.play();


		//				REPEAT				NO_CYCLE				REFLECT

		LinearGradient lg = new LinearGradient(0,0,300,300,false,CycleMethod.REPEAT
				, new Stop(1,Color.ORANGE)
				, new Stop(0,Color.VIOLET)
				,new Stop(0.5,Color.SILVER)
		);

		RadialGradient rg = new RadialGradient(90,200,900,325,300,false,CycleMethod.NO_CYCLE
				,new Stop(0,Color.BLUE)
				,new Stop(1,Color.RED)
				,new Stop(0.5,Color.ORANGE)
		);

		Text tx=new Text (650,50,"");
			String str="absdifgajklmnopqrstyuwxvz";
			AnimationString.Value asv=new AnimationString.Value(str);
			AnimationString as=new AnimationString(tx.textProperty());
			KeyValue kv=new KeyValue(as,asv);
			KeyFrame kf=new KeyFrame(Duration.seconds(2),kv);
			Timeline tml=new Timeline(kf);
			tml.setCycleCount(Animation.INDEFINITE);
			tml.setAutoReverse(true);
			tml.play();

		rect[3].setFill(rg);
		rect[2].setFill(lg);
		rect[0].setFill(null);
		getChildren().add(rect[2]);
		getChildren().add(rect[3]);
		getChildren().add(rect[0]);
		getChildren().add(rect[1]);
		getChildren().add(crc);
		getChildren().add(tx);

	}
}
class AnimationString implements WritableValue<AnimationString.Value>{
	private StringProperty prop;
	private Value value;
	public AnimationString(StringProperty prop) {
		this.prop=prop;
		value=new Value(prop.getValue());
	}
	@Override
	public Value getValue() {
		return value;
	}
	@Override
	public void setValue(Value value) {
		prop.setValue(value.tx);
		this.value=value;
	}
	static class Value implements Interpolatable<Value>{
		private String tx;
		public Value(String tx) {
			this.tx=tx;
		}
		@Override
		public Value  interpolate (Value endValue,double t) {
		String s=endValue.tx;
		int len=s.length()+1;
		int result=Math.min(s.length(),(int)(t*len));
		if (result !=tx.length()) {
			return new Value(s.substring(0,result));
		}return this;
				}}
}
