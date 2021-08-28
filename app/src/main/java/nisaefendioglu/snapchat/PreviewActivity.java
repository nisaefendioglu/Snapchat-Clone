package nisaefendioglu.snapchat;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.zomato.photofilters.imageprocessors.Filter;

import java.util.ArrayList;

import nisaefendioglu.snapchat.fragments.Camera;
import nisaefendioglu.snapchat.utils.FilteredImageItem;


public class PreviewActivity extends AppCompatActivity {

    int COUNT = 0;


    static {
        System.loadLibrary("NativeImageProcessor");
    }

    ArrayList<FilteredImageItem> Deneme = new ArrayList<FilteredImageItem>();
    ArrayList<Bitmap> FilteredImageList = new ArrayList<Bitmap>();
    public  static  ArrayList<String> Names = new ArrayList<String>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        final ViewPager viewPager = findViewById(R.id.vpPager);

        final ImageView mPhotoEditorView = findViewById(R.id.imageView);
        mPhotoEditorView.setImageBitmap(Camera.bitmap);
        SetFilters();

    }

    private void SetFilters() {
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < Deneme.size(); i++) {
                    FilteredImageItem item = Deneme.get(i);
                    Bitmap bitmap = item.image;
                    Filter filter = item.filter;
                    Bitmap Lost;
                    if (i == 0) {
                        FilteredImageList.add(bitmap);
                    } else {
                        FilteredImageList.add(filter.processFilter(Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false)));
                    }
                    Names.add(item.Name);
                }
            }

        };
        new Thread(r).start();

    }


    public void DownloadIamge() {
        Toast.makeText(this, "İndirme", Toast.LENGTH_SHORT).show();
    }

    public void Closeamge() {
        onBackPressed();
        Toast.makeText(this, "İptal", Toast.LENGTH_SHORT).show();
    }

    public void SendImage() {
        Toast.makeText(this, "Göderme", Toast.LENGTH_SHORT).show();
    }


}

