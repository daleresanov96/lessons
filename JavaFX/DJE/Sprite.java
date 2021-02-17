import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;

public class Sprite{
    private Image image;
    private double positionX;
    private double positionY;    
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;
    public double tx,ty;

    public Sprite(){
        positionX = 0;
        positionY = 0;    
        velocityX = 0;
        velocityY = 0;
    }
    public void setXY(double ppx,double ppy){
        tx=ppx;ty=ppy;
        // System.out.println(tx+""+ty);
        // System.out.println(positionX);
    }

    public void setImage(Image i){
        image = i;
        width = i.getWidth();
        height = i.getHeight();

    }

    public void setImage(String filename){
        Image i = new Image(filename);
        setImage(i);
    }

    public void setPosition(double x, double y){
        positionX = x;
        positionY = y;
        // System.out.println(positionX);
    }

    public void setVelocity(double x, double y){
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y){
        velocityX += x;
        velocityY += y;
    }

    public void update(double time){
        double oo=150;double ox=tx-100;double oy=ty-100;
        double g=(positionX/tx);
        if(positionX>ox)velocityX-=oo;
        if(positionX<0)velocityX+=oo;
        if(positionY>oy)velocityY-=oo;
        if(positionY<0)velocityY+=oo;
        positionX += velocityX * time;
        positionY += velocityY * time; 
    }

    public void render(GraphicsContext gc){
        double g=positionX*(tx/positionX);
        System.out.println(g);
        // positionY=positionY*(1000/ty);
        gc.drawImage( image, positionX, positionY,100,100 );
    }

    public Rectangle2D getBoundary(){
        return new Rectangle2D(positionX,positionY,width,height);
    }

    public boolean intersects(Sprite s){
        return s.getBoundary().intersects( this.getBoundary() );
    }
    
    public String toString(){
        return "PX"+positionX + "PY" + positionY + "]"+"\r" 
        + "VX" + velocityX + "VY" + velocityY + "]"+"\r";
    }
}