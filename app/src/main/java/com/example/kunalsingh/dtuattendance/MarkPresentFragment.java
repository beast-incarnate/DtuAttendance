package com.example.kunalsingh.dtuattendance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by kunalsingh on 13/02/17.
 */

public class MarkPresentFragment extends Fragment {


    ListView listView;
    public MarkPresentFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.mark_present_frag,container,false);

        ArrayList<String> studentsList = MarkingAttendaceTeacher.getStudents();
        ArrayList<Integer> colorsList = MarkingAttendaceTeacher.getColors();
        listView = (ListView)view.findViewById(R.id.student_list_view_pre);
        ListViewAdapter listViewAdapter = new ListViewAdapter(studentsList,'p',getContext(),colorsList);
        listView.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();
        return view;
    }
}
