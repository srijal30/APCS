package SummerAssignments;
public class Time {
    //Chapter 2: Data Types 
    //Exercise 3

    public static void main(String[] args){
        //Constants
        final int SEC_IN_MIN = 60;
        final int MIN_IN_HOUR = 60;
        final int HOUR_IN_DAY = 24;
        final int SEC_IN_HOUR = MIN_IN_HOUR * SEC_IN_MIN;
        final int SEC_IN_A_DAY = SEC_IN_HOUR * HOUR_IN_DAY;


        //Variables
        double hour, minute, second;
        hour = 18d;
        minute = 18d;
        second = 30d;

        //Print out how many sec since 12am
        double secondsSinceMidnight = hour * SEC_IN_HOUR + minute * SEC_IN_MIN + second;
        System.out.println(secondsSinceMidnight);

        //How many sec left in the day
        double secondsUntilNextMin = SEC_IN_MIN - second;
        double minutesUntilNextHour = MIN_IN_HOUR - minute - 1; //minus one to account for being x amount seconds into a minute already
        double hoursUntilNextDay = HOUR_IN_DAY - hour - 1; //to account for being x minutes already into an hour

        double secondsUntilNextDay = hoursUntilNextDay * SEC_IN_HOUR + minutesUntilNextHour * SEC_IN_MIN + secondsUntilNextMin;
        System.out.println(secondsUntilNextDay);
        
        //Percentage of day that has gone by
        System.out.print( secondsSinceMidnight/SEC_IN_A_DAY * 100 );
        System.out.println("%");

        //Time since exercise started
        double newHour, newMinute, newSecond;
        newHour = 18d;
        newMinute = 39d;
        newSecond = 30d;

        System.out.printf("It has been %f hours, %f minutes and %f seconds", newHour - hour , newMinute - minute , newSecond - second);



        

    }
    
}
