package com.premiumminds.internship.screenlocking;

import java.util.concurrent.Future;
import javax.management.InvalidAttributeValueException;

/**
  * Created by aamado on 05-05-2022.
  */
interface IScreenLockinPattern {
  /**
    * Method to count patterns from firstPoint with the length
    * @param firstPoint initial matrix position
    * @param length the number of points used in pattern
    * @return number of patterns
    */
  public Integer countPatternsFrom(int firstPoint,int length);
}
