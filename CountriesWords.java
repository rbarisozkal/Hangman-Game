package hangmangame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CountriesWords extends RandomWord {

	 Random rnd = new Random();	
	 String CountriesWord;
	 Scanner sc;
	 List<String> CountriesWords;
	 
	@Override
	public void getTxtFile() throws FileNotFoundException {
		 sc = new Scanner (new File ("C:\\Users\\ceycey\\Desktop\\category\\CountriesWords.txt"));	
		 CountriesWords = new ArrayList<>();
	}

	@Override
	public void createListOfArray()  {
		while (sc.hasNext()) {
			CountriesWords.add(sc.nextLine());               
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
		CountriesWord = CountriesWords.get(rnd.nextInt(CountriesWords.size()));
		return CountriesWord;											// We get a random word for hangman game
	}
}

