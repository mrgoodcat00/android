package com.goodcat.vkclient.application.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.goodcat.vkclient.application.R;
import com.goodcat.vkclient.application.model.music.MusicModel;
import com.goodcat.vkclient.application.service.MusicService;

import java.util.List;

public class MusicAdapter extends ArrayAdapter<MusicModel>{

    private static String token;
    private List<MusicModel> mItems;
    private MusicService.MusicWorker musicBinder;
    private Intent musicIntent = new Intent(getContext(),MusicService.class);

    public MusicAdapter(Context context,List<MusicModel> objects, MusicService.MusicWorker musicBinder) {
        super(context, 0, objects);
        this.mItems    = objects;
        this.musicBinder = musicBinder;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewAudioItemsHolder holder;
        View currentView = null;
        if (convertView == null) {
            holder = new ViewAudioItemsHolder();
            currentView = View.inflate(getContext(),R.layout.music_list_item, null);
            holder.music_singer = (TextView) currentView.findViewById(R.id.music_singer);
            holder.music_song_title = (TextView) currentView.findViewById(R.id.music_song_title);
            holder.music_duration = (TextView) currentView.findViewById(R.id.music_duration);

            holder.music_play = (ImageButton) currentView.findViewById(R.id.music_play);
            holder.music_pause = (ImageButton) currentView.findViewById(R.id.music_pause);
            holder.music_stop = (ImageButton) currentView.findViewById(R.id.music_stop);

            currentView.setTag(holder);
        } else {
            currentView = convertView;
            holder = (ViewAudioItemsHolder) currentView.getTag();

        }

        final MusicModel musicItem = mItems.get(position);

        holder.music_singer.setText(musicItem.getArtist());
        holder.music_song_title.setText(musicItem.getTitle());
        long dur = musicItem.getDuration()/60;
        long durInMin = dur % 60;
        holder.music_duration.setText(dur+","+durInMin+" min");







        holder.music_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicBinder.playAudioTrack(musicItem.getUrl().substring(0,musicItem.getUrl().indexOf("?")),position+"");
            }
        });

        holder.music_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicBinder.stopAudioTrack(position+"");
            }
        });

        holder.music_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicBinder.pauseAudioTrack(position+"");
            }
        });








       
        return currentView;
    }



    public static class ViewAudioItemsHolder {
        TextView music_song_title;
        TextView music_singer;
        ImageButton music_play;
        ImageButton music_pause;
        ImageButton music_stop;
        TextView music_duration;
        TextView music_circled;
    }


}
