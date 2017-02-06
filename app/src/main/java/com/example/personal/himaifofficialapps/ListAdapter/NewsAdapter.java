package com.example.personal.himaifofficialapps.ListAdapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personal.himaifofficialapps.NewsDetail;
import com.example.personal.himaifofficialapps.R;
import com.example.personal.himaifofficialapps.model.NewsModel;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahmatridham on 8/14/2016.
 */
public class NewsAdapter extends BaseAdapter {
    Context context;
    List<NewsModel> newsModelList = new ArrayList<>();
    public NewsAdapter(Context context, List<NewsModel> newsModelList) {
        this.context = context;
        this.newsModelList = newsModelList;
    }

    @Override
    public int getCount() {
        return newsModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.news_listrow, parent, false);

        NewsModel newsModel = newsModelList.get(position);

        TextView title = (TextView) v.findViewById(R.id.textViewNamaItem);
        TextView desc = (TextView) v.findViewById(R.id.textViewDesc);
//        TextView continueRead = (TextView) v.findViewById(R.id.textViewContinue);
        final ImageView foto = (ImageView) v.findViewById(R.id.imageViewNewsFoto);

        title.setText(newsModel.getTitle());
        desc.setText(newsModel.getDesc());
        Picasso.with(context).load("http://192.168.43.29/himaifdb/" + newsModel.getUrlPhoto()).into(new Target() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                foto.setBackground(new BitmapDrawable(context.getResources(),bitmap));
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });

        return v;
    }


}
