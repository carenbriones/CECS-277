import java.util.LinkedList;

/**
 * This class allows for the construction, addition, and multiplication of
 * a Polynomial object, with a LinkedList of Terms as its data member.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Polynomial {
	/** LinkedList of all of the terms of the Polynomial */
	private LinkedList <Term> terms;

	/**
	 * Constructs a Polynomial with the first term as the term given in the parameters
	 * @param t first term of the Polynomial
	 */
	public Polynomial(Term t){
		terms = new LinkedList<Term>();
		terms.add(t);
	}

	/**
	 * Constructs an empty Polynomial object
	 */
	public Polynomial(){
		terms = new LinkedList<Term>();
	}

	/**
	 * Adds a single term to a Polynomial object, making sure to combine
	 * like terms with the same power of x
	 * @param t term being added to the Polynomial
	 */
	public void add(Term t){
		int power = t.getPower();
		int coefficient = t.getCoefficient();
		
		//Checks to see if the power is present in the polynomial to add like terms
		boolean found = false;
		for(int i = 0; i < terms.size(); i++){
			if (terms.get(i).getPower() == power){
				found = true;
				//Deletes the element if it results in a coefficient of 0
				if (terms.get(i).getCoefficient() + coefficient != 0){
					terms.set(i, new Term(terms.get(i).getCoefficient() + coefficient, power));
				} else{
					terms.remove(i);
				}
			}
		}
		
		//If there are no like terms
		if (found == false){
			terms.add(t);
		}
	}

	/**
	 * Adds a whole Polynomial to this Polynomial
	 * @param p Polynomial to be added
	 */
	public void add(Polynomial p){
		for (int i = 0; i < p.getTerms().size(); i++){
			add(p.getTerms().get(i));
		}
	}

	/**
	 * Returns the LinkedList of terms within the polynomial
	 * @return LinkedList of all terms within the polynomial
	 */
	public LinkedList <Term> getTerms(){
		return terms;
	}

	/**
	 * Multiplies the implicit by the explicit Polynomial and returns the resulting Polynomial
	 * @param p Polynomial to be multiplied to the implicit parameter
	 * @return the resulting Polynomial from the multiplication
	 */
	public Polynomial multiply(Polynomial p){
		Polynomial answer = new Polynomial();
		for(int i = 0; i < p.getTerms().size(); i++){
			for (int j = 0; j < terms.size(); j++){
				//Multiplies coefficients together
				int coefficient = p.getTerms().get(i).getCoefficient() * terms.get(j).getCoefficient();
				//Adds powers together
				int power = p.getTerms().get(i).getPower() + terms.get(j).getPower();
				if (power != 0){
					answer.add(new Term(coefficient, power));
				}
			}
		}
		return answer;
	}

	/**
	 * Prints out the implicit Polynomial
	 */
	public void print(){
		for (int i = 0; i < terms.size(); i++){
			//Doesn't print out a plus sign if it is the last term in the Polynomial
			if (i != terms.size() - 1){
				System.out.print(terms.get(i) + " + ");
			} else{
				System.out.print(terms.get(i));
			}
		}
	}

}
