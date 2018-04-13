
import java.awt.*;
import javax.swing.*;
import java.lang.Runnable;

/**
 * Class that creates two car objects that move across a frame
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 *
 */
public class Main extends JFrame{

	public Main() {

		Move move1 = new Move(10, 10, Color.PINK, 3);
		Move move2 = new Move(50, 100, Color.BLUE, 1);
		
		Thread thread1 = new Thread(move1);
		Thread thread2 = new Thread(move2);
		
		add(move1);
		add(move2);
		
		thread1.start();
		thread2.start();
		
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);

	}
	
	public static void main(String[] args) {
		Main cars = new Main();
	}
	
}
