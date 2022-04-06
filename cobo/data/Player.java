public class Player{

    private String name;
    private String ptsPerGame;
    

    public Player( String name, String pts){
        this.name = name;
        ptsPerGame = pts; 
    }

    public String toString(){
        return "Name: " + name + "\nPPG: " + ptsPerGame;
    }

    public double points(){
        return Double.parseDouble( ptsPerGame );

    }

    public int compareTo(Player x) {
        if (this.points() > x.points()) return 1;
        else if ( x.points() > this.points() ) return -1;
        return 0;
    }


}