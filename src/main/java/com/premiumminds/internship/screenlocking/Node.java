package com.premiumminds.internship.screenlocking;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Node {

    private int value;
    private List<Integer> connected = new ArrayList<>();

    static int[] corner = {2, 4, 5, 6, 8};
    static int[] side28 = {1, 3, 4, 5, 6, 7, 9};
    static int[] side46 = {1, 2, 3, 5, 7, 8, 9};
    static int[] middle = {1, 2, 3, 4, 6, 7, 8, 9};

    public Node(int value) {
        this.value = value;
        if (value == 1 || value == 3 || value == 7 || value == 9) {
            for (int num : corner) {
                this.connected.add(num);
            }
        }
        else if (value == 2 || value == 8) {
            for (int num : side28) {
                this.connected.add(num);
            }
        }

        else if (value == 4 || value == 6) {
            for (int num : side46) {
                this.connected.add(num);
            }
        }

        else {
            for (int num : middle) {
                this.connected.add(num);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getConnected() {
        return connected;
    }

    public void clearValue(int value) {
        /* Removes a node from the list of connected nodes */
        this.connected.remove(connected.indexOf(Integer.valueOf(value)));
    }
}
