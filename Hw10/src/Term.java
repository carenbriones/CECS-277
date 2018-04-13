
public class Term {
	/** The coefficient of the term being multiplied by x */
	private int coefficient;
	/** The power of x within the term */
	private int power;

	/**
	 * Constructs a Term with the coefficient and power given by the parameters
	 * @param c coefficient of the term
	 * @param p power of x of the term
	 */
	public Term(int c, int p){
		coefficient = c;
		power = p;
	}

	/**
	 * Returns the coefficient of the term
	 * @return the coefficient of the term
	 */
	public int getCoefficient(){
		return coefficient;
	}

	/**
	 * Returns the power of x of the term
	 * @return the power of x
	 */
	public int getPower(){
		return power;
	}

	/**
	 * Sets/modifies the coefficient of a term
	 * @param c coefficient to be changed to
	 */
	public void setCoefficient(int c){
		coefficient = c;
	}

	/**
	 * Sets/modifies the power of x of a term
	 * @param p power of x to be changed to
	 */
	public void setPower(int p){
		power = p;
	}

	/**
	 * Returns a term's String equivalent, taking into account whether or not to
	 * print out the coefficient or x dependent on its coefficient and power
	 */
	@Override
	public String toString(){
		String s = "";
		if (coefficient != 0){
			if (coefficient != 1){
				s += coefficient;
			}
			if (power != 0){
				s += "x";
			}
			if (power != 1 && power != 0){
				s += "^" + power;
			}
		}
		return s;
	}
}
