import core.data.*;
import java.util.ArrayList;l

public class MVPFInder {

    public static void main(String[] args) {
        
        DataSource ds = DataSource.connect("player.csv").load();
        ArrayList<Player> players = ds.fetchList("Player", "Player", "PTS");
        System.out.println( players);
        
    }
    
}
