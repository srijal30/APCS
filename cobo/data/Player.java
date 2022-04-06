public class Player{

    private String name;
    private double ptsPerGame;
    

    public Player( String name, double pts){
        this.name = name;
        ptsPerGame = pts; 
    }

    public String toString(){
        return "Name: " + name + "\nPPG: " + Double.toString(ptsPerGame);
    }

    public int compareTo(Player x) {
        if (this.ptsPerGame > x.ptsPerGame) return 1;
        else if ( x.ptsPerGame > this.ptsPerGame ) return -1;
        return 0;
    }


}