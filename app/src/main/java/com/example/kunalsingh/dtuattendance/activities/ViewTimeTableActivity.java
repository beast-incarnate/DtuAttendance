package com.example.kunalsingh.dtuattendance.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.kunalsingh.dtuattendance.R;
import com.example.kunalsingh.dtuattendance.fragments.ViewTimeTableFragment;

public class ViewTimeTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_time_table);

       // FrameLayout frameLayout = (FrameLayout)findViewById(R.id.view_tt_fl);

        Fragment fragment = new ViewTimeTableFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.view_tt_fl,fragment);
        transaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.view_timetable_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
}
