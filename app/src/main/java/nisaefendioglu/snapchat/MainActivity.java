package nisaefendioglu.snapchat;

import android.os.Build;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import nisaefendioglu.snapchat.Adapter.MainPagerAdapter;
import nisaefendioglu.snapchat.Fragment.Camera;
import nisaefendioglu.snapchat.Fragment.Chat;
import nisaefendioglu.snapchat.Fragment.Stories;

public class MainActivity extends AppCompatActivity {

    ImageView CaptureBtn,chat_btn,story_btn,settings;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = findViewById(R.id.ma_view_pager);

        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainPagerAdapter);
        viewPager.setCurrentItem(1);
        CaptureBtn = findViewById(R.id.capture_photo_btn);
        chat_btn = findViewById(R.id.chat_btn);
        story_btn = findViewById(R.id.story_btn);
        settings = findViewById(R.id.settings);

        CaptureBtn.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() != 1) {
                viewPager.setCurrentItem(1, true);
            } else {
                Camera fragment = (Camera) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.ma_view_pager + ":" + viewPager.getCurrentItem());
                fragment.TakePhoto();
            }
        });


        chat_btn.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() != 0) {
                viewPager.setCurrentItem(0, true);
            }
        });

        story_btn.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() != 2) {
                viewPager.setCurrentItem(2, true);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() != 3) {
                    viewPager.setCurrentItem(3, true);
                }
            }
        });



    }

}
