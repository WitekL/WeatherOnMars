package com.example.witol.volleytestin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView maxtemp;
    TextView terrestialDate;
    TextView sol;
    TextView mintemp;
    TextView pressure;
    TextView windSpeed;
    String url = "http://marsweather.ingenology.com/v1/latest/";
    JSONObject json = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        terrestialDate = (TextView) findViewById(R.id.terrdate);
        maxtemp = (TextView) findViewById(R.id.maxtemp);
        sol = (TextView) findViewById(R.id.sol);
        mintemp = (TextView) findViewById(R.id.mintemp);
        pressure = (TextView) findViewById(R.id.pressure);


        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               //String jsonResponse = response.toString();
                try{
                    json = response.getJSONObject("report");
                    maxtemp.setText("Max temperature: " + json.getDouble("max_temp"));
                    terrestialDate.setText("Terrestrial date: " +json.getString("terrestrial_date"));
                    sol.setText("Sol: " +json.getInt("sol"));
                    mintemp.setText("Minimal temperature: " + json.getDouble("min_temp"));
                    pressure.setText("Pressure: " + json.getDouble("pressure"));


                } catch(Exception e){
                    maxtemp.setText("Somtink ronk");
                }

                //show.setText("Max temperature: " + response.toString());
            }

            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){

        }

        });

        ConnectionHelper.getInstance(this).getRequestQueue().add(jsonRequest);





    }
}
