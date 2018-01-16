package Ref;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ref {
	int temp = 0;
	
	System.out.println("Search-------------------------");
	
	search = user.nextLine();	

	String del = ", .;:!-?";
	
	StringTokenizer split = new StringTokenizer(search, del);
    
	while (split.hasMoreTokens()) 
	{
         
		tok = split.nextToken();
		
	
		for(int j = 0; j < stocksAdd.size(); j++)
		{
			if(tok.equalsIgnoreCase(stocksAdd.get(j).symbol) || tok.equalsIgnoreCase(stocksAdd.get(j).Name ))
			{
				System.out.println(stocksAdd.get(j));
			}
		}	
	
	
	}
}





//CHECK IF LAST ELEMENT IS DASH THEN ABOVE
if(Character.isDigit(range.charAt(j)) && range.charAt(j+1) == '-' && 
Character.isDigit(( range.charAt((range.length()-1) + j) ) ) )
{
	//System.out.println("BETWEEN");
	
	System.out.println("LENTH IS" + range.charAt(    ( (range.length()-1) + j )     ));
	
	
	
	between = 1;
	
	StringTokenizer split = new StringTokenizer(range, del);
	
	while (split.hasMoreTokens()) 
	{
   
		double value = Double.parseDouble(split.nextToken());
		
		array.add(temp,value);
		
		temp++;
	
	}
	
	//break;
}

public static void FileIO(ArrayList<Investment> investAdd){
    String fileName = "myFile.txt";
    String tempVar;
   
    // Write to a file
    BufferedWriter writer;
    try{
        writer = new BufferedWriter(new FileWriter(fileName));
        for(int x = 0; x< investAdd.size(); x++)
        {
        	
        	if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.StockPrac"))
	         {
        		tempVar = "stock";
	         }
        	
        	else if(investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.MutualFundPrac"))
	         {
        		tempVar = "mutualfund";
	         }
        	
        	
        	writer.write("Type = " + tempVar + "\r\n");
        	
        	writer.write(investAdd.get(x).toString1() + "\r\n");
        
        }
        
        System.out.println("Sucessfully Saved");
        
        writer.close();
    } catch(IOException e){
        System.out.println("Failed to write to "+fileName+".");
    }
    

}

public static void LoadFileIO(ArrayList<Investment> investAdd)
{
	String fileName = "myFile.txt";
    int countTok = 0;
    int i = 0;
    ArrayList<String> tempInvest = new ArrayList<String>();
    	
	
    investAdd.clear();
	
	// Read the file
    BufferedReader reader;
    try{
        reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while (line != null)
        {
          
        	String del = " = ";
			
			StringTokenizer split = new StringTokenizer(line, del);
		    
			while (split.hasMoreTokens()) 
			{
		         
				String tok = split.nextToken();
				tempInvest.add(countTok,tok);
			
				countTok++;
				
			}
	
        	
        	
			
			
			if(tempInvest.get(0).equals("stock")) //Book
        	{
        		
				StockPrac temp = new StockPrac(tempInvest.get(1),tempInvest.get(2),Integer.parseInt(tempInvest.get(3)), Double.parseDouble(tempInvest.get(4)), Double.parseDouble(tempInvest.get(5))  );
            	
        		investAdd.add(i,temp);
        		
        		i++;
        		countTok = 0;
        		

        	}
			
			
        	else if(tempInvest.get(0).equals("mutualfund"))// Textbook
        	{
        		
        		MutualFundPrac temp = new MutualFundPrac(tempInvest.get(1),tempInvest.get(2),Integer.parseInt(tempInvest.get(3)), Double.parseDouble(tempInvest.get(4)), Double.parseDouble(tempInvest.get(5))  );
            	
            	
        		investAdd.add(i,temp);
        		i++;
        	
        		countTok = 0;
        		
        		
        	}
        	
        	
            
        	line = reader.readLine();
        }
   
      
        for(int x = 0; x<investAdd.size(); x++)
    	{
        	 System.out.println(investAdd.get(x));
    	}
        
        System.out.println("Succesfully Loaded"); 
        
         
      reader.close();
    } catch(IOException e)
    {
        System.out.println("Failed to read "+fileName+".");
    }
    
    
}







/*
it =  keys.iterator();
 
 while (it.hasNext()) 
 {
        
	 key = it.next();
     HashSet<Integer> content = hm.get(key);
     System.out.println("Key " + key + " is mapped to value: '" + content + "'.");
 }
*/

/*	
//comment this out 
for(int x = 0; x< intersection.size(); x++)
{
	 
	 ArrayList<Integer> arr = new ArrayList<Integer>(intersection);
	 
	 System.out.println("Found at: " + investAdd.get(arr.get(x)));
}
*/


//arr.remove(i);

// System.out.println("SIZE" + arr.size());
 //System.out.println("Del HashMap!!" + hm);
 //i--;


/*
if(arr.size()!=0)
{
	  System.out.println("IN IF HERE HURYY");
		  
	
	if(arr.get(x) > index)
	  {
		  System.out.println("arr.get(i) " + arr);
		  System.out.println("UPDATED " + content);
		  ArrayList<Integer> arr1 = new ArrayList<Integer>(content);
		  arr.set(x, arr1.get(x) -1);
		  System.out.println("Indexes array " + arr);
		  HashSet<Integer> arr2 = new HashSet<Integer>(arr);
		  hm.put(key, arr2);
		  System.out.println("Del HashMap" + hm);
		  x++;
	  }

  }
*/



/*
JMenu first = new JMenu("Menu 1");
JMenu second = new JMenu("Menu 2");
JMenu sub = new JMenu("Sub");
JMenuItem test = new JMenuItem("test");
sub.add(test);

JMenuItem bacon = new JMenuItem("Bacon");
JMenuItem cheese = new JMenuItem("Cheese");
first.add(bacon);
first.add(cheese);
first.add(sub);

add(first);
add(second);
*/





}
