import java.awt.event.*;

import javax.swing.*;

/**
 * Has two buttons with separate clickers for each button,
 * printing a message for how many times each button is clicked.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class MainPart1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button1 = new JButton("");
		JButton button2 = new JButton("");
		final JLabel label = new JLabel();
		
		/**
		 * Creates an Action Listener to display a message each time a button is clicked.
		 */
		class Clicker implements ActionListener{
			int counter;
			/**
			 * Creates a Clicker object with counts starting at 0.
			 */
			public Clicker (){
				counter = 0;
			}
			/**
			 * Increments the counter when a button is clicked and displays
			 * how many times the button is clicked.
			 * 
			 * @param event ActionEvent for the clicker
			 */
			public void actionPerformed(ActionEvent event){
				counter++;
				label.setText("Button was clicked " + counter + " time(s).");
			}
		}
		
		//Adds all panels and labels to the frame
		JPanel panel = new JPanel();
		panel.add(label);
		label.setVisible(true);
		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
		
		//Creates Clicker for each button
		ActionListener listener1 = new Clicker();
		ActionListener listener2 = new Clicker();
		button1.addActionListener(listener1);
		button2.addActionListener(listener2);
		
		//Sets frame size and makes it visible
		int width = 500;
		int height = 100;
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
