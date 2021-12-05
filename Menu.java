package hangmangame;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("What is the word type do you want to play?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(5, 10, 421, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Countries");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.category=("Countries");
				Controller.showMain();
				Controller.main.newGame();
			}
		});
		btnNewButton_1.setBounds(147, 77, 121, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Fruits and Vegetables");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.category = "Fruits and Vegetables";
				Controller.showMain();
				Controller.main.newGame();
			}
		});
		btnNewButton.setBounds(123, 108, 172, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Cinemas");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.category = "Cinemas";
				Controller.showMain();
				Controller.main.newGame();
			
			}
		});
		btnNewButton_2.setBounds(165, 139, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Random");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.category = "Random";
				Controller.showMain();
				Controller.main.newGame();
			}
		});
		btnNewButton_3.setBounds(165, 170, 85, 21);
		contentPane.add(btnNewButton_3);
	}
}

