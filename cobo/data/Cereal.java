public class Cereal{

	
	private String name;

	private int calories;
	private int protein;
	private int fats;

	public Cereal (String name, int c, int p, int f){
		this.name = name;
		calories = c;
		protein = p;
		fats = f;
	}

	public String toString(){
		return "Name: " + name +
		       "\nCalories: " + Integer.toString( calories ) + 
		       "\nProtein: " + Integer.toString( protein ) +
		       "\nFats: " + Integer.toString( fats );
	}


	public static void main(String[] args){
	
		Cereal cocoaPuffs = new Cereal( "Cocoa Puffs", 110, 1, 1);
		System.out.println( cocoaPuffs);
	
	}
}
