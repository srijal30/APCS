public class test{
  int number;
  public test() {
  
  }
  
  public test(int a) {
  
  number = a;
  
  }
   
  public static void main(String[] args) {
  	
  test perry = new test(16);
  test salaj = new test(16);
  System.out.print(perry.equals(salaj));
//    equals

  }

}
