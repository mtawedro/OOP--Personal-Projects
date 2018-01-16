package permute;

public class Textbook extends Book {

	String subject;
	String workbookISBN;

	
	public Textbook( String subject, String workbookISBN, String title, String author, String isbn, int year, double price) 
    {
        
		//MATH 123 MAKES MCGIIL 456 1998 20.0

		
		super(title, author, isbn, year, price, workbookISBN);
		
		
		this.subject = subject;
        this.workbookISBN = workbookISBN;
      
    }

	Textbook() 
    {
        this.subject = "NewSubject";
       this.workbookISBN= "NewWorkbookISBN";
       
    }

	public String toString()

	{

		String Data1= "Subject:"+ this.subject+"\n"+"Workbook ISBN:"+ this.workbookISBN +"\n";
		String Data2= "Title:"+ this.title+"\n"+"Author:"+ this.author +"\n";
		String Data3= "ISBN:"+ this.isbn + "\n";
		String Data8= "Year:"+ this.year+ "\n";
		String Data9="Price:"+this.price;
		
		String Data= Data1 +Data2+Data3+ Data8+ Data9+ "\n";
			
		return Data;
		
	
	}
    
	public String toString1()

	{

		String Data1= this.subject+","+ this.workbookISBN +"," + this.title + "," + this.author + "," + this.isbn + "," + this.year + "," + this.price  ;
   		
   		String Data= Data1 ;
   			
   		
		return Data;
		
	
	}

	public boolean equals(Object obj) { //
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
    

}

