package com.abdul.tataauto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent receivedIntentMA = getIntent();
        Bundle extrasBox = receivedIntentMA.getExtras();
        String mName = extrasBox.getString("labelkey");
        TextView homeTextView = findViewById(R.id.tvHome);
        homeTextView.setText(mName);
    }
}