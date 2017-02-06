package com.example.personal.himaifofficialapps;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.personal.himaifofficialapps.ListAdapter.FjbAdapter;
import com.example.personal.himaifofficialapps.ListAdapter.NewsAdapter;
import com.example.personal.himaifofficialapps.model.JualanModel;
import com.example.personal.himaifofficialapps.model.NewsModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Forumjb extends Fragment implements SwipeRefreshLayout.OnRefreshListener,AdapterView.OnItemClickListener {
    ListView listView;
    FjbAdapter adapter;
    ArrayList<JualanModel> newsArrayList;
    private SwipeRefreshLayout swipeRefreshLayout;

    public Forumjb() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_news, container, false);
        newsArrayList = new ArrayList<>();
        listView = (ListView) v.findViewById(R.id.listViewNews);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);

        adapter = new FjbAdapter(Forumjb.this.getContext(), newsArrayList);
        getAllNews("getAllFJB.php");
        swipeRefreshLayout.setOnRefreshListener(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();
        return v;
    }

    @Override
    public void onRefresh() {
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.detach(this).attach(this).commit();
        newsArrayList.clear();
        getAllNews("getAllFJB.php");

    }

    private void getAllNews(String url) {

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.29/himaifdb/" + url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
//                            newsArrayList = new ArrayList<>();


                            JSONObject result = new JSONObject(response);
                            JSONArray jsonArray = result.getJSONArray("result");
                            JualanModel model;

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                model = new JualanModel(object.optString("urlfoto"), object.optString("nama_item"), object.optString("desc"), object.optString("price"));
                                newsArrayList.add(model);
                            }

                            adapter.notifyDataSetChanged();
                            swipeRefreshLayout.setRefreshing(false);


                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(Forumjb.this.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        error.printStackTrace();
                        Toast.makeText(Forumjb.this.getContext(), "erroring: " + error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Forumjb.this.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    return params;
                }
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        JualanModel newsModel = newsArrayList.get(position);

        Toast.makeText(Forumjb.this.getContext(), newsModel.getDesc(), Toast.LENGTH_SHORT).show();
    }


}
