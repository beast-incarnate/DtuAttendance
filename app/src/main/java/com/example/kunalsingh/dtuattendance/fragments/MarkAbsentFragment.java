package com.example.kunalsingh.dtuattendance.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kunalsingh.dtuattendance.adapters.ListViewAdapter;
import com.example.kunalsingh.dtuattendance.activities.MarkingAttendaceTeacher;
import com.example.kunalsingh.dtuattendance.R;

import java.util.ArrayList;

/**
 * Created by kunalsingh on 13/02/17.
 */

public class MarkAbsentFragment extends Fragment {

    ListView listView;
    public MarkAbsentFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mark_absent_frag,container,false);

        ArrayList<String> studentsList = MarkingAttendaceTeacher.getStudents();
        ArrayList<Integer> colorsList = MarkingAttendaceTeacher.getColors();
        listView = (ListView)view.findViewById(R.id.student_list_view_abs);
        ListViewAdapter listViewAdapter = new ListViewAdapter(studentsList,'a',getContext(),colorsList);
        listView.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();

        return view;
    }
}
