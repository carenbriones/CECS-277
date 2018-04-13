import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Creates a Resistor calculator GUI that allows a user to click on buttons to decide what
 * colors they want the resistor to be, and calculates the resistance values when "enter" is clicked.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 *
 */
public class ResistorCalculator extends JFrame implements MouseListener {

	/** Counter for the number of clicks */
	public int counter;
	final int NUMBER_OF_BUTTONS = 14;

	// Panel where all buttons will be added
	JPanel panel = new JPanel();

	// All buttons of the calculator
	JButton[] buttons = new JButton[NUMBER_OF_BUTTONS];
	
	// Names of all of the buttons
	String[] names = {"black", "brown", "red", "orange", "yellow", "green",
			"blue", "violet", "grey", "white", "gold", "silver", "enter", "clear"};
	
	// Background colors of all of the buttons
	Color[] colors = {Color.BLACK, new Color(102, 51, 0), Color.RED, Color.ORANGE,
			Color.YELLOW, Color.GREEN, Color.BLUE, new Color(102, 0, 204), Color.DARK_GRAY,
			Color.WHITE, new Color(204, 204, 0), new Color(224, 224, 224),
			new Color(192, 192, 192), new Color(192, 192, 192)};

	JTextField field = new JTextField(24);

	ResistorCalculator(){
		counter = 0;
		field.setEditable(false);
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Adds text field and buttons to the panel with initialized values
		panel.add(field);
		for (int i = 0; i < NUMBER_OF_BUTTONS; i++){
			buttons[i] = new JButton(names[i]);
			buttons[i].setBackground(colors[i]);
			buttons[i].setOpaque(true);
			buttons[i].addMouseListener(this);
			buttons[i].setPreferredSize(new Dimension(60, 40));
			// Disables silver, gold, clear, and enter buttons upon running the code
			if (i > 9 && i < NUMBER_OF_BUTTONS || i == 0){
				buttons[i].setEnabled(false);
			}
			panel.add(buttons[i]);
		}

		add(panel);
		setVisible(true);
	}
	
	/**
	 * Makes changes to the calculator dependent on which button is clicked
	 * and what the click counter is equal to
	 * @param e event that occurs
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		
		// Will only make changes to the calculator if the button clicked was enabled
		if (buttonClicked.isEnabled()){
			counter++;
		}
		
		// Enables the "clear" and "black" buttons after the first color is clicked
		if(counter == 1){
			buttons[0].setEnabled(true);
			buttons[13].setEnabled(true);
		}
		
		// Clears option if the clear button is clicked
		if (buttonClicked == buttons[13]){
			counter = 0;
			buttons[0].setEnabled(false);
			for (int i = 1; i < NUMBER_OF_BUTTONS; i++){
				if (i < 10){
					buttons[i].setEnabled(true);
				} else{
					buttons[i].setEnabled(false);
				}
			}
			field.setText("");
		}

		else{ 
			// Adds color to the resistor
			if (counter <= 4 && buttonClicked.isEnabled()){
				if (field.getText().equals("")){
					field.setText(buttonClicked.getText());
				}else{
					field.setText(field.getText() + " " + buttonClicked.getText());
				}
			}
			// Creates a resistor and calculates the resistance once the "enter" button is clicked
			if (buttonClicked == buttons[12]){
				String[] resistorColors = field.getText().split(" ");
				Resistor r = convertToResistor(resistorColors);
				String result = "Min = " + r.calculateMinValue() + "   Max = " + r.calculateMaxValue();
				field.setText(result);
				buttons[12].setEnabled(false);
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

	/**
	 * Changes the color of the button hovered over, unless the button is currently disabled
	 * @param e event that occurs
	 */
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

	/**
	 * Sets the background color back to normal once the mouse isn't hovering over any buttons
	 * @param e event that occurs
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < NUMBER_OF_BUTTONS; i++){
			buttons[i].setBackground(colors[i]);
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
	
	/**
	 * Converts an array of band colors into its equivalent resistor value
	 * @param colors band colors
	 * @return resistor equal to the band colors
	 */
	public Resistor convertToResistor(String[] colors){
		//Converts first three bands into it's nominal resistor value
		int nominal = 0;
		nominal += convertToNumber(colors[0]) * 10;
		nominal += convertToNumber(colors[1]);
		nominal *= Math.pow(10, convertToNumber(colors[2]));
		
		//Converts third band into it's equivalent value
		double tolerance = 0;
		if(colors[3].equals("gold")){
			tolerance = 0.05;
		} else if(colors[3].equals("silver")){
			tolerance = 0.1;
		}
		
		//Creates and returns the resistor
		Resistor r = new Resistor(nominal, tolerance);
		return r;
	}
	
	/**
	 * Converts a band color to its corresponding number value
	 * @param color color of the band
	 * @return number value of the band
	 */
	public int convertToNumber(String color){
		int num = 0;
		if(color.equals("black")){
			num = 0;
		} else if(color.equals("brown")){
			num = 1;
		} else if(color.equals("red")){
			num = 2;
		} else if(color.equals("orange")){
			num = 3;
		} else if(color.equals("yellow")){
			num = 4;
		} else if(color.equals("green")){
			num = 5;
		} else if(color.equals("blue")){
			num = 6;
		} else if(color.equals("violet")){
			num = 7;
		} else if(color.equals("gray")){
			num = 8;
		} else if(color.equals("white")){
			num = 9;
		}
		return num;
	}
	
	public static void main(String[] args) {
		ResistorCalculator r = new ResistorCalculator();
	}
}
