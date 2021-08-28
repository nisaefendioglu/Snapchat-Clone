package nisaefendioglu.snapchat.Utils;

import android.graphics.Bitmap;

import com.zomato.photofilters.imageprocessors.Filter;

public class FilteredImageItem {
    public Bitmap image;
    public Filter filter;
    public String Name;

    public FilteredImageItem() {
    }

    public FilteredImageItem(Bitmap image, Filter filter,String Name) {
        this.image = image;
        this.filter = filter;
        this.Name = Name;
    }



}
