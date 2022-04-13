/*
 * TNPG: Froghats 
Roster: Alif Rahman, Salaj Rijal, Kevin Cheng
APCS
HW90 -- Swabbing the Deque -- Implementing our own Deque class
2022-04-12
time spent: .5 hours
*/

public interface Deque<T> {
   	
    public T removeLast();

    public T removeFirst();

    public void addFirst( T x);

    public void addLast( T x);

    public T peekFirst();

    public T peekLast();

    public int size();

    public boolean isEmpty();

    /*
     * public T pollFirst();
     * public T pollLast();
     */
}
