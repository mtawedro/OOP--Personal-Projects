package Portfolio;

public class Practice {

	public static void main(String[] args)
	{
	
		try{
			validate(); // go to validate function
		}
		catch (PriceFormatException e){
			 
			System.out.println(e.getMessage()); // print message that's passed in super
		}
		
		
		
		
		
	}

	
	public static class PriceFormatException extends Exception
	{
		
		public PriceFormatException(String string)
		{
			super(string);
		}
		
	}
	
	
	public static void validate() throws PriceFormatException //validate function with price exception 
	{
		int i = 0;
		if( i == 0)
		{
			throw new PriceFormatException("Invalid Input for Quantity\n"); // call PriceException class
		}
	}	
	
	
	
	
	
	
	
	

}
