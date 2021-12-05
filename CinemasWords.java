package hangmangame;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CinemasWords extends RandomWord {

	Random rnd = new Random();	
	 String CinemasWord;
	 Scanner sc;
	 List<String> CinemasWords;
	 
	@Override
	public void getTxtFile() throws FileNotFoundException {
		 sc = new Scanner (new File ("C:\\Users\\ceycey\\Desktop\\category\\CinemasWords.txt"));	
		 CinemasWords = new ArrayList<>();
	}

	@Override
	public void createListOfArray()  {
		while (sc.hasNext()) {
			CinemasWords.add(sc.nextLine());               
		}
	}

	@Override
	public String getRandomWord() {
		try {
			getTxtFile();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		createListOfArray();
		CinemasWord = CinemasWords.get(rnd.nextInt(CinemasWords.size()));
		return CinemasWord;											// We get a random word for hangman game
	}

	
	
}

