package com.abdul.tataauto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    EditText contactEditText;
    public static String TAG = HomeActivity.class.getSimpleName();
            //"HomeActivity"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.i(TAG,"onCreate");
        contactEditText = findViewById(R.id.etContact);

        Intent receivedIntentMA = getIntent();
        Bundle extrasBox = receivedIntentMA.getExtras();
        String mName = extrasBox.getString("labelkey");
        TextView homeTextView = findViewById(R.id.tvHome); //getting handle - hold of tvHome
        homeTextView.setText(mName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG,"onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onstop");
    }

    //purged
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG,"ondestroy");
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