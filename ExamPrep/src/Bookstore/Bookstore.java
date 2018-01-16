package Bookstore;

//import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Bookstore {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		
		//Book bookstore = new Book ();
		
		ArrayList<Book> listBook = new ArrayList<Book>();
		
		Book.run(listBook);
		
		Book math = new Book("Harry Potter", "JK Rowling", "1950", "20.99");
		
		listBook.add(math);
		
		Book math2 = new Book("Harry Potter2", "JK Rowling2", "19502", "20.992");
		
		listBook.add(math2);
		
		//bookstore.run();
	
	}

	
}
