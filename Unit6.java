/**
 * Unit6
 * 
 * @author Maggie Huang, Dimitra D.
 * @version 2/13/18
 */
public class Unit6
{
    public static String capitalize(String str)
    {
       //takes in a string and capitalizes only the first letter, the other letters are lowercase
       String first = str.substring(0,1);
       String rest = str.substring(1);
       String letter = first.toUpperCase();
       String statement = rest.toLowerCase();
       return letter + statement;
    }
    
    public static boolean isPalindrome(String statement)
    {
        //takes in a statement and returns true if it is a palindrome, else returns false
        String word = statement.toLowerCase();
        if(word.length() <= 1)
        {
            return true;
        }
        else if (word.length() == 2)
        {
            return word.charAt(0)==word.charAt(1);
        }
        else
        {
            if (word.charAt(0)!=word.charAt(word.length()-1)) // check if two end letters are same
                return false;
            else
                return isPalindrome(word.substring(1,word.length()-1 )); // check the rest of string by cut off the both ends
        }
    }
  
}
