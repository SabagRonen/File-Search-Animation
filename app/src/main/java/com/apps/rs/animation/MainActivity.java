package com.apps.rs.animation;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void clockwise(View view){
        animate(R.id.imageView1, R.anim.myanimation);
    }

    public void zoom(View view){
        animate(R.id.imageView1, R.anim.clockwise);
    }

    private void animate(int imageView1, int clockwise) {
        ImageView image = (ImageView) findViewById(imageView1);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), clockwise);
        image.startAnimation(animation1);
    }

    public void fade(View view){
        animate(R.id.imageView1, R.anim.fade);
    }

    public void blink(View view){
        animate(R.id.imageView1, R.anim.blink);
    }

    public void move(View view){
        move();

    }

    private void move() {
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

        animate(R.id.bigFile, R.anim.clockwise);
    }

    public void slide(View view){
        animate(R.id.imageView1, R.anim.slide);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (R.id.drawer_move == item.getItemId()) {
            move();
        } else {
            int animationId;
            switch (item.getItemId()) {
                case R.id.drawer_zoom:
                    animationId = R.anim.myanimation;
                    break;
                case R.id.drawer_clockwise:
                    animationId = R.anim.clockwise;
                    break;
                case R.id.drawer_fade:
                    animationId = R.anim.fade;
                    break;
                case R.id.drawer_blink:
                    animationId = R.anim.blink;
                    break;
                case R.id.drawer_slide:
                    animationId = R.anim.slide;
                    break;
                default:
                    animationId = R.anim.myanimation;
                    break;
            }
            animate(R.id.imageView1, animationId);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
