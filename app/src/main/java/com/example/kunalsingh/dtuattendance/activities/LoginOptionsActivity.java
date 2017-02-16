package com.example.kunalsingh.dtuattendance.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.kunalsingh.dtuattendance.R;

/**
 * Created by mayank on 16/2/17.
 */

public class LoginOptionsActivity extends Activity {

    Button studentLogin;
    Button teacherLogin;
    Button adminLogin;
    Button parentLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options);

        studentLogin = (Button) findViewById(R.id.btnStudent);
        teacherLogin = (Button) findViewById(R.id.btnTeacher);
        adminLogin = (Button) findViewById(R.id.btnAdmin);
        parentLogin = (Button) findViewById(R.id.btnParent);


        studentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginOptionsActivity.this, LoginActivity.class);
                i.putExtra("loginType", "student");
                startActivity(i);
            }
        });

        teacherLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginOptionsActivity.this, LoginActivity.class);
                i.putExtra("loginType", "teacher");
                startActivity(i);
            }
        });

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginOptionsActivity.this, LoginActivity.class);
                i.putExtra("loginType", "admin");
                startActivity(i);
            }
        });

        parentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginOptionsActivity.this, LoginActivity.class);
                i.putExtra("loginType", "parent");
                startActivity(i);
            }
        });
    }
}
