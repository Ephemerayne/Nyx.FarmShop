package space.lala.nyxfarmshop.data.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import space.lala.nyxfarmshop.R;
import space.lala.nyxfarmshop.model.HorizontalMenuItemModel;

public class HorizontalMenuAdapterRecyclerView extends RecyclerView.Adapter<HorizontalMenuAdapterRecyclerView.ViewHolder> {

    private ArrayList<HorizontalMenuItemModel> items;

    public void setItems(ArrayList<HorizontalMenuItemModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HorizontalMenuAdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_menu_recycler_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalMenuAdapterRecyclerView.ViewHolder holder, int position) {
        int colorId;

        if (position % 2 == 0) {
            colorId = R.color.black;
        } else if (position % 3 == 0) {
            colorId = R.color.purple_200;
        } else {
            colorId = R.color.design_default_color_primary;
        }

        holder.itemView.setBackgroundResource(colorId);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
