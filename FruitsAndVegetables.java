package hangmangame;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FruitsAndVegetables extends RandomWord {

	
	Random rnd = new Random();	
	 String fruitAndVegetableWord;
	 Scanner sc;
	 List<String> fruitAndVegetableWords;
	 
	@Override
	public void getTxtFile() throws FileNotFoundException {
		 sc = new Scanner (new File ("C:\\Users\\ceycey\\Desktop\\category\\FruitsAndVeggiesWords.txt"));	
		 fruitAndVegetableWords = new ArrayList<>();
	}

	@Override
	public void createListOfArray()  {
		while (sc.hasNext()) {
			fruitAndVegetableWords.add(sc.nextLine());               
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
		fruitAndVegetableWord = fruitAndVegetableWords.get(rnd.nextInt(fruitAndVegetableWords.size()));
		return fruitAndVegetableWord;											// We get a random word for hangman game
	}
}

