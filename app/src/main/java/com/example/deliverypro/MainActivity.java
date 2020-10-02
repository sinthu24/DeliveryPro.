package com.example.deliverypro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_log;
    Button btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_log = findViewById(R.id.login_btn);
        btn_reg = findViewById(R.id.reg_btn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_log=new Intent(MainActivity.this,HomePage.class);
                        startActivity(intent_log);
            }
        });
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_reg=new Intent(MainActivity.this,RegisterPage.class);
                startActivity(intent_reg);
            }
        });
    }

}

