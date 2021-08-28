package nisaefendioglu.snapchat.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import nisaefendioglu.snapchat.R;
import nisaefendioglu.snapchat.classes.StoriesList;

public class StoriesAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<StoriesList> storyArrayList;

    public StoriesAdapter(Activity activity, ArrayList<StoriesList> storyArrayList) {

        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.storyArrayList = storyArrayList;
    }

    @Override
    public int getCount() {
        return storyArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return storyArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mInflater.inflate(R.layout.storieslist, null);
        TextView mailName = convertView.findViewById(R.id.story_UserName);
        TextView mailContent = convertView.findViewById(R.id.story_time);
        ImageView imageView = convertView.findViewById(R.id.story_userImage);
        ImageButton imageButton = convertView.findViewById(R.id.settings);
        StoriesList mail = storyArrayList.get(position);
        mailName.setText(mail.getName());
        mailContent.setText(mail.getClock());
        imageView.setImageResource(mail.getImage());
        return convertView;
    }
}