package com.example.deliverypro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import static java.lang.Boolean.TRUE;

public class HomePage extends AppCompatActivity {
    ViewFlipper home_flipper;
    Button btn_menu,btn_pay,btn_loc,btn_user,btn_con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btn_menu=findViewById(R.id.menu_btn);
        btn_pay=findViewById(R.id.pay_btn);
        btn_loc=findViewById(R.id.loc_btn);
        btn_user=findViewById(R.id.user_btn);
        btn_con=findViewById(R.id.con_btn);

        int images[]={R.drawable.slider1,R.drawable.slider2,R.drawable.slider3};//auto slide view

        home_flipper=findViewById(R.id.home_flipper);

        //loop for images
        for(int image:images){
            flipperImages(image);
        }
    }
    public void flipperImages(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        home_flipper.addView(imageView);
        home_flipper.setFlipInterval(4000);//4seconds
        home_flipper.setAutoStart(TRUE);

        //Animation
        home_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        home_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_menu=new Intent(HomePage.this,MenuPage.class);
                startActivity(intent_menu);
            }
        });
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_pay=new Intent(HomePage.this,PaymentPage.class);
                startActivity(intent_pay);
            }
        });
        btn_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_loc=new Intent(HomePage.this,locationPage.class);
                startActivity(intent_loc);
            }
        });
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_user=new Intent(HomePage.this,UserPage.class);
                startActivity(intent_user);
            }
        });
        btn_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_con=new Intent(HomePage.this,ContactPage.class);
                startActivity(intent_con);
            }
        });
    }
}
