package nisaefendioglu.snapchat;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import nisaefendioglu.snapchat.adapters.MainPagerAdapter;
import nisaefendioglu.snapchat.fragments.Camera;

public class MainActivity extends AppCompatActivity {

    ImageView CaptureBtn;
    public static Size size;

    public MainActivity() {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Takesize();

        final View bg = findViewById(R.id.ma_bg_view);
        final ViewPager viewPager = findViewById(R.id.ma_view_pager);


        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainPagerAdapter);
        viewPager.setCurrentItem(1);

;
        CaptureBtn = findViewById(R.id.capture_photo_btn);

        final int light_blue = ContextCompat.getColor(this, R.color.light_blue);
        final int light_purple = ContextCompat.getColor(this, R.color.light_purple);


        CaptureBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem() != 1) {
                    viewPager.setCurrentItem(1, true);
                } else {
                    Camera fragment = (Camera) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.ma_view_pager + ":" + viewPager.getCurrentItem());
                    fragment.TakePhoto();
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                 if (i == 0) {
                    try {
                        Camera fragment = (Camera) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.ma_view_pager + ":" + viewPager.getCurrentItem());
                        fragment.textureView.setAlpha((float) Math.pow(v, 4));
                    } catch (Exception e) {

                    }
                    bg.setBackgroundColor(light_blue);
                    bg.setAlpha(1 - v);
                } else if (i == 1) {
                    try {
                        Camera fragment = (Camera) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.ma_view_pager + ":" + viewPager.getCurrentItem());
                        fragment.textureView.setAlpha(1 - (float) Math.pow(v, 0.25));
                    } catch (Exception e) {

                    }
                    bg.setAlpha(v);
                    bg.setBackgroundColor(light_purple);

                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void Takesize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int DSI_height = displayMetrics.heightPixels;
        int DSI_width = displayMetrics.widthPixels;
        size = new Size(DSI_width, DSI_height);

    }

}
