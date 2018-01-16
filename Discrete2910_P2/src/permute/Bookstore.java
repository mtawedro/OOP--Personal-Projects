package permute;

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
   	  public static int count = 0;
	  public static ArrayList<Book> books = new ArrayList<Book>();
    
      public static void run() throws NumberFormatException, IOException {
    
      BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
    	
   
      String user;
    
  
      int workbook =0;
      int textbook = 0;
     
      }
    
    private static void seperator(){
    	FirstWindow.text.append("____________________________________\n");
    }
    
    
    public static void BookC( ArrayList<Book> books, int count, String text1,String text2,String text3,String text4,String text5) throws NumberFormatException, IOException
    {
    
    BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
 
    Book temp = new Book(text1, text2, text4, Integer.parseInt(text3), Double.parseDouble(text5));
    	
    if(books.contains(temp)){
    	FirstWindow.text.setText("This book already exists\n");
       
        BookC(books, count,text1, text2, text3, text4,text5);
    }
    
    else{
    	 
    	books.add(count,temp);
 		
 		count ++;
    }
    
   
}

    public static void TextbookC(ArrayList<Book> books, int count, String text6, String text7, String text1,String text2,String text3,String text4,String text5) throws NumberFormatException, IOException
    {
    

     BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
   
	Textbook tempText = new Textbook( text6, text7, text1, text2, text4, Integer.parseInt(text3), Double.parseDouble(text5));
	 
	 if(books.contains(tempText)){
		 FirstWindow.text.setText("This book already exists\n");
	        TextbookC(books, count,text6,text7,text1, text2, text3, text4,text5);
	    }else{
	    	 
	    	books.add(count,tempText);
	 		
	 		count ++;
	    }
		
    }
    
   
    
    public static void WorkbookC(ArrayList<Book> books, int count, String text8, String text1,String text2,String text3,String text4,String text5) throws NumberFormatException, IOException
    {
    

    BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
   
	Workbook tempWork = new Workbook( Integer.parseInt(text8), text1, text2, text4, Integer.parseInt(text3), Double.parseDouble(text5));
	
	 	
	if(books.contains(tempWork)){
		FirstWindow.text.setText("This book already exists\n");
        WorkbookC(books, count,text8,text1, text2, text3, text4,text5);
    }else{
    	 
    	books.add(count,tempWork);
 		
 		count ++;
    }
	
    
    
    
    }
    
    
    
    
    public static void printBooks(ArrayList<Book> books){
    	 FirstWindow.text.setText("");
    	seperator();
        
        if(books.isEmpty()){
           FirstWindow.text.setText("No books available\n");
            
           // System.out.println("No books available");
            return;
        }
          
        
        for(int x = 0; x<books.size(); x++)
		{
        	 FirstWindow.text.append(books.get(x).toString() + "\n");
        	// System.out.println(books.get(x));
		}
		
  
    
    }
    
    public static void printAuthors(ArrayList<Book> books){
    	FirstWindow.text.setText("");
    	seperator();
        
        if(books.isEmpty()){
        	 FirstWindow.text.setText("No books or authors available\n");
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
            	 FirstWindow.text.append(author + "\n");
            }
            else
            {
            	
            }
        
        }
    }
    
    
    public static void averagePrice(ArrayList<Book> books)
    {
    	FirstWindow.text.setText("");
    	seperator();
        double average = 0;
        double total = 0;
        int x;

                
        if(books.isEmpty())
        {
        	 FirstWindow.text.setText("No books or prices available\n");
        }
        
        
        for( x = 0; x<books.size(); x++)
		{
			total = total + books.get(x).price;
		}
        
        average = total/2;
        
      
        FirstWindow.text.append("Total Average is: $" +  average + "\n");
        FirstWindow.text.append("Total Number of books: " +  x + "\n");
    
    }
 
    
    public static void compareWork(ArrayList<Book> books)
    {
    
    	FirstWindow.text.setText("");
    	seperator();
    	ArrayList<Workbook> ISBN = new ArrayList<Workbook>();
    	ArrayList<Textbook> workbookISBN = new ArrayList<Textbook>();
    	int ISBNCount = 0;
    	int workCount = 0;
    	
    	
    	
    	for(int i=0; i<books.size(); i++)
         {
             
         	if (books.get(i).getClass().getCanonicalName().equals("permute.Workbook"))
             {
                
                	 ISBN.add(ISBNCount, (Workbook) books.get(i));
                     
                     ISBNCount++;
                
         		
             } 
             else if (books.get(i).getClass().getCanonicalName().equals("permute.Textbook"))
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
    				
    				 FirstWindow.text.append("Match found:\nTextBook: " + workbookISBN.get(x).title+ " ¡=¿ "+ "Workbook: " + ISBN.get(i).title + "\n");
    			}
    			
    		}
    	}
     
    	
    	
    	
    	
    }
    
    public static void FileIO(ArrayList<Book> books, String fileName){
       // String fileName = "myFile.txt";
    	FirstWindow.text.setText("");
       
        // Write to a file
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(fileName));
            for(int x = 0; x< books.size(); x++)
            {
            	writer.write(books.get(x).toString1() + "\r\n");
            
            }
            
            FirstWindow.text.append("Sucessfully Saved\n");
            
            writer.close();
        } catch(IOException e){
        	 FirstWindow.text.setText("Failed to write to "+fileName+".\n");
        }
        

    }
    
    public static void LoadFileIO(ArrayList<Book> books, String fileName)
    {
    	FirstWindow.text.setText("");
    	//String fileName = "myFile.txt";
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
            	 FirstWindow.text.append(books.get(x).toString() + "\n");
        	}
            
            FirstWindow.text.append("Succesfully Loaded\n"); 
            
             
          reader.close();
        } catch(IOException e)
        {
        	 FirstWindow.text.setText("Failed to read "+fileName+".\n");
        }
        
        
    }
    
    
    
    
    
}
