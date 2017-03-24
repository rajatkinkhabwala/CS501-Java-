import javax.swing.JOptionPane;


/**
 * 
 * @author Rajat 
 * Purpose: To verify whether the given password is valid or invalid. 
 * Date: Mar 22, 2016
 */

public class C9E3CheckPassword {

	public static void main(String[] args) {
		String errorMessage = "";
		String programDescription = "This program validates the password given by the user. \n\nNote: \n1. The password should contain at least eight characters. \n2. The password consists of only letters and digits. \n3.The password should contain at least two digits.";
		boolean continueProgram = true;
		while (continueProgram) {
			JOptionPane.showMessageDialog(null, programDescription,
					"Program Description", JOptionPane.INFORMATION_MESSAGE);

			try {
				String password = JOptionPane.showInputDialog(null,
						"Please enter a password", "Input",
						JOptionPane.QUESTION_MESSAGE);
				String passwordValidation = isPasswordValid(password);
				if (passwordValidation == "InValid length") {
					errorMessage = "A password must have at least eight characters.";
					throw new Exception(errorMessage);
				} else if (passwordValidation == "InValid pattern") {
					errorMessage = "A password must contain only letters and digits.";
					throw new Exception(errorMessage);
				} else if (passwordValidation == "InValid digits") {
					errorMessage = "A password must contain at least two digits";
					throw new Exception(errorMessage);
				} else if (passwordValidation == "Valid") {
					JOptionPane.showMessageDialog(null,
							"Entered password is a valid password.", "Result",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Invalid Password.\n\n"
						+ "Error Message : " + ex.getMessage(), "Exception",
						JOptionPane.WARNING_MESSAGE);
			}
			// Ask user if the program needs to be re-executed.
			int confirmOption = JOptionPane.showConfirmDialog(null,
					"Do you want to repeat the program?",
					"Repeat confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmOption == 0)
				continueProgram = true;
			else
				continueProgram = false;
		}
	}

	private static String isPasswordValid(String password) {
		int count = 0, n = 0;
		
		if (password.length() < 8) {
			return "InValid length";
		} 
		else {
			for(int i=0;i<password.length();i++){
				if(password.charAt(i)>='0' && password.charAt(i)<='9'){
					count++;
				}
				else if((password.charAt(i)>='A' && password.charAt(i)<='Z') || (password.charAt(i)>='a' && password.charAt(i)<='z')){
					n++;
				}
				else{
					return "InValid pattern"; 
				}
			}
			if(count<2 || count == 0){
				return "InValid digits";
			}
			else if(count >=2 && n==password.length()-count)
			{
				return "Valid";
			}
			return "";
		}


	}

}
