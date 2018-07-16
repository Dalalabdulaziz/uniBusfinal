package com.example.dlalalwafy.unibus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;



public class HomeActivity extends AppCompatActivity {



    private EditText Name;
    private EditText password;
    private Button Login;
    private int counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Name = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPass);
        Login = (Button) findViewById(R.id.bLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), password.getText().toString());

            }
        });

    }

    private void validate(String userName, String userPassword) {
        if( (userName.equals("Admin") ) && (userPassword.equals("123456"))) {

            Intent myitent = new Intent(HomeActivity.this, AdminCity.class);
            startActivity(myitent);
        }
        else if( (userName.equals("Driver") ) && (userPassword.equals("123456"))) {

            Intent myitent = new Intent(HomeActivity.this, Driverpage.class);
            startActivity(myitent);
        }
        else{
            counter--;
            if(counter==0){
                Login.setEnabled(false);
            }
        }




    }

}
