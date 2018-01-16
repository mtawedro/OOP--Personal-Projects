import java.util.Objects;

/**
 *
 * @author Martina
 */
@SuppressWarnings("unused")
public class Book {
    
    String title;
    String author;
    String isbn;
    int year;
    double price;
    String workbookISBN;
    int numProblems;

    public Book(String title, String author, String isbn, int year, double price) 
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
    }

    public Book(String title, String author, String isbn, int year, double price, String workbookISBN )
    {
    	this.workbookISBN = workbookISBN;
    	 this.title = title;
         this.author = author;
         this.isbn = isbn;
         this.year = year;
         this.price = price;
    	
    }
    
    public Book(String title, String author, String isbn, int year, double price, int numProblems )
    {
    	this.numProblems = numProblems;
    	 this.title = title;
         this.author = author;
         this.isbn = isbn;
         this.year = year;
         this.price = price;
    	
    }
    
    
    
    
    Book() 
    {
        this.title = "NewBook";
        this.author = "NewAuthor";
        this.isbn = "NewISBN";
        this.year = 0000;
        this.price = 00.00;
    }

    
    @Override
    public String toString()

	{

		String Data1= "Title:"+ this.title+"\n"+"Author:"+ this.author +"\n";
		String Data3= "ISBN:"+ this.isbn + "\n";
		String Data8= "Year:"+ this.year+ "\n";
		String Data9="Price:"+this.price;
		
		String Data= Data1+Data3+ Data8+ Data9+ "\n";
			
		return Data;

	}
    
    public String toString1()

   	{

   		String Data1= this.title + "," + this.author + "," + this.isbn + "," + this.year + "," + this.price  ;
   		
   		String Data= Data1 ;
   			
   		return Data;

   	}
    
    
    public boolean equals(Object obj) {//
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
            
        final Book other = (Book) obj;
        
        if (this.year == other.year 
            && Double.compare(this.price, other.price) == 0 
            && this.title.equals( other.title)
            && this.author.equals(other.author)
            && this.isbn.equals(other.isbn) ) {
            return true;
        }
        return false;
    }
    
    
    
    
   
    
    public String getTitle()
    {
        return title;
    }
    public String getAuthor() 
    {
        return author;
    }
    public String getIsbn() 
    {
        return isbn;
    }
    public int getYear() 
    {
        return year;
    }  
    public double getPrice() 
    {
        return price;
    }    
    
    
    public boolean setTitle(String title) 
    {
        if(title.length()>0)
        {
            this.title = title;
            return true;
        }
        
        return false;
        
    }
    public boolean setAuthor(String author) {
        if(author.length()>0)
        {
            this.author = author;
           
            return true;
        }
        return false;
    }
    public boolean setIsbn(String isbn) 
    {
        if(isbn.length()==11 || isbn.length()==13)
        {
            if(isbn.matches("[a-zA-Z0-9 ]+")){
                this.isbn = isbn;
                return true;
            }
        }
        
        return false;  
    }
    public boolean setYear(int year) 
    {
        if(year>=-2600 && year<=2017)
        {
            this.year = year;
            return true;
        }
        
        return false;
    }
    public boolean setPrice(double price) 
    {
        if(Double.compare(price, 0.00) >0)
        {
            this.price = price;
            return true;
        }
        
        return false;
    }
    
}
