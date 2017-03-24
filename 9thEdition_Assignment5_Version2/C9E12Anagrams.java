import javax.swing.JOptionPane;

/**
 * 
 * @author Rajat
 * Purpose: To check whether two given words are Anagrams or not.
 * Date: Mar 22, 2016
 */
public class C9E12Anagrams {

	public static void main(String[] args) {

		String programDescription = "This program verifies whether the given two words are anagrams or not. \n\n Note: Two words are anagrams if they contain the same letters in any order. \n For example, SILENT and LISTEN are anagrams.";
		boolean continueProgram = true;
		while (continueProgram) {
			JOptionPane.showMessageDialog(null, programDescription,
					"Description", JOptionPane.INFORMATION_MESSAGE);
			String input = JOptionPane.showInputDialog(null,
					"Enter the two words separated with spaces.", "Input",
					JOptionPane.QUESTION_MESSAGE);

			try {
				String[] inputsArray = input.split(" ");
				String firstWord = inputsArray[0];
				String secondWord = inputsArray[1];
				boolean isAnagram = isAnagram(firstWord, secondWord);

				if (isAnagram) {
					JOptionPane.showMessageDialog(null, "Given two words '"
							+ firstWord + "' and '" + secondWord
							+ "' are Anagrams.", "Result",
							JOptionPane.INFORMATION_MESSAGE);
				} else
					JOptionPane.showMessageDialog(null, "Given two words '"
							+ firstWord + "' and '" + secondWord
							+ "' are not Anagrams.", "Result",
							JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Exception occured in program execution. Please re-try.",
						"Exception", JOptionPane.WARNING_MESSAGE);
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

	public static boolean isAnagram(String s1, String s2) {
		int count = 0;
		char[] firstCharArray = new char[s1.length()];
		char[] secondCharArray = new char[s2.length()];

		for (int i = 0; i < s1.length(); i++) {
			firstCharArray[i] = s1.charAt(i);
		}
		for (int i = 0; i < s2.length(); i++) {
			secondCharArray[i] = s2.charAt(i);
		}
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (firstCharArray[i] == secondCharArray[j]) {
					count++;
					break;
				}
			}
		}
		//System.out.println(count);
		if (count == s1.length() && count == s2.length()) {
			return true;
		} else
			return false;
	}
}
