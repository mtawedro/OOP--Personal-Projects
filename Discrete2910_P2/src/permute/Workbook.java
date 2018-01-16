package permute;

public class Workbook extends Book
{
	int numProblems;
	
	public Workbook(int numProblems, String title, String author, String isbn, int year, double price) 
    {
        
		super(title, author, isbn, year, price, numProblems); //
		
		this.numProblems = numProblems;
       
    }

	Workbook() 
    {
        this.numProblems = 0;
      
    }

	
	
	public String toString()

	{

		String Data1= "Num of problems:"+ this.numProblems+"\n";
		String Data2= "Title:"+ this.title+"\n"+"Author:"+ this.author +"\n";
		String Data3= "ISBN:"+ this.isbn + "\n";
		String Data8= "Year:"+ this.year+ "\n";
		String Data9="Price:"+this.price;
		
		String Data= Data1 +Data2+Data3+ Data8+ Data9+ "\n";
			
		return Data;
		
		
	}
	
	
	
	public String toString1()

	{

		String Data1=  this.numProblems+ "," + this.title + "," + this.author + "," + this.isbn + "," + this.year + "," + this.price  ;
   		
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
    
	
	
	
	
	
	
}

