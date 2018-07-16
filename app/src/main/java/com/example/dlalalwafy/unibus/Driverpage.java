package com.example.dlalalwafy.unibus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Driverpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverpage);
    }

    public void Students(View view) {

            Intent myitent=new Intent(this,SeeAllStudents.class);
            startActivity(myitent);
    }

    public void attance(View view) {
        Intent myitent=new Intent(this,AttandceStudents.class);
        startActivity(myitent);
    }
}
