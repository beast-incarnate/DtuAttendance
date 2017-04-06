package com.example.kunalsingh.dtuattendance.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kunalsingh.dtuattendance.R;
import com.example.kunalsingh.dtuattendance.activities.StudentActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

/**
 * Created by kunalsingh on 04/04/17.
 */

public class AskDetailsFragment extends Fragment {


    Spinner spinYear;
    Spinner spinBranches;
    Spinner spinStudents;
    ProgressDialog mDialog;
    Button btnSubmit;
    String year;
    public static final String TAG = "AskDetailsFragment";

    public AskDetailsFragment() {
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        mDialog = new ProgressDialog(getContext());
        mDialog.setMessage("Loading");
        View view = inflater.inflate(R.layout.ask_details_frag,container,false);
        final ArrayList<String> years = new ArrayList<>();
        years.add("Select year");
        final ArrayList<String> branches = new ArrayList<>();
        branches.add("Select Branch");
        final ArrayList<String> students = new ArrayList<>();
        students.add("Select Roll Number");
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference();
        mDialog.show();
        spinYear = (Spinner)view.findViewById(R.id.spinner_year);
        spinBranches = (Spinner)view.findViewById(R.id.spinner_branch);
        spinStudents = (Spinner)view.findViewById(R.id.spinner_roll_no);
        btnSubmit = (Button)view.findViewById(R.id.btn_submit);

        // getting years from database

        reference.child("year").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                Log.d(TAG,"check"+" "+dataSnapshot.exists());
                for(DataSnapshot child : children){

                   years.add(child.getKey());

                }
                setAdapter(spinYear,years);
                mDialog.dismiss();
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        final ArrayAdapter<String> adapter = setAdapter(spinBranches,branches);

        final  ArrayAdapter<String> adapter2 = setAdapter(spinStudents,students);

        // getting batches for each year

        spinYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year = String.valueOf(parent.getItemAtPosition(position));
                branches.clear();
                branches.add("Select Branch");
                adapter.notifyDataSetChanged();
                students.clear();
                students.add("Select Roll Number");
                adapter2.notifyDataSetChanged();
                btnSubmit.setVisibility(View.GONE);
                if (year != null) {
                    reference.child("year").child(spinYear.getSelectedItem().toString()).addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            branches.add(dataSnapshot.getKey());
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        // getting students of each group or branch

        spinBranches.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = String.valueOf(parent.getItemAtPosition(position));
                students.clear();
                students.add("Select Roll Number");
                adapter2.notifyDataSetChanged();
                btnSubmit.setVisibility(View.GONE);
                if(year!=null&&s!=null) {

                    reference.child("students").child(spinYear.getSelectedItem().toString()).child(spinBranches.getSelectedItem().toString()).addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            students.add(dataSnapshot.getKey());
                            adapter2.notifyDataSetChanged();
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinStudents.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String s = String.valueOf(parent.getItemAtPosition(position));

                if(!s.equals("Select Roll Number"))
                    btnSubmit.setVisibility(View.VISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final ArrayList<CharSequence> subjects = new ArrayList<>();


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDialog.show();

                reference.child("students").child(spinYear.getSelectedItem().toString()).child(spinBranches.getSelectedItem().toString())
                        .child(spinStudents.getSelectedItem().toString()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                      Iterable<DataSnapshot> iterable = dataSnapshot.getChildren();

                        long count = 0;

                        for(DataSnapshot child : iterable){
                            subjects.add(child.getKey());
                            count++;
                            if(count==dataSnapshot.getChildrenCount()){
                                Log.d(TAG,"ss"+dataSnapshot.getChildrenCount());
                                mDialog.dismiss();

                                // load attendance

                                final long [] total = new long[subjects.size()];
                                final long [] present = new long[subjects.size()];


                                for(final CharSequence s2 : subjects){

                                    //  Log.d(TAG,"sww"+subjects.indexOf(s2));
                                    reference.child("students").child(spinYear.getSelectedItem().toString()).child(spinBranches.getSelectedItem().toString())
                                            .child(spinStudents.getSelectedItem().toString()).child(s2.toString()).addChildEventListener(new ChildEventListener() {
                                        @Override
                                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                                            if(dataSnapshot.getKey().equals("Total")) {
                                                total[subjects.indexOf(s2)] = (long) dataSnapshot.getValue();
                                            }
                                            else if (dataSnapshot.getKey().equals("Present")) {
                                                present[subjects.indexOf(s2)] = (long) dataSnapshot.getValue();
                                            }

                                            if(subjects.indexOf(s2)==subjects.size()-1){
                                                Intent intent = new Intent(getContext(), StudentActivity.class);
                                                intent.putCharSequenceArrayListExtra("subjects",subjects);
                                                intent.putExtra("total",total);
                                                intent.putExtra("present",present);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                            }
                                        }

                                        @Override
                                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                                        }

                                        @Override
                                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                                        }

                                        @Override
                                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {

                                        }
                                    });

                                }






                            }
                        }



                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });







            }
        });

        return view;
    }


    public ArrayAdapter<String> setAdapter(Spinner spin , ArrayList<String> contents){

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,contents){

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {

                View v = null;

                if (position == 0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    v = tv;
                }
                else {

                    v = super.getDropDownView(position, null, parent);
                }

                parent.setVerticalScrollBarEnabled(false);
                return v;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.notifyDataSetChanged();
        spin.setAdapter(adapter);

        return adapter;

    }
}
