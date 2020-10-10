import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args)
	{
		String r = "";
		
		Scanner input = new Scanner(System.in);       
		int guess, highGuess, lowGuess;          
		int randNum;                                 

		do{
			highGuess = 100;
			lowGuess = 0;
			
			new RNG(); 
			RNG.resetCount(); // resets the number of guesses
			
			randNum = RNG.rand();
			System.out.print("Enter your first guess ");
			guess = input.nextInt();
			
			while (guess != randNum){
				boolean checker = true;
				checker = RNG.inputValidation(guess, lowGuess, highGuess);
				
				if(!checker){ // Repeats the question until the user inputs a number in the range
					guess = input.nextInt();
					continue;
				}
				
				System.out.println("Number of guesses is " + RNG.getCount());
				
				if(guess > randNum){ //Gives the user a hint that their guess is too high
					System.out.println("Your guess is too high");
					highGuess = guess;
				}
				
				else if(guess < randNum){ //Gives the user a hint that their huess is too low
					System.out.println("Your guess is too low");
					lowGuess = guess;
				}
				
				System.out.print("Enter your next guess between " + lowGuess + " and " + highGuess + " "); //Shows the range
				guess = input.nextInt();
			}
			
			new RNG();
			System.out.println("Number of guesses is " + RNG.getCount());
			System.out.println("Congratulations, you guessed correctly");
			System.out.print("Try again? (yes or no) ");
			input.nextLine();
			r = input.nextLine();
			
			while(!r.equals("yes") && !r.equals("YES") && !r.equals("Yes") && !r.equals("yEs") && !r.equals("yeS") && !r.equals("YEs") && !r.equals("YeS") && !r.equals("yES") && !r.equals("no") && !r.equals("NO") && !r.equals("No") && !r.equals("nO")){
				System.out.println("Congratulations, you guessed correctly");
				System.out.print("Try again? (yes or no) ");
				r = input.nextLine();
			} // Repeats the question until the user answers yes or no while ignoring cases
			
		}while(r.equals("yes") || r.equals("YES") || r.equals("Yes") || r.equals("yEs") || r.equals("yeS") || r.equals("YEs") || r.equals("YeS") || r.equals("yES"));
		
		System.out.println("Thanks for playing...");
		input.close();
	}
}
