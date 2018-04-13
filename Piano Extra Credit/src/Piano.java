import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Piano extends JComponent implements MouseListener {
	final int NUMBER_OF_WHITE_KEYS = 7;
	final int NUMBER_OF_KEYS = 12;
	final int WIDTH = 72;
	JPanel panel = new JPanel();
	
	Color[] colors = {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
			Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
			Color.BLACK};

	public void paintComponent(Graphics g){
		
		//Draws the white keys of the piano
		for (int i = 0; i < NUMBER_OF_WHITE_KEYS; i++){
			g.setColor(Color.BLACK);
			g.drawRect(WIDTH * i, 0, WIDTH, getHeight() - 1);
			g.setColor(colors[i]);
			g.fillRect(WIDTH * i + 1, 1, WIDTH - 2, getHeight() - 2);
		}
		
		//Draws the black keys of the piano
		int keyCounter = NUMBER_OF_WHITE_KEYS;
		for (int i = 0; i < NUMBER_OF_WHITE_KEYS; i++){
			if (i != 2 && i != NUMBER_OF_WHITE_KEYS - 1){
				g.setColor(colors[keyCounter]);
				g.fillRect((WIDTH * i) + ((WIDTH / 4) * 3), 0, WIDTH / 2, (getHeight() / 3) * 2);
				keyCounter++;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		double x = e.getPoint().getX();
		double y = e.getPoint().getY();
		
		System.out.println(x + " " + y);
		int keyNumber = (int) x / WIDTH;
		colors[keyNumber] = Color.GRAY;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
