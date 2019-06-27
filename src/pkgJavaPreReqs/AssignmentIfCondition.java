package pkgJavaPreReqs;

public class AssignmentIfCondition {

	public static void main(String[] args) {
		
		//Write a program to check if a candidate is eligible for voting or not. (Hint: Check age)
		
		int age = 17;
		
		if( age <= 17 )
			System.out.println("Age is: " + age + ". Person is too young to vote.");
		else
			System.out.println("Age is: " + age + ". Person is old enough to vote.");
		
		age++;
		
		if( age <= 17 )
			System.out.println("Age is: " + age + ". Person is too young to vote.");
		else
			System.out.println("Age is: " + age + ". Person is old enough to vote.");
		
		
		//Write a program to check if the number is positive or negative.
		
		int posOrNeg = -1;
		
		if( posOrNeg < 0 )
			System.out.println("Num is: " + posOrNeg + ". Number is Negative.");
		else
			System.out.println("Num is: " + posOrNeg + ". Number is Positive.");
		
		posOrNeg = 1;
				
		if( posOrNeg < 0 )
			System.out.println("Num is: " + posOrNeg + ". Number is Negative.");
		else
			System.out.println("Num is: " + posOrNeg + ". Number is Positive.");
		
		
		//Extend the previous program to check whether the given number is positive, zero or 
		//negative. (Hint: use if - else conditions)
		
		int posZeroOrNeg = -1;
		if( posZeroOrNeg < 0 ) System.out.println("Num is: " + posZeroOrNeg + ". Number is Negative.");
			else
				if( posZeroOrNeg == 0) System.out.println("Num is: " + posZeroOrNeg + ". Number is Zero.");
					else
						System.out.println("Num is: " + posZeroOrNeg + ". Number is Positive.");
		
		posZeroOrNeg = 0;
				
		if( posZeroOrNeg < 0 ) System.out.println("Num is: " + posZeroOrNeg + ". Number is Negative.");
			else
				if( posZeroOrNeg == 0) System.out.println("Num is: " + posZeroOrNeg + ". Number is Zero.");
					else
						System.out.println("Num is: " + posZeroOrNeg + ". Number is Positive.");
	
		posZeroOrNeg = 1;
		
		if( posZeroOrNeg < 0 ) System.out.println("Num is: " + posZeroOrNeg + ". Number is Negative.");
			else
				if( posZeroOrNeg == 0) System.out.println("Num is: " + posZeroOrNeg + ". Number is Zero.");
					else
						System.out.println("Num is: " + posZeroOrNeg + ". Number is Positive.");
		
		
		//Write a program to find largest of two numbers.
		
		float A = (float) 3.4;
		float B = (float) 1.2;
		if( A > B )
			System.out.println("Number A with value: " + A + " is greater than number B with value: " + B);
		else
			System.out.println("Number A with value: " + A + " is greater than number B with value: " + B);
		
		B = (float) (B + 10.5);
		
		if( A > B )
			System.out.println("Number A with value: " + A + " is greater than number B with value: " + B);
		else
			System.out.println("Number A with value: " + A + " is greater than number B with value: " + B);
		
		
		//Write a program to check given number is even or odd. (Hint: use % operator).
		int iOdd = 3;
		int iEven = 4;
			
		if( iOdd % 2 == 0 ) System.out.println("Number 'iOdd' with value: " + iOdd + " is Even.");
			else System.out.println("Number 'iOdd' with value: " + iOdd + " is Odd.");
		
		if( iEven % 2 == 0 ) System.out.println("Number 'iEven' with value: " + iEven + " is Even.");
		else System.out.println("Number 'iEven' with value: " + iEven + " is Odd.");
		
	
	}

}
