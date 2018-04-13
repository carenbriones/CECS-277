package lab20;

public class main {

	public static void main(String[] args) {
		double sum = 0;
		
		double nums[] = new double[args.length];
		for(int i = 0; i < args.length; i++)
		{
			nums[i] = Double.valueOf(args[i]);
		}
		for(int i = 0; i < nums.length; i++)
		{
			sum += nums[i];
		}
		
		System.out.println(sum);
	}
}
