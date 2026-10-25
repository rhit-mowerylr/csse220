package recursion;

import java.util.Arrays;

/**
 * Class: HWRecursionPart2
 * @author CSSE Faculty
 * Purpose: Provide practice implementing recursive operations that may or may not require a separate recursive helper operation
 *  
 */
public class HWRecursionPart2 {

	/**
	  * For this problem, you are to use recursion to find if each element
	  * of one array appears in the other array in the same order.  There
	  * may be extra values in the input array.
	  * <br>
	  * Example 1:
	  * input = {1, 2, 3, 4, 5, 6, 7}
	  * toFind = {3, 4, 5}
	  * Given the above input, this should return true
	  * <br>
	  * Example 2:
	  * input = {1, 2, 3, 4 ,5, 6, 7}
	  * toFind = {1, 3, 5}
	  * Given the above input, this should return true
	  * <br>
	  * Example 3:
	  * input = {1, 3, 5, 7, 9}
	  * toFind = {3, 4, 5}
	  * false because 4 is not in the array this should return false
	  * <br>
	  * Example 4:
	  * input = {1, 3, 5, 7, 4}
	  * toFind = {3, 4, 5}
	  * false because the order is 3,5,4 in the input array
	  *
	  * @param input - the array to find the values in
	  * @param toFind - the array to find in the other
	  * @return true if toFind is found in input, false otherwise
	  */
	
	public static boolean findIn(int[] input, int[] toFind) {
		if (input.length<=1){
				return true;
			}

		return isNewfind(0, 0, input.length,toFind.length, input, toFind);
	} // findIn
	public static boolean isNewfind(int fromIndexinput, int fromIndexFind, int toIndexInput, int toIndexFind, int[] array1, int[] array2) {

		if (fromIndexFind==toIndexFind) {
			return true;
		} else if (fromIndexinput==toIndexInput){
			return false;
		}
		if (array1[fromIndexinput]==array2[fromIndexFind]){
			return (array1[fromIndexinput] == array2[fromIndexFind]) && isNewfind(fromIndexinput+1, fromIndexFind+1, toIndexInput, toIndexFind, array1, array2);

		}
		return (array1[fromIndexinput] != array2[fromIndexFind] && isNewfind(fromIndexinput+1, fromIndexFind, toIndexInput, toIndexFind, array1, array2 ));
	}


	/**
	 * In this problem, you will calculate
	 * <a href="https://en.wikipedia.org/wiki/Compound_interest">compound interest</a>
	 * with monthly compounding. You are given an initial principal amount, an
	 * annual interest rate (as a percentage), and the number of months to compound.
	 * You should return the final balance after the specified number of months.
	 * <br>
	 * The formula for monthly compounding is:
	 * New Balance = Previous Balance * (1 + (annual rate / 100) / 12)
	 * <br>
	 * For example:
	 * principal = 1000.0, annualRate = 6.0, months = 12
	 * After 12 months, the balance should be approximately 1061.68
	 * <br>
	 * principal = 5000.0, annualRate = 4.8, months = 24
	 * After 24 months, the balance should be approximately 5502.74
	 *
	 * @param principal - the initial amount of money
	 * @param annualRate - the annual interest rate as a percentage (e.g., 6.0 for 6%)
	 * @param months - the number of months to compound
	 * @return the final balance after compounding for the specified months
	 */
	public static double compoundInterest(double principal, double annualRate, int months) {
		if (months==0){
			return principal;
		}
		return newcompoundInterest(principal,annualRate,months, 0);
	} // compoundInterest
	public static double newcompoundInterest(double previousblance, double annualRate, int months, int currentmonth){
		if (currentmonth==months){
			return previousblance;
		}
		double newbalance = previousblance*(1+(annualRate/100)/12);
		return newcompoundInterest(newbalance,annualRate,months,currentmonth+1);
	}


	/**
	 * For this problem, you are given a string and need to recursively check whether the string is a near-palindrome.
	 * A near-palindrome is defined as a string that can become a palindrome by changing at most one character.
	 * (Recall that a palindrome is a string that reads the same forwards and backwards.)
	 * <br>
	 * Examples:
	 * "racecar" is a palindrome, so it is also a near-palindrome (no changes needed).
	 * "facecar" can become "racecar" by changing 'l' to 'r', so it is a near-palindrome (one change needed).
	 * "hello" cannot become a palindrome with just one change, so it is not a near-palindrome (two changes needed).
	 * "abca" can become "abba" or "acca" by changing 'c' to 'b' or 'b' to 'c', so it is a near-palindrome (one change needed).
	 * <br>
	 * @param input the string to check
	 * @return true if the string is a near-palindrome, false otherwise
	 */
	public static boolean isNearPalindrome(String input) {
		if (newisNearPalindrome(input)<=1){
			return true;
		}
		return false;
	} // isNearPalindrome
	public static int newisNearPalindrome(String input) {
		int output=0;
		if(input.length()>0){
			if(!input.substring(0, 1).equals(input.substring(input.length()-1))){
				output+=1;
			}
			if(input.length()>2){
				return output+ newisNearPalindrome(input.substring(1, input.length()-1));
			}
		}
		return output;
	}


	/**
	 * For this problem, you are given an array of integers.  You are to use 
	 * recursion to find the subsequence of elements that yields the highest
	 * sum.  A subsequence can be any set of the array values that are sequential.
	 * That is, if the values at indices 3, 4 and 5 produce the highest sum, that
	 * sum is what you should return.  You cannot sum numbers that are not sequential
	 * however.  For instance, you cannot return a sum that was from elements 
	 * 3, 4, 6 and 7.  Those values skipped element 5.
	 * <br>
	 * For the sake of simplicity, you can assume that there is a subsequence in
	 * the array that has a maximum sum and contains more than one element in the 
	 * sequence.  In other words, the subsequence with the highest sum will consist
	 * of at least two values.
	 * <br>
	 * Below are some examples:
	 * input = {-1, -2, 3, 4, 6, -2, -2}
	 * The highest possible sum from any subsequence is 13, the value to return.
	 * 13 is from 3+4+6.  Those elements in sequence yielded the highest sum of
	 * any other subsequence.
	 * <br>
	 * input = {-1, -2, 2, 5, 6, -1, 7, -3}
	 * The highest possible sum from any subsequence here is 19, the value to 
	 * return.  19 is from 2+5+6+(-1)+7.  Note that the subsequence from indices
	 * 2 to 6 yields a higher sum than 2 to 4 even though it includes a negative
	 * value.
	 * <br>
	 * input = {-1, 2, 3, 4, -10, 5, 6, -3, 7, -20, 2, 3}
	 * The highest possible sum from any subsequence here is 15, the value to 
	 * return.  15 is from 5+6+(-3)+7.
	 * 
	 * @param input - The array of integers
	 * @return the highest possible sum of any subsequence
	 */
	public static int highestSubsequenceSum(int[] input) {
		int maxTotal=0;
		int currentTotal=newhighestSubsequenceSum(input, 0);
		if (currentTotal>=maxTotal) {
			maxTotal = currentTotal;
		}
		if(input.length>1){
			int[] newInput = Arrays.copyOfRange(input, 1, input.length);
			int newMax=highestSubsequenceSum(newInput);
			if(maxTotal<=newMax){
				maxTotal=newMax;
			}
		}
		if(input.length>1) {
			int[] newInput = Arrays.copyOfRange(input, 0, input.length - 1);
			int newMax = highestSubsequenceSum(newInput);
			if (maxTotal <= newMax) {
				maxTotal = newMax;
			}
		}
		return maxTotal;
	} // highestSubsequenceSum
	public static int newhighestSubsequenceSum(int[] input, int currentspot) {
		if(input.length<=currentspot)
			return 0;
		else{
			int spot = currentspot+1;
			return input[currentspot]+newhighestSubsequenceSum(input, spot);
		}
	}

	
} // end HWRecursionPart2
