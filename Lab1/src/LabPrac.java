/***************************************
Name: Martina Tawedrous
Date: September 23 2017
Email: mtawedro@uoguelph.ca
Student Number: 0977473
Program: LabPrac.java
***************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;



public class LabPrac {

	@SuppressWarnings("resource")
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	
	{
		BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
		
		
		int x;
		int i = 0;
		int totalChar = 0;
		int totalResult = 0;
		int totalVowels = 0;
		int flag = 0;
		int k = 0;
		int count = 0;
		int start = 0;
		String tok;

	
		
		String [] array = new String[10];
		
		
		System.out.println("1. Enter a sentence");
		System.out.println("2. Print all sentences entered, in the order they were entered");
		System.out.println("3. Print all sentences entered, in reverse order");
		System.out.println("4. Print the total number of sentences entered");
		System.out.println("5. Print the total number of characters in all sentences");
		System.out.println("6. Print the number of vowels in all sentences");
		System.out.println("7. Print the kth sentence stored (if it exists)");
		System.out.println("8. Search for a word using case-insensitive comparisons");
		System.out.println("9. Search for a word using case-sensitive comparisons");
		System.out.println("10. Quit");  
	
		
		System.out.println("Enter in a Number: 1-10\n");
		
		x = Integer.parseInt(myinput.readLine());
		
		Scanner user = new Scanner (System.in);
		
		String input;
		
		

		while(x!=10)
		{
		
			switch(x)
			{
			
				case 1:
				
				{
				
					if(start > 10)
					{
						System.out.println("Sorry you've entered 10 sentences");
						
						
					}
					
					System.out.println("Enter in a sentence");
					
					flag = 1;
					
					input = user.nextLine();
					
					while(input.length() == 0 || input.charAt(0) == ' ')
					{
						System.out.println("Sorry, enter in a valid Sentence");
						
						input = user.nextLine();
						
						start ++; 
						
					}
								
					
					array[i]= input;
					
					
					i++;
					
					break;
						
				}
			
				
				
				case 2:
					
				{
					
					if(flag==1)
					{
					
					
						for(int j = 0; j< i; j++)
						{
						
							System.out.println(array[j]);
								
						}
					
						break;
					
					}
					
					else
					{
						System.out.println("Sorry, you have to enter in at least one sentence");
						
						break;
					}
					
					
					
					}
				
				
				case 3:
				{
					
					
					if(flag==1)
					{
					
						for(int j = i-1; j>=0; j--)
						{
							System.out.println(array[j]);
						
						
						}
					
						break;
					}
				
					else
					{
						System.out.println("Sorry, you have to enter in at least one sentence");
						break;
					}
					
					
					
				}
				
				
				
				case 4:
				{
									
					System.out.println("Sentences: " + i);
				
					break;
					
				}
				
		
			
				case 5:
				{
					
								
					for(int a = 0; a<i; a++)
					{
						totalChar= array[a].length();
						
						totalResult = totalResult + totalChar;
				
					}
					
					System.out.println("Total Char: " + totalResult);
									
					totalResult = 0; 
					
					break;
					
				}
			
			
			
				
				case 6:
				{
					
					for(int a = 0; a<i; a++)
					{
						
						
						for(k = 0; k<= array[a].length() -1; k++)
						{
						
							
							if(array[a].charAt(k) == 'a' || array[a].charAt(k) == 'e' || array[a].charAt(k) == 'i'|| array[a].charAt(k) == 'o' ||
									array[a].charAt(k) == 'u'|| array[a].charAt(k) == 'y' || array[a].charAt(k) == 'A' || array[a].charAt(k) == 'E' ||
									array[a].charAt(k) == 'I'|| array[a].charAt(k) == 'O' ||
									array[a].charAt(k) == 'U'|| array[a].charAt(k) == 'Y'  )
							{
							
								totalVowels++;
							
							
							
							}
						
						}
				
					}
					
					System.out.println("Total Vowels: " + totalVowels);
					
					totalVowels = 0;
					
					
					break;	
				
				}
				
				
				
				case 7:
				{
					
					if(flag==1)
					{
						System.out.println("Which sentence do you you want to print? (1-10)");
					
						count = Integer.parseInt(myinput.readLine());
					
						while(count>i)
						{
							System.out.println("Invalid input, please try again (1-10)");
							count = Integer.parseInt(myinput.readLine());
							
						}
						
								
						if(count>10 || count<0)
						{
							System.out.println("Invalid input, please try again (1-10)");
						
							count = Integer.parseInt(myinput.readLine());
						}
					
					
						else
						{
							System.out.println(array[count-1]);
					
						}
				
						break;
					}
					
					else
					{
						System.out.println("Sorry, you have to enter in at least one sentence");
						break;
					}
				
				
				
				
				}
				
				
		
				
				case 8:
				{
					if(flag==1)
					{
						System.out.println("Enter Word you want to search:");
						
						input = user.nextLine(); 
					
					
					
					for(int a = 0; a<i; a++)
					{
						String del = ", .;:!-?";
						
						StringTokenizer split = new StringTokenizer(array[a], del);
					    
						while (split.hasMoreTokens()) 
						{
					         
							tok = split.nextToken();
						
							if(input.compareToIgnoreCase(tok) == 0)
							{
								
								System.out.println("Match Found in Sentence " + (a+1));
							
								
							}
						
							/*
							else
							{
								System.out.println("No sentences found");
								
							}
							 */
				    	
						}
				
					
					
					}
					
					
						
					break;
					
					}
					
					else
					{
					
						System.out.println("Sorry, you have to enter in at least one sentence");
						break;
				
					}
				
		
				
				}
				
				
				
				case 9:
				{
					
					if(flag ==1)
					{
					
						System.out.println("Enter Word you want to search:");
					
						input = user.nextLine(); 
					
					
					for(int a = 0; a<i; a++)
					{
						
						String del = ", .;:!-?";
						
						StringTokenizer split = new StringTokenizer(array[a], del);
					    
						while (split.hasMoreTokens()) 
						{
					         
							tok = split.nextToken();
							
							if(input.compareTo(tok) == 0)
							{
								
								
								System.out.println("Match Found in Sentence: " + (a+1));
								
								
								
							}
						
							/*
							else
							{
								System.out.println("No sentences found");
								
							}
							 */
				    	
						
				    	
						}
				
					
					
					}
					
					
						
					break;
				
					
					}
					
					else
					{
					
						System.out.println("Sorry, you have to enter in at least one sentence");
						break;
				
					}
				
				
				
				}
				
				default:
				{
					System.out.println("Sorry please enter in options 1-10");
				}
				
			
			} 
			
			
			
			System.out.println("Enter in a Number: 1-10");
			
			x = Integer.parseInt(myinput.readLine());
		
		}
		
		
	
		System.out.println("Exited");
		
		
		
	}//end of main

	
	
}//end of class
