//Time-stamp: <2016-02-09 12:29:38 jdm>
// this program creates and manipulates rational numbers
public class Rational implements Comparable<Rational>{

  public final long numerator;
  public final long denominator;

  // Constructor
  public Rational(final long num,
                  final long den) {
    
    // Divide each by the greatest common divisor to ensure
    // representation is in lowest common terms.
    	final long gcd = gcd(num, den);
    	numerator = num / gcd;
    	denominator = den / gcd;
    	try{
    		if (denominator == 0){
    			throw new IllegalArgumentException("Denominator cannot be 0");
    		}// test for zero denominator
    	}
    	catch(IllegalArgumentException e){
    		System.err.println(e);
    	}
  } // constructor

  private static long gcd(final long a, final long b) {
    // Euclid's Algorithm, from Wikipedia
    // https://en.wikipedia.org/wiki/Greatest_common_divisor
    if (b == 0) return a;
    return gcd(b, a % b);
  } // gcd()

  @Override
  public String toString() {
    return numerator + " / " + denominator;
  } // toString()

  // multiplication
  public Rational times(final Rational other) {
    Rational tRash = new Rational(numerator * other.numerator,
                        denominator * other.denominator);
    try{
    	if ((this.sign() == 1 && other.sign() == 1 && tRash.sign() != 1) || 
    			(this.sign() == -1 && other.sign() == -1 && tRash.sign() != 1)){
    		throw new OverflowException("Integer overflow error! Calculation failed (times error)");
    	}
    }
    catch (OverflowException e){
    	System.err.println(e);
    }
    return tRash;
    
  } // times()

  // addition
  public Rational plus(final Rational other) {
	  Rational pRash = new Rational(numerator * other.denominator
              + other.numerator * denominator,
              denominator * other.denominator);
	  try{
		  if((this.sign() == 1 && other.sign() == 1 && pRash.sign() != 1) || 
				  (this.sign() == -1 && other.sign() == -1 && pRash.sign() !=-1)){
			  throw new OverflowException("Integer overflow error! Calculation failed (plus error)");
		  }
	  }
	  catch (OverflowException e){
		  System.err.println(e);
	  }
	  return pRash;
    
  } // plus()

  // negation
  public Rational negate() {
	  Rational nRash = new Rational(-numerator, denominator);
	  
	  try{
		  if ((this.sign() == 1 && nRash.sign() == 1) || (this.sign() == -1 && nRash.sign() == -1)){
			  throw new OverflowException("Integer overflow error! Cannot negate value (negation error)"
			  		+ "");
		  }
	  }
	  catch(OverflowException e){
		  System.err.println(e);
	  }
	  
    return nRash;
  } // negate()

  // reciprocal
  public Rational reciprocal() {
    return new Rational(denominator, numerator);
  } // reciprocal()

  public double toDouble() {
    return (double)numerator / (double)denominator;
  } // toDouble()

  public long toLong() {
    return (long)numerator / denominator;
  } // toLong()

  // sign
  public int sign(){
	  if (numerator >= 0 && denominator > 0){
		  return 1;
	  }
	  else if (numerator < 0 || denominator < 0){
		  return -1;
	  }
	  else{
		  return 0;
	  }
  }// sign()
  
  @Override
  public int compareTo(Rational b){
	  double aD = (double)numerator / denominator;
	  double bD = (double)b.numerator / b.denominator;
	  if (aD > bD){
		  return 1;
	  }
	  else if(aD < bD){
		  return -1;
	  }
	  else{
		  return 0;
	  }
  }// compareTo()
  
  // Unit test driver
  public static void main(String[] args) {
    Rational a = new Rational(3, 8);
    Rational b = new Rational(5, 11);
    Rational c = new Rational(7, 1);
    Rational d = new Rational(7, 2);
    Rational e = new Rational(3, 10);
    Rational f = new Rational(6, 20);
    
    System.out.println("Is " + a + " < " + b + "?" + " Should be negative. " + a.compareTo(b));
    System.out.println("Is " + c + " > " + d + "?" + " Should be positive. " + c.compareTo(d));
    System.out.println("Does " + e + " = " + f + "?" + " Should be zero. " + e.compareTo(f));

    new Rational(1, 0);
    new Rational(Long.MIN_VALUE, 1).negate();
    
    Rational sevenBill = new Rational(7000000000L, 2);
    Rational tenBill = new Rational(10000000000L, 3);
    sevenBill.times(tenBill);
    
    Rational plusFail = new Rational(Long.MAX_VALUE, 1);
    Rational val = new Rational(22, 7);
    plusFail.plus(val);
    
    System.out.print("Rational program completed.");

  } // main()
  
} // class Rational
class OverflowException extends ArithmeticException{
	  public OverflowException(String s){
		  super(s);
	  }//constructor
}//class OverflowException