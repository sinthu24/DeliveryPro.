package com.example.deliverypro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterPage extends AppCompatActivity {
    Button btn_reg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        btn_reg1=findViewById(R.id.reg_1_btn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_reg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_reg1=new Intent(RegisterPage.this,HomePage.class);
                startActivity(intent_reg1);
            }
        });
    }
}