import javax.swing.JOptionPane;

/**
 * 
 * @author Rajat
 * Purpose: Program that prompts the user to enter the number of students and each student�s name and score, 
 * 			and finally displays the student with the highest score and the student with the second-highest score. 
 * Date: 2-17-2016
 */
public class C4E9TwoHighestScores {

	public static void main(String[] args) {
		int keyForTop = 0, keyForTop2 = 0;
		double highest = 0, secondHighest = 0;
		boolean continueProgram = true;
		String programDescription = "This program prompts the user to enter the number of students and each student�s name and score \nand finally displays the student with the highest score and the student with the second-highest score.";
		
			while(continueProgram) {
				try{				
						JOptionPane.showMessageDialog(null, programDescription, "Program Description", JOptionPane.INFORMATION_MESSAGE);
						
						//Get the number of students as input from user.
						int numberOfStudents = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of students: ", "User Input", JOptionPane.QUESTION_MESSAGE));
						
						String nameAndScoreInputDescription = "Enter the name and score for all the students separated by space.\nFor example: Peter 60 david 50...";
						
						//Get the name and score details of the students as input from user in a single string separated by spaces.
						String nameAndScores = JOptionPane.showInputDialog(null, nameAndScoreInputDescription, "Name and Score input", JOptionPane.INFORMATION_MESSAGE);
						
						String[] totalDetails = nameAndScores.split(" ");
						String studentNames[] = new String[numberOfStudents];
						double studentScores[] = new double[numberOfStudents];
						int j =0, k = 0;
						
						for(int i = 0; i < totalDetails.length; i++) {
							if(i % 2 == 0) {
								studentNames[j] = totalDetails[i];			
								j++;
							}
							else {
								studentScores[k] = Double.parseDouble(totalDetails[i]);			
								k++;
							}
						}
						
						//To get the first highest scorer.
						for(int i = 0; i < studentScores.length; i++){
							if(studentScores[i] > highest) {
								keyForTop = i;
								highest = studentScores[i];
							}	
						}
						//To get the second highest scorer.
						for(int i = 0; i < studentScores.length; i++){
							if((studentScores[i] > secondHighest) & (i != keyForTop)) {
								keyForTop2 = i;
								secondHighest = studentScores[i];
							}	
						}
						
						//Display the result of numbers.
						String result = "Student with highest score "+ highest+ " is " + studentNames[keyForTop] + '\n' + "Student with second highest score "+ secondHighest+ " is " + studentNames[keyForTop2];
						JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
						
				}
				catch(Exception e) {
					//Display warning box if any exception occurs.
					JOptionPane.showMessageDialog(null, "Exception occured. Please try executing the program again with correct input.", "Exception", JOptionPane.WARNING_MESSAGE);
				}
				//Ask user if the program needs to be re-executed.
				int confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to repeat the program?", "Repeat confirmation", JOptionPane.YES_NO_OPTION);
				if(confirmOption == 0)
					continueProgram = true;
				else
					continueProgram = false;
		}	
	}
}
