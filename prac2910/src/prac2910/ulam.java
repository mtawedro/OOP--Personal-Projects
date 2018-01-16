/***************************************
Name: Martina Tawedrous
Date: September 23 2017
Email: mtawedro@uoguelph.ca
Student Number: 0977473
Program: ulam.java
REFERENCE: @C++ Program Sanfoundry --www.sanfoundry.com--
***************************************/

package prac2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ulam {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
		
		int [] newArray  = new int [5000]; 
		 
		  newArray[0]=1;
		 
		  newArray[1]=2;
		
		  int user ;
		  
		 int i = 0;
		  
		  int num = 2;
		  
		 
		  System.out.println("Enter  your  choice:\n");
		  
		  user = Integer.parseInt(myinput.readLine());
		  
		  for (int x=3; x<=5000; x++)
		  {
			
			  for (int j=0; j<num; j++)
			  {
		         
		    	  for (int k=j+1; k<num; k++)
		    	  {
		              
		        	   if (newArray[j] + newArray[k] == x)
		        	   {

		            	  i++;
		        	   	}
		    	  }
		 }
		
			  if (i==1)
			  {
				  newArray[num]= x;
				
				  num++;
			  }
			  
			  i=0;
		   }
		  	
		  	System.out.println("Ulam number is \n" + newArray[user-1]);
		

		 }

	}



/************************************
 * pseudo:
For the nth term is less than or equal to 5000, starting at index 3 and iterating 
{
 	for the third term starting at index 0 while the second term is less than the term entered by the user 
 	{
    	For the second term + 1, giving you the next term you're adding it by, while its less than the term entered by the user
     	{
    		this adds the calculated terms you need and makes it the new first term so that the process can be repeated until nth term. 
		}
	}

}
 * 
 **********************************/

