package co.edu.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class WordAryApp {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
//		 임의 문장을 10개씩 출력하고 타이핑해서 맞으면 사라지고...
		ArrayList<String> words = randomWords(10);
		for(String word : words) {
			System.out.println(word);
		}
//		for(String word : words) {
//			System.out.println(word);
//		}
		
		//하나씩 찾아서 지우기
		String inputVal = scn.nextLine();
		if(words.get(i).equals(inputVal)) {
			words.remove(i);
		}
		if(words.isEmpty()) {
			break;
		}
		
	}
	
	public static ArrayList<String> randomWords(int times) throws Exception {
		ArrayList<String> words = new ArrayList<String>();
		String path = "src/co/edu/io/wordAry.txt";
			File file = new File(path);
			Scanner scn = new Scanner(file);
			
			while(scn.hasNext()) {
				String readStr = scn.nextLine();
				readStr = readStr.replaceAll("\"","").trim();
				words.add(readStr.substring(0, readStr.indexOf(",")));
			}
			
			ArrayList <String> randomWords = new ArrayList<String>();
			for(int i=0; i<10;i++) {
				randomWords.add(words.get((int) (Math.random()*495)));
			}
			words = randomWords;
			Set<Integer> idxSet = new hashSet<>();
			while (idxSet.size()<times) {
				idxSet.add((int) (Math.random()* words.size()));
			}
			
			scn.close();
			return words;
		
	}
}
