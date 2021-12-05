package hangmangame;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomWord {

	 Random rnd = new Random();	
	 String word;
	 Scanner sc;
	 List<String> words;
	 
	public void getTxtFile() throws FileNotFoundException{
											// We uploaded our file back to our java program just to find any word from .txt file
		 sc = new Scanner (new File ("C:\\Users\\ceycey\\Desktop\\category\\FruitsAndVeggiesWords.txt"));	
		 words = new ArrayList<>();
	}
		
	
	
	
	public void createListOfArray() {
		 													// We upload our each word to a list of array to get them as a random
			while (sc.hasNext()) {
				words.add(sc.nextLine());               
			}
			
	}
	public String getRandomWord()   {
		
		try {
			getTxtFile();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		createListOfArray();
		word = words.get(rnd.nextInt(words.size()));
		return word;						// We get a random word for hangman game
	}
	
}

