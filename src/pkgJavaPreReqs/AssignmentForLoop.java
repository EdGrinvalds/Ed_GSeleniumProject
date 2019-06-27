package pkgJavaPreReqs;

public class AssignmentForLoop {

	public static void main(String[] args) {
		
		//Write a program to print 10 even numbers and 10 odd numbers.
		
		int iEven = -6;
		int iOdd = -3;
		
		for( int i = 1; i <= 10 ; i++ ) {
			System.out.println("Printing even number " + i + ": " + iEven);
			iEven = iEven + 2;
		}
			
		for( int i = 1; i <= 10 ; i++ ) {
			System.out.println("Printing odd number " + i + ": " + iOdd);
			iOdd = iOdd + 2;
		}
		
		
		//Write a program to find factorial of a number.
		
		int iFactorial = 5;
		int iSubTotal = 1;

		for( int i = 1; i <= iFactorial ; i++) {
			iSubTotal = iSubTotal * i;
			
			System.out.println("Current factorial subtotal of " + iFactorial + " is: " + iSubTotal);
		}
		System.out.println("Factorial of: " + iFactorial + ": " + iSubTotal);
		
		
		//Write a program to add the digits of a number.
		//Will not work if integer is more than 1000 digits in length
		//The assignment is to use a for statement. This sum of digits is better implemented with a while statement.
        
		int iSum = 0;
		int iNum = 432;
		int iStoreInitNum = 0;
        
		iStoreInitNum = iNum;
		
        for (int i = 1; i <= 1000; i++) {
        	iSum = iSum + iNum % 10;
        	iNum = iNum / 10;
        	System.out.println("Current subtotal sum of the total of digits in the number " + iStoreInitNum + " is:" + iSum); 
        	if(iNum <= 0) break;
        }
        System.out.println("Sum of the total of digits in the number " + iStoreInitNum + " is:" + iSum); 
        
        
        //Write a program to reverse the digits of a number.
        //Will not work if integer is more than 1000 digits in length
      	//The assignment is to use a for statement. This reversal of digits is better implemented with a while statement.
              
      	int iReversed = 0;
      	int iNumToReverse = 1234;
      	int iStoreInitNumOfNumToReverse = 0;
              
      	iStoreInitNumOfNumToReverse = iNumToReverse;
      		
        for (int i = 1; i <= 1000; i++) {
        	int iDigit = iNumToReverse % 10;
        	iReversed = iReversed * 10 + iDigit;
        	iNumToReverse = iNumToReverse / 10;
        	System.out.println("Current reversed digits of the number " + iStoreInitNumOfNumToReverse + " is:" + iReversed); 
        	if(iNumToReverse <= 0) break;
        }
        System.out.println("Final reversed digits of the number " + iStoreInitNumOfNumToReverse + " is:" + iReversed); 
        
	}

}
