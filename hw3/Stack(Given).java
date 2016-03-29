import java.util.ArrayList;

public class Stack<T> implements IStack<T> {
  private final ArrayList<T> data;

  public Stack() {
    data = new ArrayList<T>();
  }

  @Override
  public void push(final T item) {
    data.add(item);
  } // push()

  @Override
  public T pop() {
    return data.remove(data.size() - 1);
  } // pop()

  @Override
  public boolean isEmpty() {
    return data.size() == 0;
  } // isEmpty()

  @Override
  public boolean isFull() {
    return false;
  } // isFull()



  // unit test driver
  public static void main(String[] args) {
    final Stack<Integer> aStack = new Stack<Integer>();

    int item;

    verify(aStack.isEmpty());

    aStack.push(1);
    aStack.push(2);

    item = aStack.pop();
    verify(item == 2);
    item = aStack.pop();
    verify(item == 1);

    aStack.push(1);
    aStack.push(2);
    item = aStack.pop();
    verify(item == 2);

    aStack.push(3);
    aStack.push(4);

    item = aStack.pop();
    verify(item == 4);

    item = aStack.pop();
    verify(item == 3);

    item = aStack.pop();
    verify(item == 1);

    verify(aStack.isEmpty());

    try {
      item = aStack.pop();
      verify(false);
    } catch(ArrayIndexOutOfBoundsException e) { ; }

    System.out.println("Unit Test Passed");
  } // main()

  public static void verify(final boolean ok) {
    if (!ok)
      throw new IllegalStateException();
  } // verify()

} // class Stack
