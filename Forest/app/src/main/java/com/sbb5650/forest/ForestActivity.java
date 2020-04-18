package com.sbb5650.forest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

import java.util.Random;


public class ForestActivity extends AppCompatActivity {

    private DemoView demoview;
    static int TREES_TO_DRAW = 1000000;
    //static int TREES_TO_DRAW = 3510;
    static int TREE_TYPES = 4;
    private int width = 0;
    private int height = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        demoview = new DemoView(this);
        setContentView(demoview);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        Log.e("Width", "" + width);
        Log.e("height", "" + height);

    }

    public class DemoView extends View{
        public DemoView(Context context){
            super(context);
        }

        @Override protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // create instance of Random class
            Random random = new Random();
            Bundle b = getIntent().getExtras();
            TREES_TO_DRAW = b.getInt("numberOfTrees");
            TREE_TYPES = b.getInt("treeCount");

            boolean isSummerOak = b.getBoolean("isSummerOak");
            boolean isAutumnOak = b.getBoolean("isAutumnOak");
            boolean isRedMaple = b.getBoolean("isRedMaple");
            boolean isElm = b.getBoolean("isElm");

            int colorSummerOak =  b.getInt("colorSummerOak");
            int colorAutumnOak =  b.getInt("colorAutumnOak");
            int colorRedMaple =  b.getInt("colorRedMaple");
            int colorElm =  b.getInt("colorElm");

            Forest forest = new Forest();
            for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
                if (isSummerOak) {
                    forest.plantTree(random.nextInt(width), random.nextInt(height),
                            "Summer Oak", colorSummerOak, "Oak texture stub");
                }
                if (isAutumnOak) {
                    forest.plantTree(random.nextInt(width), random.nextInt(height),
                            "Autumn Oak", colorAutumnOak, "Oak texture stub");
                }
                if (isRedMaple) {
                    forest.plantTree(random.nextInt(width), random.nextInt(height),
                            "Red Maple", colorRedMaple, "Oak texture stub");
                }
                if (isElm) {
                    forest.plantTree(random.nextInt(width), random.nextInt(height),
                            "Elm", colorElm, "Oak texture stub");
                }
            }

            // custom drawing code here
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);

            // make the entire canvas white
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);

            // draw the trees
            forest.paint(canvas);

            //show the Flyweight results
            showResults();

            //undo the rotate
            //canvas.restore();
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void showResults() {
        double total = ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024);
        double insteadOf = ((TREES_TO_DRAW * 38) / 1024 / 1024);
        AlertDialog.Builder dialog=new AlertDialog.Builder(ForestActivity.this);
        StringBuilder sb = new StringBuilder();
        sb.append(TREES_TO_DRAW + " trees drawn");
        sb.append("\n");
        sb.append("---------------------");
        sb.append("\n");
        sb.append("Memory usage:");
        sb.append("\n");
        sb.append("Tree size (8 bytes) * " + TREES_TO_DRAW);
        sb.append("\n");
        sb.append("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
        sb.append("\n");
        sb.append("---------------------");
        sb.append("\n");
        sb.append("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
        dialog.setMessage(sb.toString());
        dialog.setTitle("FLYWEIGHT RESULTS");
        dialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
        return;
    }


}
