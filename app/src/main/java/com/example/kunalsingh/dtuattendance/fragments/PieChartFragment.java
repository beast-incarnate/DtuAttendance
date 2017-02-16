package com.example.kunalsingh.dtuattendance.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kunalsingh.dtuattendance.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

/**
 * Created by kunalsingh on 16/02/17.
 */

public class PieChartFragment extends Fragment {

    PieChart pieChart;
    public PieChartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pie_chart_fragment,container,false);

         pieChart = (PieChart)view.findViewById(R.id.pie_chart);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(0);
        addDataSet(50,35);
        return view;
    }

    public void addDataSet(int total , int present){


        int per;
        per=(int)((float)present/total*100);

        int abs=100-per;

        ArrayList<PieEntry> entry = new ArrayList<>();

        entry.add(new PieEntry(per));
        entry.add(new PieEntry(abs));
        PieDataSet pieDataSet = new PieDataSet(entry,"RECORD");

        pieDataSet.setValueTextSize(20);

        pieDataSet.setValueTextColor(Color.WHITE);

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.parseColor("#006600"));
        colors.add(Color.parseColor("#CC0000"));

        pieDataSet.setColors(colors);
        pieDataSet.setSliceSpace(5);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.setContentDescription("");
        Description description = pieChart.getDescription();
        description.setEnabled(false);
        pieChart.setDrawHoleEnabled(false);
        Legend legend = pieChart.getLegend();
        legend.setEnabled(false);
        pieChart.invalidate();
    }
}
