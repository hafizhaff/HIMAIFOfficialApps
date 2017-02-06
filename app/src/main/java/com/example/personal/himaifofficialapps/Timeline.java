package com.example.personal.himaifofficialapps;


import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.personal.himaifofficialapps.ListAdapter.TimelineAdapter;
import com.example.personal.himaifofficialapps.model.NewsModel;
import com.example.personal.himaifofficialapps.model.TimelineModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Timeline extends Fragment {

    CalendarView calendarView;
    TextView judul,event;
    ArrayList<TimelineModel> timelineModelArrayList,list;
    ListView timeline;
    TimelineAdapter adapter;

    public Timeline() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_timeline, container, false);

        calendarView = (CalendarView) v.findViewById(R.id.calendarView);
        timeline = (ListView) v.findViewById(R.id.listViewTimeline);
        timelineModelArrayList = new ArrayList<>();

//        calendarView.setDateTextAppearance(R.);

        judul = (TextView) v.findViewById(R.id.textTimeline);
        event = (TextView) v.findViewById(R.id.textViewEvent);

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/remachinescript.ttf");
        judul.setTypeface(tf);
        event.setTypeface(tf);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
//                dateDisplay.setText("Date: " + i2 + " / " + i1 + " / " + i);
                list = new ArrayList<>();

//                Toast.makeText(Timeline.this.getContext(), "Selected Date:\n" + "Day = " + day + "\n" + "Month = " + month + "\n" + "Year = " + year, Toast.LENGTH_LONG).show();
                for (TimelineModel model : timelineModelArrayList) {
                    if(model.getDate().equals(day+"/"+(month+1)+"/"+year)){
                        list.add(model);
                    }
                }
                adapter = new TimelineAdapter(Timeline.this.getContext(),list);
                timeline.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        timeline.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TimelineModel model = list.get(position);
                Toast.makeText(Timeline.this.getContext(), model.getDesc(), Toast.LENGTH_SHORT).show();
            }
        });

        getAllTimeline("getAllTimeline.php");

        return v;
    }

    private void getAllTimeline(String url) {
//        final ProgressDialog loading = ProgressDialog.show(this.getContext(), "Fetching Data", "Please wait...", false, false);

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.29/himaifdb/" + url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
//                            newsArrayList = new ArrayList<>();


                            JSONObject result = new JSONObject(response);
                            JSONArray jsonArray = result.getJSONArray("result");
                            TimelineModel timelineModel;

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                timelineModel = new TimelineModel(object.optString("date"), object.optString("title"), object.optString("desc"), object.optString("division"));
                                timelineModelArrayList.add(timelineModel);
                            }
//                            loading.dismiss();


                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(Timeline.this.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                            loading.dismiss();

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        error.printStackTrace();
                        Toast.makeText(Timeline.this.getContext(), "erroring: " + error.getMessage(), Toast.LENGTH_SHORT).show();
//                        loading.dismiss();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                try {
                    //Adding parameters to request

                    //returning parameter
                    return params;
                } catch (Exception e) {
                    Toast.makeText(Timeline.this.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    return params;
                }
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        requestQueue.add(stringRequest);
    }

}
