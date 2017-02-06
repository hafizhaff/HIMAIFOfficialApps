package com.example.personal.himaifofficialapps;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.personal.himaifofficialapps.model.AspirasiModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Aspirasi extends Fragment {

    EditText title, advice;
    Button submit;
    TextView aspiration;

    public Aspirasi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_aspirasi, container, false);
        title = (EditText) v.findViewById(R.id.input_subject);
        advice = (EditText) v.findViewById(R.id.input_desc);

        aspiration = (TextView) v.findViewById(R.id.aspirasijudul);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/remachinescript.ttf");
        aspiration.setTypeface(tf);

        submit = (Button) v.findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strTit = title.getText().toString();
                String strAdv = advice.getText().toString();

                putToDB("putAspirasi.php", strTit, strAdv);
                title.setText("");
                advice.setText("");
            }
        });

        return v;
    }

    private void putToDB(String url, final String title, final String adv) {

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.29/himaifdb/" + url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            if (response.equals("success")) {
                                Toast.makeText(Aspirasi.this.getContext(), "Saran telah diteruskan. Terimakasih.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Aspirasi.this.getContext(), "Saran gagal diteruskan", Toast.LENGTH_SHORT).show();
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(Aspirasi.this.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        error.printStackTrace();
                        Toast.makeText(Aspirasi.this.getContext(), "erroring: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                try {
                    //Adding parameters to request
                    params.put("title", title);
                    params.put("aspirasi", adv);
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    params.put("date", format.format(calendar.getTime()));


                    //returning parameter
                    return params;
                } catch (Exception e) {
                    Toast.makeText(Aspirasi.this.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    return params;
                }
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        requestQueue.add(stringRequest);
    }

}
