package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1095, 847);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(168, 120, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton2 = new JButton("New button");
		btnNewButton2.setBounds(128, 120, 97, 23);
		contentPane.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("New button");
		btnNewButton3.setBounds(68, 120, 97, 23);
		contentPane.add(btnNewButton3);
	}

}
