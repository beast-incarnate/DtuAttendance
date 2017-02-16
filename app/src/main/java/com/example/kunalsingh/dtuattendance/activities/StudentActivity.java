package com.example.kunalsingh.dtuattendance.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.kunalsingh.dtuattendance.R;
import com.example.kunalsingh.dtuattendance.fragments.PieChartFragment;

import java.util.ArrayList;

/**
 * Created by mayank on 16/2/17.
 */

public class StudentActivity extends AppCompatActivity {

    Button btn [] = new Button[8];
    static ArrayList<Integer> total = new ArrayList<>();
    static ArrayList<Integer> present = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        assignButtons();

        final FragmentManager manager = getSupportFragmentManager();
        final PieChartFragment pieChartFragment = new PieChartFragment();
        for(int i=0;i<8;i++){
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frame_container_piechart,pieChartFragment);
                    transaction.commit();
                }
            });
        }



    }


    public void assignButtons(){

        btn[0] = (Button)findViewById(R.id.btn_one);
        btn[1] = (Button)findViewById(R.id.btn_two);
        btn[2] = (Button)findViewById(R.id.btn_three);
        btn[3] = (Button)findViewById(R.id.btn_four);
        btn[4] = (Button)findViewById(R.id.btn_five);
        btn[5] = (Button)findViewById(R.id.btn_six);
        btn[6] = (Button)findViewById(R.id.btn_seven);
        btn[7] = (Button)findViewById(R.id.btn_eight);

    }

    public static int getTotal(int i){
        return total.get(i);
    }

    public static int getPresent(int i){
        return present.get(i);
    }
}
