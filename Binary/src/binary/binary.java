/*********************************
*Name: Martina Tawedrous
*Date: Oct 10 2017
*Email: mtawedro@uoguelph.ca
*Student Number: 0977473
*Program: binary.java
*REFERENCE: @C++ Stack Exchange --www.stackexchange.com--
 *********************************/

package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Binary
{
	 int temp;
    
	String Bin;
   
    void printBinary(int N)
    {
       int j = 0;
    
     //Math.pow raises to power of 2
       for(int x = 0; x < Math.pow(2,N); x++) 
        {
           //empty string 
    	   Bin = "";
           
           //temp starts at 0  
    	   int temp = x;
           
    	   // increments until it reaches the nth term 
    	   while (j < N)
            {
                if (temp % 2 == 1)
                {
                	// temp is even == 1 bit add 1 to begginig of string  
                	Bin = '1'+ Bin; 
                }
                else
                { 
                	//temp i s odd == 0 add 0 to beggining 
                	Bin = '0'+ Bin; 
                    
                	//keep dividing by 2
                	temp = temp/2; 
                }
            
            
                j++;
            }
          
            System.out.println(Bin);
         }
    } 
}

class Input
{
    public static void main(String [] args) throws NumberFormatException, IOException
    {
    	int n;
    	
    	BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
    	
        System.out.print("Enter Nth term:");
       
        n = Integer.parseInt(myinput.readLine());

        Binary Binary = new Binary(); // creates object Binary

       Binary.printBinary(n); //calls function in Binary class
    }
}