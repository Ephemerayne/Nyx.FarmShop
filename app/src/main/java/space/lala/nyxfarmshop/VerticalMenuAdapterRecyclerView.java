package space.lala.nyxfarmshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import space.lala.nyxfarmshop.model.VerticalMenuItemModel;

public class VerticalMenuAdapterRecyclerView extends RecyclerView.Adapter<VerticalMenuAdapterRecyclerView.ViewHolder> {

    private ArrayList<VerticalMenuItemModel> modelsArray;

    public void setModelsArray(ArrayList<VerticalMenuItemModel> modelsArray) {
        this.modelsArray = modelsArray;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VerticalMenuAdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vertical_menu_recycler_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalMenuAdapterRecyclerView.ViewHolder holder, int position) {
        String modelName = modelsArray.get(position).itemName;
        TextView itemName = holder.itemView.findViewById(R.id.item_name_vertical);
        itemName.setText(modelName);
    }

    @Override
    public int getItemCount() {
        return modelsArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
