/**
 * Author: Rajat
 * Purpose: To show 2 panels (Use a GridLayout of two rows and three columns for the frame),
 * 			 with 3 each buttons on a Frame.
 * Date: 4.22.16
 */
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class C12E3GridLayout {

	public static void main(String[] args) {
		// Create a frame
		JFrame frame = new JFrame("BorderLayout");
		frame.setLayout(new GridLayout(2, 3));
		frame.add(new JButton(" Button 1 "));
		frame.add(new JButton(" Button 2 "));
		frame.add(new JButton(" Button 3 "));
		frame.add(new JButton(" Button 4 "));
		frame.add(new JButton(" Button 5 "));
		frame.add(new JButton(" Button 6 "));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
