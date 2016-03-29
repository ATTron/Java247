import java.util.LinkedList;

public class Queue<T> implements IQueue<T> {
  private final LinkedList<T> q;

  public Queue() {
    q = new LinkedList<T>();
  } // no-arg constructor

  @Override
  public void add(final T item) {
    q.add(item);
  } // add()

  @Override
  public T remove() {
    return q.remove(0);
  } // remove()

  @Override
  public boolean isEmpty() {
    return q.size() == 0;
  } // isEmpty()

  @Override
  public boolean isFull() {
    return false;
  } // isFull()

  public int size() {
    return q.size();
  } // size()

  // unit test driver
  public static void main(String[] args) {
    final Queue<Integer> theQ = new Queue<Integer>();

    int item;

    verify(theQ.isEmpty());

    theQ.add(1);
    theQ.add(2);

    item = theQ.remove();
    verify(item == 1);
    item = theQ.remove();
    verify(item == 2);

    theQ.add(1);
    theQ.add(2);
    item = theQ.remove();
    verify(item == 1);

    theQ.add(3);
    theQ.add(4);

    item = theQ.remove();
    verify(item == 2);

    item = theQ.remove();
    verify(item == 3);

    item = theQ.remove();
    verify(item == 4);

    verify(theQ.isEmpty());

    try {
      item = theQ.remove();
      verify(false);
    }
    catch(java.util.NoSuchElementException e) { ; }
    catch(IndexOutOfBoundsException e) { ; }

    System.out.println("Unit Test Passed");
  } // main()

  private static void verify(final boolean ok) {
    if (!ok)
      throw new IllegalStateException();
  } // verify()

} // class Queue
