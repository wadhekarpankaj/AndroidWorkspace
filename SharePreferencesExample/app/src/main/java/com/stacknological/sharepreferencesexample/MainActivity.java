package com.stacknological.sharepreferencesexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferenceConfig preferenceConfig;
    private EditText UserName,UserPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferenceConfig=new SharedPreferenceConfig(getApplicationContext());

        UserName=findViewById(R.id.user_name);
        UserPass=findViewById(R.id.user_password);

        if(preferenceConfig.readLoginStatus()){
            startActivity(new Intent(this,SuccessActivity.class));
            finish();
        }
    }

    public void loginUser(View view) {

        String username=UserName.getText().toString();
        String user_pass=UserPass.getText().toString();

        if(username.equals(getResources().getString(R.string.user_name)) && user_pass.equals(getResources().getString(R.string.user_password))){

            startActivity(new Intent(this,SuccessActivity.class));
            preferenceConfig.writeLoginStatus(true);
            finish();
        }
        else{
            Toast.makeText(this,"Login failed, try again",Toast.LENGTH_LONG).show();
            UserName.setText("");
            UserPass.setText("");
        }

    }
}
