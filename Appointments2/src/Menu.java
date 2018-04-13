import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that allows a user to add an Appointment, remove a cancelled Appointment,
 * or display a list of appointments for a particular day.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Menu {

	public static void main(String[] args) {
		//Creates scanner to take in user's input
		Scanner choiceScanner = new Scanner(System.in);
		int choice = 0;
		boolean flag = true;
		System.out.println("Welcome! Select an option:  ");
		ArrayList <Appointment> apptList = new ArrayList <Appointment> ();

		do{

			// Menu options
			System.out.println("1.  Add an appointment");
			System.out.println("2.  Remove a cancelled appointment");
			System.out.println("3.  Display the list of appointments for a particular day");
			System.out.println("4.  Quit.");

			// Checks whether the user's input matches is of the desired type
			choice = checkInt();
			System.out.println();

			// Checks if the user's input is from the choices 1-3
			while (choice < 1 || choice > 4){
				System.out.println("Please enter \"1\", \"2\", \"3\", or \"4\".);");
				choice = choiceScanner.nextInt();
			}

			switch(choice){

			case 1:
				//If the user wants to add an appointment
				Date apptDate = checkDate();
				
				System.out.println("Enter '1' to represent time in standard format or '2' for 12 hours format:  ");
				int format = checkInt();
				
				while(format > 2 || format < 1){
					System.out.println("Please enter '1' or '2':  ");
					format = checkInt();
				}
				
				//Formats the time the way the user wants to
				Time startTime;
				Time endTime;
				if(format == 1){
					startTime = checkTime24Hours("starts");
					endTime = checkTime24Hours("ends");
				} else{
					startTime = checkTime12Hours("starts");
					endTime = checkTime12Hours("ends");
				}
				
				//Checks if the end time is after the start time
				if(format == 1){
					//For standard format
					if(startTime.getHour() > endTime.getHour()){
						System.out.println("The ending time cannot precede/be equivalent to the starting time; please enter a new end time:  ");
						endTime = checkTime24Hours("ends");
					} else if(startTime.getHour() == endTime.getHour() && startTime.getMinute() >= endTime.getMinute()){
						System.out.println("The ending time cannot precede/be equivalent to the starting time; please enter a new end time:  ");
						endTime = checkTime24Hours("ends");
					}
				} else{
					//For 12 hours format
					if(startTime.getHour() > endTime.getHour()){
						System.out.println("The ending time cannot precede/be equivalent to the starting time; please enter a new end time:  ");
						endTime = checkTime12Hours("ends");
					} else if(startTime.getHour() == endTime.getHour() && startTime.getMinute() >= endTime.getMinute()){
						System.out.println("The ending time cannot precede/be equivalent to the starting time; please enter a new end time:  ");
						endTime = checkTime12Hours("ends");
					}
				}

				System.out.println("Enter a brief description of your appointment:  ");
				String des = choiceScanner.nextLine();

				Appointment appt = new Appointment(apptDate.getYear(), apptDate.getMonth(), apptDate.getDay(), startTime.getHour(), startTime.getMinute(), endTime, des);

				System.out.println(appt);
				apptList.add(appt);
				System.out.println(apptList);
				
				break;

			case 2:
				//If the user wants to remove a cancelled appointment
				if(apptList.size() == 0){
					System.out.println("You do not have any appointments listed.");
				}else{
					Date removeApptDate = checkDate();
					
					System.out.println("Enter '1' to represent time in standard format or '2' for 12 hours format:  ");
					format = checkInt();
					
					while(format > 2 || format < 1){
						System.out.println("Please enter '1' or '2':  ");
						format = checkInt();
					}
					
					if(format == 1){
						startTime = checkTime24Hours("starts");
					} else{
						startTime = checkTime12Hours("starts");
					}
					
					int match = -1;
					
					//Checks if the date and time are the same for every element in the ArrayList
					for (int i = 0; i < apptList.size(); i++){
						Appointment compare = apptList.get(i);
						if(compare.getYear() == removeApptDate.getYear()){
							if(compare.getMonth() == removeApptDate.getMonth()){
								if(compare.getDay() == removeApptDate.getDay()){
									if(compare.getHour() == startTime.getHour()){
										if(compare.getMinute() == startTime.getMinute()){
											match = i;
										}
									}
								}
							}
						}
					}
					
					if(match == -1){
						System.out.println("The appointment you want to remove was not found.");
					} else{
						apptList.remove(match);
						printSchedule(apptList);
						System.out.println();
						System.out.println("The cancelled appointment has been removed");
						System.out.println();
					}
				}

				break;

			case 3:
				//If the user wants to show the appointments for a particular day
				System.out.println("Enter the year:  ");
				int year = checkInt();

				//appointments only scheduled in the future
				while(year < 2016){
					System.out.println("Please enter a valid year:  ");
					year = checkInt();
				}

				System.out.println("Enter the number of the month (e.g. January = 1):  ");
				int month = checkInt();

				//checks if the month is valid
				while (month > 12 || month < 1){
					System.out.println("Please enter a valid number from 1-12:  ");
					month = checkInt();
				}

				System.out.println("Enter the number of the day:  ");
				int day = checkInt();

				//checks if the day is valid for the month that was entered
				if (month == 4 || month == 6 || month  == 9 || month == 11){
					while (day > 30 || day < 1){
						System.out.println("Please enter a valid number:  ");
						day = checkInt();
					}
				} else if (month == 2){
					if(year % 4 == 0){
						while (day > 29 || day < 1){
							System.out.println("Please enter a valid number:  ");
							day = checkInt();
						}
					} else{
						while (day > 28 || day < 1){
							System.out.println("Please enter a valid number:  ");
							day = checkInt();
						}
					}
				} else{
					while (day > 31 || day < 1){
						System.out.println("Please enter a valid number:  ");
						day = checkInt();
					}
				}
				Date dateOfAppointments = new Date(year, month, day, 12, 0);
				
				//Counter increases if there is a match or not
				int counter = 0;
				for (int i = 0; i < apptList.size(); i++){
					if(apptList.get(i).getYear() == dateOfAppointments.getYear()){
						if(apptList.get(i).getMonth() == dateOfAppointments.getMonth()){
							if(apptList.get(i).getDay() == dateOfAppointments.getDay()){
								System.out.println(apptList.get(i));
								counter++;
							}
						}
					}
				}
				System.out.println();
				
				//If the counter did not increase, there were no matches found.
				if(counter == 0){
					System.out.println("There were no appointments found for that day.");
					System.out.println();
				}
				
				break;

			case 4:
				//If the user decides to quit
				System.out.println("Goodbye.");
				flag = false;
				break;

			default:
				System.out.println("Input is invalid.");
			}
		}while (flag != false);
	}

	/**
	 * Returns a valid integer value from the input
	 * @return an integer value
	 */
	public static int checkInt(){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		int validNum = 0;

		while(!valid){
			if(in.hasNextInt()){
				// Ensures that the user's input is an integer
				validNum = in.nextInt();
				valid = true;
			} else{
				// Clear buffer of junk input
				in.next();
				System.out.print("Invalid input.  Please enter an integer: ");
			}
		}
		return validNum;
	}

	/**
	 * Returns a Date entered by the user, checking the user's input for validity
	 * @return Date entered by the user
	 */
	public static Date checkDate(){
		System.out.println("Enter the year of your appointment:  ");
		int year = checkInt();

		//appointments only scheduled in the future
		while(year < 2016){
			System.out.println("Please enter a valid year:  ");
			year = checkInt();
		}

		System.out.println("Enter the number of the month of your appointment (e.g. January = 1):  ");
		int month = checkInt();

		//checks if the month is valid
		while (month > 12 || month < 1){
			System.out.println("Please enter a valid number from 1-12:  ");
			month = checkInt();
		}

		System.out.println("Enter the day of your appointment:  ");
		int day = checkInt();

		//checks if the day is valid for the month that was entered
		if (month == 4 || month == 6 || month  == 9 || month == 11){
			while (day > 30 || day < 1){
				System.out.println("Please enter a valid number for the corresponding month:  ");
				day = checkInt();
			}
		} else if (month == 2){
			if(year % 4 == 0){
				while (day > 29 || day < 1){
					System.out.println("Please enter a valid number for the corresponding month:  ");
					day = checkInt();
				}
			} else{
				while (day > 28 || day < 1){
					System.out.println("Please enter a valid number for the corresponding month:  ");
					day = checkInt();
				}
			}
		} else{
			while (day > 31 || day < 1){
				System.out.println("Please enter a valid number for the corresponding month:  ");
				day = checkInt();
			}
		}

		Date apptDate = new Date(year, month, day, 12, 0);

		return apptDate;
	}

	/**
	 * Returns a Time in 12 hours format, checking the user's input for validity
	 * @param startOrEnd String that differentiates whether the user is entering a start or end time
	 * @return Time entered by the user
	 */
	public static Time checkTime12Hours(String startOrEnd){
		System.out.println("Enter the hour that your appointment " + startOrEnd + " at:  ");
		int hour = checkInt();

		while(hour > 12 || hour < 1){
			System.out.println("Please enter a valid number from 1 - 12:  ");
			hour = checkInt();
		}

		System.out.println("Enter the minute that your appointment " + startOrEnd + " at:  ");
		int min = checkInt();

		while(min < 0 || min > 59){
			System.out.println("Please enter a valid number from 0 - 59:  ");
			min = checkInt();
		}

		System.out.println("Enter '1' for AM or '2' for PM");
		int amOrPm = checkInt();

		while(amOrPm > 2 || amOrPm < 1){
			System.out.println("Please enter '1' or '2':  ");
			amOrPm = checkInt();
		}

		if (hour == 12  && amOrPm == 1){
			hour = 0;
		} else if (amOrPm == 2 && hour > 12){
			hour += 12;
		}

		Time apptTime = new Time(hour, min, 0);

		return apptTime;
	}
	
	/**
	 * Returns a Time in standard format, checking the user's input for validity
	 * @param startOrEnd String that differentiates whether a user is entering a start or end time
	 * @return Time entered by the user
	 */
	public static Time checkTime24Hours(String startOrEnd){
		System.out.println("Enter the hour that your appointment " + startOrEnd + " at:  ");
		int hour = checkInt();

		while(hour > 23 || hour < 0){
			System.out.println("Please enter a valid number from 0 - 23:  ");
			hour = checkInt();
		}

		System.out.println("Enter the minute that your appointment " + startOrEnd + " at:  ");
		int min = checkInt();

		while(min < 0 || min > 59){
			System.out.println("Please enter a valid number from 0 - 59:  ");
			min = checkInt();
		}

		Time apptTime = new Time(hour, min, 0);

		return apptTime;
	}
	
	/**
	 * Prints out the full schedule of appointments
	 * @param appts ArrayList of all appointments
	 */
	public static void printSchedule(ArrayList<Appointment> appts){
		System.out.println("Schedule: ");
		for (int i = 0; i < appts.size(); i++){
			System.out.println(appts.get(i));
		}
	}
}

