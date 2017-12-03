package com.example.kelseybedard.roadtripbingo;

import android.content.Context;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.kelseybedard.roadtripbingo.R;

import java.util.List;

/**
 * Created by kelseybedard on 12/1/17.
 */

public class ImageAdaptor extends BaseAdapter {
    private Context mContext;
    // Keep all Images in array
    public int[] mThumbIds = new int[25];

    // Constructor
    public ImageAdaptor(Context c) {
        mContext = c;
    }
    public ImageAdaptor(Context c, int[] images){
        mContext = c;
        mThumbIds = images;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public void changeImages (int[] images){
        mThumbIds = images;
        notifyDataSetChanged();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);

        return imageView;
    }



}
