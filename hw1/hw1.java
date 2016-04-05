// creates 4 classes implementing the ICoin interface that represent the 4
// types of coins that, when called, will return their respective value
// and the name of the coin
public class hw1 {
}// hw1()

final class Penny implements ICoin {
	@Override
	public int value(){
		return 1;
	}// value()
	
	@Override
	public String toString(){
		return "penny";
	}// toString()
	
}// Penny()

final class Nickel implements ICoin{
	@Override
	public int value(){
		return 5;
	}// value()
	
	@Override
	public String toString(){
		return "nickel";
	}// toString()
	
}// Nickel()

final class Dime implements ICoin{
	@Override
	public int value(){
		return 10;
	}// value()
	
	@Override
	public String toString(){
		return "dime";
	}// toString()
	
}// Dime()

final class Quarter implements ICoin{
	@Override
	public int value(){
		return 25;
	}// value()
	
	@Override
	public String toString(){
		return "quarter";
	}// toString()
	
}// Quarter()


