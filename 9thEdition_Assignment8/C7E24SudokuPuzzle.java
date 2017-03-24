/**
 * Author: Rajat
 * Purpose: This program validates the given input Sudoku puzzle file.
 * Date: 5.12.16
 */
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class C7E24SudokuPuzzle {

	public static void main(String[] args) {

		Boolean rowError = false;
		Boolean colError = false;
		int row = 0, col = 0;
		int grid[][] = new int[9][9];
		boolean continueProgram = true;
		while(continueProgram) {
		JOptionPane.showMessageDialog(null, "This program validates the given input Sudoku puzzle file.", "Program Description", JOptionPane.INFORMATION_MESSAGE);
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Text file only", "txt");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File("\\"));
		int result = fileChooser.showOpenDialog(null);
		BufferedReader bufferReader = null;

		if (result == JFileChooser.APPROVE_OPTION) {
			String fileName = fileChooser.getSelectedFile().getPath();

			try {
				// Create object of FileReader
				FileReader inputFile = new FileReader(fileName);

				// Instantiate the BufferedReader Class
				bufferReader = new BufferedReader(inputFile);

				String line;
				String delims = "[ , ]";
				int i = 0;
				int array[] = new int[82];

				while ((line = bufferReader.readLine()) != null) {
					line = line.trim();
					for (String part : line.split(delims))
						array[i++] = Integer.parseInt(part);
				}
				array[i] = '\0';

				for (int k = 0; array[k] != '\0'; k++)
					grid[k / 9][k % 9] = array[k];

			} catch (Exception e) {
				JOptionPane.showMessageDialog(
						null,
						"Sorry, Try again.. Error while reading file:.\n"
								+ e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			try {
				// check if rows contain valid numbers 1-9
				for (int i = 0; i < 9; i++) {
					int k = 0;
					int[] digitList = new int[9];
					for (int j = 0; j < 9; j++) {
						// rowCheck += grid[i][j];
						digitList[k] = grid[i][j];
						k++;
					}
					if (!checkDigits(digitList)) {
						rowError = true;
						row = i + 1;
						 //System.out.println("row: "+row);
						 break;
						// JOptionPane.showMessageDialog(null,
						// "Sudoku entries are wrong in the Row# "+(i+1));
					}
				}

				// check if columns contain valid numbers 1-9
				for (int i = 0; i < 9; i++) {
					int k = 0;
					int column = 0;
					int[] digitList = new int[9];
					for (int j = 0; j < 9; j++) {
						// colCheck += grid[j][i];
						digitList[k] = grid[j][i];
						k++;
						column = j;
					}
					if (!checkDigits(digitList)) {
						colError = true;
						col = column + 1;
						 //System.out.println("col: "+col);
						 break;
						// JOptionPane.showMessageDialog(null,
						// "Sudoku entries are wrong in the Column# "+(i+1));
					}
				}

				if (rowError) {
					JOptionPane.showMessageDialog(null,
							"Sudoku entries are wrong at Row# " + row
									+ "Column# " + col, "Result", JOptionPane.ERROR_MESSAGE);
				} 
				else{
					JOptionPane.showMessageDialog(null,
							"Sudoku entries are valid.", "Result", JOptionPane.INFORMATION_MESSAGE);
				}
				/*else {

					int n = 1;
					int sumCheck = 0;
					while (n <= 7) {
						for (int i = n - 1; i < n + 2; i++) {
							int k = 0;
							int[] digitList = new int[9];
							for (int j = 0; j < 3; j++) {
								digitList[k] = grid[i][j];
								k++;
							}
							if (checkDigits(digitList)) {
								sumCheck++;
							}
						}

						// System.out.print("*");
						for (int i = n - 1; i < n + 2; i++) {
							int k = 0;
							int[] digitList = new int[9];
							for (int j = 3; j < 6; j++) {
								// System.out.print(grid[i][j]);
								digitList[k] = grid[i][j];
								k++;
							}
							if (checkDigits(digitList)) {
								sumCheck++;
							}
						}

						// System.out.print("**");
						for (int i = n - 1; i < n + 2; i++) {
							int k = 0;
							int[] digitList = new int[9];
							for (int j = 6; j < 9; j++) {
								// System.out.print(grid[i][j]);
								digitList[k] = grid[i][j];
								k++;
							}
							if (checkDigits(digitList)) {
								sumCheck++;
							}
						}
						System.out.println("sum check: " + sumCheck);
						if (sumCheck != 9) {
							// System.out.print("#####");
							JOptionPane
									.showMessageDialog(null,
											"Sudoku entries are wrong in the 3x3 boxes.");

						} else {
							// System.out.print("@@@@@@");
						}
						sumCheck = 0;
						n = n + 3;
					}
				}
				*/
			} catch (Exception exp) {
				JOptionPane.showMessageDialog(null, "Exception Occured.",
						"Exception", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if (result == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Cancelling the input.");
			System.exit(0);
		} else if (result == JFileChooser.ERROR_OPTION) {
			JOptionPane.showMessageDialog(null, "An error occurred.");
			System.exit(0);
		}
		//Ask user if the program needs to be re-executed.
		int confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to repeat the program?", "Repeat confirmation", JOptionPane.YES_NO_OPTION);
		if(confirmOption == 0)
			continueProgram = true;
		else
			continueProgram = false;
		}
	}

	public static boolean checkDigits(int checkArr[]) {
		// method to check whether a array list of 9 integers has numbers 1-9
		int[] temp = new int[checkArr.length];
		System.arraycopy(checkArr, 0, temp, 0, checkArr.length);
		// sort the copied array
		java.util.Arrays.sort(temp);
		// check that the sorted numbers are in sequential order 1+ for each
		for (int i = 0; i < 9; i++) {
			if (temp[i] != i + 1) {
				return false;
			}
		}
		return true;
	}

}