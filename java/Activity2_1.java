package com.sdet.JavaActivity2;

public class Activity2_1 {

	public static void main(String[] args) {
		// Initialize title of the book
		String title = "Tata Nexon";
		// Create object for MyBook
		Book newNovel = new MyBook();
		// Set title
		newNovel.setTitle(title);

		// Print result
		System.out.println("The title is: " + newNovel.getTitle());
	}

}

// Abstract class
abstract class Book {
	String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

class MyBook extends Book {
	// Define abstract method
	public void setTitle(String s) {
		this.title = s;
	}
}
