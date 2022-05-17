package com.abdul.tataauto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
EditText contactEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        contactEditText = findViewById(R.id.etContact);

        Intent receivedIntentMA = getIntent();
        Bundle extrasBox = receivedIntentMA.getExtras();
        String mName = extrasBox.getString("labelkey");
        TextView homeTextView = findViewById(R.id.tvHome); //getting handle - hold of tvHome
        homeTextView.setText(mName);
    }

    /**
     * this method returns the contact details to the main activity
     * @param view
     */
    public void clickHandler(View view) {
        //get the contact data from edittext
        String contact = contactEditText.getText().toString();
        //put the data into the intent
        Intent contactIntent = new Intent();
        contactIntent.putExtra("conkey",contact);
        //set the result for main activity to receive
        setResult(RESULT_OK,contactIntent);
        //close this activity
        finish();
    }
}