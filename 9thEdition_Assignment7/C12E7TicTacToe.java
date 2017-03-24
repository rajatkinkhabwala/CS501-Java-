
/**
 * Author: Rajat
 * Purpose: Tic-Tac-Toe game.
 * Date: 4.22.16
 */
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class C12E7TicTacToe {

	private static ImageIcon[] image = new ImageIcon[2];

	public static void main(String[] args) {

		// Setting up the x and o images.
		image[0] = new ImageIcon("image/x.gif");
		image[1] = new ImageIcon("image/o.gif");

		// Create a frame
		JFrame frame = new JFrame("Tic-Tac-Toe");
		frame.setLayout(new GridLayout(3, 3));

		for (int j = 0; j < 9; j++) {
			int val = (int) (Math.round(Math.random() * 1));
			JLabel square = new JLabel(image[val]);
			frame.add(square);
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
