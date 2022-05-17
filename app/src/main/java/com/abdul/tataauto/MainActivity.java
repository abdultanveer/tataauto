package com.abdul.tataauto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//inflation

        nameEditText = findViewById(R.id.etName); //initialization

    }

    public void handleClick(View view) {
        Intent hIntent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(hIntent);

        String name = nameEditText.getText().toString();

        Toast.makeText(this, name + "----welcome to automotive", Toast.LENGTH_SHORT).show();
    }
}