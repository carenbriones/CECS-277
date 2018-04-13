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
	private Color c;
	private int d;
	
	/**
	 * Creates a Car object with a starting point and color
	 * @param xCoordinate x coordinate of the starting point
	 * @param yCoordinate y coordinate of the starting point
	 * @param carColor color of the car
	 */
	public Car(int xCoordinate, int yCoordinate, Color carColor, int direction){
		x = xCoordinate;
		y = yCoordinate;
		c = carColor;
		d = direction;
	}
	
	public int getDirection()
	{
		return d;
	}
	
	public void setDirection(int direction)
	{
		d = direction;
	}
	
	/**
	 * Draws the Car
	 * @param g Graphics object being used to draw
	 */
	public void paintComponent(Graphics g){
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
		if (x - 30 == 0)
		{
			setDirection(1);
		}
	}
	
	/**
	 * Moves the car's position to the right
	 */
	public void moveRight()
	{
		x += 1;
		repaint();
		if(x + 60 == getWidth())
		{
			setDirection(2);
		}
	}
	
	/**
	 * Moves the car's position down the frame
	 */
	public void moveDown()
	{
		y += 1;
		repaint();
		if (y + 50 == getHeight())
		{
			setDirection(3);
		}
	}
	
	/**
	 * Moves the car's position up the frame
	 */
	public void moveUp()
	{
		y -= 1;
		repaint();
		if(y == 0)
		{
			setDirection(4);
		}
	}
}
