package com.abdul.tataauto;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
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

        Student abdul; //declaration
        abdul = new Student(); //initialization

    }
    //indent

    public void handleClick(View viewClicked) {
        switch (viewClicked.getId()){
            case R.id.btnSubmit:
                startHome();
                break;
            case R.id.btnDial:
                startDialer();
                break;
            case R.id.btnAlarm:
                createAlarm("tata",12,21); //arguments
                break;
        }

    }

    //    public void createAlarm(String message, int hour, int minutes) -- method signature
    public void createAlarm(String message, int hour, int minutes) { //params
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void startDialer() {
        int a = 10;
        int b = 20;
       int d = add(a,b);
        int c = a+b;
        throw new NullPointerException("from startdialer");
        /*Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9880979732"));  //implicit intent
        startActivity(dialIntent);*/
    }

    /**
     * this method adds 2 nos
     * @param a first num
     * @param b second num
     * @return
     */
    private int add(int a, int b) {
        int f = 45;
        return a+b;
    }


    /**
     * this will start the home activity
     */
    private void startHome() {
        String name = nameEditText.getText().toString();
        //intent = box, this box has a partition called extras-- in that partition i'll keep the name
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class); //explicit intent
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