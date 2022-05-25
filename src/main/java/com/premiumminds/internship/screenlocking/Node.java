package com.premiumminds.internship.screenlocking;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.ArrayList;

import com.premiumminds.internship.screenlocking.Problem;

public class Node {
    
    private Integer state = null;
    private Node parent = null;
    private Integer action = null;
    private int depth = 0;

    public Node() {

    }

    public Node(Integer state) {
        this.state = state;
    }

    public Node(Integer state, Node parent, Integer action) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        if (parent != null) {
            this.depth = parent.depth + 1;
        }
    }

    public Integer getState() {
        return this.state;
    }

    public ArrayList<Node> expand(ScreenProblem problem) {
        /** List the nodes reachable in one step from this node */
        List<Node> nodes = new ArrayList<>();
        for (int action: problem.actions(this.state)) {
            nodes.add(this.childNode(problem, action));
        }
        problem.clear(this.state);
        return nodes;
    }

    public Node childNode(ScreenProblem problem, int action) {
        /** Returns the child node resulting from performing a given action */
        try {
            Integer nextState = problem.result(this.state, action);
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        };
        Node nextNode = new Node(nextState, this, action);
        return nextNode;
    }
}
