package com.example.dlalalwafy.unibus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminCity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_city);
    }

    public void buYanbu(View view) {
        Intent myitent=new Intent(this,yanbupage.class);
        startActivity(myitent);
    }
}
