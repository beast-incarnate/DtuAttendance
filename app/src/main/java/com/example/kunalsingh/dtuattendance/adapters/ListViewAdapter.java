package com.example.kunalsingh.dtuattendance.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kunalsingh.dtuattendance.R;

import java.util.ArrayList;

/**
 * Created by kunalsingh on 13/02/17.
 */

public class ListViewAdapter extends BaseAdapter {

    private static final String TAG = "ListViewAdapter";
    ArrayList<String> studentsList = new ArrayList<>();
    char ch;
    Context context;
    ArrayList<Integer> colorsList = new ArrayList<>();

    public ListViewAdapter(ArrayList<String> studentsList, char ch , Context context , ArrayList<Integer> colorsList) {
        this.studentsList = studentsList;
        this.ch = ch;
        this.context = context;
        this.colorsList = colorsList;
    }

    @Override
    public int getCount() {
        return studentsList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.d(TAG,"view at position :"+position);
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = layoutInflater.inflate(R.layout.students_list,null);
        convertView.setBackgroundColor(colorsList.get(position));
        TextView textView = (TextView)convertView.findViewById(R.id.tv_student_info);
        textView.setText(studentsList.get(position));

        final View finalConvertView = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Drawable background = finalConvertView.getBackground();

                int color = ((ColorDrawable)background).getColor();
                if(ch=='p') {
                    if (color == Color.WHITE) {
                        finalConvertView.setBackgroundColor(Color.GREEN);
                        colorsList.set(position,Color.GREEN);
                    } else {
                        finalConvertView.setBackgroundColor(Color.WHITE);
                        colorsList.set(position,Color.WHITE);
                    }
                }else{
                    if (color == Color.WHITE) {
                        finalConvertView.setBackgroundColor(Color.RED);
                        colorsList.set(position,Color.RED);
                    } else {
                        finalConvertView.setBackgroundColor(Color.WHITE);
                        colorsList.set(position,Color.RED);
                    }
                }

            }
        });

        return convertView;
    }
}
