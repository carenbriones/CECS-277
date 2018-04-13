import java.awt.*;
import javax.swing.*;

/**
 * Class that creates a Car object and allows a used to modify the object
 * @author Caren Briones <carenpbriones@gmail.com>
 *
 */
public class Car extends JComponent{
	private int x;
	private int y;
	private int d;
	private Color c;
	
	/**
	 * Creates a Car object with a starting point and color
	 * @param xCoordinate x coordinate of the starting point
	 * @param yCoordinate y coordinate of the starting point
	 * @param carColor color of the car
	 */
	public Car(int xCoordinate, int yCoordinate, int direction, Color carColor){
		x = xCoordinate;
		y = yCoordinate;
		c = carColor;
		d = direction;
	}
	
	/**
	 * Returns the number equivalent of the direction the car is headed in
	 * @return number equivalent of the car's direction
	 */
	public int getDirection(){
		return d;
	}
	
	/**
	 * Draws the Car
	 * @param g Graphics object being used to draw
	 */
	public void drawCar(Graphics g){
		g.setColor(c);
		
		//Draws body of the car
		g.drawLine(x, y, x + 30, y);
		g.drawLine(x + 30, y, x + 45, y + 15);
		g.drawLine(x + 45, y + 15, x + 60, y + 15);
		g.drawLine(x + 60, y + 15, x + 60, y + 30);
		g.drawLine(x + 60, y + 30, x - 30, y + 30);
		g.drawLine(x - 30, y + 30, x - 30, y + 15);
		g.drawLine(x - 30, y + 15, x - 15, y + 15);
		g.drawLine(x - 15, y + 15, x, y);
		
		//Draws two windows
		g.drawRect(x + 1, y + 5, 13, 10);
		g.drawRect(x + 16, y + 5, 13, 10);
		
		//Draws two wheels
		g.setColor(Color.BLACK);
		g.fillOval(x - 20, y + 25, 20, 20);
		g.fillOval(x + 30, y + 25, 20, 20);

	}
	
	/**
	 * Moves the car's position to the left
	 */
	public void moveLeft()
	{
		x -= 1;
		repaint();
		if (touchesBorders())
		{
			d = 2;
		}
	}
	
	/**
	 * Moves the car's position to the right
	 */
	public void moveRight()
	{
		x += 1;
		repaint();
		if (touchesBorders())
		{
			d = 1;
		}
	}
	
	/**
	 * Moves the car's position up the frame
	 */
	public void moveUp()
	{
		y -= 1;
		repaint();
		if (touchesBorders())
		{
			d = 4;
		}
	}
	
	/**
	 * Moves the car's position down the frame
	 */
	public void moveDown()
	{
		y += 1;
		repaint();
		if (touchesBorders())
		{
			d = 3;
		}
	}
	
	/**
	 * Method that returns a boolean indicating whether the car is touching
	 * a border of the frame or not
	 * @return boolean whether the car is touching the border or not
	 */
	public boolean touchesBorders()
	{
		boolean flag = false;
		if (x + 60 == 500)
		{
			flag = true;
		} else if (x - 30 == 0)
		{
			flag = true;
		} else if (y + 65 == 500)
		{
			flag = true;
		} else if (y == 0)
		{
			flag = true;
		}
		
		return flag;
	}
}
