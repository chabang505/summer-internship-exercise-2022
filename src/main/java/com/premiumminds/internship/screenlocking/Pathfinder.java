package com.premiumminds.internship.screenlocking;

import com.premiumminds.internship.screenlocking.Grid;
import com.premiumminds.internship.screenlocking.Node;

public class Pathfinder {
    
    Integer firstPoint;
    int length;
    Grid grid = new Grid();

    public Pathfinder(Integer firstPoint, int length) {
        this.firstPoint = firstPoint;
        this.length = length;
    }

    public int solve() {
        Node firstNode = grid.getNode(firstPoint);
        return solveAux(firstNode, length, grid);
    }

    public int solveAux(Node firstNode, int length, Grid grid) {
        if (length == 1) return 1;
        int cases = 0;
        for (int i = 0; i < firstNode.getConnected().size(); i++) {
            cases += solveAux(grid.getNode(firstNode.getConnected(i)), length - 1, grid.updateGrid(firstNode.getValue()));
        }
        return cases;
    } 
}
