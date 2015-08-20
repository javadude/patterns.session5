package com.javadude.fileclosing;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileClosingApp {
	public static void main(String[] args) {
		new AutoCloser() {
			@Override protected void doWork() throws Throwable {
				FileWriter fw = autoClose(new FileWriter("foo.txt"));
				PrintWriter pw = autoClose(new PrintWriter(fw));
				pw.println("Hello");
				pw.println("Goodbye");
			}};
			
		// or without the intermediate FileWriter variable
		new AutoCloser() {
			@Override protected void doWork() throws Throwable {
				PrintWriter pw = 
						autoClose(new PrintWriter(
								autoClose(new FileWriter("foo.txt"))));
				pw.println("Hello");
				pw.println("Goodbye");
			}};
			
			
		// IN JAVA 7 (AND ANDROID MIN API 19 [KitKat]) AND BEYOND
		// I haven't yet found a formatting style I like for this...
		try (
			FileWriter fw = new FileWriter("foo.txt");
			PrintWriter pw = new PrintWriter(fw);
			) {
				pw.println("Hello");
				pw.println("Goodbye");
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
}
