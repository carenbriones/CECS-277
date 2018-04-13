/**
 * Tests the Term and Polynomial classes and their functions
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Tester {

	public static void main(String[] args) {
		//Creates the polynomial
		Polynomial p = new Polynomial(new Term(-4, 3));
		p.add(new Polynomial(new Term(6, 2)));
		p.add(new Polynomial(new Term(2, 1)));
		
		
		Polynomial r = new Polynomial(new Term(1, 3));
		r.add(new Term(-2, 1));
		
		//Multiplies the polynomial by itself and returns the result
		p.add(r);
		p.print();
//		Polynomial q = p.multiply(r);
//		q.print();

	}

}
