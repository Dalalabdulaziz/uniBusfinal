package com.example.dlalalwafy.unibus;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class studentyanbu extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    TextView Name;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentyanbu);

        listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        new connection().execute();

    }

    class connection extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {

            String result = "";
            String host = "http://192.168.64.2/Admin/contactinfo.php";
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(host));
                HttpResponse response = client.execute(request);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer stringBuffer = new StringBuffer("");
                String line = "";
                while ((line = reader.readLine()) != null) {
                    stringBuffer.append(line);
                    // break;
                }
                reader.close();
                result = stringBuffer.toString();

            } catch (Exception e) {


                return new String("There excrption : " + e.getMessage());

            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {

            try {

                JSONObject jsonResult = new JSONObject(result);
                int success = jsonResult.getInt("success");
                if (success == 1) {
                    JSONArray Students = jsonResult.getJSONArray("Students");
                    for (int i = 0; i < Students.length(); i++) {
                        JSONObject Student = Students.getJSONObject(i);
                        int ID = Student.getInt("ID");
                        String name = Student.getString("name");
                        int phone = Student.getInt("phone");
                        String line =   ID + "                   " +name + "                   " + phone + "          ";
                        adapter.add(line);


                    }


                } else {
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }


            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
    }
}


