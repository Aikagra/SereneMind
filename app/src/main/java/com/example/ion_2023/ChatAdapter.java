package com.example.ion_2023;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ion_2023.ChatMessage;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ChatMessage> chatMessages;

    public ChatAdapter(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatViewHolder chatViewHolder = (ChatViewHolder) holder;
        ChatMessage chatMessage = chatMessages.get(position);

        if (chatMessage.isSent()) {
            chatViewHolder.leftChatView.setVisibility(View.GONE);
            chatViewHolder.rightChatView.setVisibility(View.VISIBLE);
            chatViewHolder.rightChatTextView.setText(chatMessage.getMessage());
        } else {
            chatViewHolder.leftChatView.setVisibility(View.VISIBLE);
            chatViewHolder.rightChatView.setVisibility(View.GONE);
            chatViewHolder.leftChatTextView.setText(chatMessage.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout leftChatView, rightChatView;
        public TextView leftChatTextView, rightChatTextView;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            leftChatView = itemView.findViewById(R.id.left_chat_view);
            rightChatView = itemView.findViewById(R.id.right_chat_view);
            leftChatTextView = itemView.findViewById(R.id.left_chat_text_view);
            rightChatTextView = itemView.findViewById(R.id.right_chat_text_view);
        }
    }
}
