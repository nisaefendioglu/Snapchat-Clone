package nisaefendioglu.snapchat.adapters;


import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import nisaefendioglu.snapchat.fragments.Camera;
import nisaefendioglu.snapchat.fragments.Chat;
import nisaefendioglu.snapchat.fragments.Stories;

public class MainPagerAdapter extends FragmentPagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return Chat.create();
            case 1:
                return Camera.create();
            case 2:
                return Stories.create();

        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Chat";
            case 1:
                return "Kamera";
            case 2:
                return "Hikaye";
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
