package ulamSer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//import java.util.ArrayList;


public class ulamSer {

	public static void main(String[] args) 
	
	{
		
		int [] array  = {1,2,3,4,6,8,11,13};
		
		int [] newArray = new int[50];
	
		int x = 0;
		int i = 0;
		
		int counter = 0;
		
		while(x<7)
		{
			for(i = 0; i<7; i++)
			{
				
				
				newArray[counter] = array[x] + array[i+1]; 
				
				counter++;
		
			
			}
			
			x++;
			//i++;
			
		}
		
		
		//sort first (bubble sort)
		for (int j  = 0 ; j < ( counter - 1 ); j++)
		  {
		    for ( i  = 0 ; i < counter - j - 1; i++)
		    {
		      if (newArray[i] > newArray[i+1]) /* For decreasing order use < */
		      {
		       int temp  = newArray[i];
		        newArray[i]   = newArray[i+1];
		        newArray[i+1] = temp;
		      }
		    }
		  }

	
		//for(int j = 0; j<newArray.length-1; j++)
		//{
				//	if(newArray[j] == newArray[j+1])
					//	{
						//	newArray[j] = 0;
							
						
					//	}
					
					
		//}
				
		
		
		
		
		
		
		
		
		
		
		/*
		for(int i = 0; i<newArray.length-1; i++)
		{
			
			if(newArray[i]<=13)
			{
				newArray[i] = 0;
					
				
			}
			
			
		}
		*/
	
		
		//for(int j = 0; j<newArray.length-1; j++)
		//{
		//	for(int i = 0; i<newArray.length-1; i++)
		//	{
			//	if(newArray[i] == newArray[i+1])
			//	{
			//		newArray[i] = 0;
					
				
			//	}
		//	}
			
		//}
		
		
		for( i = 0; i<newArray.length-1; i++)
		{
			
			System.out.println(newArray[i]);
			
			
		}
		
		
		
		
		

	}

}
