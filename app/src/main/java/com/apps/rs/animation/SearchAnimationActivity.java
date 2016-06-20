package com.apps.rs.animation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SearchAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onResume() {
        super.onResume();

        move();
    }

    private void move() {
        animate(R.id.smallFile0, R.anim.move_small, false);
        animate(R.id.smallFile1, R.anim.move_small, false);
        animate(R.id.smallFile2, R.anim.move_small, false);
        animate(R.id.smallFile3, R.anim.move_small, false);
        animate(R.id.smallFile4, R.anim.move_small, false);
        animate(R.id.smallFile5, R.anim.move_small, false);
        animate(R.id.smallFile6, R.anim.move_small, true);
        animate(R.id.smallFile7, R.anim.move_small, true);

        animate(R.id.bigFile1, R.anim.move, false);
        animate(R.id.bigFile2, R.anim.second_move, false);
    }

    private void animate(int imageViewResourceId, int animationResourceId, final boolean should) {
        final ImageView image = (ImageView) findViewById(imageViewResourceId);
        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), animationResourceId);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (should) {
                    Handler handler = new Handler(getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            move();
                        }
                    }, 1000);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(animation);
    }
}
