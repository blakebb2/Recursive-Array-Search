/**
 *  Recursive Array Search Algorithm
 *  Recursively searches an array till a match is found  
 *  between the index and the value of the index.
 *
 * Results for arrays:
 * 10a: 4 comparisons, found at index 6
 * 10b: 1 comparison, none found
 * 10c: 4 comparisons, found at index 9
 * 10d: 2 comparisons, found at index 4
 * 10e: 3 comparisons, none found
 * 50: 4 comparisons, found at index 32
 * 100a: 9 comparisons, none found
 * 100b: 9 comparisons, none found
 * 100c: 9  comparisons, none found
 * 100d: 7 comparisons, found at index 99
 * 10000: 35 comparisons, found at index 6696
 * 100000a: 72 comparisons, none found
 * 100000b: 72 comparisons, none found
 * 
 *
 * @author Blake Byerly
 */

package elon.edu.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class main {
	
	private static int[] nums;
    private static int counter;

   public static boolean recursive(int[] array, int i, int end) {  
	  System.out.println(i);
      // make sure array is reachable
	  if (array[i] == i) {
      	counter+=1;
      	System.out.println("index: "+i);
          return true;
      }
      // base case: make sure end of search is reached
      else if (end - i <=  1) {
		  return false;
	  }
	  // search recursively by searching in consecutively lower halves
      else  {
		  if (i < array.length) {
		       if (array[i] == i) {
		        	counter+=1;
		        	System.out.println("index: "+i);
		            return true;
		         }
		       else {
				   if (array[i] < i) {	   // check upper half is [i] is lower than i     		
						   counter+=1;
						   return recursive(array, (i+end)/2, end);
				   }
				   else {    				// check lower half 
						counter+=1;
						return recursive(array, (i-(i/2)/2), i);
				    }
		        	
		    }
	  }
	  }
	  return true;
   }


	public static void main(String[] args) {
        File file = new File("src/elon/edu/algorithms/nums_10a.txt");
        int i=0;
        
        try {
            Scanner input = new Scanner(file);
            nums  =  new int[input.nextInt()];
            while(input.hasNext())
            {
            	nums[i] = input.nextInt();
            	i++;
            }
            input.close();
        }
        
        catch(Exception e) {
           System.out.println("exception");
           e.printStackTrace();
        }
        
        int test  =   nums.length/2;
        System.out.println(Arrays.toString(nums));
        System.out.println(recursive(nums, test, nums.length) + ": condition of matching number and index found");
        System.out.println("Comparisons: " + counter);

	}
}
