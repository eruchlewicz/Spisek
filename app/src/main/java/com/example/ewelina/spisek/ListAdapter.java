package com.example.ewelina.spisek;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ewelina on 2017-10-09.
 */

public class ListAdapter extends ArrayAdapter<Song> {

    private Context context;
    private List<Song> data;

    public ListAdapter(Context context, int textViewResourceId, ArrayList<Song> data) {
        super(context,textViewResourceId,data);
        this.context = context;
        this.data = data;
    }

    static class ViewHolder
    {
        public TextView title;
        public TextView songbook;
        public TextView page;
        public TextView number;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView == null)
        {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.row_item, null);

            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.songbook = (TextView) convertView.findViewById(R.id.songbook);
            holder.page = (TextView) convertView.findViewById(R.id.page);
            holder.number = (TextView) convertView.findViewById(R.id.number);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Song individualSong= data.get(position);
        holder.title.setText(individualSong.getTitle());
        holder.songbook.setText(individualSong.getSongbook());
        if(individualSong.getPage().length()==0) holder.page.setText("-");
        else holder.page.setText(individualSong.getPage());
        if(individualSong.getNumber().length()==0) holder.number.setText("-");
        else holder.number.setText(individualSong.getNumber());

        return convertView;
    }
}
