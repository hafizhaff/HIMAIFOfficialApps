package com.example.personal.himaifofficialapps;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import com.example.personal.himaifofficialapps.ListAdapter.NewsAdapter;
import com.example.personal.himaifofficialapps.model.NewsModel;

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
public class News extends Fragment implements AdapterView.OnItemClickListener,SwipeRefreshLayout.OnRefreshListener{
    ListView listView;
    NewsAdapter adapter;
    ArrayList<NewsModel> newsArrayList;
    private SwipeRefreshLayout swipeRefreshLayout;

    public News() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_news, container, false);
        newsArrayList = new ArrayList<>();
        listView = (ListView) v.findViewById(R.id.listViewNews);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);

        adapter = new NewsAdapter(News.this.getContext(), newsArrayList);

//        getAllNews("getAllNews.php");

        swipeRefreshLayout.setOnRefreshListener(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);
                                        newsArrayList.clear();

                                        getAllNews("getAllNews.php");

                                    }
                                }
        );
        return v;
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
                            NewsModel newsModel;

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                newsModel = new NewsModel(object.optString("urlfoto"), object.optString("title"), object.optString("desc"), object.optString("source"), object.optString("writer"));
                                newsArrayList.add(newsModel);
                            }

                            adapter.notifyDataSetChanged();
                            swipeRefreshLayout.setRefreshing(false);


                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(News.this.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        error.printStackTrace();
                        Toast.makeText(News.this.getContext(), "erroring: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setRefreshing(false);

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
                    Toast.makeText(News.this.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
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
        NewsModel newsModel = newsArrayList.get(position);
        Intent intent = new Intent(News.this.getContext(), NewsDetail.class);

        intent.putExtra("urlfoto",newsModel.getUrlPhoto());
        intent.putExtra("title",newsModel.getTitle());
        intent.putExtra("desc",newsModel.getDesc());
        intent.putExtra("source",newsModel.getSourceNews());
        intent.putExtra("writer",newsModel.getWriter());

        startActivity(intent);
    }

    @Override
    public void onRefresh() {
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.detach(this).attach(this).commit();
        newsArrayList.clear();
        getAllNews("getAllNews.php");

    }
}
