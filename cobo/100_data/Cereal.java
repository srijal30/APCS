public class Cereal{

	
	private String name;


	private int Calories;

	private int Protein;
	private int Fats;

	public Cereal (String name, int c, int p, int f){
		this.name = name;
		Calories = c;
		Protein = p;
		Fats = f;
	}

	public String toString(){
		return "Name: " + name +
		       "\nCalories: " + Integer.toString( Calories ) + 
		       "\nProtein: " + Integer.toString( Protein ) +
		       "\nFats: " + Integer.toString( Fats );
	}


	public static void main(String[] args){
	
		Cereal cocoaPuffs = new Cereal( "Cocoa Puffs", 110, 1, 1);
		System.out.println( cocoaPuffs);	
	
	}
}
