package introduction;

public class Variables {

	public static void main(String[] args) {
		int firstNumber;
		firstNumber = 0;
		int secondNumber = 5;
		double sum = (double)firstNumber / secondNumber;
		System.out.println(sum);
		String firstName = "Petar";
		String lastName = "Petrovic";
		//System.out.println(firstName+(firstNumber+secondNumber));
		char space = ' ';
		System.out.println(firstName+space+lastName+" Njegos");
		
		if(firstNumber > 0) 
			System.out.println("Broj je pozitivan!");
		else if(firstNumber<0)
			System.out.println("Broj je negativan!");
		else
			System.out.println("Broj je nula!");
		
		System.out.println("While od 1 do 10");
		int i = 1;
		while(i<11) {
			System.out.println(i);
			i++;
		}
		
		System.out.println("While od 8 do 3");
		i = 8;
		while(i>2) {
			System.out.println(i);
			i--;
		}
		
		System.out.println("While faktorijel broja 5");
		
		int factorialNumber=5;
		int factorial=1;
		i=1;
		while(i<=factorialNumber) {
			factorial *= i;
			i++;
		}
		System.out.println("Faktorijel broja " + factorialNumber + " je " + factorial);
		
		System.out.println("Do while faktorijel broja 5");
		
		i=1;
		factorial = 1;
		factorialNumber = 5;
		do {
			factorial *= i;
			i++;
		}while(i<=factorialNumber);
		System.out.println("Faktorijel broja " + factorialNumber + " je " + factorial);
		
		System.out.println("pomocu for 3 do 8");
		for(i=3;i<9;i++)
			System.out.println(i);
		
		System.out.println("pomocu for parne brojeve 1 do 11");
		
		for(i=0;i<11;i++)
			if(i%2==0)
				System.out.println("Broj "+i+" je paran");
	}

}
