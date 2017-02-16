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

public class LoginActivity extends Activity{

    Button loginButton;
    String loginType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.btnLogin);

        loginType = getIntent().getStringExtra("loginType");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginType.equals("student")){
                    Intent i = new Intent(LoginActivity.this, StudentActivity.class);
                    startActivity(i);
                }
                else if (loginType.equals("parent")){
                    Intent i = new Intent(LoginActivity.this, ParentActivity.class);
                    startActivity(i);
                }
                else if (loginType.equals("admin")){
                    Intent i = new Intent(LoginActivity.this, AdminActivity.class);
                    startActivity(i);
                }
                else if (loginType.equals("teacher")){
                    Intent i = new Intent(LoginActivity.this, TeacherActivity.class);
                    startActivity(i);
                }
            }
        });


    }


}
