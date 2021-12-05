package hangmangame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Main extends JFrame {
	int spaceCount=0;
	private JPanel contentPane;
	private JTextField enteredGuessArea;
	String hiddenText;
	int mistakeCount=1;
	int trueCount=0;
	JLabel background = new JLabel("New label");
	JLabel findThisWord;
	String randomWord ;
	private JLabel guessedLetters;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Main() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel guessedLetters = new JLabel("Enter Your Guess");
		guessedLetters.setBounds(10, 226, 176, 27);
		contentPane.add(guessedLetters);
		
		enteredGuessArea = new JTextField();
		enteredGuessArea.setBounds(185, 228, 176, 23);
		contentPane.add(enteredGuessArea);
		enteredGuessArea.setColumns(10);
	
		findThisWord = new JLabel("");
		findThisWord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		findThisWord.setBounds(10, 167, 327, 35);
		contentPane.add(findThisWord);
		
		JButton guessButton = new JButton("New button");
		guessButton.setBounds(371, 227, 64, 24);
		contentPane.add(guessButton);
	
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 425, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		background.setIcon(new ImageIcon("background.jpeg"));
		background.setBounds(0, 0, 425, 147);
		panel.add(background);	
		
		guessedLetters = new JLabel("New label");
		guessedLetters.setBounds(347, 167, 88, 35);
		contentPane.add(guessedLetters);
		
		newGame();
		guessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				char c = enteredGuessArea.getText().charAt(0);
				enteredGuessArea.setText("");
				System.out.println(c);
				boolean f = false;				
				for(int i = 0; i < randomWord.length(); i++ ) {
					if(randomWord.charAt(i) == c) {
						hiddenText = hiddenText.substring(0,i) + c + hiddenText.substring(i+1);
						trueCount++;
						f = true;
						
					}
					if(trueCount==randomWord.length()-spaceCount) {
						break;
					}
				}
				if(trueCount==randomWord.length()-spaceCount) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "You won! Would You Like to Continue Your Game?","GameOver",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						newGame();
					}
					else {
						System.exit(0);
					}					
				}
				if(f==false&&mistakeCount==7) {					
                    background.setIcon(new ImageIcon(mistakeCount + ".jpg"));
                    panel.add(background);
                    mistakeCount++;
                    Controller controller = new Controller();
                    int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "You lost! Would You Like to Continue Your Game?","GameOver",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						controller.showMenu();
					}
					else {
						System.exit(0);
					}                    
			}				
				if(f==false) {
					
                        background.setIcon(new ImageIcon("" + mistakeCount + ".jpg"));
                        panel.add(background);
                        mistakeCount++;                                  
				}
				findThisWord.setText(hiddenText);				
			}
		});		
	}
	public void newGame() {
		spaceCount=0;
		RandomWord rw;
		background.setIcon(new ImageIcon("background.jpeg"));
		if(Controller.category.equalsIgnoreCase("Countries")) {
			rw = new CountriesWords();
		}
		else if(Controller.category.equalsIgnoreCase("Cinemas")) {
			rw = new CinemasWords();
		}
		else if(Controller.category.equalsIgnoreCase("Fruits and Vegetables")) {
			rw = new FruitsAndVegetables();
		}
		else {
			rw = new RandomWord();
		}
		this.randomWord = (rw.getRandomWord()).toLowerCase();
		
		hiddenText="";
		
		for(int i = 0; i<randomWord.length(); i++) {
			if(randomWord.charAt(i)==' ') {
				hiddenText+=" ";
				spaceCount++;
			}
			else {
				hiddenText+="*";
			}		
		}		
		findThisWord.setText(hiddenText);
		System.out.println("Bilinmesi gereken kelime " + randomWord);
		trueCount=0;
		mistakeCount=1;
	}
}
