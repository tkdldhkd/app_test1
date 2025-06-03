package com.example.app_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AchievementsAdapter extends RecyclerView.Adapter<AchievementsAdapter.ViewHolder> {
    private List<Achievements_list> achievements;

    public AchievementsAdapter(List<Achievements_list> achievements) {
        this.achievements = achievements;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_achievement, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Achievements_list achievement = achievements.get(position);
        holder.titleTextView.setText(achievement.getTitle());
        holder.messageTextView.setText(achievement.getMessage());


        if (achievement.getTriggerTimeMillis() > 0) {
            holder.statusImageView.setImageResource(R.drawable.achieved_icon);
        }
        /*else {
            holder.statusImageView.setVisibility(View.GONE);
        }*/
    }

    @Override
    public int getItemCount() {
        return achievements.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, messageTextView;
        ImageView statusImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            messageTextView = itemView.findViewById(R.id.message);
            statusImageView = itemView.findViewById(R.id.status_icon);
        }
    }
}