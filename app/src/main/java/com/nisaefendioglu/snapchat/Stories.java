package com.nisaefendioglu.snapchat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Stories extends Fragment {
    View view;
    ListView storyListView;
    final ArrayList<StoriesList> storiesLists = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.stories, container, false);


        storyListView = view.findViewById(R.id.storyListView);
        storiesLists.add(new StoriesList("Nisa","08:45",R.drawable.avatarstory));
        storiesLists.add(new StoriesList("Mehmet","02:58",R.drawable.avatarstory2));
        storiesLists.add(new StoriesList("Halise","05:40",R.drawable.avatarstory3));

        StoriesAdapter storiesAdapter = new StoriesAdapter(getActivity(), storiesLists);
        if (storyListView != null) {
            storyListView.setAdapter(storiesAdapter);
        }

        return view;


    }
}
