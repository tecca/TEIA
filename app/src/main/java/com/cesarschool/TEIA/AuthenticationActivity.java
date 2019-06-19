package com.cesarschool.TEIA;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.SignInUIOptions;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobileconnectors.cognitoauth.Auth;

public class AuthenticationActivity extends AppCompatActivity {

    private static final String TAG = AuthenticationActivity.class.getSimpleName();

//    Auth.Builder builder = new Auth.Builder()
//            .setAppClientId(getString(R.string.cognito_client_id));
//            .setAppCognitoWebDomain(getString(R.string.cognito_web_domain));
//            .setApplicationContext(getApplicationContext());
//            .setAuthHandler(new callback());
//            .setSignInRedirect(getString(R.string.app_redirect_signin));
//            .setSignOutRedirect(getString(R.string.app_redirect_signout));
//            .setScopes(userScopes);
//            auth = builder.build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {

            @Override
            public void onResult(UserStateDetails userStateDetails) {
                Log.i(TAG, userStateDetails.getUserState().toString());
                switch (userStateDetails.getUserState()){
                    case SIGNED_IN:
                        Intent i = new Intent(AuthenticationActivity.this, MainActivity.class);
                        startActivity(i);
                        break;
                    case SIGNED_OUT:
                        showSignIn();
                        break;
                    default:
                        AWSMobileClient.getInstance().signOut();
                        showSignIn();
                        break;
                }
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, e.toString());
            }
        });
    }

    private void showSignIn() {
        try {
            AWSMobileClient.getInstance().showSignIn(this,
                    SignInUIOptions.builder().nextActivity(MainActivity.class).build(),
                    new Callback<UserStateDetails>() {
                        @Override
                        public void onResult(UserStateDetails result) {
                            Log.d(TAG, "onResult: " + result.getUserState());
                            switch (result.getUserState()){
                                case SIGNED_IN:
                                    Log.i(TAG, "onResult: case SIGNED_IN");
                                    break;
                                case SIGNED_OUT:
                                    Log.i(TAG, "onResult: case SIGNED_OUT");
                                    break;
                                default:
                                    AWSMobileClient.getInstance().signOut();
                                    break;
                            }
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.e(TAG, "onError: ", e);
                        }
                    }
            );

        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

}
