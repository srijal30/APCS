import java.util.NoSuchElementException;

public class RunMed {

    private ALHeapMax lilVals; 
    private ALHeapMin bigVals;

    public RunMed(){

        lilVals = new ALHeapMax();
        bigVals = new ALHeapMin();

    }

    public double getMedian(){

        if ( bigVals.isEmpty() ){
            throw new NoSuchElementException();
        }
        if ( lilVals.isEmpty() ){
            return bigVals.peekMin();
        }

        //return bigVals cuz its size is guaranteed to be bigger
        if ( bigVals.size() > lilVals.size() ){
            return bigVals.peekMin();
        }
        //else return the average
        return ( lilVals.peekMax() + bigVals.peekMin() ) / 2.0;

    }

    public void add( Integer newVal ){

        //choosing which heap to add too

        //if big vals is empty, add there
        if( bigVals.isEmpty() ){
            bigVals.add(newVal);
        }

        //if the min of big vals is greater than the new val, then add new val to lilvals
        else if(   bigVals.peekMin().compareTo(newVal) > 0  ){
            lilVals.add( newVal );
        }

        //since newval is greater than equal to
        else{
            bigVals.add( newVal );
        }



        if ( bigVals.size() - lilVals.size() > 1 ) {
            lilVals.add( bigVals.removeMin() );
        }

        else if( lilVals.size() > bigVals.size() ){
            bigVals.add( lilVals.removeMax() );
        }


    }
    

}
