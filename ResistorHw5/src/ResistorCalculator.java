import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ResistorCalculator extends JFrame implements MouseListener {

	final int NUMBER_OF_BUTTONS = 14;
	public int counter;

	JPanel panel = new JPanel();

	JButton[] buttons = new JButton[NUMBER_OF_BUTTONS];
	String[] names = {"black", "brown", "red", "orange", "yellow", "green",
			"blue", "violet", "grey", "white", "gold", "silver", "enter", "clear"};
	Color[] colors = {Color.BLACK, new Color(102, 51, 0), Color.RED, Color.ORANGE,
			Color.YELLOW, Color.GREEN, Color.BLUE, new Color(102, 0, 204), Color.DARK_GRAY,
			Color.WHITE, new Color(204, 204, 0), new Color(224, 224, 224),
			new Color(192, 192, 192), new Color(192, 192, 192)};

	JTextField field = new JTextField(20);

	ResistorCalculator(){
		counter = 0;
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.add(field);
		for (int i = 0; i < NUMBER_OF_BUTTONS; i++){
			buttons[i] = new JButton(names[i]);
			buttons[i].setBackground(colors[i]);
			buttons[i].setOpaque(true);
			buttons[i].addMouseListener(this);
			buttons[i].setPreferredSize(new Dimension(60, 40));
			if (i > 9 && i < NUMBER_OF_BUTTONS){
				buttons[i].setEnabled(false);
			}
			panel.add(buttons[i]);
		}

		add(panel);
		setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		
		// Will only make changes to the calculator if the button clicked was enabled
		if (buttonClicked.isEnabled()){
			counter++;
		}
		
		// Enables the "clear" button after the first color is clicked
		if(counter == 1){
			buttons[13].setEnabled(true);
		}
		
		// Clears option if the clear button is clicked
		if (buttonClicked == buttons[13]){
			counter = 0;
			for (int i = 0; i < NUMBER_OF_BUTTONS; i++){
				if (i < 10){
					buttons[i].setEnabled(true);
				} else{
					buttons[i].setEnabled(false);
				}
			}
			field.setText("");
		}
		// Adds the color to the text field
		else{ 
			if (counter <= 4 && buttonClicked.isEnabled()){
				field.setText(field.getText() + " " + buttonClicked.getText());
			}
		}
		
		// Disables all color buttons except for gold and silver for the last band color
		if (counter == 3){
			for (int i = 0; i < 12; i++){
				if (i < 10){
					buttons[i].setEnabled(false);
				} else{
					buttons[i].setEnabled(true);
				}
			}
		}
		
		// Resistor band colors are filled; user can either enter or clear colors
		if (counter == 4){
			buttons[10].setEnabled(false);
			buttons[11].setEnabled(false);
			buttons[12].setEnabled(true);
		}
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < NUMBER_OF_BUTTONS; i++){
			if (e.getSource() == buttons[i]){
				if (buttons[i].isEnabled()){
					buttons[i].setBackground(Color.GRAY);
				}
			}
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		for (int i = 0; i < NUMBER_OF_BUTTONS; i++){
			buttons[i].setBackground(colors[i]);
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		ResistorCalculator r = new ResistorCalculator();

	}
}
