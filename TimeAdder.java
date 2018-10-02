/**
 * TimeAdder
 * 
 * @author Maggie Huang
 * @version 2/20/18
 */
public class TimeAdder
{
    public static int makeIntoSeconds (String time)
    {
        // takes into String and converts to seconds
        String hour = time.substring(0, 2); // get first two digit for hour
        String min = time.substring(3, 5);  // get two digit for minute
        String sec = time.substring(6);     // get two digit for second
        int hour2 = Integer.parseInt(hour); // convert string to integer
        int min2 = Integer.parseInt(min);  // convert string to integer
        int sec2 = Integer.parseInt(sec);  // convert string to integer
        return hour2 * 3600 + min2 * 60 + sec2;  // return total seconds
    }
    
    public static String timeString (int seconds)
    {
        // takes in seconds and converts to String
        int hour = seconds / 3600;                  // get hour
        int min = (seconds - 3600 * hour) / 60;     // get minutes
        int sec = seconds - 3600 * hour - 60 * min; // get second
        String time = String.format("%02d:%02d:%02d", hour, min, sec); // return string hh:mm:ss
        return time;
    }
    
    public static String addTimes (String time1, String time2)
    {
        //takes in two times and returns the sum
        int sec1 = makeIntoSeconds(time1);  // convert time string into seconds 
        int sec2 = makeIntoSeconds(time2);  // convert time string into seconds
        int sec = sec1 + sec2;        
        String total = timeString(sec); // convert seconds to time string 
        return total;
    }
}
