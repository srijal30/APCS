/*
Ubuntus: Salaj: George, May: Perry Jr., Faiyaz: Atlas and Payne
APCS
HW 09 -- What are BigSibs Good For? -- How Java Files interact
2021-10-01

DISCOVERIES
-In order to run a method from another file, you need to compile that mentioned file first.:

UNRESOLVED QUESTIONS:
-What is the best practice when running a  java project that requires multiple files

*/
public class Greet {
        public static void main(String[] args){
              BigSib.greet("Daniel");
              BigSib.greet("Raj");
              BigSib.greet("Caleb");
        }
}
