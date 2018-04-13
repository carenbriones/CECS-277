/**
 * Class that constructs and allows access to/modification of the
 * data members of a Date object that consists of a year, month, 
 * and day.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Date {
	/** Year of the date*/
	private int year;
	/** Month of the date */
	private int month;
	/** Day of the date */
	private int day;
	
	/**
	 * Constructs a Date object with the information entered in the parameters
	 * @param y year of the date
	 * @param m month of the date
	 * @param d day of the date
	 */
	public Date(int y, int m, int d){
		year = y;
		month = m;
		day = d;
	}
	
	/**
	 * Returns the year of a date
	 * @return year of the date
	 */
	public int getYear(){
		return year;
	}
	
	/**
	 * Returns the month of a date
	 * @return month of the date
	 */
	public int getMonth(){
		return month;
	}
	
	/**
	 * Returns the day of a date
	 * @return day of the date
	 */
	public int getDay(){
		return day;
	}
	
	/**
	 * Changes the year of a date using the year in the parameters
	 * @param y year to be changed to
	 */
	public void setYear(int y){
		year = y;
	}
	
	/**
	 * Changes the month of a date using the month in the parameters
	 * @param m month to be changed to
	 */
	public void setMonth(int m){
		month = m;
	}
	
	/**
	 * Changes the day of a date using the day in the parameters
	 * @param d day to be changed to
	 */
	public void setDay(int d){
		day = d;
	}
	
	/**
	 * Returns a string version of a Date object
	 * @return string version of the date
	 */
	@Override
	public String toString(){
		String s = year + "/" + month + "/" + day;
		return s;
	}
	
}