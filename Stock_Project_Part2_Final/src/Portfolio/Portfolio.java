package Portfolio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Portfolio {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
		
		int input = 0;
		String choiceStock;	
		Scanner user = new Scanner (System.in); 
		HashMap<String,  HashSet <Integer>> hm = new HashMap<String, HashSet<Integer>>();
		ArrayList<Double> amountGained = new ArrayList<Double>();
		ArrayList<Investment> investAdd = new ArrayList<Investment>();
		
		
		
		
		System.out.println("(1) buy: own a new investment or add more quantity to an existing investment");    
		 
		System.out.println("(2) sell: reduce some quantity of an existing investment"); 
		 
		System.out.println("(3) update: refresh the prices of all existing investments"); 
		 
		System.out.println("(4) getGain: compute the total gain of the portfolio by accumulating the gains of all its investments");    
		 
		System.out.println("(5) Search:");
		
		System.out.println("(6) Quit");
		
		File fileName = null;
		
		if(args.length > 0)
		{
			
			fileName = new File(args[0]);
					
		}//pass in argument
		
		else
		{
			fileName = new File("myFile.txt");
		}
			
		
		LoadFileIO(investAdd, fileName);
		
		if(investAdd.size() != 0)
		{
		    //updates HashMap
			HashMap(hm,investAdd);
		
		}
		
		//error check for user input
		boolean done = false;
		while (!done) {
		    try {

				System.out.println("Enter Choice");
				input = Integer.parseInt(myinput.readLine());
		       
				done = true;
		    } catch (NumberFormatException e) 
		    {
		       System.out.println("Invalid Input");
		    }
      	}
		
	//command prompt
	while(input!= 6)
	{
		switch(input)
		{
			case 1: 
			{
				
				System.out.println("Which Investment - Stock (S) or MutualFund (MF):");
				
				choiceStock = user.nextLine();
				
				while(choiceStock.equalsIgnoreCase("S") == false && choiceStock.equalsIgnoreCase("MF") == false)
				{
					System.out.println("Sorry, Invalid Input. Enter in Investment - Stock (S) or MutualFund (MF):");
					choiceStock = user.nextLine();
				}
					
				
				if(choiceStock.equalsIgnoreCase("MF"))
				{
					MutualFund.CalculateMutualFunds(investAdd);
					
					//updates
					HashMap(hm,investAdd); 
					
				}
				
				else if(choiceStock.equalsIgnoreCase("S"))
				{
					Stock.CalculateStockFunds( investAdd);
					
					//updates
					HashMap(hm,investAdd);
				}
				
				
				break;
			
			}//end case1
			
			
			case 2:
			{
				
				System.out.println("Which Investment - Stock (S) or MutualFund (MF):");
				
				choiceStock = user.nextLine();
				
				while(choiceStock.equalsIgnoreCase("S") == false && choiceStock.equalsIgnoreCase("MF") == false)
				{
					System.out.println("Sorry, Invalid Input. Enter in Investment - Stock (S) or MutualFund (MF):");
					choiceStock = user.nextLine();
				}
				
				
				if(choiceStock.equalsIgnoreCase("MF") || choiceStock.equalsIgnoreCase("S"))
				{
					Investment.SellInvestments( hm, investAdd);
				}
				
				//prints
				for(int x = 0; x<investAdd.size(); x++)
				{
					System.out.println(investAdd.get(x));
				}
				
				break;
				
			}//end of case2
			
			
			case 3:
			{
				
				Investment.updateInvestmentPrice(investAdd);
				
				//prints
				for(int x = 0; x<investAdd.size(); x++)
				{
					System.out.println(investAdd.get(x));
				}
				
				break;
	
			}//end of case3
			
			
			case 4:
			{
				
				 Investment.InvestmentGained(investAdd, amountGained);
				 
			   	 break;
			
			}//end of case 4
			
			
			case 5:
			{
				
				Search(hm,investAdd);
				break;
			}
			
			
			default: 
			{
				System.out.println("Sorry please enter in options 1-6");
			}
			
			
			
			
		}//end of switch
		
		//error check
		done = false;
		while (!done) {
		    try {

				System.out.println("Enter Choice");
				input = Integer.parseInt(myinput.readLine());
		        done = true;
		    } catch (NumberFormatException e) 
		    {
		       System.out.println("Invalid Input");
		    }
      	}
	
	}//end of while
		
		//writes to the file once user quits
		FileIO(investAdd, fileName);
	
	
	}// end of main
		
	
	
	
	/**
	*User-defined function to generic data by taking a search word from user depending
	*on what fields user will enter (HashMap) is used when user enters in company name. Range/Symbol also
	*took into consideration .

	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashMap<String,  HashSet <Integer>> HashMap

	* *@return void */ 
	
	public static void Search(HashMap<String,  HashSet <Integer>> hm, ArrayList<Investment> investAdd)
	{
		
		int below = 0;
		int above = 0;
		int between = 0;
		int temp = 0;
		int exact = 0;
		int flag = 0;
		String choiceSymbol;
		String range;
		String compName = "Random";
		ArrayList<Double> array = new ArrayList<Double>();
		Scanner user = new Scanner (System.in);
		
		String del = ", ;:!-?";
		    
		System.out.println("Search-------------------------");
		System.out.println("Enter Symbol:");
		choiceSymbol = user.nextLine();
		
		System.out.println("Enter name of company:");
		compName= user.nextLine();
		System.out.println("Enter Range:");
		range = user.nextLine();
		
		HashSet<Integer> determine;
		
	
		//if nothing is entered
		if(choiceSymbol.length() == 0 && compName.length() == 0 && range.length() == 0)
		{
			
			for(int x = 0; x<investAdd.size(); x++)
			{
				System.out.println(investAdd.get(x));
			}
			
			
			flag = 1;
		
		}
		
		
		//if symbol is only entered
		else if(choiceSymbol.length() != 0 && compName.length() == 0 && range.length() == 0 )
		{
			
			for(int j = 0; j<investAdd.size(); j++)
			{
				if(choiceSymbol.equalsIgnoreCase(investAdd.get(j).symbol) )
				{
					System.out.println(investAdd.get(j));
				}
				
			}
			
			
			flag = 1;
			
		}
		
		
		//if company name is only entered
		else if(choiceSymbol.length() == 0 && compName.length() != 0 && range.length() == 0 )
		{
			
			determine = IntersectionCheck(hm,investAdd, compName);
			
			//prints
			for(int x = 0; x< determine.size(); x++)
			{
				 
				 ArrayList<Integer> arr = new ArrayList<Integer>(determine);
				 
				 System.out.println( investAdd.get(arr.get(x)));
			}
			
			flag = 1;
		}
		
		
		//if company name and symbol name is entered 
		else if(choiceSymbol.length() != 0 && compName.length() != 0 && range.length() == 0)
		{
			 determine = IntersectionCheck(hm,investAdd, compName);
				
			 symbol(determine, investAdd, choiceSymbol);
			
			 flag = 1;
			
		}
				
				
				
		// if above options were not entered
		if(flag != 1)
		{
					/*****Parses the ranges into an temp array and sets flags whether range is below
					 * between or above*****/
		
					StringTokenizer split = new StringTokenizer(range, del);
					
					while (split.hasMoreTokens()) 
					{
				   
						double value = Double.parseDouble(split.nextToken());
						
						array.add(temp,value);
						
						temp++;
					
					}
					
					if(temp == 2)
					{
						
						between = 1;
					}
		
			
					if(range.charAt(0) == '-' && Character.isDigit(range.charAt(1)) )
					{
						
						below = 1;
				
						StringTokenizer split1 = new StringTokenizer(range, del);
				
						while (split1.hasMoreTokens()) 
						{
			   
							double value = Double.parseDouble(split1.nextToken());
					
							array.add(temp,value);
					
							temp++;
				
						}
				
					}
		
					else if(Character.isDigit(range.charAt(range.length()-2)) && range.charAt(range.length()-1) == '-' )
					{
						
						above = 1;
				
						StringTokenizer split2 = new StringTokenizer(range, del);
				
						while (split2.hasMoreTokens()) 
						{
			   
							double value = Double.parseDouble(split2.nextToken());
					
							array.add(temp,value);
					
							temp++;
				
						}
				
				
					}
			
					else if(between != 1)
					{
						
						exact = 1;
						
						StringTokenizer split3 = new StringTokenizer(range, del);
						
						while (split3.hasMoreTokens()) 
						{
			   
							double value = Double.parseDouble(split3.nextToken());
					
							array.add(temp,value);
					
							temp++;
				
						}
						
						
						
					}
			
			
	
		
		}
					
	if(flag != 1)
	{	
		
		
		for(int j = 0; j < investAdd.size(); j++)
		{
			/** company and range is entered , will call IntersectionCheck (uses HashMap to find comp key indexes that
			 * are common) returns HashSet of common indexes and passes that to Below(), Above(), Between(), or Exact()
			 *  which evaluate range dependent on user input and checks if both company and range matches the conditions user inputed
			 * ***********************/

			if(choiceSymbol.length() == 0 && compName.length() != 0 && below == 1 )
			{
				
				 determine = IntersectionCheck(hm,investAdd, compName);
				
				 below(determine, investAdd, array, j);
				 break;
					
			}
		
			
			else if(choiceSymbol.length() == 0 && compName.length() != 0 && above == 1 )
			{
				
				 determine = IntersectionCheck(hm,investAdd, compName);
					
				 above(determine, investAdd, array, j);
				 break;
			
			
			}
			
			else if(choiceSymbol.length() == 0 && compName.length() != 0 && between == 1 )
			{
			
				 determine = IntersectionCheck(hm,investAdd, compName);
					
				 between(determine, investAdd, array, j);
				 break;
				
			}
			
			
			else if(choiceSymbol.length() == 0 && compName.length() != 0 && exact == 1 )
			{
				
				 determine = IntersectionCheck(hm,investAdd, compName);
					
				 exact(determine, investAdd, array, j);
				 break;
				
			}
			
			
			
			/** symbol and range is entered, will compare symbol name and price range user entered with current symbol 
			 * name and price  in Investment array and iterates until symbols are equal and range conditions are matched 
			 * ***********************/
			else if(choiceSymbol.length() != 0 && compName.length() == 0 && below == 1)
			{
				
				if(choiceSymbol.equalsIgnoreCase(investAdd.get(j).symbol) && (investAdd.get(j).price <= array.get(0)))
				{
					System.out.println(investAdd.get(j));
				}
				
				
			}
			
			else if(choiceSymbol.length() != 0 && compName.length() == 0 && above == 1)
			{
				
				if(choiceSymbol.equalsIgnoreCase(investAdd.get(j).symbol) && (investAdd.get(j).price >= array.get(0)))
				{
					System.out.println(investAdd.get(j));
				}
				
				
			}
			
			else if(choiceSymbol.length() != 0 && compName.length() == 0 && between == 1)
			{
				
				if(choiceSymbol.equalsIgnoreCase(investAdd.get(j).symbol) && ((array.get(0) <= investAdd.get(j).price) && 
						(investAdd.get(j).price <= array.get(0+1))))
				{
					System.out.println(investAdd.get(j));
				}
				
				
			}
			
			else if(choiceSymbol.length() != 0 && compName.length() == 0 && exact == 1)
			{
				
				if(choiceSymbol.equalsIgnoreCase(investAdd.get(j).symbol) && ((array.get(0) == investAdd.get(j).price)))
				{
					System.out.println(investAdd.get(j));
				}
				
				
			}
			
		
			
			/** range is entered, will  compare price range user entered with price  in Investment array and iterates
			 *  until range conditions are satisfied 
			 * ***********************/
			
			else if(choiceSymbol.length() == 0 && compName.length() == 0 && below == 1  )
			{
				
				if( (investAdd.get(j).price <= array.get(0)))
				{
					System.out.println(investAdd.get(j));
				}
				
				
			}
		
			else if(choiceSymbol.length() == 0 && compName.length() == 0 && above ==1 )
			{
				
				if((investAdd.get(j).price >= array.get(0)))
				{
					System.out.println(investAdd.get(j));
				}
				
				
			}	
		
			else if(choiceSymbol.length() == 0 && compName.length() == 0 && between ==1 )
			{
				
				if(((array.get(0) <= investAdd.get(j).price) && (investAdd.get(j).price <= array.get(0+1))))
				{
					System.out.println(investAdd.get(j));
				}
				
				
			}	
		
			else if(choiceSymbol.length() == 0 && compName.length() == 0 && exact == 1 )
			{
				
				if( ((array.get(0) == investAdd.get(j).price)))
				{
					System.out.println(investAdd.get(j));
				}
				
				
			}	
			
			/** company, symbol, range is entered , will call IntersectionCheck (uses HashMap to find comp key indexes that
			 * are common) returns HashSet of common indexes and passes that to symbolRangeBelow(), symbolRangeAbove(), 
			 * symbolRangeBetween(), or symbolRangeExact() which evaluate ranges dependent if Below, Above, Between, or Exact
			 *  ranges along with compare symbol name and  checks if  both company, symbol and range matches the conditions user inputed
			 * ***********************/
			
			else if(choiceSymbol.length() != 0 && compName.length() != 0 && below == 1)
			{
				
				 determine = IntersectionCheck(hm,investAdd, compName);
					
				 symbolRangeBelow(determine, investAdd, choiceSymbol, array, j);
				 break;
				
			
				
			}
			
			else if(choiceSymbol.length() != 0 && compName.length() != 0 && above == 1)
			{
				
				 determine = IntersectionCheck(hm,investAdd, compName);
					
				 symbolRangeAbove(determine, investAdd, choiceSymbol, array, j);
				 break;
			
				
			}
			
			else if(choiceSymbol.length() != 0 && compName.length() != 0 && between == 1)
			{
				
				 determine = IntersectionCheck(hm,investAdd, compName);
					
				 symbolRangeBetw(determine, investAdd, choiceSymbol, array, j);
				 break;
				
				
				
			}
			
			else if(choiceSymbol.length() != 0 && compName.length() != 0 && exact == 1)
			{
				
				 determine = IntersectionCheck(hm,investAdd, compName);
					
				 symbolRangeExact(determine, investAdd, choiceSymbol, array, j);
				 break;
				
				
				
			}
			
			
			
		}//end of Investment loop
		
		
		
	}
		

}
	/**
	*User-defined function to write data(all investments) from Investment array list to a .txt file 
	 *@pre user defined arrayList for type Investment

	 *@param Investment arrayList.

	* *@return void */ 
	

	public static void FileIO( ArrayList<Investment> investAdd, File fileName) 
	{
	    String tempVar = null;
	   
	    BufferedWriter writer;
	    try{
	        writer = new BufferedWriter(new FileWriter(fileName));
	        for(int x = 0; x< investAdd.size(); x++)
	        {
	        	
	        	if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.Stock"))
		         {
	        		tempVar = "stock,";
		         }
	        	
	        	else if(investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.MutualFund"))
		         {
	        		tempVar = "mutualfund,";
		         }
	        	
	        	
	        	writer.write(tempVar);
	        	
	        	writer.write(investAdd.get(x).toString1() + "\r\n");
	        
	        }
	       
	        System.out.println("Sucessfully Saved");
	        
	        writer.close();
	    } catch(IOException e){
	        System.out.println("Failed to write to "+fileName+".");
	    }
	    

	}

	
	/**
	*User-defined function to load data(all investments) from .txt file back into Investment array list
	
	 *@pre user defined arrayList for type Investment

	 *@param Investment arrayList.

	* *@return void */ 
	
	
	public static void LoadFileIO(ArrayList<Investment> investAdd, File fileName)
	{
		
		
	    int countTok = 0;
	    int i = 0;
	    ArrayList<String> tempInvest = new ArrayList<String>();
	    	
		
	    investAdd.clear();
		
		// Read the file
	    BufferedReader reader;
	    try{
	        reader = new BufferedReader(new FileReader(fileName));
	        String line = reader.readLine();
	       
	        /*by parsing each word separated by comma's in line and checks whether it's stocks or mutual funds, calls corresponding constructor
	          and stores investment into Investment array list
	        **/
	        while (line != null)
	        {
	          
	        	String del = ",";
				
				StringTokenizer split = new StringTokenizer(line, del);
			    
				while (split.hasMoreTokens()) 
				{
			         
					String tok = split.nextToken();
					tempInvest.add(countTok,tok);
				
					countTok++;
					
				}
		
				
				
				if(tempInvest.get(0).equals("stock")) //Stock
	        	{
	        		
					Stock temp = new Stock(tempInvest.get(1),tempInvest.get(2),Integer.parseInt(tempInvest.get(3)), Double.parseDouble(tempInvest.get(4)), Double.parseDouble(tempInvest.get(5))  );
	            	
	        		investAdd.add(i,temp);
	        		
	        		i++;
	        		countTok = 0;
	        		

	        	}
				
				
	        	else if(tempInvest.get(0).equals("mutualfund"))// MutualFund
	        	{
	        		
	        		MutualFund temp = new MutualFund(tempInvest.get(1),tempInvest.get(2),Integer.parseInt(tempInvest.get(3)), Double.parseDouble(tempInvest.get(4)), Double.parseDouble(tempInvest.get(5))  );
	            	
	            	
	        		investAdd.add(i,temp);
	        		i++;
	        	
	        		countTok = 0;
	        		
	        		
	        	}
	        	
	        	
	            
	        	line = reader.readLine();
	        }
	   
	      
	        
	        System.out.println("Succesfully Loaded"); 
	        
	         
	      reader.close();
	    } catch(IOException e)
	    {
	        System.out.println("Failed to read "+fileName+".");
	    }
	    
	    
	}

    
	/**
	*User-defined function to generic data by parsing each company name, places each company key in Hashmap and maps
	*to its corresponding indexes that occur in array list

	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashMap<String,  HashSet <Integer>> HashMap

	* *@return void */ 
	
	public static void HashMap(HashMap<String,  HashSet <Integer>> hm, ArrayList<Investment> investAdd) throws NumberFormatException, IOException
	{
		
		int count = 0;
		
		ArrayList<String> tempArray = new ArrayList<String>();
		
		HashSet <Integer> array = new HashSet <Integer>();
		
		String del = ", .;:!-?";
		String key;
		
		
		//parses each company name into array, places them in HashMap first
		 for(int x = 0; x<investAdd.size(); x++)
		 {
					
				StringTokenizer split = new StringTokenizer(investAdd.get(x).Name, del);
			    
				while (split.hasMoreTokens()) 
				{
					String tok = split.nextToken();
					String upper = tok.toUpperCase();
					tempArray.add(count, upper);
					hm.put(upper, array); // indexArray (nothing)
					
					
					count++;
						
				}
			 
			 
		 }
		  
		 Set<String> keys = hm.keySet();
	     Iterator<String> it = keys.iterator();
	    
		
		 tempArray.clear();
	    
		 while(it.hasNext())
	     {
			
			 HashSet <Integer> array1 = new HashSet <Integer>();
			 key = it.next();
			 count = 0;
     		
			 for(int x = 0; x<investAdd.size(); x++) 
	    	 {
	        		/**********splits each company name into tokens investment by investment *************/
	        		
	    			StringTokenizer split = new StringTokenizer(investAdd.get(x).Name, del);
	    			    
	    			while (split.hasMoreTokens()) 
	    			{      
	    				String tok = split.nextToken();
	    				String upper = tok.toUpperCase();
						tempArray.add(count, upper);
	    			
	    				count++;	
	    				
	    			}
	        	
	    		
	    			for(int i = 0; i < tempArray.size(); i++)
	    			{
	    				/**if key word equals the parsed company name add index it found it at to HashSet (with no repeated elements)*/
	    				
	    				if(key.equalsIgnoreCase(tempArray.get(i)))
	    				{
	    					 array1.add(x);
	    					 
	    					 break;
	    						
	    				}			
	    				
	    				
	    			}
	    			 
	    			count = 0;
	    			tempArray.clear();
	    			
	    	  }//end of inner for
		     
			
			 hm.put(key, array1);
	   
			 
	     }//end of outer while
		
	
		 System.out.println(hm);
		 
		 
	} // end of void
		
	
	/**
	*User-defined function (used for search purposes) that uses HashMap to match the companyName (user entered for
	*search) (parsed company name ) with each key and if keys matched in Hashmap -> get content in set-> find indexes that are common to both key words mapped (in set)) 

	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashMap<String,  HashSet <Integer>> HashMap
	
	 *@param String CompName (user entered for search)

	* *@return HashSet<Integer> HashSet of common indexes with (respect to company name user entered )  */ 
	
	
	public static HashSet<Integer> IntersectionCheck(HashMap<String,  HashSet <Integer>> hm, ArrayList<Investment> investAdd, String compName)
	 {
		
		 int counter = 0;
		 int intersectionFlag = 0;
		 ArrayList<String> tempArray1 = new ArrayList<String>();
			
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		
		 HashSet <Integer> intersection = new HashSet <Integer>();
		 String del = ", .;:!-?";
		 
		 
		String choice =  compName.toUpperCase();  
		
		//splits company name tok into temp array1
		StringTokenizer split = new StringTokenizer(choice, del);
	    
		while (split.hasMoreTokens()) 
		{
			
			String tok = split.nextToken();
			tempArray1.add(counter, tok);
			
			counter++;
				
		}
		
	
		
		for(int x = 0; x<tempArray1.size(); x++)
		{
			
			 
			if(hm.containsKey(tempArray1.get(x)) == false)
			{
				intersectionFlag = 1;
				continue;
			}
			 
			
			 HashSet<Integer> content = hm.get(tempArray1.get(x));
			 
			 ArrayList<Integer> arr = new ArrayList<Integer>(content);
			
			
			  for(int j = 0; j<arr.size(); j++)
			 {
				  newArray.add(arr.get(j));
			 }
			 
			 
		}
	
		
	/*Nested loop: gets index in array Inner Loop: compares index with every index after in array (i + 1) , if index matches 
	 * grabs index in set and puts in into intersection set (prevents repeated indexes)**/	
		
	for(int i = 0; i< newArray.size(); i++)
	{
		
		if(intersectionFlag == 1) //A key word was found that didn't exist in HashTable
		{
			break;
		}
		
		
		
		if(newArray.size() == 1 || tempArray1.size() == 1)
		{
			for(int x = 0; x< newArray.size(); x++)
			{ 
				//intersectionFlag = 1;
				
				intersection.add(newArray.get(x));
			}
			
			break;
		}
			
		
		
		for(int l = i+1; l <newArray.size(); l++)
		{
			if(newArray.get(i) == newArray.get(l))
			{
				//intersectionFlag = 1;
				
				intersection.add(newArray.get(l));
				
			}
			
			
		}
		/*
		if(intersectionFlag != 1)
		{
		  intersection.add(newArray.get(i));
		}
		*/
	}
	
  // System.out.println(intersection);
	 return intersection;
	
		
	}	
		
	
	/**
	*User-defined function to delete specific investment array along with deleting the corresponding index in HashMap with subtracting
	*one --> indexes that are higher 
	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashMap<String,  HashSet <Integer>> HashMap
	
	 *@param int index 

	* *@return void */ 

	public static void DeleteIndex(HashMap<String,  HashSet <Integer>> hm, ArrayList<Investment> investAdd, int index) throws NumberFormatException, IOException
	{
	
		 Set<String> keys = hm.keySet();
	     Iterator<String> it = keys.iterator();
	   
		 it =  keys.iterator();
	
		 while (it.hasNext()) 
		 {
	            
			 String key = it.next();
	         HashSet<Integer> content = hm.get(key);
	        
	         ArrayList<Integer> arr = new ArrayList<Integer>(content);
				
			 for(int i = 0; i< arr.size(); i++)
			  {
				  
				  if(arr.get(i) == index)
				  {
					 
					 // remove inside set
					  content.remove(arr.get(i)); 
					 
					  if(content.size()== 0)
					  {
						  //removes whole key -> set
						  it.remove();
					  }
					  
				  }
		  }
		
}// end of while	
		
		
		 it =  keys.iterator();
		 
		 while (it.hasNext()) 
		 {
	            
			 String key = it.next();
	         HashSet<Integer> content = hm.get(key);
	        
	         ArrayList<Integer> arr = new ArrayList<Integer>(content);
			
			  for(int i = 0; i< arr.size(); i++)
			  {
				  
				  if(arr.get(i) > index)
				  {
					  arr.set(i, arr.get(i) -1);
					  HashSet<Integer> arr1 = new HashSet<Integer>(arr);
					  hm.put(key, arr1);

				  }
				  
				  
			  }
			  
		 }//end of while
		 
		 
		
	}//end of function
	
	
	/**
	*User-defined function(called from search()) that iterates through intersection set (set that has the common indexes from searching 
	*for company name) and compares price below range ex. '-80'
	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashSet<Integer> intersection
	
	 *@param int j -> current position in investment array
	 
	 *@param ArrayList<Double> array -> have parsed ranges #

	* *@return void */ 
	
	public static void below(HashSet<Integer> intersection, ArrayList<Investment> investAdd, ArrayList<Double> array, int j )
	{
		
		for(int x = 0; x< intersection.size(); x++)
		{
			 
			 ArrayList<Integer> arr = new ArrayList<Integer>(intersection);
			 
			   if(investAdd.get(arr.get(x)).price <= array.get(0))
				{
				   System.out.println( investAdd.get(arr.get(x)));
				}
			 
			
		}
	
	
	}	

	
	/**
	*User-defined function(called from search()) that iterates through intersection set (set that has the common indexes from searching 
	*for company name) and compares price above range ex. '80-'
	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashSet<Integer> intersection
	
	 *@param int j -> current position in investment array
	 
	 *@param ArrayList<Double> array -> have parsed ranges #

	* *@return void */ 
	

	public static void above(HashSet<Integer> intersection, ArrayList<Investment> investAdd, ArrayList<Double> array, int j )
	{
		
		for(int x = 0; x< intersection.size(); x++)
		{
			 
			 ArrayList<Integer> arr = new ArrayList<Integer>(intersection);
			 
			   if(investAdd.get(arr.get(x)).price >= array.get(0))
				{
				   System.out.println(investAdd.get(arr.get(x)));
				}
			 
			
		}
	
	
	}	
	
	/**
	*User-defined function(called from search()) that iterates through intersection set (set that has the common indexes from searching 
	*for company name) and compares price between range ex. '80-90'
	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashSet<Integer> intersection
	
	 *@param int j -> current position in investment array
	 
	 *@param ArrayList<Double> array -> have parsed ranges #

	* *@return void */ 
	
	public static void between(HashSet<Integer> intersection, ArrayList<Investment> investAdd, ArrayList<Double> array, int j )
	{
		
		for(int x = 0; x< intersection.size(); x++)
		{
			 
			 ArrayList<Integer> arr = new ArrayList<Integer>(intersection);
			
			 if(((array.get(0) <= investAdd.get(arr.get(x)).price) && 
						(investAdd.get(arr.get(x)).price <= array.get(0+1))))
				{
				   System.out.println( investAdd.get(arr.get(x)));
				}
			 
			
		}
	
	
	}	

	/**
	*User-defined function(called from search()) that iterates through intersection set (set that has the common indexes from searching 
	*for company name) and compares price within exact range ex. '80'
	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashSet<Integer> intersection
	
	 *@param int j -> current position in investment array
	 
	 *@param ArrayList<Double> array -> have parsed ranges #

	* *@return void */ 
	public static void exact(HashSet<Integer> intersection, ArrayList<Investment> investAdd, ArrayList<Double> array, int j )
	{
		
		for(int x = 0; x< intersection.size(); x++)
		{
			 
			 ArrayList<Integer> arr = new ArrayList<Integer>(intersection);
			 
			   if(((array.get(0) == investAdd.get(arr.get(x)).price)))
				{
				   System.out.println( investAdd.get(arr.get(x)));
				}
			 
			
		}
	
	
	}	
	
	/**
	*User-defined function(called from search()) that iterates through intersection set (set that has the common indexes from searching 
	*for company name) and compares symbols for exactness
	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashSet<Integer> intersection
	
	 *@param String choiceSymbol 
	 
	* *@return void */ 
	
	public static void symbol(HashSet<Integer> intersection, ArrayList<Investment> investAdd, String choiceSymbol )
	{
		
		for(int x = 0; x< intersection.size(); x++)
		{
			 
			 ArrayList<Integer> arr = new ArrayList<Integer>(intersection);
			 
			   if(choiceSymbol.equalsIgnoreCase(investAdd.get(arr.get(x)).symbol))
				{
				   System.out.println(investAdd.get(arr.get(x)));
				   
				  
				}
			 
			
		}
	
		
	
	}	
	
	/**
	*User-defined function(called from search()) that iterates through intersection set (set that has the common indexes from searching 
	*for company name) and compares symbols for exactness and and compares price below range ex. '-80'
	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashSet<Integer> intersection
	
	 *@param String choiceSymbol
	 
	 *@param int j -> current position in investment array
	 
	 *@param ArrayList<Double> array -> have parsed ranges # 
	 
	* *@return void */ 
	
	public static void symbolRangeBelow(HashSet<Integer> intersection, ArrayList<Investment> investAdd, String choiceSymbol, ArrayList<Double> array, int j )
	{
		
		for(int x = 0; x< intersection.size(); x++)
		{
			 
			 ArrayList<Integer> arr = new ArrayList<Integer>(intersection);
			 
			
			 if(choiceSymbol.equalsIgnoreCase(investAdd.get(arr.get(x)).symbol) && investAdd.get(arr.get(x)).price <= array.get(0) )
				{
				   System.out.println( investAdd.get(arr.get(x)));
				   
				}
			 
			
		}
	
		
	
	}	
	

	/**
	*User-defined function(called from search()) that iterates through intersection set (set that has the common indexes from searching 
	*for company name) and compares symbols for exactness and and compares price above range ex. '80-'
	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashSet<Integer> intersection
	
	 *@param String choiceSymbol
	 
	 *@param int j -> current position in investment array
	 
	 *@param ArrayList<Double> array -> have parsed ranges # 
	 
	* *@return void */ 
	public static void symbolRangeAbove(HashSet<Integer> intersection, ArrayList<Investment> investAdd, String choiceSymbol, ArrayList<Double> array, int j )
	{
		
		for(int x = 0; x< intersection.size(); x++)
		{
			 
			 ArrayList<Integer> arr = new ArrayList<Integer>(intersection);
			 
			
			 if(choiceSymbol.equalsIgnoreCase(investAdd.get(arr.get(x)).symbol) && investAdd.get(arr.get(x)).price >= array.get(0) )
				{
				   System.out.println( investAdd.get(arr.get(x)));
				   
				}
			 
			
		}
	
		
	
	}	
	
	/**
	*User-defined function(called from search()) that iterates through intersection set (set that has the common indexes from searching 
	*for company name) and compares symbols for exactness and and compares price between ranges ex. '80-90'
	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashSet<Integer> intersection
	
	 *@param String choiceSymbol
	 
	 *@param int j -> current position in investment array
	 
	 *@param ArrayList<Double> array -> have parsed ranges # 
	 
	* *@return void */ 
	
	public static void symbolRangeBetw(HashSet<Integer> intersection, ArrayList<Investment> investAdd, String choiceSymbol, ArrayList<Double> array, int j )
	{
		
		for(int x = 0; x< intersection.size(); x++)
		{
			 
			 ArrayList<Integer> arr = new ArrayList<Integer>(intersection);
			 
			
			 if(choiceSymbol.equalsIgnoreCase(investAdd.get(arr.get(x)).symbol) && ((array.get(0) <= investAdd.get(arr.get(x)).price) && 
						(investAdd.get(arr.get(x)).price <= array.get(0+1))) )
				{
				   System.out.println(investAdd.get(arr.get(x)));
				   
				}
			 
			
		}
	
		
	
	}	
	
	/**
	*User-defined function(called from search()) that iterates through intersection set (set that has the common indexes from searching 
	*for company name) and compares symbols for exactness and and compares price within exact range ex. '80'
	 *@pre user defined arrayList for type Investment and updated HashMap

	 *@param Investment arrayList.

	 *@param HashSet<Integer> intersection
	
	 *@param String choiceSymbol
	 
	 *@param int j -> current position in investment array
	 
	 *@param ArrayList<Double> array -> have parsed ranges # 
	 
	* *@return void */ 
	public static void symbolRangeExact(HashSet<Integer> intersection, ArrayList<Investment> investAdd, String choiceSymbol, ArrayList<Double> array, int j )
	{
		
		for(int x = 0; x< intersection.size(); x++)
		{
			 
			 ArrayList<Integer> arr = new ArrayList<Integer>(intersection);
			 
			
			 if(choiceSymbol.equalsIgnoreCase(investAdd.get(arr.get(x)).symbol) && ( (array.get(0) == investAdd.get(arr.get(x)).price)) )
				{
				   System.out.println( investAdd.get(arr.get(x)));
				   
				}
			 
			
		}
	
		
	
	}	
	
	
	
	

}


