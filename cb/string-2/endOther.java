public class endOther {

    /*Given 2 strings, return true if either of the strings appears at the
    very end of the other string, ignoring upper/lower case differences (in other words, the 
    computation should not be "case sensitive") Note: str.toLowerCase() returns the lowercase
    version of a string */

    public static void main(String[] args) {
        System.out.println( endOther( "Hiabc", "abc") );        
        System.out.println( endOther( "AbC", "HiaBc") );
        System.out.println( endOther( "abc", "abXabc") );
    }

    public static boolean endOther(String a, String b){
        String lowerA = a.toLowerCase();
        String lowerB = b.toLowerCase();

        if( a.length() >= b.length() ){
            return lowerB.equals( lowerA.substring(a.length()-b.length()) );
        }
        return lowerA.equals( lowerB.substring(b.length()-a.length()) );
    }
    
}
