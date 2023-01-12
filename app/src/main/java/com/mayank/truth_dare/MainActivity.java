package com.mayank.truth_dare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ImageView img;
    private Random random=new Random();
    private int NewDirection,lastDirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView);
        btn=findViewById(R.id.button);


    }








    public void Spin(View view) {
        NewDirection = random.nextInt();
        float pivoitx = img.getWidth()/2;
        float pivoity = img.getHeight()/2;
        Animation rotate = new RotateAnimation(lastDirection,NewDirection,pivoitx,pivoity);
        rotate.setDuration(3000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                btn.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btn.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
                                    });
        lastDirection = NewDirection;
        img.startAnimation(rotate);

    }
    }