package Portfolio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Portfolio {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
		
		int input = 0;
		double totalGained = 0.0;
		String search;
		String choiceStock;
		double returnTotalMutualFunds = 0.0;
		double returnStock = 0.0;
		int returnFlag;
		String tok;
		String choiceSymbol;
		String range;
		String compName;
		
		Scanner user = new Scanner (System.in);
		
		// ***used for the search options but initially nothing is in user's portfolio**
		Stock s1 = new Stock("AAPL", "Apple Inc", 0, 156.99, 0.0);
		Stock s2 = new Stock("GOOAV", "Google Inc", 0, 568.67, 0.0);
		Stock s3 = new Stock("RY", "Royal Bank of Canada", 0, 99.08, 0.0);
		Stock s4 = new Stock("BBRY", "Blackberry Ltd", 0, 11.57, 0.0);
		Stock s5 = new Stock("BAC", "Bank of America", 0, 25.83, 0.0);
		Stock s6 = new Stock("DIS", "Walt Disney Inc", 0, 97.38, 0.0);
		Stock s7 = new Stock("IBM", "International Business Machines Corp", 0, 147.10, 0.0);
		Stock s8 = new Stock("MSFT", "Microsoft Inc", 0, 77.49, 0.0);
		Stock s9 = new Stock("INTC", "Intel Inc", 0, 39.67, 0.0);
		Stock s10 = new Stock("TSE:L", "Lobaw Companies Ltd", 0, 69.15, 0.0);
		Stock s11 = new Stock("FB", "Facebook Inc", 0, 173.74, 0.0);
		
		MutualFund m1 = new MutualFund("CSCO", "Cisco Systems Inc", 0, 33.47, 0.0);
		MutualFund m2 = new MutualFund("AMZN", "Amazon.com Inc", 0, 1002.94, 0.0);
		MutualFund m3 = new MutualFund("BMO", "Bank of Montreal", 0, 97.53, 0.0);
		MutualFund m4 = new MutualFund("TD", "Toronto Dominion Bank", 0, 71.08, 0.0);
		MutualFund m5 = new MutualFund("T", "TELUS Corporation", 0, 44.99, 0.0);
		MutualFund m6 = new MutualFund("RCI.B", "Rogers Communications Inc", 0, 67.12, 0.0);
		MutualFund m7 = new MutualFund("KO", "Coca-Cola Corp", 0, 173.74, 0.0);
		MutualFund m8 = new MutualFund("WMT", "Wal-Mart Stores Inc", 0, 86.62, 0.0);
		MutualFund m9 = new MutualFund("AC", "Air Canada", 0, 27.70, 0.0);
		MutualFund m10 = new MutualFund("SIM", "SimCorp A/S", 0, 386.10, 0.0);
		MutualFund m11 = new MutualFund("GOOGL", "Alphabet Inc", 0, 1007.87, 0.0);

		ArrayList<Stock> stocks = new ArrayList<Stock>();
		ArrayList<Stock> stocksAdd = new ArrayList<Stock>();
		ArrayList<Double> amountGained = new ArrayList<Double>();
		
		ArrayList<MutualFund> MutualFunds = new ArrayList<MutualFund>();
		ArrayList<MutualFund> mutualFundsAdd = new ArrayList<MutualFund>();
		ArrayList<Double> amountGainedm = new ArrayList<Double>();
		ArrayList<Double> array = new ArrayList<Double>();
		
		
		// adding to stocks array list 
		stocks.add(0, s1);
		stocks.add(1, s2);
		stocks.add(2, s3);
		stocks.add(3, s4);
		stocks.add(4, s5);
		stocks.add(5, s6);
		stocks.add(6, s7);
		stocks.add(7, s8);
		stocks.add(8, s9);
		stocks.add(9, s10);
		stocks.add(10, s11);
		
		MutualFunds.add(0, m1);
		MutualFunds.add(0, m2);
		MutualFunds.add(0, m3);
		MutualFunds.add(0, m4);
		MutualFunds.add(0, m5);
		MutualFunds.add(0, m6);
		MutualFunds.add(0, m7);
		MutualFunds.add(0, m8);
		MutualFunds.add(0, m9);
		MutualFunds.add(0, m10);
		MutualFunds.add(0, m11);
		
		
		System.out.println("(1) buy: own a new investment or add more quantity to an existing investment");    
		 
		System.out.println("(2) sell: reduce some quantity of an existing investment"); 
		 
		System.out.println("(3) update: refresh the prices of all existing investments"); 
		 
		System.out.println("(4) getGain: compute the total gain of the portfolio by accumulating the gains of all its investments");    
		 
		System.out.println("(5) Search:");
		
		System.out.println("(6) Quit:");
		
		
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
					MutualFund.CalculateMutualFunds(MutualFunds, mutualFundsAdd, stocksAdd);
				}
				
				else if(choiceStock.equalsIgnoreCase("S"))
				{
					Stock.CalculateStockFunds(stocks, stocksAdd, mutualFundsAdd);
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
				
				
				if(choiceStock.equalsIgnoreCase("MF"))
				{
					MutualFund.SellMutualFunds( mutualFundsAdd);
				}
				
				else if(choiceStock.equalsIgnoreCase("S"))
				{
					Stock.SellStocks(stocksAdd); 
				}
				
				//prints
				for(int x = 0; x<stocksAdd.size(); x++)
				{
					System.out.println(stocksAdd.get(x));
				}


				for(int x = 0; x<mutualFundsAdd.size(); x++)
				{
					System.out.println(mutualFundsAdd.get(x));
				}

				
				
				
				break;
				
			}//end of case2
			
			
			case 3:
			{
				/*FIX THIS WHEN THERES NO STOCKS PRINT NO STOCKS, and if theres 1 node press s shoudnt go to the next one*/
				if(stocksAdd.size() !=0)
				{
					System.out.println("Stocks:");
				}
				
				returnFlag = Stock.updateStockPrice(stocksAdd);
				
				if(returnFlag != -1)
				{
					System.out.println("Mutual Funds:");
							
					MutualFund.updateMutualFundPrice(mutualFundsAdd);
				}
				
				
				//prints
				for(int x = 0; x<stocksAdd.size(); x++)
				{
					System.out.println(stocksAdd.get(x));
				}

				
				for(int x = 0; x<mutualFundsAdd.size(); x++)
				{
					System.out.println(mutualFundsAdd.get(x));
				}

			
				break;
	
			}//end of case3
			
			
			case 4:
			{
				
				 returnTotalMutualFunds = MutualFund.MutualFundsGained(mutualFundsAdd, amountGainedm);
				 
				 returnStock = Stock.StocksGained(stocksAdd, amountGained);
				 
				 totalGained =  returnTotalMutualFunds + returnStock;
				 
				 System.out.println("Total Amount Gained:" + totalGained);
								
				
			   	 break;
			
			}//end of case 4
			
			
			case 5:
			{
				
				int below = 0;
				int above = 0;
				int between = 0;
				int temp = 0;
				int exact = 0;
				int tempComp = 0;
				int tempCompStruct = 0;
				int flag = 0;
				
				String del = "-";
				    
				System.out.println("Search-------------------------");
				System.out.println("Enter Symbol:");
				choiceSymbol = user.nextLine();
				System.out.println("Enter name of company:");
				compName= user.nextLine();
				System.out.println("Enter Range:");
				//choiceSymbol = user.nextLine();
				range = user.nextLine();
			
				
				if(choiceSymbol.length() == 0 && compName.length() == 0 && range.length() == 0)
				{
					
					for(int x = 0; x<stocksAdd.size(); x++)
					{
						System.out.println(stocksAdd.get(x));
					}
					
					
					for(int x = 0; x<mutualFundsAdd.size(); x++)
					{
						System.out.println(mutualFundsAdd.get(x));
					}
				
					flag = 1;
				
				}
				
				
				else if(choiceSymbol.length() != 0 && compName.length() == 0 && range.length() == 0 )
				{
					
					for(int j = 0; j<stocksAdd.size(); j++)
					{
						if(choiceSymbol.equalsIgnoreCase(stocksAdd.get(j).symbol) )
						{
							System.out.println(stocksAdd.get(j));
						}
						
					}
					

					for(int j = 0; j<mutualFundsAdd.size(); j++)
					{
						if(choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol) )
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
					}
					
					flag = 1;
					
				}
				
				else if(choiceSymbol.length() == 0 && compName.length() != 0 && range.length() == 0 )
				{
					
					for(int j = 0; j<mutualFundsAdd.size(); j++)
					{
						if( mutualFundsAdd.get(j).Name.contains(compName))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
					}
				
	
					for(int j = 0; j<stocksAdd.size(); j++)
					{
						if( stocksAdd.get(j).Name.contains(compName))
						{
							System.out.println(stocksAdd.get(j));
						}
						
					}
					
					flag = 1;
				}
				
				
				
				else if(choiceSymbol.length() != 0 && compName.length() != 0 && range.length() == 0)
				{
					for(int j = 0; j<mutualFundsAdd.size(); j++)
					{
					
						if( mutualFundsAdd.get(j).Name.contains(compName) && choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
					}
					for(int j = 0; j<stocksAdd.size(); j++)
					{
					
						if(stocksAdd.get(j).Name.contains(compName) && choiceSymbol.equalsIgnoreCase(stocksAdd.get(j).symbol))
						{
							System.out.println(stocksAdd.get(j));
						}
					}
					
					flag = 1;
					
				}
				
				
				
				
				
				if(flag != 1)
				{
				
				
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
				//System.out.println("INSIDE LOOP");
				
				for(int j = 0; j < stocksAdd.size(); j++)
				{
					
					
					if(choiceSymbol.length() == 0 && compName.length() != 0 && below == 1 )
					{
						
						
					
						
						if(stocksAdd.get(j).Name.contains(compName) && (stocksAdd.get(j).price <= array.get(0)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
					}
				
					
					else if(choiceSymbol.length() == 0 && compName.length() != 0 && above == 1 )
					{
						
					
						if(stocksAdd.get(j).Name.contains(compName) && (stocksAdd.get(j).price >= array.get(0)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
					}
					
					else if(choiceSymbol.length() == 0 && compName.length() != 0 && between == 1 )
					{
					
						
						if(stocksAdd.get(j).Name.contains(compName) && ((array.get(0) <= stocksAdd.get(j).price) && 
								(stocksAdd.get(j).price <= array.get(0+1))))
						{
							System.out.println(stocksAdd.get(j));
						}
						
					}
					
					
					else if(choiceSymbol.length() == 0 && compName.length() != 0 && exact == 1 )
					{
						
						if(stocksAdd.get(j).Name.contains(compName) && ((array.get(0) == stocksAdd.get(j).price)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
					}
					
					
					//
					else if(choiceSymbol.length() != 0 && compName.length() == 0 && below == 1)
					{
						
						if(choiceSymbol.equalsIgnoreCase(stocksAdd.get(j).symbol) && (stocksAdd.get(j).price <= array.get(0)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() == 0 && above == 1)
					{
						
						if(choiceSymbol.equalsIgnoreCase(stocksAdd.get(j).symbol) && (stocksAdd.get(j).price >= array.get(0)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() == 0 && between == 1)
					{
						
						if(choiceSymbol.equalsIgnoreCase(stocksAdd.get(j).symbol) && ((array.get(0) <= stocksAdd.get(j).price) && 
								(stocksAdd.get(j).price <= array.get(0+1))))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() == 0 && exact == 1)
					{
						
						if(choiceSymbol.equalsIgnoreCase(stocksAdd.get(j).symbol) && ((array.get(0) == stocksAdd.get(j).price)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}
					
				
					//
					else if(choiceSymbol.length() == 0 && compName.length() == 0 && below == 1  )
					{
						
						if( (stocksAdd.get(j).price <= array.get(0)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}
				
					else if(choiceSymbol.length() == 0 && compName.length() == 0 && above ==1 )
					{
						
						if((stocksAdd.get(j).price >= array.get(0)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}	
				
					else if(choiceSymbol.length() == 0 && compName.length() == 0 && between ==1 )
					{
						
						if(((array.get(0) <= stocksAdd.get(j).price) && (stocksAdd.get(j).price <= array.get(0+1))))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}	
				
					else if(choiceSymbol.length() == 0 && compName.length() == 0 && exact == 1 )
					{
						
						if( ((array.get(0) == stocksAdd.get(j).price)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}	
					
					
					//
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && below == 1)
					{
						
						if(stocksAdd.get(j).Name.contains(compName) && choiceSymbol.equalsIgnoreCase(stocksAdd.get(j).symbol) && (stocksAdd.get(j).price <= array.get(0)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && above == 1)
					{
						
						if(stocksAdd.get(j).Name.contains(compName) && choiceSymbol.equalsIgnoreCase(stocksAdd.get(j).symbol) && (stocksAdd.get(j).price >= array.get(0)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && between == 1)
					{
						
						if(stocksAdd.get(j).Name.contains(compName) && choiceSymbol.equalsIgnoreCase(stocksAdd.get(j).symbol) && ((array.get(0) <= stocksAdd.get(j).price) && 
								(stocksAdd.get(j).price <= array.get(0+1))))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && exact == 1)
					{
						
						if(stocksAdd.get(j).Name.contains(compName) && choiceSymbol.equalsIgnoreCase(stocksAdd.get(j).symbol) && ((array.get(0) == stocksAdd.get(j).price)))
						{
							System.out.println(stocksAdd.get(j));
						}
						
						
					}
						
				
				
					
				}//end of stocks loop
				
				
				
			
				
				
				
				//
				for(int j = 0; j < mutualFundsAdd.size(); j++)
				{
					
					
					if(choiceSymbol.length() == 0 && compName.length() != 0 && below == 1 )
					{
					
						if(mutualFundsAdd.get(j).Name.contains(compName) && (mutualFundsAdd.get(j).price <= array.get(0)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
					}
				
					
					else if(choiceSymbol.length() == 0 && compName.length() != 0 && above == 1 )
					{
					
						if(mutualFundsAdd.get(j).Name.contains(compName) && (mutualFundsAdd.get(j).price >= array.get(0)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
					}
					
					else if(choiceSymbol.length() == 0 && compName.length() != 0 && between == 1 )
					{
					
						if(mutualFundsAdd.get(j).Name.contains(compName) && ((array.get(0) <= mutualFundsAdd.get(j).price) && 
								(mutualFundsAdd.get(j).price <= array.get(0+1))))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
					}
					
					
					else if(choiceSymbol.length() == 0 && compName.length() != 0 && exact == 1 )
					{
					
						if(mutualFundsAdd.get(j).Name.contains(compName) && ((array.get(0) == mutualFundsAdd.get(j).price)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
					}
					
					//HERE
					else if(choiceSymbol.length() != 0 && compName.length() == 0 && below == 1)
					{
						if(choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol) && (mutualFundsAdd.get(j).price <= array.get(0)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() == 0 && above == 1)
					{
						if(choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol) && (mutualFundsAdd.get(j).price >= array.get(0)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() == 0 && between == 1)
					{
						if(choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol) && ((array.get(0) <= mutualFundsAdd.get(j).price) && 
								(mutualFundsAdd.get(j).price <= array.get(0+1))))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() == 0 && exact == 1)
					{
						if(choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol) && ((array.get(0) == mutualFundsAdd.get(j).price)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}
					
				
					//
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && below == 1  )
					{
						if(choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol) && (mutualFundsAdd.get(j).price <= array.get(0)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}
				
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && above ==1 )
					{
						if(choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol)  && (mutualFundsAdd.get(j).price >= array.get(0)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}	
				
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && between ==1 )
					{
						if(choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol)  && ((array.get(0) <= mutualFundsAdd.get(j).price) && 
								(mutualFundsAdd.get(j).price <= array.get(0+1))))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}	
				
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && exact ==1 )
					{
						if(choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol) && ((array.get(0) == mutualFundsAdd.get(j).price)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}	
				
				
					//
					else if(choiceSymbol.length() == 0 && compName.length() == 0 && below == 1  )
					{
						
						if( (mutualFundsAdd.get(j).price <= array.get(0)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}
				
					else if(choiceSymbol.length() == 0 && compName.length() == 0 && above ==1 )
					{
						
						if((mutualFundsAdd.get(j).price >= array.get(0)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}	
				
					else if(choiceSymbol.length() == 0 && compName.length() == 0 && between ==1 )
					{
						
						if((array.get(0) <= mutualFundsAdd.get(j).price) && (mutualFundsAdd.get(j).price <= array.get(0+1)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}	
				
					else if(choiceSymbol.length() == 0 && compName.length() == 0 && exact == 1 )
					{
						
						if( ((array.get(0) == mutualFundsAdd.get(j).price)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}	
				
				
					//
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && below == 1)
					{
						
						if(mutualFundsAdd.get(j).Name.contains(compName) && choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol) && (mutualFundsAdd.get(j).price <= array.get(0)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && above == 1)
					{
						
						if(mutualFundsAdd.get(j).Name.contains(compName) && choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol) && (mutualFundsAdd.get(j).price >= array.get(0)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && between == 1)
					{
						
						if(mutualFundsAdd.get(j).Name.contains(compName) && choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol) && ((array.get(0) <= mutualFundsAdd.get(j).price) && 
								(mutualFundsAdd.get(j).price <= array.get(0+1))))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}
					
					else if(choiceSymbol.length() != 0 && compName.length() != 0 && exact == 1)
					{
						
						if(mutualFundsAdd.get(j).Name.contains(compName) && choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(j).symbol) && ((array.get(0) == mutualFundsAdd.get(j).price)))
						{
							System.out.println(mutualFundsAdd.get(j));
						}
						
						
					}
						
				
				
					
					
					
				}	
				
			     
				
			}	
				
				
				
				
			break;
			}
			
			
			default:
			{
				System.out.println("Sorry please enter in options 1-6");
			}
			
			
			
			
		}//end of switch
		
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
		
	System.out.println("Exited");
  }
		
}
