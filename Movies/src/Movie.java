import java.util.ArrayList;

/**
 * Class that allows you to construct, access data members,
 * and modify data members of a movie object that consists of a
 * title,  release year, movie rating, length, audience rating, and
 * a list of actors.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */

public class Movie {
	//Data members
	/** The name of the movie */
	private String title;
	/** The year the movie was released */
	private int releaseYear;
	/** The rating of what audiences can watch the movie */
	private String movieRating;
	/** The length of the movie in minutes */
	private int length;
	/** Average number of stars the audience rates the movie from 1-10 */
	private double audienceRating;
	/** Actors that appear in the movie */
	private ArrayList <String> actors;
	
	/**
	 * Constructs a movie object knowing only the title
	 * @param t the title of the movie
	 */
	public Movie(String t){
		title = t;
	}
	
	/**
	 * Constructs a movie with all of the data members it has
	 * @param t title of the movie
	 * @param r release year of the movie
	 * @param m movie rating of what audiences can watch
	 * @param l length of the movie in minutes
	 * @param aud audience average rating of the movie from 1-10
	 * @param act actors in the movie
	 */
	public Movie(String t, int r, String m, int l, double aud, ArrayList <String> act){
		title = t;
		releaseYear = r;
		movieRating = m;
		length = l;
		audienceRating = aud;
		actors = act;
	}
	
	/**
	 * Returns the title of the movie
	 * @return title of the movie
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Returns the release year of the movie
	 * @return year the movie was released
	 */
	public int getYear(){
		return releaseYear;
	}
	
	/**
	 * Returns the movie content rating
	 * @return movie content rating
	 */
	public String getMovieRating(){
		return movieRating;
	}
	
	/**
	 * Returns the length of the movie in minutes
	 * @return length of the movie in minutes
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Returns the average audience rating of the movie from 1-10
	 * @return average audience rating of the movie from 1-10
	 */
	public double getAudienceRating(){
		return audienceRating;
	}
	
	/**
	 * Returns the list of actors in the movie
	 * @return list of actors in the movie
	 */
	public ArrayList <String> getActors(){
		return actors;
	}
	
	/**
	 * Changes the title of the movie to the string in the parameters
	 * @param t title to be changed to
	 */
	public void setTitle(String t){
		title = t;
	}
	
	/**
	 * Chances the release year of the movie to the integer in the
	 * parameters
	 * @param y year to change the release year to
	 */
	public void setYear(int y){
		releaseYear = y;
	}
	
	/**
	 * Changes the movie content rating to the string in the parameter
	 * @param m movie content rating to be changed to
	 */
	public void setMovieRating(String m){
		movieRating = m;
	}
	
	/**
	 * Changes the movie length to the integer in the parameter
	 * @param l length to be changed to
	 */
	public void setLength(int l){
		length = l;
	}
	
	/**
	 * Changes the audience rating from 1-10 to the double in the
	 * parameters
	 * @param a audience rating to be changed to
	 */
	public void setAudienceRating(double a){
		audienceRating = a;
	}
	
	/**
	 * Changes the existing list of actors to the list in the parameters
	 * @param a list of actors to be changed to
	 */
	public void setActors(ArrayList <String> a){
		actors = a;
	}
	
	/**
	 * Adds an actor to the already existing list of actors of the movie
	 * @param a actor to be added to the list of actors
	 */
	public void addActor(String a){
		actors.add(a);
	}
	
	/**
	 * Searches for an actor in the list of actors.  If the actor is not found,
	 * -1 will be returned; if the actor is found, the index of the actor will
	 * be returned
	 * @param a actor to be searched for
	 * @return -1 if the actor is not found in the list, the index of the actor if they are in the list
	 */
	public int searchActor(String a){
		int index = -1;
		if (actors.isEmpty()){
			System.out.println("There are no actors listed for this movie.");
		} else{
			for (int i = 0; i < actors.size(); i++){
				if (actors.get(i) == a){
					index = i;
				}
			}
		}
		return index;
	}
	
	/**
	 * Deletes an actor from the list of actors if it is present.
	 * @param a actor to be added
	 */
	public void deleteActor(String a){
		if (actors.isEmpty()){
			System.out.println("There are no actors listed for this movie.");
		} else{
			if (actors.remove(a)){
				System.out.println("The actor has been removed.");
			} else{
				System.out.println("The actor was not in the list of actors for this movie.");
			}
		}
	}
	
	/**
	 * Returns a string value of the actors separated by commas
	 * @return string value of actors separated by commas
	 */
	public String printActors(){
		String s = "";
		if(actors.isEmpty()){
			return "";
		} else{
			for (int i = 0; i < actors.size(); i++){
				s = s + actors.get(i) + ",";
			}
			s = s.substring(0, s.length() - 1);
			return s;
		}
	}
	
	/**
	 * Compares two words using the compareTo method of the String class
	 * to determine which word comes first lexicographically
	 * @param w word to compare this word to
	 * @return integer indicating which word comes first
	 */
	public int compareTo(Movie m){
		if(m.getTitle().compareTo(title) > 0){
			return 1;
		} else if(m.getTitle().compareTo(title) < 0){
			return -1;
		} else{
			return 0;
		}
	}
	
	/**
	 * Converts a Movie object to a string
	 * @return returns a string version of a movie
	 */
	@Override
	public String toString(){
		String s = "Title: " + title;
		if(releaseYear == 0){
			s = s + "\tRelease Year: unknown";
		} else{
			s = s + "\tRelease Year: " + releaseYear;
		}
		if(movieRating == ""){
			s = s + "\tMovie Rating: unknown";
		} else{
			s = s + "\tRelease Year: " + movieRating;
		}
		if(length == 0){
			s = s + "\tLength: unknown";
		} else{
			s = s + "\tLength: " + length;
		}
		if(audienceRating == 0){
			s = s + "\tAudience Rating: unknown";
		} else{
			s = s + "\tAudience Rating: " + audienceRating;
		}
		s = s + "\tActors: " + actors;
		return s;
	}
}
