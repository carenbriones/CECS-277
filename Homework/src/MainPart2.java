import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Has two buttons, labeled "A" and "B", and returns how many times each button
 * has been pressed.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class MainPart2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		//Creates the two buttons
		JButton button1 = new JButton("A");
		JButton button2 = new JButton("B");
		
		final JLabel label = new JLabel();
		
		/**
		 * Creates an ActionListener to display a message each time a button is clicked
		 */
		class Clicker implements ActionListener{
			String name;
			int counter;
			
			/**
			 * Creates a Clicker object with counts starting at 0 and takes in a name
			 * for the button as a parameter
			 * @param n name of the button
			 */
			public Clicker (String n){
				name = n;
				counter = 0;
			}
			
			/**
			 * Increments the counter and displays a message each time a button is clicked.
			 */
			public void actionPerformed(ActionEvent event){
				counter++;
				label.setText(name + " was clicked " + counter + " time(s).");
			}
		}
		
		//Creates a panel, places buttons in panel, places panel in frame
		JPanel panel = new JPanel();
		panel.add(label);
		label.setVisible(true);
		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
		
		//Adds action listener to each button
		ActionListener listener1 = new Clicker("A");
		ActionListener listener2 = new Clicker("B");
		button1.addActionListener(listener1);
		button2.addActionListener(listener2);
		
		//Display of the frame
		int width = 500;
		int height = 100;
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
