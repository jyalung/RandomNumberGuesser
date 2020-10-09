import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		Scanner yn = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		
		int x = RNG.rand();
		int guess = 0;
		int lowguess = 0;
		int highguess = 100;
		
		String r = "";
		String yesNo = "";
		
		
		System.out.println(x);
		System.out.print("Enter your first guess: ");
		guess = input.nextInt();
		RNG.inputValidation(guess, lowguess, highguess);
		System.out.println("Number of guesses is " + RNG.getCount());
		
		do {
			
			if(guess > x) {
				System.out.println("Your guess is too high");
				RNG.inputValidation(guess, lowguess, highguess);
				if(guess < highguess) {
					highguess = guess;
				}
				System.out.print("Enter your next guess between " + lowguess + " and " + highguess + " ");
				guess = input.nextInt();
				System.out.println("Number of guesses is " + RNG.getCount());
			
			} else if(guess < x) {
				System.out.println("Your guess is too low");
				RNG.inputValidation(guess, lowguess, highguess);
				if(guess > lowguess) {
					lowguess = guess;
				}
				System.out.print("Enter your next guess between " + lowguess + " and " + highguess + " ");
				guess = input.nextInt();
				System.out.println("Number of guesses is " + RNG.getCount());
			
			} 
			
		} while(guess != x);
		
		
				
		System.out.println("Congratulations, you guessed correctly");
		System.out.print("Try again? (yes or no) ");
		r = yn.nextLine();
		yesNo = r.toLowerCase();
		while(!(yesNo.charAt(0) == 'y') && !(yesNo.charAt(0) == 'n')) {
			System.out.println("Congratulations, you guessed correctly");
			System.out.print("Try again? (yes or no) ");
			r = yn.nextLine();
			yesNo = r.toLowerCase();
		}
		if((yesNo.charAt(0) == 'y')) {
			playAgain(guess, r);
		}
		System.out.println("Thanks for playing...");
		yn.close();
		input.close();
	}
	
	public static void playAgain(int otherGuess, String again) {
		Scanner yn = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		int x = RNG.rand();
		RNG.resetCount();
		
		otherGuess = 0;
		int lowguess = 0;
		int highguess = 100;
		
		again = "";
		String yesNo = "";
		
		System.out.println(x);
		System.out.print("Enter your first guess: ");
		otherGuess = input.nextInt();
		RNG.inputValidation(otherGuess, lowguess, highguess);
		System.out.println("Number of guesses is " + RNG.getCount());
		
		do {
			if(RNG.getCount() == 0) {
				System.out.println(x);
				System.out.print("Enter your first guess: ");
				otherGuess = input.nextInt();
				RNG.inputValidation(otherGuess, lowguess, highguess);
				System.out.println("Number of guesses is " + RNG.getCount());
			}
			do {
				if(otherGuess > x) {
					System.out.println("Your guess is too high");
					RNG.inputValidation(otherGuess, lowguess, highguess);
					if(otherGuess < highguess) {
						highguess = otherGuess;
					}
					System.out.print("Enter your next guess between " + lowguess + " and " + highguess + " ");
					otherGuess = input.nextInt();
					System.out.println("Number of guesses is " + RNG.getCount());
				} else if(otherGuess < x) {
					System.out.println("Your guess is too low");
					RNG.inputValidation(otherGuess, lowguess, highguess);
					if(otherGuess > lowguess) {
						lowguess = otherGuess;
					}
					System.out.print("Enter your next guess between " + lowguess + " and " + highguess + " ");
					otherGuess = input.nextInt();
					System.out.println("Number of guesses is " + RNG.getCount());
				}
			} while (otherGuess != x);
			
			System.out.println("Congratulations, you guessed correctly");
			System.out.print("Try again? (yes or no) ");
			again = yn.nextLine();
			yesNo = again.toLowerCase();
			while(!(yesNo.charAt(0) == 'y') && !(yesNo.charAt(0) == 'n')) {
				System.out.println("Congratulations, you guessed correctly");
				System.out.print("Try again? (yes or no) ");
				again = yn.nextLine();
				yesNo = again.toLowerCase();
			}
			x = RNG.rand();
			RNG.resetCount();
		} while(yesNo.charAt(0) == 'y');
		
		
		yn.close();
		input.close();
	}
}
