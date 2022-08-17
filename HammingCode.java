import java.util.*;

public class HammingCodeClass
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no. of digits:- ");
		int m = sc.nextInt();
		
		//Calculating value of r
		boolean EquationSatisfied = false;
		int r = 0, pow=1;
		while(!EquationSatisfied)
		{
			pow=1;
			if(r == 0)
				pow = 1;
			else
			{
				for(int i=0;i<r;i++)
					pow *= 2;
			}
			
			if(pow >= (m+r+1))
				EquationSatisfied = true;
			else
				r++;
		}
//		System.out.print(pow);
//		System.out.print(r);
		
		//Calculating parity of r
		int[] message = new int[m+r];
		for(int i=0;i<message.length;i++)
			message[i] = -1;
		for(int i=1;i<=pow/2;i*=2)
			message[i-1] = 0;
		for(int i=message.length;i>0;i--)
		{
			if(message[i-1] == -1)
			{
				System.out.print("n>");
				message[i-1] = sc.nextInt();
			}
		}
		for(int i=message.length;i>0;i--)
			System.out.print(message[i-1]);
	}

}
