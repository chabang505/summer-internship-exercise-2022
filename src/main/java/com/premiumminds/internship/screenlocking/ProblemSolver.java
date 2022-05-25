package com.premiumminds.internship.screenlocking;

import java.util.ArrayList;
import java.util.Stack;

import com.premiumminds.internship.screenlocking.Problem;

public class ProblemSolver {
    
    private Problem problem = new Problem();
    private int limit = 0;
    private int depth;

    public ProblemSolver() {

    }

    public ProblemSolver(Problem problem, int limit) {
        this.problem = problem;
        this.limit = limit;
    }

    public int depthLimitedSearch() {
        Stack<Node> nodeStack = new Stack<>();
        int count;
        nodeStack.add(problem.getInitial());

        this.depth = 0;
        
        while(!nodeStack.isEmpty()) {
            if (depth < limit) {
                Node current = nodeStack.pop();
                if (current.getState() == problem.getGoal()) {
                    System.out.println("Goal found");
                    return -1;
                }
                else {
                    nodeStack.addAll(current.expand(problem));
                    depth++;
                }
            }
            else if (depth == limit) {
                count = nodeStack.size();
            }
        }
        return count;
    }
}
