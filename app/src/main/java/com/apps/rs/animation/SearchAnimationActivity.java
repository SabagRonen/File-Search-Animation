package com.apps.rs.animation;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SearchAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_animation_activity);

        setBigFileFrameClip();
    }

    @Override
    protected void onResume() {
        super.onResume();

        move();
    }

    private void setBigFileFrameClip() {
        /***************************************************************************************
         * for pre lollipop we use custom frame layout (com.apps.rs.views.CircleViewFrameLayout)
         * to add the circle clip so the clipping done inside CircleViewFrameLayout, for lollipop
         * and above we use ViewOutlineProvider
         ***************************************************************************************/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View view = findViewById(R.id.bigFileFrame);
            if (null == view) {
                return;
            }
            view.setOutlineProvider(new ViewOutlineProvider() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            });
            view.setClipToOutline(true);
        }

    }

    private void move() {
        animate(R.id.smallFile0, R.anim.small_file_move, false);
        animate(R.id.smallFile1, R.anim.small_file_move, false);
        animate(R.id.smallFile2, R.anim.small_file_move, false);
        animate(R.id.smallFile3, R.anim.small_file_move, false);
        animate(R.id.smallFile4, R.anim.small_file_move, false);
        animate(R.id.smallFile5, R.anim.small_file_move, false);
        animate(R.id.smallFile6, R.anim.small_file_move, true);
        animate(R.id.smallFile7, R.anim.small_file_move, true);

        animate(R.id.bigFile1, R.anim.big_file_move, false);
        animate(R.id.bigFile2, R.anim.big_file_second_move, false);
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
