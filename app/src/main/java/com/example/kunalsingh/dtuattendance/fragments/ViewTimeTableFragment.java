package com.example.kunalsingh.dtuattendance.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kunalsingh.dtuattendance.R;

/**
 * Created by kunalsingh on 16/02/17.
 */

public class ViewTimeTableFragment extends Fragment {

    TextView timeTable[][] = new TextView[5][8];
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_time_table_frag,container,false);

        assignTable(view);
        timeTable[0][0].setText("2nd yr");
        timeTable[1][1].setText("2nd yr");
        timeTable[2][2].setText("2nd yr");

        return view;
    }

    public void assignTable(View view){

        timeTable[0][0] = (TextView) view.findViewById(R.id.tt_tr_one_et_one);
        timeTable[0][1] = (TextView) view.findViewById(R.id.tt_tr_one_et_two);
        timeTable[0][2] = (TextView) view.findViewById(R.id.tt_tr_one_et_three);
        timeTable[0][3] = (TextView) view.findViewById(R.id.tt_tr_one_et_four);
        timeTable[0][4] = (TextView) view.findViewById(R.id.tt_tr_one_et_five);
        timeTable[0][5] = (TextView) view.findViewById(R.id.tt_tr_one_et_six);
        timeTable[0][6] = (TextView) view.findViewById(R.id.tt_tr_one_et_seven);
        timeTable[0][7] = (TextView) view.findViewById(R.id.tt_tr_one_et_eight);
        timeTable[1][0] = (TextView) view.findViewById(R.id.tt_tr_two_et_one);
        timeTable[1][1] = (TextView) view.findViewById(R.id.tt_tr_two_et_two);
        timeTable[1][2] = (TextView) view.findViewById(R.id.tt_tr_two_et_three);
        timeTable[1][3] = (TextView) view.findViewById(R.id.tt_tr_two_et_four);
        timeTable[1][4] = (TextView) view.findViewById(R.id.tt_tr_two_et_five);
        timeTable[1][5] = (TextView) view.findViewById(R.id.tt_tr_two_et_six);
        timeTable[1][6] = (TextView) view.findViewById(R.id.tt_tr_two_et_seven);
        timeTable[1][7] = (TextView) view.findViewById(R.id.tt_tr_two_et_eight);
        timeTable[2][0] = (TextView) view.findViewById(R.id.tt_tr_three_et_one);
        timeTable[2][1] = (TextView) view.findViewById(R.id.tt_tr_three_et_two);
        timeTable[2][2] = (TextView) view.findViewById(R.id.tt_tr_three_et_three);
        timeTable[2][3] = (TextView) view.findViewById(R.id.tt_tr_three_et_four);
        timeTable[2][4] = (TextView) view.findViewById(R.id.tt_tr_three_et_five);
        timeTable[2][5] = (TextView) view.findViewById(R.id.tt_tr_three_et_six);
        timeTable[2][6] = (TextView) view.findViewById(R.id.tt_tr_three_et_seven);
        timeTable[2][7] = (TextView) view.findViewById(R.id.tt_tr_three_et_eight);
        timeTable[3][0] = (TextView) view.findViewById(R.id.tt_tr_four_et_one);
        timeTable[3][1] = (TextView) view.findViewById(R.id.tt_tr_four_et_two);
        timeTable[3][2] = (TextView) view.findViewById(R.id.tt_tr_four_et_three);
        timeTable[3][3] = (TextView) view.findViewById(R.id.tt_tr_four_et_four);
        timeTable[3][4] = (TextView) view.findViewById(R.id.tt_tr_four_et_five);
        timeTable[3][5] = (TextView) view.findViewById(R.id.tt_tr_four_et_six);
        timeTable[3][6] = (TextView) view.findViewById(R.id.tt_tr_four_et_seven);
        timeTable[3][7] = (TextView) view.findViewById(R.id.tt_tr_four_et_eight);
        timeTable[4][0] = (TextView) view.findViewById(R.id.tt_tr_five_et_one);
        timeTable[4][1] = (TextView) view.findViewById(R.id.tt_tr_five_et_two);
        timeTable[4][2] = (TextView) view.findViewById(R.id.tt_tr_five_et_three);
        timeTable[4][3] = (TextView) view.findViewById(R.id.tt_tr_five_et_four);
        timeTable[4][4] = (TextView) view.findViewById(R.id.tt_tr_five_et_five);
        timeTable[4][5] = (TextView) view.findViewById(R.id.tt_tr_five_et_six);
        timeTable[4][6] = (TextView) view.findViewById(R.id.tt_tr_five_et_seven);
        timeTable[4][7] = (TextView) view.findViewById(R.id.tt_tr_five_et_eight);


    }
}
