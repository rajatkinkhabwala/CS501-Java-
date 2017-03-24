/**
 * Author: Rajat
 * Purpose: To show 2 panels (Place one panel in the south of the frame and the other in the center), 
 * 			 with 3 each buttons on a Frame.
 * Date: 4.22.16
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class C12E2BorderLayout {

	public static void main(String[] args) {
		// Create two panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());

		// Add three buttons to each panel
		panel1.add(new JButton(" Button 1 "));
		panel1.add(new JButton(" Button 2 "));
		panel1.add(new JButton(" Button 3 "));
		panel2.add(new JButton(" Button 4 "));
		panel2.add(new JButton(" Button 5 "));
		panel2.add(new JButton(" Button 6 "));

		// Create a frame
		JFrame frame = new JFrame("BorderLayout");
		frame.setLayout(new BorderLayout());

		// Add panels to frame - Flow layout
		frame.add(panel1, BorderLayout.SOUTH);
		frame.add(panel2, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);;
		frame.setVisible(true);
	}
}
