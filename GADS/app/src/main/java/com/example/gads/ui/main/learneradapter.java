package com.example.gads.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads.R;
import com.example.gads.models.learner;

import java.util.ArrayList;

public class learneradapter extends RecyclerView.Adapter<learneradapter.ViewHolder> {

    ArrayList<learner> top_learners;
    private Context context;


    public void setDATA(ArrayList<learner> top_learners){this.top_learners = top_learners;};

    public learneradapter(ArrayList<learner> top_learners, Context context) {
        this.top_learners = top_learners;
        this.context = context;
    }



    @NonNull
    @Override
    public learneradapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.details,parent,false);
       ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull learneradapter.ViewHolder holder, int position) {
        holder.img.setImageResource(R.drawable.top);
        holder.name.setText(top_learners.get(position).getName());
        holder.hrs_country.setText(top_learners.get(position).getHours() + " learning hours, "+top_learners.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return top_learners.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView hrs_country;
        CardView card;
        public ViewHolder(@NonNull View details){
            super(details);

            img = details.findViewById(R.id.img);
            name = details.findViewById(R.id.name);
            hrs_country= details.findViewById(R.id.score_hours);
            card = details.findViewById(R.id.card_ui);

        }
    }
}
