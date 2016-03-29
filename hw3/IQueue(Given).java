public interface IQueue<T> {
  // Pre:  Queue is sn, ..., s1, s0
  // Post: Queue is item, sn, ..., s1, s0
  public void add(T item);

  // Pre:  Queue is sn, ..., s1, s0
  // Post: Queue is sn, ..., s2, s1; s0 returned
  public T remove();

  // Returns true iff queue contains zero elements.
  public boolean isEmpty();

  // Returns true iff queue has no free space.
  public boolean isFull();
} // interface IQueue 
