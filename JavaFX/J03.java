import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class J03{
	public static void main(String[] args) {
		GameWindow gw = new GameWindow("a",400,300);
		gw.setVisible(true);
		gw.change(new DrawCanvas());
		gw.startGameLoop();
	}
}
class GameWindow extends JFrame implements Runnable{
	private Thread th = null;
	private double sleepAddTime;
	private int fps=60;
	public GameWindow(String title, int width, int height) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width,height);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setFps(fps);
	}
	public synchronized void change(JPanel p) {
		getContentPane().removeAll();
		Insets inset = getInsets();
		p.setBounds(-inset.left,-inset.top,getWidth(),getHeight());
		add(p);
		validate();
		repaint();
	}
	public synchronized void startGameLoop(){
		if ( th == null ) {
			th = new Thread(this);
			th.start();
		}
	}
	public synchronized void stopGameLoop(){
		if ( th != null ) {
			th = null;
		}
	}
	public void run(){
		double nextTime = System.currentTimeMillis() + sleepAddTime;
		while(th != null){
			try{
				long res = (long)nextTime - System.currentTimeMillis();
				if ( res < 0 ) res = 0;
				Thread.sleep(res);
				repaint();
				nextTime += sleepAddTime;
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public void setFps(int fps){
		if ( fps < 10 || fps > 60 ) {
			throw new IllegalArgumentException("b");
		}
		this.fps = fps;
		sleepAddTime = 1000.0 / fps;
	}
}
class DrawCanvas extends JPanel{
 
	int cx=200,cy=150;
 

	int[] angle = new int[5];
	DrawCanvas() {
		
		for ( int i = 0;i < angle.length;i++ ) {
			angle[i] = i * 40;
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
 
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 300);
 
		g.setColor(Color.BLACK);
		g.fillOval(cx-5, cy-10, 10, 10);
 
		g.setColor(Color.ORANGE);
 

		int distance = 100;
 
		for ( int i = 0;i < angle.length;i++ ) {
		
			angle[i]++;
 
			
			double rad = Math.toRadians(angle[i]);
 
			int rx = (int)(Math.cos(rad) * distance) + cx;
 
			
			int ry = (int)(Math.sin(rad) * distance) + cy;
 
			g.fillOval(rx-10, ry-10, 20, 20);
		}
	}
}