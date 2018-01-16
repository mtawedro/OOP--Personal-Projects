package Portfolio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MutualFund extends Investment
{


	
	public MutualFund (String compSymbol, String compName, int shares, double stockPrice, double book)
	{
	
		super(compSymbol, compName, shares, stockPrice, book);
			
	}
	
	
	/**
	*User-defined function to generic data by adding and editing updated mutualFunds with
	* their respected calculations.

	*@pre user defined arrayList for type Investment

	 *@param Investment ArrayList

	* *@return void */ 
	
	public static void CalculateMutualFunds( ArrayList<Investment> investAdd)throws NumberFormatException, IOException{

		int numShares = 0;
		double value = 0.0;
		int holdShares = 0;
		String choice;
		String choiceSymbol;
		int count = 0;
		double newPrice = 0.0;
		String compName;
		int present = 0;
		boolean exit = true;
		int found = 0;
		
		Scanner user = new Scanner (System.in);
			
		BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
	
					
		
					
					System.out.println("own a new investment (A) or add more quantity to an existing investment(B)?");
					
					choice =  user.nextLine();	
					
					while(choice.equalsIgnoreCase("A") == false && choice.equalsIgnoreCase("B") == false)
					{
						System.out.println("Invalid Input: own a new investment (A) or add more quantity to an existing investment(B)?");
						
						choice = user.nextLine();
					}
					
					if(choice.charAt(0) == 'B' || choice.charAt(0) == 'b')
					{
						for(int x = 0; x<investAdd.size(); x++)
						{
							
							 if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.MutualFund"))
					         {
					            exit = false;
					         }
							
							
						}
						
						if(exit == true)
						{
							System.out.println("Sorry, there are no Mutual Funds to update shares");
							
						}
					
					if(exit == false)
					{	
						
						
						
						System.out.println("Which Company do you want to add shares to? (symbols):");
					
						choiceSymbol = user.nextLine();	
						
						while(choiceSymbol.length() == 0)
						{
							System.out.println("Invalid Choice, you must enter in a symbol");
							
							choiceSymbol = user.nextLine();	
						}
					
						for(int x = 0; x<investAdd.size(); x++)
						{
							if(choiceSymbol.equalsIgnoreCase(investAdd.get(x).symbol))
							{
								found = 1;
							}
						}
						
						if(found != 1)
						{
							System.out.println("Investment does not exsit");
						}
						
						else
						{
						   //asks for updated price
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
							
							//Initializes new price
							for(int x = 0; x<investAdd.size(); x++)
							{
								if(choiceSymbol.equalsIgnoreCase(investAdd.get(x).symbol))
								{
									investAdd.get(x).price = newPrice;
									
								}
							}
							
							
							
							
							done = false;
							while (!done) {
							    try {
							    	System.out.println("How much shares you want to buy?");
							    	numShares = Integer.parseInt(myinput.readLine());
							        done = true;
							    } catch (NumberFormatException e) 
							    {
							       System.out.println("Invalid Input");
							    }
					      	}
						
						while(numShares <= 0)
						{
							System.out.println("Sorry, you must enter in at least one share:");
							
							 done = false;
								while (!done) {
								    try {
								    	System.out.println("How much shares you want to buy?");
								    	numShares = Integer.parseInt(myinput.readLine());
								        done = true;
								    } catch (NumberFormatException e) 
								    {
								       System.out.println("Invalid Input");
								    }
						      	}
							
						}
							
						for(int x = 0; x< investAdd.size(); x++)
						{
							
							
							if(choiceSymbol.equalsIgnoreCase(investAdd.get(x).symbol))
							{
								
								investAdd.get(x).sharesNum = investAdd.get(x).sharesNum + numShares;
								
								investAdd.get(x).bookValue = investAdd.get(x).bookValue + 
						        
								((investAdd.get(x).price) * numShares) ;
								
							
							}
						
						
						}
					
						for(int x = 0; x<investAdd.size(); x++)
						{
							System.out.println(investAdd.get(x));
						}
					
					
						}// end of big else
					
					}// end of exit if
				
				}//end of if
					
					
					else if(choice.charAt(0) == 'A' || choice.charAt(0) == 'a')
					{
								
								
								System.out.println("Which Company do you want to buy shares from? Enter Symbol:");
								
								choiceSymbol = user.nextLine();	
								
								while(choiceSymbol.length() == 0)
								{
									System.out.println("Invalid Choice, you must enter in a symbol");
									
									choiceSymbol = user.nextLine();	
								}
						
							
								for(int x = 0; x < investAdd.size(); x++)
								{
									if(choiceSymbol.equals(investAdd.get(x).symbol))
									{
										if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.Stock"))
							             {
							              
											System.out.println("Sorry, this investment already exists in your Stock List");
										
											present = 1;	
							             }
									}
									
									
								}
								
											
								
								
								for(int x = 0; x < investAdd.size(); x++)
								{
									if(choiceSymbol.equals(investAdd.get(x).symbol))
									{
										if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.MutualFund"))
							             {
										
										present = 1;
										
										System.out.println("Sorry, this investment already exists in your Mutual Funds List");
										
										 boolean done = false;
											while (!done) {
											    try {
											    	System.out.println("How much shares you want to buy?");
											    	numShares = Integer.parseInt(myinput.readLine());
											        done = true;
											    } catch (NumberFormatException e) 
											    {
											       System.out.println("Invalid Input");
											    }
									      	}
										
										while(numShares <= 0)
										{
											System.out.println("Sorry, you must enter in at least one share:");
											
											 done = false;
												while (!done) {
												    try {
												    	System.out.println("How much shares you want to buy?");
												    	numShares = Integer.parseInt(myinput.readLine());
												        done = true;
												    } catch (NumberFormatException e) 
												    {
												       System.out.println("Invalid Input");
												    }
										      	}
											
										}
										
										investAdd.get(x).sharesNum = investAdd.get(x).sharesNum + numShares;
										
										investAdd.get(x).bookValue = investAdd.get(x).bookValue + 
								        
										((investAdd.get(x).price) * numShares) ;
										
								
									}
									
									
									}
								
								}
								
								
								
								if(present != 1)
								{
								
								System.out.println("Enter Name of company:");
								
								compName = user.nextLine();
								
								while(compName.length() == 0)
								{
									System.out.println("Invalid Choice, you must enter in a company name");
									
									compName = user.nextLine();
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
								
										
						
								
								MutualFund temp = new MutualFund( choiceSymbol, compName, 0, newPrice, 0.0);
								
								investAdd.add(count,temp);	
								
								 done = false;
									while (!done) {
									    try {
									    	System.out.println("How much shares you want to buy?");
									    	numShares = Integer.parseInt(myinput.readLine());
									        done = true;
									    } catch (NumberFormatException e) 
									    {
									       System.out.println("Invalid Input");
									    }
							      	}
								
								while(numShares <= 0)
								{
									System.out.println("Sorry, you must enter in at least one share:");
									
									 done = false;
										while (!done) {
										    try {
										    	System.out.println("How much shares you want to buy?");
										    	numShares = Integer.parseInt(myinput.readLine());
										        done = true;
										    } catch (NumberFormatException e) 
										    {
										       System.out.println("Invalid Input");
										    }
								      	}
									
								}
									
								holdShares = holdShares + numShares;
									
								investAdd.get(count).sharesNum = holdShares;
									
								value = (investAdd.get(count).price) * (investAdd.get(count).sharesNum);
									
								
									
								investAdd.get(count).bookValue =  value;
								
								value = 0;
								
								holdShares = 0;
										
								count++;
								}
						
						
								
								
								for(int x = 0; x<investAdd.size(); x++)
								{
									System.out.println(investAdd.get(x));
								}
								
				    }
				
					
				
			}

				
	/**
	*User-defined function to represent object MutualFund in a textualized format.

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
