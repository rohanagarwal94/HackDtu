package com.example.rohanagarwal94.hackdtu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rohanagarwal94 on 11/2/17.
 */
public class DiabetesActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8;

    Button b1;
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diabetes_layout);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);
        e6=(EditText)findViewById(R.id.editText6);
        e7=(EditText)findViewById(R.id.editText7);
        e8=(EditText)findViewById(R.id.editText8);

        b1=(Button)findViewById(R.id.data);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmotion();
            }
        });
    }

    void getEmotion(){
        requestQueue = Volley.newRequestQueue(DiabetesActivity.this);
        String url="https://codeslayers.herokuapp.com/detectDiabetes";
//        HashMap<String, String> params = new HashMap<String, String>();
//        params.put("text", "A suicide note or death note is a message left behind before a person has committed suicide, or who intends to commit suicide.  It is estimated that 25–30% of suicides are accompanied by a note. According to Gelder, Mayou and Geddes (2005) one in six leaves a suicide note. The content can be a plea for absolution or blaming family and friends for life's failings. However, incidence rates may depend on ethnicity, method of suicide, and cultural differences, and may reach rates as high as 50% in certain demographics.[1] A suicide message can be a written note, an audio message, or a video.");
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("1",e1.getText().toString());
            jsonObject.put("2",e1.getText().toString());
            jsonObject.put("3",e1.getText().toString());
            jsonObject.put("4",e1.getText().toString());
            jsonObject.put("5",e1.getText().toString());
            jsonObject.put("6",e1.getText().toString());
            jsonObject.put("7",e1.getText().toString());
            jsonObject.put("8",e1.getText().toString());


        }catch (JSONException e){
            //Toast.makeText(getApplicationContext(), "Json exception", Toast.LENGTH_SHORT).show();
        }
        JsonObjectRequest jor = new JsonObjectRequest(url, jsonObject,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if(response.getInt("ans") == 0)
                            Toast.makeText(DiabetesActivity.this, "No diabetes", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(DiabetesActivity.this, "You have diabetes", Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        System.out.println(response.toString());



                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"User already registered or Error in internet connection.",Toast.LENGTH_LONG).show();
                        Log.e("Volley",error.toString());
                    }
                }
        ){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
//                params.put("text", "A suicide note or death note is a message left behind before a person has committed suicide, or who intends to commit suicide.  It is estimated that 25–30% of suicides are accompanied by a note. According to Gelder, Mayou and Geddes (2005) one in six leaves a suicide note. The content can be a plea for absolution or blaming family and friends for life's failings. However, incidence rates may depend on ethnicity, method of suicide, and cultural differences, and may reach rates as high as 50% in certain demographics.[1] A suicide message can be a written note, an audio message, or a video.");
                //  params.put("","");
                return params;
            }


        };
        requestQueue.add(jor);

    }

}