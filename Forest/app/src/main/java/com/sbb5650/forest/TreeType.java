package com.sbb5650.forest;

import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;

public class TreeType {

    private String name;
    private int color;
    private String otherTreeData;

    public TreeType() {
    }

    public TreeType(String name, int color, String otherTreeData) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getOtherTreeData() {
        return otherTreeData;
    }

    public void setOtherTreeData(String otherTreeData) {
        this.otherTreeData = otherTreeData;
    }

    public void draw(Canvas c, int x, int y) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        c.drawRect(x - 1, y, 3, 5, paint);
        paint.setColor(color);
        c.drawOval(x - 5, y - 10, 10, 10, paint);
    }
}
