package com.abdul.tataauto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//inflation

        nameEditText = findViewById(R.id.etName); //initialization

    }
    //indent

    public void handleClick(View viewClicked) {
        switch (viewClicked.getId()){
            case R.id.btnSubmit:
                startHome();
                break;
            case R.id.btnDial:
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                startActivity(dialIntent);
                break;
        }

    }

    private void startHome() {
        String name = nameEditText.getText().toString();
        //intent = box, this box has a partition called extras-- in that partition i'll keep the name
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
        hIntent.putExtra("labelkey", name);
        startActivityForResult(hIntent,123);
        //request code will identify what kind of data is being returned

        // Toast.makeText(this, name + "----welcome to automotive", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent receivedIntent) {
        super.onActivityResult(requestCode, resultCode, receivedIntent);
        if(requestCode == 123 && resultCode == RESULT_OK){
            Bundle extrasBox = receivedIntent.getExtras();
            String contactDetails = extrasBox.getString("conkey");
            TextView mainTextView = findViewById(R.id.tvMain);
            mainTextView.setText(contactDetails);

        }
    }
}