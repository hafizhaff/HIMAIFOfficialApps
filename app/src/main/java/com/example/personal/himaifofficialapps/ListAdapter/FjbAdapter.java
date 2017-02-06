package com.example.personal.himaifofficialapps.ListAdapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.personal.himaifofficialapps.R;
import com.example.personal.himaifofficialapps.model.JualanModel;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by rahmatridham on 8/14/2016.
 */
public class FjbAdapter extends BaseAdapter {
    Context context;
    List<JualanModel> jualanModelList;

    public FjbAdapter(Context context, List<JualanModel> jualanModelList) {
        this.context = context;
        this.jualanModelList = jualanModelList;
    }

    @Override
    public int getCount() {
        return jualanModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return jualanModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.fjb_listrow, parent, false);

        JualanModel model = jualanModelList.get(position);

        TextView title = (TextView) v.findViewById(R.id.textViewNamaItem);
        TextView desc = (TextView) v.findViewById(R.id.textViewDesc);
        TextView price = (TextView) v.findViewById(R.id.textViewPrice);
        final ImageView foto = (ImageView) v.findViewById(R.id.imageViewNewsFoto);

        title.setText(model.getNamaItem());
        desc.setText(model.getDesc());

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);
        price.setText("IDR " + format.format(Double.valueOf(model.getPrice())).substring(1));

        Picasso.with(context).load("http://192.168.43.29/himaifdb/" + model.getUrlPhoto()).into(new Target() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                foto.setBackground(new BitmapDrawable(context.getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });


        return v;
    }
}
