import java.awt.*;
import javax.swing.*;

public class MainPiano extends JFrame {
	
	public MainPiano(){
		Piano p = new Piano();
		add(p);
		
		setSize(504, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		MainPiano play = new MainPiano();

	}

}
