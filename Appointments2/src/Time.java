/**
 * Class that constructs and allows access to/modification of the
 * data members of a Time object that consists of an hour,
 * minute, and second.
 * 
 * @author Caren Briones <carenpbriones@gmail.com> 
 */
public class Time {
	/** Hour value of the time */
	private int hour;
	/** Minute value of the time */
	private int minute;
	/** Second value of the time */
	private int second;
	
	/**
	 * Constructs a Time object consisting of the information in the parameters
	 * without entering a value for the seconds
	 * @param h hour of the time
	 * @param m minute of the time
	 */
	public Time(int h, int min){
		hour = h;
		minute = min;
		second = 0;
	}
	
	/**
	 * Constructs a Time object consisting of the information in the parameters
	 * @param h hour of the time
	 * @param m minute of the time
	 * @param s second of the time
	 */
	public Time(int h, int min, int s){
		hour = h;
		minute = min;
		second = s;
	}
	
	/**
	 * Returns the hour of the Time object
	 * @return hour of the time
	 */
	public int getHour(){
		return hour;
	}
	
	/**
	 * Returns the minute of the Time object
	 * @return minute of the time
	 */
	public int getMinute(){
		return minute;
	}
	
	/**
	 * Returns the second of the Time object
	 * @return second of the time
	 */
	public int getSecond(){
		return second;
	}
	
	/**
	 * Changes the hour of the Time to the hour in the parameters
	 * @param h hour to be changed to
	 */
	public void setHour(int h){
		hour = h;
	}
	
	/**
	 * Changes the minute of the Time to the minute in the parameters
	 * @param m minute to be changed to
	 */
	public void setMinute(int m){
		minute = m;
	}
	
	/**
	 * Changes the second of the Time to the second in the parameters
	 * @param s second to be changed to
	 */
	public void setSecond(int s){
		second = s;
	}
	
	/**
	 * Converts and returns a string version of a Time object
	 * @return string version of the Time object
	 */
	@Override
	public String toString(){
		String s = "" + hour;
		if(minute == 0){
			s += ":00";
		} else if(minute < 10 && minute > 0){
			s += ":0" + minute;
		} else{
			s += ":" + minute;
		}
		return s;
	}
}