package nisaefendioglu.snapchat.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;

import nisaefendioglu.snapchat.R;


public class SnapBarView extends FrameLayout implements ViewPager.OnPageChangeListener {
    private ImageView mProfileBtn, mAddFriendsBtn,mRotateCamera;

    private TextView mTitle, mLine;


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

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_snap_bar,this,true);
        mProfileBtn = findViewById(R.id.bar_profile_btn);
        mAddFriendsBtn = findViewById(R.id.bar_add_friend_btn);
        mRotateCamera = findViewById(R.id.bar_rotate_camera_btn);


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("SetTextI18n")
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