import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

/**
 * Class that allows a car object to move
 *
 * @author Caren Briones <carenpbriones@gmail.com>
 *
 */
public class Move extends JPanel implements Runnable{
	private Car car1;

	/**
	 * Creates a Move object with two cars
	 * @param xCoordinate starting x coordinate of the first car
	 * @param yCoordinate starting y coordinate of the second car
	 * @param c color of the car
	 */
	public Move(int xCoordinate, int yCoordinate, Color c, int direction)
	{
		car1 = new Car(xCoordinate, yCoordinate, c, direction);
	}

	/**
	 * Paints both cars
	 * @param g Graphics object that is used to draw
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		car1.paintComponent(g);

		if (car1.getDirection() == 1)
		{
			car1.moveRight();
		} else if (car1.getDirection() == 2)
		{
			car1.moveLeft();
		} else if (car1.getDirection() == 3)
		{
			car1.moveUp();
		} else
		{
			car1.moveDown();
		}
	}


	/**
	 * Runs while using the sleep method on the thread
	 */
	@Override
	public void run(){
		while(true)
		{
			repaint();
			try{
				Thread.sleep(50);
			}catch(InterruptedException c){

			}
		}
	}
}
