import javax.swing.JOptionPane;

/**
 * @author Rajat
 * Purpose: Displays first 50 prime numbers under 1000 and  verifies whether the user given input number is prime or not. 
 * Date: Feb 27, 2016
 */
public class C5E10AndC6E6PrimeNumber {

	public static void main(String[] args) {
		boolean continueProgram = true;
		boolean continuePrimecheckProgram = true;
		String programDescription = "This program \n -  Displays the first 50 prime numbers under 1000 and \n -  Verifies whether the given number (must be less than 1000) is prime or not.";
		String first50Primes = "  ";
		int primesCount = 0;
		int[] primeNumbersArray = new int[168];

		while (continueProgram) {
			try {
				JOptionPane.showMessageDialog(null, programDescription,
						"Program Description", JOptionPane.INFORMATION_MESSAGE);
				int count = 0;
				int j = 0;
				for (int i = 2; i < 1000; i++) {
					if (isPrime(i)) {
						// Add to the array;
						primeNumbersArray[j] = i;
						j++;
						primesCount++;
						if (primesCount < 51) {
							first50Primes = first50Primes + " " + i + " ";
							count++;
						}
						if (count == 10) {
							first50Primes = first50Primes + '\n';
							count = 0;
						}
					}
				}
				JOptionPane.showMessageDialog(null,
						"First 50 primes under 1000 are: \n\n" + first50Primes,
						"First 50 primes", JOptionPane.INFORMATION_MESSAGE);
				//Repeat this loop for verifying input number is prime or not.
				while (continuePrimecheckProgram) {
					int primeCheck = Integer
							.parseInt(JOptionPane
									.showInputDialog(
											null,
											"Enter a number under 1000 to find if it is prime or not.",
											"Prime or not?",
											JOptionPane.QUESTION_MESSAGE));
					String divisors = "";
					for (int i = 0; i < primeNumbersArray.length; i++) {
						if (primeNumbersArray[i] == primeCheck) {
							divisors = "It is a prime number.";
						}
					}
					if (divisors == "") {
						divisors = "Number given is not prime. Prime factors of the number are: \n";
						for (int i = 0; i < primeNumbersArray.length; i++) {
							if ((primeCheck > primeNumbersArray[i])
									&& (primeCheck % primeNumbersArray[i] == 0)) {
								divisors = divisors + primeNumbersArray[i]
										+ '\n';
							}
						}
					}
					JOptionPane.showMessageDialog(null, divisors,
							"Prime check", JOptionPane.INFORMATION_MESSAGE);

					// Ask user if the program needs to be re-executed.
					int confirmPrimeCheckOption = JOptionPane
							.showConfirmDialog(null,
									"Do you want to verify another number?",
									"Prime check repeat - confirmation",
									JOptionPane.YES_NO_OPTION);
					if (confirmPrimeCheckOption == 0)
						continuePrimecheckProgram = true;
					else
						continuePrimecheckProgram = false;
				}
			} catch (Exception e) {
				// Display warning box if any exception occurs.
				JOptionPane
						.showMessageDialog(
								null,
								"Exception occured. Please try executing the program again with correct input.",
								"Exception", JOptionPane.WARNING_MESSAGE);
			}
			// Ask user if the program needs to be re-executed.
			int confirmOption = JOptionPane.showConfirmDialog(null,
					"Thank you! Do you want to repeat the program?",
					"Program repeat - confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmOption == 0)
				continueProgram = true;
			else
				continueProgram = false;
		}
	}

	// Check whether given input number is prime or not an return boolean.
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0) {
				return false; // Number not prime.
			}
		}
		return true; // Number is prime.
	}
}
