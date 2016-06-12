package com.apps.rs.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clockwise(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView1);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
        image.startAnimation(animation);
    }

    public void zoom(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView1);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        image.startAnimation(animation1);
    }

    public void fade(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView1);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        image.startAnimation(animation1);
    }

    public void blink(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView1);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation1);
    }

    public void move(View view){
        ImageView image1 = (ImageView)findViewById(R.id.imageView1);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image1.startAnimation(animation);

        ImageView image2 = (ImageView)findViewById(R.id.imageView2);
        image2.startAnimation(animation);

        ImageView image3 = (ImageView)findViewById(R.id.imageView3);
        image3.startAnimation(animation);

        ImageView image4 = (ImageView)findViewById(R.id.imageView4);
        image4.startAnimation(animation);

        ImageView image5 = (ImageView)findViewById(R.id.imageView5);
        image5.startAnimation(animation);

        ImageView image6 = (ImageView)findViewById(R.id.imageView6);
        image6.startAnimation(animation);

        ImageView bigFile = (ImageView) findViewById(R.id.bigFile);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        bigFile.startAnimation(animation1);

    }

    public void slide(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView1);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);
    }
}
