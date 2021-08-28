package nisaefendioglu.snapchat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

import nisaefendioglu.snapchat.R;
import nisaefendioglu.snapchat.adapters.StoriesAdapter;
import nisaefendioglu.snapchat.classes.StoriesList;

public class Stories  extends Fragment {
    View view;
    ListView storyListView;
    final ArrayList<StoriesList> storiesLists = new ArrayList<>();
    ImageView settings;
    Fragment fragment = null;

    public static Fragment create() {
        return new Stories();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.stories, container, false);
        settings = view.findViewById(R.id.settings);

        storyListView = view.findViewById(R.id.storyListView);
        storiesLists.add(new StoriesList("Nisa","08:45",R.drawable.avatarstory));
        storiesLists.add(new StoriesList("Mehmet","02:58",R.drawable.avatarstory2));
        storiesLists.add(new StoriesList("Halise","05:40",R.drawable.avatarstory3));

        StoriesAdapter storiesAdapter = new StoriesAdapter(getActivity(), storiesLists);
        if (storyListView != null) {
            storyListView.setAdapter(storiesAdapter);
        }


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new Settings();
                FragmentManager fm = getFragmentManager();
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
            }
        });

        return view;


    }
}
