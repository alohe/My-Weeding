package com.example.user.myapplication;

import android.content.Intent;
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
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
Button login ;
EditText Username,Password;
   String URL_PRODUCTS = "http://192.168.137.1/Dailyenbla/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
Username = (EditText)findViewById(R.id.username);
Password = (EditText)findViewById(R.id.password);

        login = (Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.contains("true")){
                            Intent intent = new Intent();
                            startActivity(new Intent(getBaseContext(),Navigation_More.class));
                        }
                        else {
                            Toast.makeText(getBaseContext(), "Wrong Username and password", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getBaseContext(),error.toString(),Toast.LENGTH_LONG).show();

                    }
                }){
                    @Override
                    public Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<>();
                        params.put("username",Username.getText().toString());
                        params.put("password",Password.getText().toString());
                        return params;
                    }
                };
//Intent intent = new Intent(MainActivity.this,Navigation_More.class);
//startActivity(intent);
                Volley.newRequestQueue(MainActivity.this).add(stringRequest);
            }
        });
    }
}
