package com.abdul.tataauto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * this is the second activity
 */
public class HomeActivity extends AppCompatActivity
        implements View.OnFocusChangeListener, View.OnClickListener,
        AdapterView.OnItemSelectedListener {
    Spinner cSpinner;
    EditText contactEditText;
    Button contactButton; //declaration on stack memory -- table of content
    public static String TAG = HomeActivity.class.getSimpleName();
            //"HomeActivity"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.i(TAG,"onCreate");   //i = info
        cSpinner = findViewById(R.id.countriesSspinner);
        contactEditText = findViewById(R.id.etContact);
        contactButton = findViewById(R.id.btnContact); //initialization --- heap mem
        cSpinner.setOnItemSelectedListener(this); //this means object of homeActivity
        contactButton.setOnClickListener(this); //it means when the button is clicked plz call the onclick of this class[homeActivity]
        contactEditText.setOnFocusChangeListener(this);

        //getDataMainActivity();
    }

    private void getDataMainActivity() {
        Intent receivedIntentMA = getIntent();
        Bundle extrasBox = receivedIntentMA.getExtras();
        String mName = extrasBox.getString("labelkey");
        TextView homeTextView = findViewById(R.id.tvHome); //getting handle - hold of tvHome
        homeTextView.setText(mName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onstart");  //debug
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onresume"); //e=error
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG,"onpause"); //w=warnings
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onstop");  //v=verbose
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
        Log.i(TAG,"clickHandler");   //i = info

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

    @Override
    public void onFocusChange(View view, boolean isFocussed) {
        if(isFocussed){
            Toast.makeText(this, "received focus", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "lost focus", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
    }

    public void fabClickHandler(View view) {
        Toast.makeText(this, "fab was clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String cName = (String) adapterView.getItemAtPosition(position);
        Toast.makeText(this, cName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}