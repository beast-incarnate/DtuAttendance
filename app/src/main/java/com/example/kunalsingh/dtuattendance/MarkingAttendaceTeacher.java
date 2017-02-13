package com.example.kunalsingh.dtuattendance;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import java.util.ArrayList;

public class MarkingAttendaceTeacher extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marking_attendace_teacher);


        viewPager = (ViewPager)findViewById(R.id.view_pager_mark);
        tabLayout = (TabLayout)findViewById(R.id.tab_layout_mark);

        FragmentManager fragmentManager = getSupportFragmentManager();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPagerAdapter.notifyDataSetChanged();


    }


    public class ViewPagerAdapter extends FragmentPagerAdapter{

        private String tabs[] = {"Present","Absent"};

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch(position){
                case 0: return new MarkPresentFragment();

                case 1 : return new MarkAbsentFragment();

                default: return null;
            }


        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }

    public static ArrayList<String> getStudents(){

        ArrayList<String> studentsList = new ArrayList<>();

        studentsList.add("Aastha Jain (2K15/MC/001)");
        studentsList.add("Aayush Jain (2K15/MC/002)");
        studentsList.add("Abhishek Kumar (2K15/MC/003)");
        studentsList.add("Abhishek Kumar Sagar (2K15/MC/004)");
        studentsList.add("Aditi Gupta (2K15/MC/005)");
        studentsList.add("Aditya Prateek (2K15/MC/006)");
        studentsList.add("Alankrit Nirjhar (2K15/MC/007)");
        studentsList.add("Alisha Jaiswal (2K15/MC/008)");
        studentsList.add("Aman Mehta (2K15/MC/009)");
        studentsList.add("Anil Kumar (2K15/MC/010)");
        studentsList.add("Ankesh Kumar Suman (2K15/MC/011)");
        studentsList.add("Anuj Badhwar (2K15/MC/012)");
        studentsList.add("Apoorvi Varshney (2K15/MC/013)");
        studentsList.add("Arnav Saxena (2K15/MC/014)");
        studentsList.add("Asad Hafeez (2K15/MC/015)");
        studentsList.add("Ashish Padhi (2K15/MC/016)");
        studentsList.add("Deepak (2K15/MC/017)");
        studentsList.add("Abhishek Kumar Sagar (2K15/MC/018)");

        return studentsList;

    }

    public static ArrayList<Integer> getColors(){

        ArrayList<Integer> colorsList = new ArrayList<>();

        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);
        colorsList.add(Color.WHITE);

        return colorsList;
    }
}
