/*
Flying sullen Actors: Alif Rahman, Faiyaz Rafee, Salaj Rijal
APCS
LAB 6 -- Read/Review/Expand -- Cobo Consumer Review Lab
2022-2-14
time spent: 4 hours
*/
public class NuestroPrograma {
    public static void main(String[] args) {
        System.out.println("should be...");
        System.out.println("false");
        System.out.println("true");
        System.out.println("true");
        System.out.println("Testing...");
        System.out.println(isExcited("Will you be my valentine!?"));
        System.out.println(isExcited("sure!"));
        System.out.println(isExcited("yay!!"));
    
    } // end of main method

    public static boolean isExcited (String input) {
        String letter = "";
        boolean excite = false;

        for (int i = 0; i < input.length(); i++) {
            // iterates through String Input
            letter = input.substring(i, i+1);
            // sets letter as the current index i of Input
            if (letter.equals("!")) {
                // checks to see if there is a "!" --> conveys excitement
                if (input.indexOf("?") < 1) {
                    // checks to see if there is no "?" --> "?" with "!" doesn't really convey excitement, it's more like nervousness.
                    excite = true;
                }
            }
        }
        return excite;
    } // end of isExcited method

} // end of class