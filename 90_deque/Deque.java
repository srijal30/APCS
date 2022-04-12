public interface Deque<T> {
    
    public T dequeueLast();

    public T dequeueFirst();

    public void enqueueFirst( T x);

    public void enqueueLast( T x);

    public T peekTop();

    public T peekBottom();

    public int size();

    public boolean isEmpty();


}
