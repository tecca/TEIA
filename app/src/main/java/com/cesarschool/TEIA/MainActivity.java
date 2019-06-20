package com.cesarschool.TEIA;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = AuthenticationActivity.class.getSimpleName();

    public void signOut(View view) {
        AWSMobileClient.getInstance().signOut();
        Intent i = new Intent( MainActivity.this, AuthenticationActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {
            @Override
            public void onResult(UserStateDetails userStateDetails) {
                switch (userStateDetails.getUserState()){
                    case SIGNED_IN:
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Button button = (Button) findViewById(R.id.signOut);
                                TextView textView = (TextView) findViewById(R.id.text);
                                textView.setText("onResult: case SIGNED_IN");
                            }
                        });
                        break;
                    case SIGNED_OUT:
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView textView = (TextView) findViewById(R.id.text);
                                textView.setText("onResult: case SIGNED_OUT");
                            }
                        });
                        break;
                    default:
                        AWSMobileClient.getInstance().signOut();
                        break;
                }
            }


        @Override
            public void onError(Exception e) {
                Log.e(TAG, e.toString());
            }
        });

    }
}