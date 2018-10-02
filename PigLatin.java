
/**
 * PigLatin
 *
 * @author Maggie Huang
 * @version 2/13/18
 */
public class PigLatin
{
    public static String translateWord(String word)
    {
        //takes in a word and translates to Pig Latin
        if (isVowel(word.charAt(0))) return word+"way";  // if start with a vowel
        if (word.startsWith("qu")) return word.substring(2)+"quay"; // if start with "qu"
        
        int i;
        
        for (i=0;i<word.length();i++) 
        {
            if (isVowel(word.charAt(i))) break;  // find a vowel
            if (i>0 && word.charAt(i)=='y') break; // find ay and not the first letter
        }

        return word.substring(i) + word.substring(0,i) + "ay";
    }
    
    public static boolean isVowel(char c)
    {
        //takes in a char and returns true if it is a vowel, else returns false
	return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
