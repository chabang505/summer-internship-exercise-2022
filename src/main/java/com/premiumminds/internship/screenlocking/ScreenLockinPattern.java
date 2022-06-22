package com.premiumminds.internship.screenlocking;

import com.premiumminds.internship.screenlocking.Pathfinder;

/**
 * Created by aamado on 05-05-2022.
 */
class ScreenLockinPattern implements IScreenLockinPattern {

 /**
  * Method to count patterns from firstPoint with the length
  * @param firstPoint initial matrix position
  * @param length the number of points used in pattern
  * @return number of patterns
  */
  public int countPatternsFrom(int firstPoint,int length) {
    Pathfinder solver = new Pathfinder(firstPoint, length);
    return solver.solve();
  }
 
  public static void main(String[] args) {

    ScreenLockinPattern counter = new ScreenLockinPattern();
    // The program receives the first point and the length from the command line, printing out the result
    int firstPoint = Integer.valueOf(args[0]);
    int length = Integer.valueOf(args[1]);
    int result = counter.countPatternsFrom(firstPoint, length);
        System.out.println(result);
  }
}