package space.lala.nyxfarmshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import space.lala.nyxfarmshop.model.MarketItem;

public class CustomAdapterRecyclerView extends RecyclerView.Adapter<CustomAdapterRecyclerView.ViewHolder> {

    private ArrayList<MarketItem> marketItems;

    public void setItems(ArrayList<MarketItem> items) {
        marketItems = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull CustomAdapterRecyclerView.ViewHolder viewHolder,
            final int position
    ) {
        viewHolder.getNameItem().setText(marketItems.get(position).itemName);
    }

    @Override
    public int getItemCount() {
        return marketItems.size();
    }

    /**
     * Вьюхолдер
     * */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameItem = itemView.findViewById(R.id.name_item);
        }

        public TextView getNameItem() {
            return nameItem;
        }
    }

}
