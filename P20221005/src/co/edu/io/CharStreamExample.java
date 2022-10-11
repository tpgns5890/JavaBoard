package co.edu.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamExample {
	public static void main(String[] args) {
		read();
	}

	public static void read() {

		try {
			FileReader reader = new FileReader("C:/temp/addr.txt");

			while (true) {
				int bytes = reader.read();
				System.out.println(bytes);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void write() {

		Scanner scn = new Scanner(System.in);
		try {
			FileWriter fw = new FileWriter("C:/temp/addr.txt");

			while (true) {
				System.out.print(">> ");
				String temp = scn.nextLine();
				if (temp.equals("quit"))
					break;

				fw.write(temp + "\n");
			}
			fw.close();
			scn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("completed");

	}
}
