package com.wwk.sharedelementtransition.data;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wwk.sharedelementtransition.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wwk on 8/7/17.
 */

public class MyListAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<DataItem> dataItems;

    public MyListAdapter(Activity activity, ArrayList<DataItem> dataItems) {
        this.activity = activity;
        this.dataItems = dataItems;
    }

    @Override
    public int getCount() {
        return dataItems.size();
    }

    @Override
    public Object getItem(int position) {
        return dataItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dataItems.get(position).getId();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent, R.layout.list_item);
    }

    static class ViewHolder {
        TextView textTitle;
        TextView textDescription;
    }

    private View createViewFromResource(int position, View convertView, ViewGroup parent, int resource) {
        View view;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(resource, parent, false);
            ViewHolder holder = new ViewHolder();
            holder.textTitle = (TextView) view.findViewById(R.id.title);
            holder.textDescription = (TextView) view.findViewById(R.id.description);
            view.setTag(holder);
        } else {
            view = convertView;
        }

        bindView(view, dataItems.get(position));
        return view;
    }

    public void bindView(View view, DataItem item) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.textTitle.setText(item.getTitle());
        holder.textDescription.setText(item.getDescription());
    }

}
