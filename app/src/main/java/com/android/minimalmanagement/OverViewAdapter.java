package com.android.minimalmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.zip.Inflater;

public class OverViewAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    int[] imgRoom;

    public OverViewAdapter(Context context, int[] imgRoom) {
        this.context = context;
        this.imgRoom = imgRoom;
    }

    @Override
    public int getCount() {
        return imgRoom.length;
    }

    @Override
    public Object getItem(int position) {
        return imgRoom;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.img_item);

        imageView.setImageResource(imgRoom[position]);

        return convertView;
    }
}
