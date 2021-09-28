package SummerAssignments;
public class Date {
    //Chapter 2: Data Types
    //Exercise 2

    public static void main(String[] args){
        String day, date, month;
        int year;

        day = "Wednesday";
        date = "25th";
        month = "August";
        year = 2021;

        //American Format
        System.out.print(day);
        System.out.print(", ");
        System.out.print(month);
        System.out.print(" ");
        System.out.print(date);
        System.out.print(", ");
        System.out.println(year);

        //European Format
        System.out.print(day);
        System.out.print(" ");
        System.out.print(date);
        System.out.print(" ");
        System.out.print(month);
        System.out.print(" ");
        System.out.println(year);

    }
}
