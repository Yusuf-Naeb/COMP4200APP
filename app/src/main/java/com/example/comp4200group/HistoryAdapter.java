package com.example.comp4200group;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    ArrayList<Mood_His> dataList;
    Context context;
    public HistoryAdapter(ArrayList<Mood_His> data, Context context){
        this.dataList = data;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.his_recycle, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position)
    {
        position = holder.getAdapterPosition();
        Mood_His data = dataList.get(position);

        if(data.getMood().equals("Happy")) {
            holder.cardView.setBackgroundResource(R.color.yellow);
        }
        else if(data.getMood().equals("Sad")) {
            holder.cardView.setBackgroundResource(R.color.blue);
        }
//        else if(data.getMood().equals("Angry")) {
//            holder.cardView.setBackgroundResource(R.color.red);
//        }
//        else if(data.getMood().equals("Anxious")) {
//            holder.cardView.setBackgroundResource(R.color.gray);
//        }
        else if(data.getMood().equals("Okay")) {
            holder.cardView.setBackgroundResource(R.color.green);
        }
//        else if(data.getMood().equals("Love")) {
//            holder.cardView.setBackgroundResource(R.color.pink);
//        }
//        else if(data.getMood().equals("Overworked")) {
//            holder.cardView.setBackgroundResource(R.color.black);
//            holder.tv_date.setTextColor(Color.WHITE);
//            holder.tv_date_mood.setTextColor(Color.WHITE);
//            holder.tv_your_mood.setTextColor(Color.WHITE);
//        }

        holder.tv_date.setText("Date: " + data.getDate());
        holder.tv_date_mood.setText("Your mood: " + data.getMood());
//        holder.tv_your_mood.setText("Your mood: " + data.getMood2());

    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }
    public class HistoryViewHolder extends RecyclerView.ViewHolder{
        TextView tv_date, tv_date_mood, tv_your_mood;
        CardView cardView;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            tv_date = itemView.findViewById(R.id.textView_date);
            tv_date_mood = itemView.findViewById(R.id.textView_date_mood);
//            tv_your_mood = itemView.findViewById(R.id.textView_your_mood);
        }
    }

}
