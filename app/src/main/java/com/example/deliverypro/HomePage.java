package com.example.deliverypro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import static java.lang.Boolean.TRUE;

public class HomePage extends AppCompatActivity {
    ViewFlipper home_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

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
}
