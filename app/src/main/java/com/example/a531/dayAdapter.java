package com.example.a531;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dayAdapter extends RecyclerView.Adapter<dayAdapter.dayViewHolder> {

    private ArrayList<dayItem> m_dayList;

    public static class dayViewHolder extends RecyclerView.ViewHolder {
        public TextView m_Line1, m_Line2;
        public dayViewHolder(@NonNull View itemView) {
            super(itemView);
            m_Line1 = itemView.findViewById(R.id.line1_view);
            m_Line2 = itemView.findViewById(R.id.line2_view);
        }
    }

    public dayAdapter(ArrayList<dayItem> dayList) {
        m_dayList = dayList;

    }

    @NonNull
    @Override
    public dayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_item, parent, false);
        dayViewHolder dayVH = new dayViewHolder(v);
        return dayVH;
    }

    @Override
    public void onBindViewHolder(@NonNull dayViewHolder holder, int position) {
        dayItem currentItem = m_dayList.get(position);
        holder.m_Line1.setText(currentItem.get_Line1());
        holder.m_Line2.setText(currentItem.get_Line2());
    }

    @Override
    public int getItemCount() {
        return m_dayList.size();
    }
}
