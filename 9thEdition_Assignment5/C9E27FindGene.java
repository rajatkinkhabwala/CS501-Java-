/**
 * 
 * @author Rajat 
 * Purpose: This program prompts the user to enter a genome and displays all genes in the genome.
 * Date: Mar 22, 2016
 * 
 */

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class C9E27FindGene {
	static char[] genomeCharArray;
	static String endTriplet1 = "TAG";
	static String endTriplet2 = "TAA";
	static String endTriplet3 = "TGA";

	public static void main(String[] args) {
		boolean continueProgram = true;
		while (continueProgram) {
			JOptionPane.showMessageDialog(null,
					"This program displays all the genes in the given genome. \n\nNote: A gene is a substring of a genome that starts after a triplet ATG and ends before a triplet TAG, TAA, or TGA. \nBiologists use a sequence of the letters A, C, T, and G (Case sensitive) to model a genome.", "Program Description", JOptionPane.QUESTION_MESSAGE);
				String genome = JOptionPane.showInputDialog(null, "Enter the genome whose genes are to be found:", "Input", JOptionPane.QUESTION_MESSAGE);
			try {
				// String[] genes = new String[genome.length()];//Recheck later
				List<String> genesList = new ArrayList<String>();
				int genomeLength = genome.length();
				String genes = "";
				// This array consists of the string characters.
				genomeCharArray = new char[genome.length()];
				for (int i = 0; i < genomeLength; i++) {
					genomeCharArray[i] = genome.charAt(i);
				}
				boolean genomeValidate = genomeValidate(genomeLength);
				if(genomeValidate) {
					for (int i = 0; i < genomeLength; i++) {
						if (genomeCharArray[i] == 'A') {
							if ((i + 1) < genomeLength
									&& genomeCharArray[i + 1] == 'T') {
								if ((i + 2) < genomeLength
										&& genomeCharArray[i + 2] == 'G') {
									System.out.println("Calling findGene method");
									// i is the index where String 'ATG' is found.
									String gene = findGene(i + 2, genomeLength);
									//Adding the gene returned from the findGene() to the list.
									genesList.add(gene);
								}
							}
						}
					}

					for (int i = 0; i < genesList.size(); i++) {
						if (!genesList.get(i).isEmpty()) {
							genes = genesList.get(i) + ", " + genes;
						}
					}
				}
				if(!genomeValidate) {
					JOptionPane.showMessageDialog(null,
							"Incorrect input. Biologists use a sequence of the letters A, C, T, and G to model a genome.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				else if (genes.isEmpty())
					JOptionPane.showMessageDialog(null,
							"No gene is found in the given genome- '" + genome
									+ "'", "Result",
							JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null,
							"Below are the genes in the given genome - '" + genome
									+ "' \n" + genes, "Result",
							JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Exception Occured.",
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

	public static String findGene(int index, int genomeLength) {
		int n = 3;
		StringBuilder geneStringBuilder = new StringBuilder();
		;
		StringBuilder tripletStringBuilder;
		String gene = "";
		boolean continueCheck = true;
		while (continueCheck && (index + n + 3) < genomeLength) {
			
			tripletStringBuilder = new StringBuilder();
			String endTripletCheckString = tripletStringBuilder
					.append(genomeCharArray[index + n + 1])
					.append(genomeCharArray[index + n + 2])
					.append(genomeCharArray[index + n + 3]).toString();
			
			if (endTripletCheckString.equals(endTriplet1)
					|| endTripletCheckString.equals(endTriplet2)
					|| endTripletCheckString.equals(endTriplet3)) {
				
				for (int i = 0; i < n; i++) {
					geneStringBuilder.append(genomeCharArray[index + 1 + i]);
				}
				
				n = n + 3;
			} else
				n = n + 3;
			
			if (geneStringBuilder != null && geneStringBuilder.toString() != "") {
				System.out.println("geneStringBuilder: " + geneStringBuilder);
				gene = geneStringBuilder.toString();
			}
			// System.out.println("GENE: "+gene);
			if (gene.isEmpty() && n <= 100)
				continueCheck = true;
			else
				continueCheck = false;

			// System.out.println("continueCheck: "+continueCheck);
		}

		return gene;
	}
	
	public static boolean genomeValidate(int genomeLength){
		boolean isValid = true;
		for(int i = 0; i < genomeLength; i++){
			if(genomeCharArray[i] != 'A' && genomeCharArray[i] != 'C' && genomeCharArray[i] != 'T' && genomeCharArray[i] != 'G') {
				isValid = false;
			}
		}
		if(!isValid) return false;
		return true;
	}
}
