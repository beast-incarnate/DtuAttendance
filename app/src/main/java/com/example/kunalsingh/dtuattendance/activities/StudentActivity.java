package com.example.kunalsingh.dtuattendance.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.kunalsingh.dtuattendance.R;
import com.example.kunalsingh.dtuattendance.fragments.PieChartFragment;

import java.util.ArrayList;

/**
 * Created by mayank on 16/2/17.
 */

public class StudentActivity extends AppCompatActivity {

    public static final String TAG = "StudentActivity";

    private static int tmp;
    static long[] total;
    static long[] present;

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Intent intent = getIntent();

        ArrayList<CharSequence> subjects = intent.getCharSequenceArrayListExtra("subjects");
        total = intent.getLongArrayExtra("total");
        present = intent.getLongArrayExtra("present");
        for(int j=0;j<subjects.size();j++)
        Log.d(TAG,"ss"+total[j]+" "+present[j]);

        int size = subjects.size();

        relativeLayout = (RelativeLayout) findViewById(R.id.rl_student_activity);

        RelativeLayout.LayoutParams params[] = new RelativeLayout.LayoutParams[size];

        final Button btn[] = new Button[size];

        // adding buttons dynamically


        for (int i = 0; i < size; i++) {
            btn[i] = new Button(this);
            btn[i].setId((i + 1) * 4);
            btn[i].setBackgroundColor(Color.parseColor("#03a9f4"));
            params[i] = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params[i].setMargins(4, 4, 0, 0);

            if (i % 4 == 0 && i > 0) {
                //    Log.d(TAG,"came "+" "+i);
                params[i].addRule(RelativeLayout.BELOW, btn[i - 4].getId());

            } else if (i > 0 && i > 3) {
                params[i].addRule(RelativeLayout.RIGHT_OF, btn[i - 1].getId());
                params[i].addRule(RelativeLayout.BELOW, btn[i - 4].getId());
            } else if (i > 0) {
                params[i].addRule(RelativeLayout.RIGHT_OF, btn[i - 1].getId());
            } else {
                params[i].addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            }
            if (subjects.get(i).toString().length() <= 5)
                btn[i].setText(subjects.get(i).toString());
            else {
                btn[i].setText(subjects.get(i).toString().substring(0, 3) + "..");
            }

            btn[i].setTextSize(12);

            btn[i].setLayoutParams(params[i]);
            relativeLayout.addView(btn[i], params[i]);

            final int finalI = i;
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tmp = finalI;

                    PieChartFragment pieChartFragment = new PieChartFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();

                    transaction.replace(R.id.frame_container_piechart,pieChartFragment,null);
                    transaction.commit();

                }
            });
        }
        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_container_piechart);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.BELOW, btn[size-1].getId());
        frameLayout.setLayoutParams(layoutParams);
        if (frameLayout.getParent() != null) {
            ((ViewGroup) frameLayout.getParent()).removeView(frameLayout);
        }
        relativeLayout.addView(frameLayout);
    }

    public static long getTotal(){
        return total[tmp];
    }

    public static long getPresent(){
        return present[tmp];
    }

}
