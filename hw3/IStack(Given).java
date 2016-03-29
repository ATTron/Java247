public interface IStack<T> {
  // Pre:  Stack is s0, s1, ..., sn
  // Post: Stack is item, s0, s1, ..., sn
  public void push(T item);

  // Pre:  Stack is s0, s1, ..., sn
  // Post: Stack is s1, s2, ..., sn; s0 returned
  public T pop();

  // Returns true iff stack contains zero elements.
  public boolean isEmpty();

  // Returns true iff stack has no free space.
  public boolean isFull();
} // interface IStack 
