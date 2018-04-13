/**
 * Class that constructs and allows access to/modification of the data members
 * of an Appointment object that consists of a date, start time, end time, 
 * and description.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Appointment {
	//Data members
	/** Date of the appointment */
	private Date date;
	/** Starting time of the appointment */
	private Time start;
	/** Ending time of the appointment*/
	private Time end;
	/** Description of the appointment */
	private String description;
	
	/**
	 * Constructs an Appointment object consisting of the information in the parameters
	 * @param d date of the appointment
	 * @param s start time of the appointment
	 * @param e end time of the appointment
	 * @param des description of the appointment
	 */
	public Appointment(Date d, Time s, Time e, String des){
		date = d;
		start = s;
		end = e;
		description = des;
	}
	
	/**
	 * Returns the date of the appointment
	 * @return date of the appointment
	 */
	public Date getDate(){
		return date;
	}
	
	/**
	 * Returns the start time of the appointment
	 * @return start time of the appointment
	 */
	public Time getStartTime(){
		return start;
	}
	
	/**
	 * Returns the end time of the appointment
	 * @return end time of the appointment
	 */
	public Time getEndTime(){
		return end;
	}
	
	/**
	 * Returns the description of the appointment
	 * @return description of the appointment
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * Returns the string version of an Appointment object
	 * @return string version of the Appointment
	 */
	@Override
	public String toString(){
		String s = description + "\t" + date + "\t" + start + "\t" + end;
		return s;
	}

}