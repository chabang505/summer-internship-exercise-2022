package com.premiumminds.internship.screenlocking;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.premiumminds.internship.screenlocking.Node;

public class Grid {
    
        
    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Map<Integer, Integer>> inFront = new ArrayList<Map<Integer, Integer>>();
    private ArrayList<Integer> usedNodes = new ArrayList<>();

    public Grid() {
        populateNodes();
        populateInFront();
    }

    public void populateNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        this.nodes.add(node1);
        this.nodes.add(node2);
        this.nodes.add(node3);
        this.nodes.add(node4);
        this.nodes.add(node5);
        this.nodes.add(node6);
        this.nodes.add(node7);
        this.nodes.add(node8);
        this.nodes.add(node9);
    }

    public void populateInFront() {
        Map<Integer, Integer> map1 = Map.of(2, 3, 4, 7, 5, 9);
        Map<Integer, Integer> map2 = Map.of(5, 8);
        Map<Integer, Integer> map3 = Map.of(2, 1, 5, 7, 6, 9);
        Map<Integer, Integer> map4 = Map.of(5, 6);
        Map<Integer, Integer> map5 = new HashMap<>();
        Map<Integer, Integer> map6 = Map.of(5, 4);
        Map<Integer, Integer> map7 = Map.of(4, 1, 5, 3, 8, 9);
        Map<Integer, Integer> map8 = Map.of(5, 2);
        Map<Integer, Integer> map9 = Map.of(5, 1, 6, 3, 8, 7);
        inFront.add(map1);
        inFront.add(map2);
        inFront.add(map3);
        inFront.add(map4);
        inFront.add(map5);
        inFront.add(map6);
        inFront.add(map7);
        inFront.add(map8);
        inFront.add(map9);
    }

    public Node getNode(int value) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getValue() == value) {
                return nodes.get(i);
            }
        }
        return null;
    }

    public void clearNode(Integer value) {
        /* Removes a node from the grid by removing it's respctive arraylist of connected nodes
         * and removing it from the lists of connected on all other nodes
         */
        usedNodes.add(value);
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getValue() == value) {
                nodes.remove(nodes.indexOf(nodes.get(i)));
                nodes.get(i).clearValue(value);
            }
        }   
    }

    public void seeNodes(Integer value) {
        /* Adds to a node's list of connected nodes previously unattainable nodes */
        for (int i = 0; i < inFront.size(); i++) {
            /* Checks if node(value) is blocking others and if it hasn't been used yet */
            if (inFront.get(i).containsKey(value) && !usedNodes.contains(value)) {
                nodes.get(i).getConnected().add(inFront.get(i).get(value));
            }
        }
    }

    public void updateGrid(Integer value) {
        clearNode(value);
        seeNodes(value);
    }
}
