package com.sbb5650.forest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.graphics.Color;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String numberOfTrees;
    private int treeCount = 0;
    private boolean isSummerOak = false;
    private boolean isAutumnOak = false;
    private boolean isRedMaple = false;
    private boolean isElm = false;

    /*
    This project demonstrates the Flyweight Pattern and the Iterate Pattern.
    The Flyweight pattern was adopted from the example given in the Refactoring Guru's Design Patterns website
    https://refactoring.guru/design-patterns
    I re-engineered and refactored the original code.  The original code was written in the Java JFrame, Java AWT and
    legacy java graphics technologies.  I refactored and re-engineered the code into Java Android and Java up-to-date
    graphics.  I also added the classes to implement the Iterate Pattern.  A front-end was also added to give the user
    the choice of the number of trees and colors.  A Java alert dialog provides Flyweight statistics.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up the widgets
        final EditText edHowManyTrees = (EditText) findViewById(R.id.edHowManyTrees);
        numberOfTrees = edHowManyTrees.getText().toString();
        edHowManyTrees.setHint("Enter total number of trees Here");
        final CheckBox cbSummerOak = (CheckBox) findViewById(R.id.cbSummerOak);
        final CheckBox cbAutumnOak = (CheckBox) findViewById(R.id.cbAutumOak);
        final CheckBox cbRedMaple = (CheckBox) findViewById(R.id.cbRedMaple);
        final CheckBox cbElm = (CheckBox) findViewById(R.id.cbElm);
        final RadioGroup rgSummerOak = (RadioGroup) findViewById(R.id.rgSummerOak);
        final RadioGroup rgAutumnOak = (RadioGroup) findViewById(R.id.rgAutumnOak);
        final RadioGroup rgRedMaple = (RadioGroup) findViewById(R.id.rgRedMaple);
        final RadioGroup rgElm = (RadioGroup) findViewById(R.id.rgElm);
        final RadioButton rbRedSummerOak = (RadioButton) findViewById(R.id.rbRedSummerOak);
        final RadioButton rbGreenSummerOak = (RadioButton) findViewById(R.id.rbGreenSummerOak);
        final RadioButton rbBlueSummerOak = (RadioButton) findViewById(R.id.rbBlueSummerOak);
        final RadioButton rbBlackSummerOak = (RadioButton) findViewById(R.id.rbBlackSummerOak);
        final RadioButton rbRedAutumnOak = (RadioButton) findViewById(R.id.rbRedAutumnOak);
        final RadioButton rbGreenAutumnOak = (RadioButton) findViewById(R.id.rbGreenAutumnOak);
        final RadioButton rbBlueAutumnOak = (RadioButton) findViewById(R.id.rbBlueAutumnOak);
        final RadioButton rbBlackAutumnOak = (RadioButton) findViewById(R.id.rbBlackAutumnOak);
        final RadioButton rbRedRedMaple = (RadioButton) findViewById(R.id.rbRedRedMaple);
        final RadioButton rbGreenRedMaple = (RadioButton) findViewById(R.id.rbGreenRedMaple);
        final RadioButton rbBlueRedMaple = (RadioButton) findViewById(R.id.rbBlueRedMaple);
        final RadioButton rbBlackRedMaple = (RadioButton) findViewById(R.id.rbBlackRedMaple);
        final RadioButton rbRedElm = (RadioButton) findViewById(R.id.rbRedElm);
        final RadioButton rbGreenElm = (RadioButton) findViewById(R.id.rbGreenElm);
        final RadioButton rbBlueElm = (RadioButton) findViewById(R.id.rbBlueElm);
        final RadioButton rbBlackElm = (RadioButton) findViewById(R.id.rbBlackElm);

        // handle the reset button
        final Button btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v==btnReset) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
            }
        });

        // handle the button
        Button btnMakeForest = (Button) findViewById(R.id.btnMakeForest);
        btnMakeForest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Main", "Button works!!! ===================================");

                // Creating Bundle object
                Bundle b = new Bundle();

                numberOfTrees = edHowManyTrees.getText().toString();
                edHowManyTrees.requestFocus();
                if( edHowManyTrees.getText().toString().length() == 0 ) {
                    edHowManyTrees.setError("Total Number of Trees is required!");
                    return;
                }
                edHowManyTrees.requestFocus();
                if (edHowManyTrees.getText().toString().trim().equalsIgnoreCase("")) {
                    edHowManyTrees.setError("This field can not be blank");
                    return;
                }

                treeCount = 0;
                // check Summer Oak seettings
                if (cbSummerOak.isChecked()) {
                    isSummerOak = true;
                    treeCount++;
                    if (rgSummerOak.getCheckedRadioButtonId() == -1) {
                        // no radio buttons are checked
                    } else {
                        if (rbRedSummerOak.isChecked()) {
                            b.putInt("colorSummerOak", Color.RED);
                        }
                        if (rbGreenSummerOak.isChecked()) {
                            b.putInt("colorSummerOak", Color.GREEN);
                        }
                        if (rbBlueSummerOak.isChecked()) {
                            b.putInt("colorSummerOak", Color.BLUE);
                        }
                        if (rbBlackSummerOak.isChecked()) {
                            b.putInt("colorSummerOak", Color.BLACK);
                        }
                    }
                }

                // check Autumn Oak seettings
                if (cbAutumnOak.isChecked()) {
                    isAutumnOak = true;
                    treeCount++;
                    if (rgAutumnOak.getCheckedRadioButtonId() == -1) {
                        // no radio buttons are checked
                    } else {
                        if (rbRedAutumnOak.isChecked()) {
                            b.putInt("colorAutumnOak", Color.RED);
                        }
                        if (rbGreenAutumnOak.isChecked()) {
                            b.putInt("colorAutumnOak", Color.GREEN);
                        }
                        if (rbBlueAutumnOak.isChecked()) {
                            b.putInt("colorAutumnOak", Color.BLUE);
                        }
                        if (rbBlackAutumnOak.isChecked()) {
                            b.putInt("colorAutumnOak", Color.BLACK);
                        }
                    }
                }

                // check Red Maple seettings
                if (cbRedMaple.isChecked()) {
                    isRedMaple = true;
                    treeCount++;
                    if (rgRedMaple.getCheckedRadioButtonId() == -1) {
                        // no radio buttons are checked
                    } else {
                        if (rbRedRedMaple.isChecked()) {
                            b.putInt("colorRedMaple", Color.RED);
                        }
                        if (rbGreenRedMaple.isChecked()) {
                            b.putInt("colorRedMaple", Color.GREEN);
                        }
                        if (rbBlueRedMaple.isChecked()) {
                            b.putInt("colorRedMaple", Color.BLUE);
                        }
                        if (rbBlackRedMaple.isChecked()) {
                            b.putInt("colorRedMaple", Color.BLACK);
                        }
                    }
                }

                // check Elm seettings
                if (cbElm.isChecked()) {
                    isElm = true;
                    treeCount++;
                    if (rgElm.getCheckedRadioButtonId() == -1) {
                        // no radio buttons are checked
                    } else {
                        if (rbRedElm.isChecked()) {
                            //colorElm = Color.RED;
                            b.putInt("colorElm", Color.RED);
                        }
                        if (rbGreenElm.isChecked()) {
                            //colorElm = Color.GREEN;
                            b.putInt("colorElm", Color.GREEN);
                        }
                        if (rbBlueElm.isChecked()) {
                            //colorElm = Color.BLUE;
                            b.putInt("colorElm", Color.BLUE);
                        }
                        if (rbBlackElm.isChecked()) {
                            //colorElm = Color.BLACK;
                            b.putInt("colorElm", Color.BLACK);
                        }
                    }
                }

                // no trees were selected
                if (!isSummerOak && !isAutumnOak && !isRedMaple && !isElm) {
                    AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                    dialog.setMessage("Please Select at least one tree and tree color.");
                    dialog.setTitle("ALERT");
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

                // Storing data into bundle
                if( numberOfTrees.toString().length() == 0 ) {
                    edHowManyTrees.setError("This field can not be blank");
                    return;
                }
                else {
                    b.putInt("numberOfTrees", Integer.parseInt(numberOfTrees));
                    b.putInt("treeCount", treeCount);
                    b.putBoolean("isSummerOak", isSummerOak);
                    b.putBoolean("isAutumnOak", isAutumnOak);
                    b.putBoolean("isRedMaple", isRedMaple);
                    b.putBoolean("isElm", isElm);
                }

                // Creating Intent object
                Intent in = new Intent(MainActivity.this, ForestActivity.class);

                // Storing bundle object into intent
                in.putExtras(b);
                startActivity(in);
            }
        });
    }
}

