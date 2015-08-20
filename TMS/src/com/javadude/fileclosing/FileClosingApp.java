package com.javadude.fileclosing;

import java.io.FileWriter;
import java.io.PrintWriter;

public class FileClosingApp {
	// NOTE: THIS IS BAD (and will be bad for a while...)
	public static void main(String[] args) {
		Throwable pending = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("foo.txt");
			pw = new PrintWriter(fw);
			pw.println("Hello");
			pw.println("Goodbye");
			
		} catch (Throwable t) {
			pending = t;

		} finally {
			if (pw != null)
				try {
					pw.close();
				} catch (Throwable t) {
					if (pending == null)
						pending = t;
				}
			if (fw != null)
				try {
					fw.close();
				} catch (Throwable t) {
					if (pending == null)
						pending = t;
				}
			if (pending != null)
				throw new RuntimeException(pending);
		}
	}
}
