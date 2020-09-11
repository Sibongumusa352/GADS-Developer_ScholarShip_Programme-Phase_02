package com.example.gads.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads.R;
import com.example.gads.models.skill_iq;

import java.util.ArrayList;

public class skilladapter extends RecyclerView.Adapter<skilladapter.ViewHolder>{
        ArrayList<skill_iq> top_iq;
        private Context context;

       public void setData(ArrayList<skill_iq> top_iq){this.top_iq =top_iq;}

    public skilladapter(ArrayList<skill_iq> top_iq, Context context) {
        this.top_iq = top_iq;
        this.context = context;
    }

    @NonNull
    @Override
    public skilladapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.details,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull skilladapter.ViewHolder holder, int position) {
        holder.img.setImageResource(R.drawable.iq);
        holder.name.setText(top_iq.get(position).getName());
        holder.hrs_country.setText(top_iq.get(position).getScore() + " skill IQ Score, "+top_iq.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return top_iq.size();
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
