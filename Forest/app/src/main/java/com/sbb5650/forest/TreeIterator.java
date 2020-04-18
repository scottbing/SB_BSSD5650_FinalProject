package com.sbb5650.forest;

import java.util.ArrayList;
import java.util.List;

//TreeIterator.java
public class TreeIterator implements Iterator<Tree> {

    private List<Tree> trees;
    private int position;

    public TreeIterator(List<Tree> trees)
    {
        this.trees = trees;
        position = 0;
    }

    @Override
    public void reset() {
        position = 0;
    }

    @Override
    public Tree next() {
        return trees.get(position++);
    }

    @Override
    public Tree currentItem() {
        return trees.get(position);
    }

    @Override
    public boolean hasNext() {
        if(position >= trees.size())
            return false;
        return true;
    }
}