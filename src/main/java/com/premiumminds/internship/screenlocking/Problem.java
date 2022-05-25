package com.premiumminds.internship.screenlocking;

import java.util.ArrayList;

public class Problem {
    
    private Node initial = new Node(0);
    private Node goal = new Node(0);

    public Problem() {

    }

    public Problem(int initial, int goal) {
        this.initial = new Node(initial);
        this.goal = new Node(goal);
    }

    public Node getInitial() {
        return this.initial;
    }

    public Node getGoal() {
        return this.goal;
    }

    public ArrayList<Integer> actions(int state) throws RuntimeException{
        throw new RuntimeException("Not implemented yet");
    }

    public int result(int state, int action) throws RuntimeException{
        throw new RuntimeException("Not implemented yet");
    } 

    public boolean goalTest(int state) {
        return this.goal.state == state;
    }
}
