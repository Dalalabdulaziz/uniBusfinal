package com.example.dlalalwafy.unibus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class yanbupage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yanbupage);
    }

    public void buDriver(View view) {
        Intent myitent=new Intent(this,driverAd.class);
        startActivity(myitent);
    }

    public void bustudentsY(View view) {
        Intent myitent=new Intent(this,studentyanbu.class);
        startActivity(myitent);
    }

    public void buaddStude(View view) {
        Intent myitent=new Intent(this,addNewStudentY.class);
        startActivity(myitent);

    }
}

