package com.zijin.wifi_teacher.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zijin.wifi_teacher.R;
import com.zijin.wifi_teacher.activity.LoginActivity;

public class WelcomeActivity extends AppCompatActivity {

    private Button welcome_btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcome_btn_login = (Button) findViewById(R.id.welcome_btn_login);
        welcome_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
