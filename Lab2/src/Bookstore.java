
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * @author Martina
 */
@SuppressWarnings("unused")
class Bookstore {
	

	
      static Scanner input = new Scanner(System.in);
    
      public static void run() throws NumberFormatException, IOException {
    
      BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
    	
      int choice = 0;
      ArrayList<Book> books = new ArrayList<Book>();
      
      System.out.println("1. Add a unique Textbook or Workbook to the inventory");
      System.out.println("2. Print out information on each Book");
      System.out.println("3. Print out all unique authors");
      System.out.println("4. Print out the average book price, along with the total number of Books");
      System.out.println("5. Print out all Textbook-Workbook pairs in the inventory");
      System.out.println("6. Save the state of the inventory to a file");
      System.out.println("7. Load the state of the inventory from a file");
      System.out.println("8. Quit");
     
        
      System.out.println("Enter Choice");
      choice = Integer.parseInt(myinput.readLine());
      String user;
    
  
      int count = 0; 
      int workbook =0;
      int textbook = 0;
       
        while(choice != 8)
        {
            switch(choice)
            {
               
                case 1:
                {
                	 	System.out.println("1. Add unique Book (B), Textbook (T) or Workbook (W) to the inventory");
                		user = input.nextLine();
                		
                		while(user.equalsIgnoreCase("B") == false && user.equalsIgnoreCase("T") == false && user.equalsIgnoreCase("W") == false )
    					{
                			System.out.println("Invalid: Add unique Book (B), Textbook (T) or Workbook (W) to the inventory");
    						
    						user = input.nextLine();
    					}
                		
                		if(user.equalsIgnoreCase("B"))
                		{
                    
                			BookC(books,user,count);
                		}
            
                		else if(user.equalsIgnoreCase("T"))
                		{
                	
                			TextbookC(books,user,count);
                
                		}
                
                		else if(user.equalsIgnoreCase("W"))
                		{
                	
                     
                			WorkbookC(books,user,count);
                	
                		}
                
                		break;
               
                }
                
                case 2:
                {
                    printBooks(books);
                   
                    break;
                }
                case 3:
                {
                    printAuthors(books);
                    
                    break;
                }
                case 4:
                {
                    averagePrice(books);
                    
                   break;
                }
                
                case 5:
                {
                	compareWork(books, workbook, textbook);
                	
                	break;
                }
          
                case 6:
                {
                	FileIO(books);
                	
                	break;
                }
            
                case 7:
                {
                	LoadFileIO(books);
                	
                	break;
                }
            
                default :
                {
                	System.out.println("Invalid Input");
                }
            }
       
            System.out.println("Enter Choice");
            choice = Integer.parseInt(myinput.readLine());
        
        
        }
        
        seperator();
        
        System.out.println("Goodbye!");
    }
    

    
    private static void seperator(){
        System.out.println("____________________________________\n");
    }
    
    public static void BookC(ArrayList<Book> books, String user, int count) throws NumberFormatException, IOException
    {
    
    BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
   

    String tempTitle = "";
    double tempPrice = 0;
    String tempAuthor = "";
    String tempIsbn = "";

    int tempYear;
    
   
    
    System.out.println("Enter new book details\n");
    
    
    System.out.println("Enter Title: ");
    tempTitle = input.nextLine();
    
    while(tempTitle.length() == 0)
    {
   	 System.out.println("Invalid Input");
   	 System.out.println("Enter Title: ");
        tempTitle = input.nextLine();
    }
    
    
    System.out.println("Author: ");
    tempAuthor= input.nextLine();
    
    while(tempAuthor.length() == 0)
    {
   	 System.out.println("Invalid Input");
   	 System.out.println("Enter Author: ");
   	 tempAuthor = input.nextLine();
    }
    
   
    System.out.println("ISBN: ");
    tempIsbn = input.nextLine();
   
    while(tempIsbn.length() != 13 && tempIsbn.length() != 10 )
    {
   	 System.out.println("Invalid Input ( Must be 10 or 13 characters wrong)");
   	 System.out.println("Enter ISBN: ");
   	 tempIsbn = input.nextLine();
    }
    
            
    System.out.println("Publishing Year - ");
    tempYear = Integer.parseInt(myinput.readLine());
   
    while(tempYear < -2600 || tempYear > 2017 )
    {
   	 System.out.println("Invalid Input ( Must be between yrs -2600 and 2017)");
   	 System.out.println("Enter Publishing Year: ");
   	 tempYear = Integer.parseInt(myinput.readLine());
    }
    
   
    System.out.println("Price: ");
    tempPrice = Double.parseDouble(myinput.readLine());
   
    while(tempPrice < 0.0 )
    {
   	 System.out.println("Invalid Input");
   	 System.out.println("Enter Price: ");
   	 tempPrice = Double.parseDouble(myinput.readLine());
   	    
    }
 
	
 
    Book temp = new Book(  tempTitle, tempAuthor, tempIsbn,  tempYear, tempPrice);
	
    if(books.contains(temp)){
        System.out.println("This book already exists");
       
        BookC(books,user,count);
    }else{
    	 
    	books.add(count,temp);
 		
 		count ++;
    }
    
   
}

    public static void TextbookC(ArrayList<Book> books, String user, int count) throws NumberFormatException, IOException
    {
    

     BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
    
     String sub;
	 String work;
     String tempTitle = "";
     double tempPrice = 0;
     String tempAuthor = "";
     String tempIsbn = "";

     int tempYear;
	
	System.out.println("Enter Subject");
	sub = input.nextLine();
	
	while(sub.length() == 0)
    {
   	 System.out.println("Invalid Input");
   	 System.out.println("Enter Subject: ");
        sub = input.nextLine();
    }
	
	System.out.println("Enter workbook ISBN");
	work = input.nextLine();
	
	while(work.length() != 13 && work.length() != 10 )
    {
   	 System.out.println("Invalid Input ( Must be 10 or 13 characters wrong)");
   	 System.out.println("Enter workbook ISBN: ");
   	 work = input.nextLine();
    
    }
	
   
    // System.out.println("Enter new book details\n");
     
         
     System.out.println("Enter Title: ");
     tempTitle = input.nextLine();
     
     while(tempTitle.length() == 0)
     {
    	 System.out.println("Invalid Input");
    	 System.out.println("Enter Title: ");
         tempTitle = input.nextLine();
     }
     
     
     System.out.println("Author: ");
     tempAuthor= input.nextLine();
     
     while(tempAuthor.length() == 0)
     {
    	 System.out.println("Invalid Input");
    	 System.out.println("Enter Author: ");
    	 tempAuthor = input.nextLine();
     }
     
    
     System.out.println("ISBN: ");
     tempIsbn = input.nextLine();
    
     while(tempIsbn.length() != 13 && tempIsbn.length() != 10 )
     {
    	 System.out.println("Invalid Input ( Must be 10 or 13 characters wrong)");
    	 System.out.println("Enter ISBN: ");
    	 tempIsbn = input.nextLine();
     }
     
             
     System.out.println("Publishing Year - ");
     tempYear = Integer.parseInt(myinput.readLine());
    
     while(tempYear < -2600 || tempYear > 2017 )
     {
    	 System.out.println("Invalid Input ( Must be between yrs -2600 and 2017)");
    	 System.out.println("Enter Publishing Year: ");
    	 tempYear = Integer.parseInt(myinput.readLine());
     }
     
    
     System.out.println("Price: ");
     tempPrice = Double.parseDouble(myinput.readLine());
    
     while(tempPrice < 0.0 )
     {
    	 System.out.println("Invalid Input");
    	 System.out.println("Enter Price: ");
    	 tempPrice = Double.parseDouble(myinput.readLine());
    	    
     }
  
	
	Textbook tempText = new Textbook( sub, work, tempTitle, tempAuthor, tempIsbn,  tempYear, tempPrice);
	 
	 if(books.contains(tempText)){
	        System.out.println("This book already exists");
	        TextbookC(books,user,count);
	    }else{
	    	 
	    	books.add(count,tempText);
	 		
	 		count ++;
	    }
		
    }
    
   
    
    public static void WorkbookC(ArrayList<Book> books, String user, int count) throws NumberFormatException, IOException
    {
    

    BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
    
    
    int numPro;
    String tempTitle = "";
    double tempPrice = 0;
    String tempAuthor = "";
    String tempIsbn = "";

    int tempYear;
    
	
	System.out.println("Enter Number of problems");
	
	numPro = Integer.parseInt(myinput.readLine());
	
	 while(numPro < 0 )
     {
    	 System.out.println("Invalid Input");
    	 System.out.println("Enter Number of problems: ");
    	 numPro = Integer.parseInt(myinput.readLine());
    	    
     }
	
    
    // System.out.println("Enter new book details\n");
     
     
     System.out.println("Enter Title: ");
     tempTitle = input.nextLine();
     
     while(tempTitle.length() == 0)
     {
    	 System.out.println("Invalid Input");
    	 System.out.println("Enter Title: ");
         tempTitle = input.nextLine();
     }
     
     
     System.out.println("Author: ");
     tempAuthor= input.nextLine();
     
     while(tempAuthor.length() == 0)
     {
    	 System.out.println("Invalid Input");
    	 System.out.println("Enter Author: ");
    	 tempAuthor = input.nextLine();
     }
     
    
     System.out.println("ISBN: ");
     tempIsbn = input.nextLine();
    
     while(tempIsbn.length() != 13 && tempIsbn.length() != 10 )
     {
    	 System.out.println("Invalid Input ( Must be 10 or 13 characters wrong)");
    	 System.out.println("Enter ISBN: ");
    	 tempIsbn = input.nextLine();
     }
     
             
     System.out.println("Publishing Year - ");
     tempYear = Integer.parseInt(myinput.readLine());
    
     while(tempYear < -2600 || tempYear > 2017 )
     {
    	 System.out.println("Invalid Input ( Must be between yrs -2600 and 2017)");
    	 System.out.println("Enter Publishing Year: ");
    	 tempYear = Integer.parseInt(myinput.readLine());
     }
     
    
     System.out.println("Price: ");
     tempPrice = Double.parseDouble(myinput.readLine());
    
     while(tempPrice < 0.0 )
     {
    	 System.out.println("Invalid Input");
    	 System.out.println("Enter Price: ");
    	 tempPrice = Double.parseDouble(myinput.readLine());
    	    
     }
  
 	
	
	Workbook tempWork = new Workbook(numPro, tempTitle, tempAuthor, tempIsbn,  tempYear, tempPrice);
	
	 	
	if(books.contains(tempWork)){
        System.out.println("This book already exists");
        WorkbookC(books,user,count);
    }else{
    	 
    	books.add(count,tempWork);
 		
 		count ++;
    }
	
    
    
    
    }
    
    
    
    
    public static void printBooks(ArrayList<Book> books){
        seperator();
        
        if(books.isEmpty()){
            System.out.println("No books available");
            return;
        }
        
       
        for(int x = 0; x<books.size(); x++)
		{
			System.out.println(books.get(x));
		}
		
  
    
    }
    
    public static void printAuthors(ArrayList<Book> books){
        seperator();
        
        if(books.isEmpty()){
            System.out.println("No books or authors available");
        }
        
        String authors[] = new String[books.size()];
        int authorCount = 0;
        
        for(Book entry: books){
            if(!(Arrays.asList(authors).contains(entry.getAuthor()))){
                authors[authorCount] = entry.getAuthor();
                authorCount++;
            }
        }   
        
        for(String author: authors){
            if(author != null)
            {
            	System.out.println(author);
            }
            else
            {
            	
            }
        
        }
    }
    
    
    public static void averagePrice(ArrayList<Book> books)
    {
        seperator();
        double average = 0;
        double total = 0;
        int x;

                
        if(books.isEmpty())
        {
            System.out.println("No books or prices available");
        }
        
        
        for( x = 0; x<books.size(); x++)
		{
			total = total + books.get(x).price;
		}
        
        average = total/2;
        
       
        System.out.println("Total Average is: $" +  average);
        System.out.println("Total Number of books: " +  x);
    
    }
 
    
    public static void compareWork(ArrayList<Book> books, int workbook, int textbook)
    {
    	seperator();
    	ArrayList<Workbook> ISBN = new ArrayList<Workbook>();
    	ArrayList<Textbook> workbookISBN = new ArrayList<Textbook>();
    	int ISBNCount = 0;
    	int workCount = 0;
    	
    	
    	
    	for(int i=0; i<books.size(); i++)
         {
             
         	if (books.get(i).getClass().getCanonicalName().equals("Workbook"))
             {
                
                	 ISBN.add(ISBNCount, (Workbook) books.get(i));
                     
                     ISBNCount++;
                
         		
             } 
             else if (books.get(i).getClass().getCanonicalName().equals("Textbook"))
             {
            	

            		 workbookISBN.add(workCount, (Textbook) books.get(i));
            		
            		 workCount++;
                 
               	 
             }
     
         
         }
     
    	
    	for(int x = 0; x<ISBN.size(); x++) //Work 3
    	{
    		
    		for(int i = 0; i<workbookISBN.size(); i++ ) //TEXT 2
    		{
    			
    			if(ISBN.get(x).isbn.equalsIgnoreCase(workbookISBN.get(i).workbookISBN))
    			{
    				
    				System.out.println("Match found:\nTextBook: " + workbookISBN.get(x).title+ " ¡=¿ "+ "Workbook: " + ISBN.get(i).title);
    			}
    			
    		}
    	}
     
    	
    	
    	
    	
    }
    
    public static void FileIO(ArrayList<Book> books){
        String fileName = "myFile.txt";
       
        // Write to a file
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(fileName));
            for(int x = 0; x< books.size(); x++)
            {
            	writer.write(books.get(x).toString1() + "\r\n");
            
            }
            
            System.out.println("Sucessfully Saved");
            
            writer.close();
        } catch(IOException e){
            System.out.println("Failed to write to "+fileName+".");
        }
        

    }
    
    public static void LoadFileIO(ArrayList<Book> books)
    {
    	String fileName = "myFile.txt";
        int countTok = 0;
        int i = 0;
        ArrayList<String> tempBooks = new ArrayList<String>();
        	
    	
    	books.clear();
    	
		// Read the file
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null)
            {
              
            	String del = ",";
				
				StringTokenizer split = new StringTokenizer(line, del);
			    
				while (split.hasMoreTokens()) 
				{
			         
					String tok = split.nextToken();
					tempBooks.add(countTok,tok);
				
					countTok++;
					
				}
		
            	
            	
				
				
				if(countTok == 5) //Book
            	{
            		
					Book temp = new Book(tempBooks.get(0), tempBooks.get(1),tempBooks.get(2), Integer.parseInt(tempBooks.get(3)), 
            				Double.parseDouble(tempBooks.get(4)) );
                	
            		books.add(i,temp);
            		
            		i++;
            		countTok = 0;
            		

            	}
				
				
            	else if(countTok == 7)// Textbook
            	{
            		
            		Textbook tempText = new Textbook(tempBooks.get(0), tempBooks.get(1),tempBooks.get(2), tempBooks.get(3),tempBooks.get(4), Integer.parseInt(tempBooks.get(5)), 
            				Double.parseDouble(tempBooks.get(6)) );
                	
            		books.add(i,tempText);
            		i++;
            	
            		countTok = 0;
            		
            		
            	}
            	
            	else if(countTok == 6)//Workbook
            	{
            		
            		Workbook tempWork = new Workbook(Integer.parseInt(tempBooks.get(0)),tempBooks.get(1), tempBooks.get(2),tempBooks.get(3), Integer.parseInt(tempBooks.get(4)), Double.parseDouble(tempBooks.get(5)));
            	
            		books.add(i,tempWork);
            		i++;
            	
            		countTok = 0;
            	
            	}
            	
            	
                
            	line = reader.readLine();
            }
       
          
            for(int x = 0; x<books.size(); x++)
        	{
            	 System.out.println(books.get(x));
        	}
            
            System.out.println("Succesfully Loaded"); 
            
             
          reader.close();
        } catch(IOException e)
        {
            System.out.println("Failed to read "+fileName+".");
        }
        
        
    }
    
    
    
    
    
}
