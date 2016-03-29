// Test driver for IS 247 homework 1, coins

// Decide how many coins to use and the actual coins to use
// psuedo-randomly.
import java.util.Random;

public class Driver {
  private final static Random rng = new Random();

  public static void main(String[] args) {

    // a pseudorandom number of from 1 to 12 coins
    final ICoin[] coins = new ICoin[rng.nextInt(12) + 1];

    // choose the coins
    for (int index = 0; index < coins.length; ++index)
      coins[index] = makeCoin();

    // Show the coins and the sum of their values.
    int value = 0;
    for (ICoin aCoin: coins) {
      System.out.println("Got a " + aCoin + ".");
      value += aCoin.value();
    } // for each coin

    // convert from cents to dollars and cents
    final int dollars = value / 100;
    final int cents = value % 100;
    System.out.print("The total value is $" 
                     + dollars
                     + ".");

    // insert a missing leading zero if needed
    if (cents < 10)
      System.out.print(0);
    System.out.println(cents);
  } // main()

  private static ICoin makeCoin() {
    // pick a number in the range 0-3
    int choice = rng.nextInt(4);

    // choose a different coin for each possible choice
    switch (choice) {
    case 0: return new Penny();
    case 1: return new Nickel();
    case 2: return new Dime();
    case 3: return new Quarter();
    default:
      // error -- can't happen
      return null;
    } // switch
  } // makeCoin() 

} // class Driver 
