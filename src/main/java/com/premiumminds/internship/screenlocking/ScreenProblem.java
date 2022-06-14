package com.premiumminds.internship.screenlocking;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

public class ScreenProblem extends Problem {

    private int initial;
    private int goal;
    private ArrayList<Integer>[] actionList = new ArrayList[9];

    private Integer[] corner = {2, 4, 5, 6, 8};
    private Integer[] edge28 = {1, 3, 4, 5, 6, 7, 9};
    private Integer[] edge46 = {1, 2, 3, 5, 7, 8, 9};
    private Integer[] middle = {1, 2, 3, 4, 6, 7, 8, 9};

    public ScreenProblem() {
        
    }

    public ScreenProblem(int initial, int goal) {
        super(initial, goal);
        actionListBuilder();
    }
    
    private void actionListBuilder() {
        /** Builds an array with the possible actions for each state in the problem */
        for (int i = 0; i < 9; i++) {
            if (i+1 == 1 || i+1 == 3 || i+1 == 7 || i+1 == 9) {
                actionList[i] = Arrays.asList(corner);
            }
            else if (i+1 == 2 || i+1 == 8) {
                actionList[i] = Arrays.asList(edge28);
            }
            else if (i+1 == 4 || i+1 == 6) {
                actionList[i] = Arrays.asList(edge46);
            }
            else {
                actionList[i] = Arrays.asList(middle);
            }
        }
    }

    public void clear(Integer state) {
        /** Removes a state from the array of possible actions, 
         * since a given state can only be visited once
         */
        for (int i = 0; i < 9; i++) {
            if (actionList[i].contains(state))
                actionList[i].remove(actionList[i].indexOf(state));
            else
                continue;
        }
    }

    @Override
    public ArrayList<Integer> actions(int state) {
        /** Returns the actions possible from a certain state */
        return actionList[state-1];
    }

    public int result(int state, Integer action) throws InvalidParameterException {
        /** Returns the result of performing an action on a given state */
        if (actions(state).contains(action)) {
            return action;
        }
        else {
            throw new InvalidParameterException("Invalid action");
        }
    }

}
