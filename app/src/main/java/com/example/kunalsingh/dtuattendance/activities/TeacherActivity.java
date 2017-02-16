package com.example.kunalsingh.dtuattendance.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.kunalsingh.dtuattendance.R;

/**
 * Created by mayank on 16/2/17.
 */

public class TeacherActivity extends AppCompatActivity {

    Button markAttendance;
    Button viewTimetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        viewTimetable = (Button) findViewById(R.id.viewTimetable);
        markAttendance = (Button) findViewById(R.id.markAttendanceButton);

        markAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TeacherActivity.this, MarkingAttendaceTeacher.class);
                startActivity(i);
            }
        });

    }
}
