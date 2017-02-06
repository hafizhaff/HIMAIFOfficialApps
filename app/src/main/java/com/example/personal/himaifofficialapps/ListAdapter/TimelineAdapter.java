package com.example.personal.himaifofficialapps.ListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.personal.himaifofficialapps.R;
import com.example.personal.himaifofficialapps.model.TimelineModel;

import java.util.ArrayList;

/**
 * Created by rahmatridham on 8/19/2016.
 */
public class TimelineAdapter extends BaseAdapter {
    Context context;
    ArrayList<TimelineModel> timelineModelArrayList;


    public TimelineAdapter(Context context, ArrayList<TimelineModel> timelineModelArrayList) {
        this.context = context;
        this.timelineModelArrayList = timelineModelArrayList;
    }

    @Override
    public int getCount() {
        return timelineModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return timelineModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.timeline_listrow, parent, false);

        TimelineModel model = timelineModelArrayList.get(position);

        TextView judul = (TextView) v.findViewById(R.id.timelineJudul);
//        TextView desc = (TextView) v.findViewById(R.id.timelineDesx);
        TextView divisi = (TextView) v.findViewById(R.id.timelineDiv);

        judul.setText(model.getEventTitle());
//        desc.setText(model.getDesc());
        divisi.setText("by "+model.getDivision());

        return v;
    }
}
