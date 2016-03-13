// This program outputs information about the java environment running on my computer
public class hw0 {
	public static void main(String[] args){
		String[] propNames = {"java.runtime.version", "java.specification.version", 
		                                "java.vm.specification.version", "java.version"};
		for (int count = 0; count < propNames.length; count++){
			// display java property name with their corresponding version number
			System.out.println(propNames[count] + ": " + System.getProperty(propNames[count]));
		}
	}// main()
}// hw0()
