package Portfolio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Investment 
{
	String symbol;
	String Name;
	int sharesNum;
	double price;
	double bookValue;
	
	public Investment (String compSymbol, String compName, int shares, double stockPrice, double book)
	{
	
		this.symbol = compSymbol;
		this.Name = compName;
		this.sharesNum = shares;
		this.price = stockPrice;
		this.bookValue = book;
			
	}

	
	
	
	/**
	*User-defined function to enable user to sell investments editing updated prices with
	* their respected calculations and receiving total revenue.

	 *@pre user defined arrayList for type Investment

	 *@param Investment ArrayList.

	* *@return void */ 
	
	
				public static void SellInvestments(HashMap<String,  HashSet <Integer>> hm, ArrayList<Investment> investAdd) throws NumberFormatException, IOException
				{
			
				   BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
					String choiceSymbol;
					int shareLoss = 0;
					int flag = 0;
					double comm = 0.00;
					double revenueGained = 0.0;
					double newPrice = 0.0;
					
					Scanner user = new Scanner (System.in);
					
					
					System.out.println("Enter company investment you want to sell: (symbols)");
					
					choiceSymbol = user.nextLine();	
					
					while(choiceSymbol.length() == 0)
					{
						System.out.println("Invalid Choice, you must enter in a symbol");
						
						choiceSymbol = user.nextLine();	
					}
					
					
					for(int x = 0; x<investAdd.size(); x++)
					{
						if(choiceSymbol.equals(investAdd.get(x).symbol))
						{
							flag = 1;
							
							
							if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.Stock"))
					         {

								comm = 9.99;
					         }
							
							 else if(investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.MutualFund"))
							 {
								 comm = 45.00;
							 }
							
							boolean done = false;
							while (!done) {
							    try {
							    	System.out.println("Enter Current price for this investment:");
									
									newPrice = Double.parseDouble(myinput.readLine());
							       
									done = true;
							    } catch (NumberFormatException e) 
							    {
							       System.out.println("Invalid Input");
							    }
					      	}
							
							if(newPrice <= 0)
							{
								System.out.println("Invalid input: Can't have neg price");
								done = false;
								while (!done) {
								    try {
								    	System.out.println("Enter Current price for this investment:");
										
										newPrice = Double.parseDouble(myinput.readLine());
								       
										done = true;
								    } catch (NumberFormatException e) 
								    {
								       System.out.println("Invalid Input");
								    }
						      	}
						
								
							}
							
							investAdd.get(x).price = newPrice;
							
							done = false;
							while (!done) {
							    try {
							    	System.out.println("Enter amount of shares you want to sell");
									
									shareLoss = Integer.parseInt(myinput.readLine());
									
							       
									done = true;
							    } catch (NumberFormatException e) 
							    {
							       System.out.println("Invalid Input");
							    }
					      	}
							
							
							while(shareLoss <= 0)
							{
								System.out.println("Invalid Input, you must enter at least one share");
								
								done = false;
								while (!done) {
								    try {
								    	System.out.println("Enter amount of shares you want to sell");
										
										shareLoss = Integer.parseInt(myinput.readLine());
										
								       
										done = true;
								    } catch (NumberFormatException e) 
								    {
								       System.out.println("Invalid Input");
								    }
						      	}
							}
							
							
							
							while(shareLoss > investAdd.get(x).sharesNum )
							{
								System.out.println("Invalid Input, shares entered exceeded limit amount");
								
								done = false;
								while (!done) {
								    try {
								    	System.out.println("Enter amount of shares you want to sell");
										
										shareLoss = Integer.parseInt(myinput.readLine());
										
								       
										done = true;
								    } catch (NumberFormatException e) 
								    {
								       System.out.println("Invalid Input");
								    }
						      	}
							}
							
							
							if(shareLoss <= investAdd.get(x).sharesNum)
							{
							
							
								investAdd.get(x).bookValue = (investAdd.get(x).bookValue * (investAdd.get(x).sharesNum - shareLoss)) / investAdd.get(x).sharesNum;
									
								investAdd.get(x).sharesNum = investAdd.get(x).sharesNum - shareLoss; 
								
								revenueGained = ((shareLoss * investAdd.get(x).price) - comm );
								
								System.out.println("Revenue Received: $" + revenueGained);
								
								if(investAdd.get(x).sharesNum <= 0)
								{
									investAdd.remove(x);
									
									//to delete from HashMap
									Portfolio.DeleteIndex(hm, investAdd, x);
									
								}
											
								
						
							}
							
							
							
						}
						
					}
					
					if(flag != 1)
					{
						System.out.println("Sorry, investment doesn't exit");
					}
					
					
				}
				
	
	
	
	
	/**
	*User-defined function to generic data updated all Investment price with
	* their respected calculations.

	 *@pre user defined arrayList for type Investment

	 *@param Investment ArrayList.

	* *@return void*/ 
	
	public static void updateInvestmentPrice(ArrayList<Investment> investAdd) throws NumberFormatException, IOException 
	{
		BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
		double updated = 0.0;
		String choice;
		
		
		Scanner user = new Scanner (System.in);
		
		for(int x = 0; x<investAdd.size(); x++)
		{
			 if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.Stock"))
	          {
				 System.out.println("Stocks:");
	          }
			 
			 else  if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.MutualFund"))
	          {
				 System.out.println("Mutual Funds:");
	          }
				
			 	 
			 	System.out.println(investAdd.get(x).symbol + "\n" + investAdd.get(x).Name + "\n" +  "Current Price: $" + investAdd.get(x).price + "\n");
			
				System.out.println("Enter 'P'- To Update Price, 'S'- To Skip This Investment, 'Q'- Quit)");
				
				choice = user.nextLine();
				
				
				while(choice.equalsIgnoreCase("P") == false && choice.equalsIgnoreCase("S") == false && choice.equalsIgnoreCase("Q") == false)
				{
					System.out.println("Invalid Choice, Enter 'P'- To Update Price, 'S'- To Skip This Investment, 'Q'- Quit)" );
					choice = user.nextLine();
				}
				
				
				
				if(choice.charAt(0) == 'P' || choice.charAt(0) == 'p')
				{
					boolean done = false;
					while (!done) {
					    try {
					    	System.out.println("Enter updated Price:");
							
							updated = Double.parseDouble(myinput.readLine());
							
					       
							done = true;
					    } catch (NumberFormatException e) 
					    {
					       System.out.println("Invalid Input");
					    }
			      	}
					
				
					if(updated <= 0)
					{
						System.out.println("Invalid input: Can't have neg price");
						done = false;
						while (!done) {
						    try {
						    	System.out.println("Enter updated Price:");
								
								updated = Double.parseDouble(myinput.readLine());
						       
								done = true;
						    } catch (NumberFormatException e) 
						    {
						       System.out.println("Invalid Input");
						    }
				      	}
				
						
					}
				
					investAdd.get(x).price = updated;
				}
				
				else if(choice.charAt(0) == 'Q' || choice.charAt(0) == 'q')
				{
					
					break;
				}
		
		
		}
		
		
	
	}
	
	
	/**
	*User-defined function to generic data by adding  all gained fees from all the investments in list.

	 *@pre user defined arrayList for type Investment

	 *@param Investment ArrayList.

	 *@param amountGained  ArrayList.

	* *@return void */ 
	
	public static void InvestmentGained(ArrayList<Investment> investAdd, ArrayList<Double> amountGained) //include this in super 
	{
		
		double totalGained = 0.0;
		int G = 0;
		double amountGain = 0.0;
		double comm = 0.00;
		
		
		
		for(int x = 0; x<investAdd.size(); x++)
		{

			 if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.Stock"))
	         {
	            comm = 9.99;
	         }
			
			 else if(investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.MutualFund"))
			 {
				 comm = 45.00;
			 }
				 
			
			 amountGain = ((investAdd.get(x).sharesNum * investAdd.get(x).price) - comm) - investAdd.get(x).bookValue;
	
			 amountGained.add(G, amountGain);
			
			 totalGained = totalGained + amountGained.get(G);
			
			 G++;
		
		}
		
		
		 System.out.println("Total Amount Gained:" + totalGained);
	
		
		
		
	}
  
			
				/**User-defined function to represent object MutualFund in a textualized format.

				 *@pre user defined object Investment

				 * *@return type object 
				 * */ 
				public String toString()

				{

					String Data1= "Symbol:"+ this.symbol+"\n"+"Name:"+ this.Name +"\n";
					String Data3= "Number of Shares:"+ this.sharesNum + "\n";
					String Data8= "Price:"+ this.price+ "\n";
					String Data9="Book Value:"+this.bookValue;
					
					String Data= Data1+Data3+ Data8+ Data9+ "\n";
						
					return Data;

				}
	

				
				/**
				*User-defined function to represent object MutualFund in a textualized format **used for only writing to .txt file.

				 *@pre user defined object Investment

				* *@return type object 
				* */ 
				public String toString1()

				{
					String Data1=  this.symbol+ "," + this.Name + "," + this.sharesNum + "," + this.price + "," + this.bookValue  ;
			   		
			   		String Data= Data1 ;
			   			
					return Data;
					

				}
				
				
				/**
				 *User-defined function to compare 2 objects and check if they are equal.

				 *@pre user defined object Investment

				 * *@return type boolean
				 * */ 
				
				public boolean equals(Object obj) {
			        if (this == obj) {
			            return true;
			        }
			        if (obj == null) {
			            return false;
			        }
			        if (getClass() != obj.getClass()) {
			            return false;
			        }
			            
			        final Investment other = (Investment) obj;
			        
			        if (Double.compare(this.bookValue, other.bookValue) == 0  
			            && Double.compare(this.price, other.price) == 0 
			            && Integer.compare(this.sharesNum, other.sharesNum) == 0 
			            && this.symbol.equalsIgnoreCase( other.symbol)
			            && this.Name.equalsIgnoreCase(other.Name) ) {
			            return true;
			        }
			        return false;
			    }
				

}
