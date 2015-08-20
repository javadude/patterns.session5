package com.javadude.fileclosing;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileClosingApp {
	// NOTE: THIS IS BAD (and will be bad for a while...)
	public static void main(String[] args) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("foo.txt");
			pw = new PrintWriter(fw);
			pw.println("Hello");
			pw.println("Goodbye");
			
		} catch (IOException e) {
			// DO SOMETHING MORE HERE IN REAL APPS...
			e.printStackTrace();

		} finally {
			if (pw != null)
				try {
					pw.close();
				} catch (Throwable t) {
					// DO SOMETHING MORE HERE IN REAL APPS...
					t.printStackTrace();
				}
			if (fw != null)
				try {
					fw.close();
				} catch (Throwable t) {
					// DO SOMETHING MORE HERE IN REAL APPS...
					t.printStackTrace();
				}
		}
	}
}
