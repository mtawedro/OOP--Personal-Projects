package Bookstore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Book {

	String title;
	String author; 
	String year;
	String price;
	
	public Book(String title, String author, String year, String price)
	{
		this.title = title;
		this.author = author; 
		this.year = year;
		this.price = price;
		
		//return ;
		
		
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public static void hello()
	{
		
		
		
	}
	
	
	public static void run(ArrayList<Book> listBook)
	{
		
		BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
		 
		hello();
		//b1.year = 11;
		
		int x;
		int countBooks=0;
		int i = 0;
		
		System.out.println("1. Add a unique book to the inventory");
		System.out.println("2. Print out information on each book");
		System.out.println("3. Print out all unique authors");
		System.out.println("4. Print out the average book price, along with the total number of books");
		System.out.println("5. Quit");
		

		System.out.println("Enter in a Number: 1-5\n");
			
		x = Integer.parseInt(myinput.readLine());	
		
		Scanner user = new Scanner (System.in);
		
		String input;
		
		//ArrayList<String> listBook = new ArrayList<String>(20);
	
		
		while(x!=5)
		{
			switch(x)
			{
		
				case 1:
				{
				
					/*
					System.out.println("Enter Title");
			   
					input = user.nextLine();
			   
		
					listBook.add(input);
				
			   
				
				System.out.println("Enter Author");
			   
			   input = user.nextLine();
			   
			   listBook.add(input);
			   
			   System.out.println("Enter year");
			   
			   input = user.nextLine();
			   
			   listBook.add(input);
			   
			   System.out.println("Enter price");
			   
			   input = user.nextLine();
			   
			   listBook.add(input);
   
			   */
			    //b1 = new Book( listBook.get(0), listBook.get(1), listBook.get(2), listBook.get(3));
			   
			    //store all objects in new array print each object
			    //System.out.println(b1);
			   /* 
			   System.out.println(b1.title);
			    System.out.println(b1.author);
			    System.out.println(b1.year);
			    System.out.println(b1.price);
			    */
			    countBooks++;
			 
			
				break;
			}
		
			case 2:
			{
				
				while(i<countBooks)
				{
					System.out.println("insdie while"); 
					
					   /*
						System.out.println(b1.title);
					    System.out.println(b1.author);
					    System.out.println(b1.year);
					    System.out.println(b1.price);
					 */
					
					i++;
				}
				
				break;
			}
		
	
		
		
		
		}

		System.out.println("Enter in a Number: 1-5\n");
		
		x = Integer.parseInt(myinput.readLine());
	}

	
	
		
		
		
		
		
		
	}
	
	
}

