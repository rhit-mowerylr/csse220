package examples;

public class SimplePalindrome {

    /**
     * Returns true if the input string is a palindrome
     * (reads the same backwards and forwards)
     * <p>
     * For example the string "aba" is a palindrome.
     * The string "abc" is not because abc backwards is cba
     * <p>
     * Spaces are not considered special in this palindrome.
     * See sentence for a more complex palindrome problem.
     *
     * @param input
     * @return
     */


    public static boolean isPalindrome(String input) {


        /**
         * Returns true if the input array is a palindrome.
         * <p>
         * For example, the array {1,2,1} is a palindrome.
         * The array {1,2,3} is not.
         * <p>
         * This problem is much easier with the use of
         * a helper method.
         *
         * @param input
         * @return
         */
        // Base case(s): single-character or empty string
        if (input.length() <= 1) {
            return true;
        }
        //Recursive case:
        String smaller = input.substring(1, input.length() - 1);
        boolean smallerIsPalindrom = isPalindrome(smaller);

        return smallerIsPalindrom && input.charAt(0) == input.charAt(input.length() - 1);
    }


    public static boolean isPalindromeIntArray(int[] input) {
        return false;
    }


}
