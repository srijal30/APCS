public class Player{

    private String name;
    private double points;
    

    public Player( String name, String pts){
        this.name = name;
        points = Double.parseDouble(pts); 
    }

    public String toString(){
        return "Name: " + name + "\nPPG: " + Double.toString(points);
    }

    public int compareTo(Player x) {
        if ( this.points > x.points) return 1;
        else if ( x.points > this.points ) return -1;
        return 0;
    }


}