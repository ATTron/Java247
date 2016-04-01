// Anthony Templeton
// Program that reads in a file and adds its contents line by line to a queue
// converts queue to a stack and moves stack to new file
// effectively reversing the order of contents from the original file
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileReverser {

  private final IQueue<String> q = new Queue<String>();
  private final IStack<String> st = new Stack<String>();
  private final Scanner in;
  private final PrintStream out;
  
  
  public FileReverser(final String fileName) throws FileNotFoundException {
    in = new Scanner(new FileInputStream(fileName));
    out = new PrintStream("reversed-" + fileName);
  }// FileReverser()
  
  public void readFile() {
	while (in.hasNext()){
		q.add(in.nextLine());
	}
	in.close();
  }// readFile()
  
  public void writeFile() {
	  while (!q.isEmpty()) {
		  String s = q.remove();
		  st.push(s);
	  }
	  
	  while(!st.isEmpty()){
		  out.append(st.pop() + "\n");
	  }
	  out.close();
  }// writeFile()
  
  public static void main(String[] args){
	  System.out.println("Enter in the name of the file: ");
	  String fileName = "";
	  Scanner input = new Scanner(System.in);
	  fileName = input.nextLine();
	  input.close();
	  
	  try{
		  FileReverser firstFile = new FileReverser(fileName);
		  firstFile.readFile();
		  firstFile.writeFile();
	  }
	  catch(FileNotFoundException e){
		  System.err.println(e);
	  }
	  System.out.println("Operations Complete.");
  }// main()
  
  
}// class FileReverser
