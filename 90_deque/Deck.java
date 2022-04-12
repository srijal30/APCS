import java.util.LinkedList;

public class Deck<T> implements Deque<T>{
    
    private LinkedList<T> wrapped = new LinkedList<T>();

    public T dequeueLast(){
        return wrapped.removeLast();
    }

    public T dequeueFirst(){
        return wrapped.removeFirst();
    }

    public void enqueueFirst( T x){
        wrapped.addFirst(x);
    }

    public void enqueueLast( T x){
        wrapped.addLast(x);
    }

    public T peekTop(){
        return wrapped.getFirst();
    }

    public T peekBottom(){
        return wrapped.getLast();
    }

    public int size(){
        return wrapped.size();
    }

    public boolean isEmpty(){
        return size() <= 0;
    }

    public static void main(String[] args) {
        
        Deck<String> deck = new Deck<String>();

    }

}