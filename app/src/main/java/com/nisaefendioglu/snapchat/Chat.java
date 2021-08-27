package com.nisaefendioglu.snapchat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Chat extends Fragment {
    View view;
    ListView chatList;
    final ArrayList<ChatList> chatListArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.chatlist, container, false);

        chatList = view.findViewById(R.id.chatList);
        chatListArrayList.add(new ChatList("Nisa","Tap to chat!",R.drawable.avatar8));
        chatListArrayList.add(new ChatList("Mehmet","Tap to chat!",R.drawable.avatar9));
        chatListArrayList.add(new ChatList("Halise","Tap to chat!",R.drawable.avatar));
        chatListArrayList.add(new ChatList("Hülya","Tap to chat!",R.drawable.avatar3));
        chatListArrayList.add(new ChatList("Ahmet","Tap to chat!",R.drawable.avatar6));
        chatListArrayList.add(new ChatList("Çağla","Tap to chat!",R.drawable.avatar4));
        chatListArrayList.add(new ChatList("Pelin","Tap to chat!",R.drawable.avatar5));
        chatListArrayList.add(new ChatList("Murat","Tap to chat!",R.drawable.avatar2));
        chatListArrayList.add(new ChatList("Aslı","Tap to chat!",R.drawable.avatar));
        chatListArrayList.add(new ChatList("Nisa","Tap to chat!",R.drawable.avatar8));
        chatListArrayList.add(new ChatList("Mehmet","Tap to chat!",R.drawable.avatar9));
        chatListArrayList.add(new ChatList("Halise","Tap to chat!",R.drawable.avatar));
        chatListArrayList.add(new ChatList("Hülya","Tap to chat!",R.drawable.avatar3));
        chatListArrayList.add(new ChatList("Ahmet","Tap to chat!",R.drawable.avatar6));
        chatListArrayList.add(new ChatList("Çağla","Tap to chat!",R.drawable.avatar4));
        chatListArrayList.add(new ChatList("Pelin","Tap to chat!",R.drawable.avatar5));
        chatListArrayList.add(new ChatList("Murat","Tap to chat!",R.drawable.avatar2));
        chatListArrayList.add(new ChatList("Aslı","Tap to chat!",R.drawable.avatar));

        ChatAdapter mailAdapter = new ChatAdapter(getActivity(), chatListArrayList);
        if (chatList != null) {
            chatList.setAdapter(mailAdapter);
        }

        return view;


    }


}
