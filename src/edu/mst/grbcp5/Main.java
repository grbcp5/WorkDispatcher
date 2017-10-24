package edu.mst.grbcp5;

import edu.mst.grbcp5.worker.WorkDispatcher;
import edu.mst.grbcp5.worker.Workable;
import edu.mst.grbcp5.worker.Worker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

  private static Random rnd;

  private static final int NUM_ITERATIONS = 100;
  private static final int UPPER_BOUND = 10000;

  public static void main( String[] args ) {

    Random rnd = new Random( 10021996 );
    Main.setInstance( rnd );

    Worker worker;
    Integer dumbWorkResult[];
    Map< String, Object > dumbWorkParameters;

    worker = new WorkDispatcher();

    dumbWorkParameters = new HashMap<>();
    dumbWorkParameters.put( "low", 0 );
    dumbWorkParameters.put( "high", UPPER_BOUND );

    dumbWorkResult = new Integer[ NUM_ITERATIONS ];

    for ( int i = 0; i < NUM_ITERATIONS; i++ ) {
      dumbWorkParameters.put( "value", rnd.nextInt( UPPER_BOUND ) );
      worker.assign( new DumbWork(), dumbWorkParameters, dumbWorkResult[ i ] );
    }

    if ( worker.waitForAllWork() ) {

      for ( Integer i : dumbWorkResult ) {
        System.out.println( "Dumb work result: " + i );
      }

    } else {
      System.out.println( "Could not evaluate work" );
    }

  }

  public static Random getInstance() {
    return rnd;
  }

  public static void setInstance( Random newRnd ) {
    Main.rnd = newRnd;
  }

}

class DumbWork implements Workable {

  @Override
  public Object work( Map< String, Object > parameters ) {

    int low = ( Integer ) parameters.get( "low" );
    int high = ( Integer ) parameters.get( "high" );
    int val = ( Integer ) parameters.get( "val" );

    return doDumbWork( low, high, val );
  }

  public int doDumbWork( int low, int high, int val ) {

    int guess;
    int numGuesses;
    Random rnd = Main.getInstance();

    numGuesses = 0;
    do {
      guess = ( int ) ( ( rnd.nextDouble() * ( high - low ) ) + low );
      numGuesses++;
    } while ( guess != val );

    return numGuesses;
  }

}
