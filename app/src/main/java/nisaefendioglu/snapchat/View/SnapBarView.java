package nisaefendioglu.snapchat.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import nisaefendioglu.snapchat.Fragment.Settings;
import nisaefendioglu.snapchat.MainActivity;
import nisaefendioglu.snapchat.R;

public class SnapBarView extends FrameLayout implements ViewPager.OnPageChangeListener {

    private ImageView settings;


    public SnapBarView(@NonNull Context context) {
        this(context, null);
    }

    public SnapBarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SnapBarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {//R.layout.view_snap_bar, this, true
        LayoutInflater.from(getContext()).inflate(R.layout.view_snap_bar,this,true);
        settings = findViewById(R.id.settings);


    }

    public void setViewPager(final ViewPager viewPager) {
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(this);

            final MainActivity activity = null;
            settings.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Settings fragment = (Settings) ((MainActivity)getContext()).getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.ma_view_pager + ":" + viewPager.getCurrentItem());

                }
            });

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}