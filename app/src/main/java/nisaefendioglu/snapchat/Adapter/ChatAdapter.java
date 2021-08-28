package nisaefendioglu.snapchat.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import nisaefendioglu.snapchat.R;
import nisaefendioglu.snapchat.DataList.ChatList;

public class ChatAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<ChatList> mailArrayList;

    public ChatAdapter(Activity activity, ArrayList<ChatList> chatArrayList) {

        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mailArrayList = chatArrayList;
    }

    @Override
    public int getCount() {
        return mailArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mailArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mInflater.inflate(R.layout.chat, null);
        TextView mailName =  convertView.findViewById(R.id.mailName);
        TextView mailContent = convertView.findViewById(R.id.mailContent);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        ChatList chat = mailArrayList.get(position);
        mailName.setText(chat.getName());
        mailContent.setText(chat.getMessageStatus());
        imageView.setImageResource(chat.getImage());
        return convertView;
    }
}
