/**
 * 
 * @author Rajat
 * Purpose: To count the no.of characters, words and lines in the given file. 
 * Date: Mar 25, 2016
 */

import java.io.*;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class C14E13CountCharsWordsLines {
	public static void main(String[] args) throws IOException {
		boolean continueProgram = true;
		String programDescription = "This program displays the number of characters, words, and lines in the given file.";
		while (continueProgram) {
			int chars = 0, words = 0, lines = 0;
			Scanner fileScanner = null;
			File selectedFile = null;
			JFileChooser chooser = new JFileChooser();
			JOptionPane.showMessageDialog(null, programDescription,
					"Program Description", JOptionPane.INFORMATION_MESSAGE);
			try {
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					selectedFile = chooser.getSelectedFile();
					fileScanner = new Scanner(selectedFile);
				}
				while (fileScanner.hasNextLine()) {
					lines++;
					String line = fileScanner.nextLine();
					Scanner lineScanner = new Scanner(line);
					while (lineScanner.hasNext()) {
						words++;
						String word = lineScanner.next();
						chars += word.length();
					}
					lineScanner.close();
				}
				JOptionPane.showMessageDialog(null, "The File you selected is "
						+ selectedFile.getAbsolutePath() + "\nLines=" + lines
						+ "\nWords=" + words + "\nCharacter=" + chars);
				fileScanner.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "The File Does not Exists.");
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Exception occured.", "Exception",
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
}
