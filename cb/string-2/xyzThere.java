public class xyzThere {
    
    public static void main(String[] args) {

        System.out.println( xyzThere("abcxyz") );
        System.out.println( xyzThere("abc.xyz") );
        System.out.println( xyzThere("xyz.abc") );
    }

    public static boolean xyzThere( String str){
        if(str.length()<3){
            return false;
        }
        if(str.substring(0, 3).equals("xyz")){
            return true;
        }
        for(int i=1; i<str.length()-2; i++){
            if( str.substring(i, i+3).equals("xyz") && !str.substring(i-1,i).equals(".") ){
                return true;
            }
        }
        return false;
    }
}
