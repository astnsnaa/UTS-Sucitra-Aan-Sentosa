package com.aan.uts_20753033_sucitraaansentosa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListMotorAdapter extends RecyclerView.Adapter<ListMotorAdapter.ListViewHolder> {

    private ArrayList<Motor> listMotor;

    public ListMotorAdapter(ArrayList<Motor> list) {
        this.listMotor = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Motor motor = listMotor.get(position);
        holder.imgPhoto.setImageResource(motor.getPhoto());
        holder.tvName.setText(motor.getName());
        holder.tvDescription.setText(motor.getDescription());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(holder.itemView.getContext(), "Kamu Memilih Motor "
                            + listMotor.get(holder.getAdapterPosition()).getName(),
                    Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return listMotor.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}