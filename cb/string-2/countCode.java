// https://codingbat.com/prob/p123614

public class countCode {
    public static void main(String[] args) {
        System.out.println(countCode("aaacodebbb")); // 1
        System.out.println(countCode("codexxcode")); // 2
        System.out.println(countCode("cozexxcope")); // 2
    }

    /*
     * Return the number of times that the string "code" appears anywhere in the
     * given string, except we'll accept any letter for the 'd', so "cope" and
     * "cooe" count.
     */
    public static int countCode(String str) {
        int codeCount = 0;
        for(int i =0; i< str.length()-3;i++){
            String first2 = str.substring(i, i+2);
            String last1 = str.substring(i+3, i+4);

            if( first2.equals("co") && last1.equals("e") ){
                codeCount++;
            }
        }

        return codeCount;
    }
}
