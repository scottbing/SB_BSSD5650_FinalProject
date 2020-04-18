package com.sbb5650.forest;

import java.nio.DoubleBuffer;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {

    static Map<String, TreeType> treeTypes = new HashMap<>();

    // This illustrates the Flyweight Pattern
    // If object already exists, return it
    // otherwise, make new
    public static TreeType getTreeType(String name, int color, String otherTreeData) {
        TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, otherTreeData);
            treeTypes.put(name, result);
        }
        return result;
    }

}
