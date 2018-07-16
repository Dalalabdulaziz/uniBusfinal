package com.example.dlalalwafy.unibus;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class addNewStudentY extends AppCompatActivity {
    Button button;
    EditText Name,Phone,id,Village;
    String server_url="http://192.168.64.2/Admin/INSERT.php";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student_y);
        button=(Button)findViewById(R.id.bn);
        Name=(EditText) findViewById(R.id.name);
        Phone=(EditText) findViewById(R.id.phone);
        id=(EditText) findViewById(R.id.id);
        Village=(EditText) findViewById(R.id.village);
        builder=new AlertDialog.Builder(addNewStudentY.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  String name,phone,ID,village;
                name=Name.getText().toString();
                phone=Phone.getText().toString();
                ID=id.getText().toString();
                village=Village.getText().toString();
                StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                builder.setTitle("Server Response");
                                builder.setMessage("Response:"+response);
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Name.setText("");
                                        Phone.setText("");
                                        id.setText("");
                                        Village.setText("");
                                    }
                                });
                                AlertDialog alertDialog=builder.create();
                                alertDialog.show();;

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(addNewStudentY.this,"Error...",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();

                    }
                }){
                    @Override
                    protected Map<String,String> getParams() throws AuthFailureError {
                        Map<String,String > params = new HashMap<String, String>();
                        params.put("name",name);
                        params.put("phone",phone);
                        params.put("ID",ID);
                        params.put("village",village);
                        return params;
                    }
                };

                MySingleton.getmInstance(addNewStudentY.this).addTopRequestque(stringRequest);

            }
        });

    }
}


