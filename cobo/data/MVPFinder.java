import core.data.*;
import java.util.ArrayList;

public class MVPFinder {

    public static void main(String[] args) {
        
        DataSource ds = DataSource.connect("players.xml").load();
        ds.printUsageString();
        ArrayList<Player> players = ds.fetchList("Player", "row/Player", "row/PTS" );

        Player best = players.get(0);

        for( Player p: players ){

            if( p.compareTo(best) > 0 ) best = p;
        }

        System.out.println( best );

    }
    
}