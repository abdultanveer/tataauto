package com.abdul.tataauto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.abdul.tataauto.model.ProgressItem;
import com.abdul.tataauto.views.CustomProgressBar;
import com.abdul.tataauto.views.ProgressDrawable;

import java.util.ArrayList;

public class DemoActivity extends AppCompatActivity {
public static String TAG = DemoActivity.class.getSimpleName();


    private CustomProgressBar seekbar;
    private ArrayList<ProgressItem> progressItemList;
    private ProgressItem mProgressItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        seekbar = ((CustomProgressBar) findViewById(R.id.seekBar0));
        seekbar.getThumb().mutate().setAlpha(0);
        initDataToSeekbar();
    }

    private void initDataToSeekbar() {
        progressItemList = new ArrayList<ProgressItem>();
        // red span
        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = 20;
        Log.i("Mainactivity", mProgressItem.progressItemPercentage + "");
        mProgressItem.color = R.color.teal_200;
        progressItemList.add(mProgressItem);
        // blue span
        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = 25;
        mProgressItem.color = R.color.black;
        progressItemList.add(mProgressItem);
        // green span
        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = 35;
        mProgressItem.color = R.color.purple_200;
        progressItemList.add(mProgressItem);

        //white span
        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = 20;
        mProgressItem.color =  R.color.white;
        progressItemList.add(mProgressItem);


        seekbar.initData(progressItemList);
        seekbar.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}



   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        ConstraintLayout cl = findViewById(R.id.constraintLayout);
       *//* LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);*//*

        final ProgressBar pb = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        Drawable d = new ProgressDrawable(0xdd00ff00, 0x4400ff00);
        pb.setProgressDrawable(d);
        pb.setPadding(20, 20, 20, 0);
        cl.addView(pb);

        SeekBar.OnSeekBarChangeListener l = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int newProgress = pb.getMax() * progress / seekBar.getMax();
                Log.d(TAG, "onProgressChanged " + newProgress);
                pb.setProgress(newProgress);
            }
        };

        int[] maxs = {4, 10, 60, 110};
        for (int i = 0; i < maxs.length; i++) {
            SeekBar sb = new SeekBar(this);
            sb.setMax(maxs[i]);
            sb.setOnSeekBarChangeListener(l);
            sb.setPadding(20, 20, 20, 0);
            cl.addView(sb);
        }

        //setContentView(ll);
    }*/
