package com.javadude.fileclosing;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileClosingApp {
	// NOTE: THIS IS BAD (and will be bad for a while...)
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("foo.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Hello");
			pw.println("Goodbye");
			pw.close();
			
		} catch (IOException e) {
			// DO SOMETHING MORE HERE IN REAL APPS...
			e.printStackTrace();
		}
	}
}
