package com.premiumminds.internship.screenlocking;

import java.util.concurrent.Future;
import javax.management.InvalidAttributeValueException;

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
  public Integer countPatternsFrom(int firstPoint,int length) {
    ProblemSolver solver = new ProblemSolver(new ScreenProblem(firstPoint, 0), length);
    Integer count = ProblemSolver.depthLimitedSearch();
  }

  public static void main(String[] args) {
    Integer result = countPatternsFrom(args[0], args[1]);
    System.out.println("Essa combinacao resulta em " + result + " padroes no ecra.");
  }
}
