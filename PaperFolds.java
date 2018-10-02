
/**
 * PaperFolds
 *
 * @author Maggie Huang
 * @version 2/13/18
 */
public class PaperFolds
{
    public static String paperFolds(int n)
    {
        //takes in an int and returns a String resembling paperfolds
        if (n==0)
            return "";
        else if (n==1)
            return "v";
        else
        {
            String s1 = paperFolds(n-1);  // get the previous pattern
            String s2 = reverseAndFlip(s1); // reverse and flip the previous pattern
            return s2 + "v" + s1;
        }
    }
        
    public static char flip(char c)
    {
        //takes in a char and flips it
        if (c=='v') return '^';      // flip v to ^
        else if (c=='^') return 'v'; // flip ^ to v
        else return ' ';               // return space if neither ^ nor v
    }
    
    public static String reverseAndFlip(String str)
    {
        //takes in a fold sequence and returns it reversed and flipped over
        if (str.length()==1) 
        return ""+flip(str.charAt(0)); // flip the letter if only one
        char last = str.charAt(str.length()-1); // get the last char
        String rest = str.substring(0,str.length()-1); // get the rest of string but cut off the last char
        return flip(last)+reverseAndFlip(rest); // flip the last character and reverse and flip the rest of string
    }
}
