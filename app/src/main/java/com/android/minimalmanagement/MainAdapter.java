package com.android.minimalmanagement;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] numberFloor;
    private int[] floorImage;

    public MainAdapter(Context c, String[] numberFloor, int[] floorImage) {
        context = context;
        this.numberFloor = numberFloor;
        this.floorImage = floorImage;
    }

    @Override
    public int getCount() {
        return numberFloor.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
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
        TextView textView = convertView.findViewById(R.id.txt_num);

        imageView.setImageResource(floorImage[position]);
        textView.setText(numberFloor[position]);
        return convertView;
    }
}
