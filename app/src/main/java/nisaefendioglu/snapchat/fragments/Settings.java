package nisaefendioglu.snapchat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import nisaefendioglu.snapchat.R;


public class Settings extends Fragment {

    View view;
    Button back;
    Fragment fragment = null;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.settings,container,false);
        back = view.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new Stories();
                FragmentManager fm = getFragmentManager();
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
            }
        });


        return view;
    }
}
