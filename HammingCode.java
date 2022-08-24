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
		
		//Calculating hamming code
		System.out.println("Enter the digits:- ");
		int[] HammingCodeArr = new int[m+r];
		for(int i=0;i<HammingCodeArr.length;i++)
			HammingCodeArr[i] = -1;
		for(int i=1;i<=pow/2;i*=2)
			HammingCodeArr[i-1] = 0;
		for(int i=HammingCodeArr.length;i>0;i--)
		{
			if(HammingCodeArr[i-1] == -1)
			{
				System.out.print(">");
				HammingCodeArr[i-1] = sc.nextInt();
			}
		}
		System.out.print("Hamming code:- ");
		for(int i=HammingCodeArr.length;i>0;i--)
			System.out.print(HammingCodeArr[i-1]);
		System.out.println();
		
		//Calculating parity to check for errors
		int[] Rn = new int[r];
		for(int i=0;i<Rn.length;i++)
			Rn[i] = 0;
		for(int i=0;i<Rn.length;i++)
		{
			int TakeNDropN=1, rn=0, parity = 0;
			for(int j=0;j<i;j++)
				TakeNDropN *= 2;
			for(int j=TakeNDropN-1;j<HammingCodeArr.length;j++)
			{
				
			}
		}
	}
}
