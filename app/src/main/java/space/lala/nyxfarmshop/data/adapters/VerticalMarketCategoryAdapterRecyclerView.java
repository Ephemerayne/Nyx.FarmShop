package space.lala.nyxfarmshop.data.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import space.lala.nyxfarmshop.R;
import space.lala.nyxfarmshop.model.MenuModel.VerticalMenuItemModel;

public class VerticalMarketCategoryAdapterRecyclerView extends RecyclerView.Adapter<VerticalMarketCategoryAdapterRecyclerView.ViewHolder> {

    private ArrayList<VerticalMenuItemModel> categoryArray = new ArrayList<>();

    public void setCategoryArray(ArrayList<VerticalMenuItemModel> categoryArray) {
        this.categoryArray.clear();
        this.categoryArray.addAll(categoryArray);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VerticalMarketCategoryAdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_recycler_view_vertical_menu, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalMarketCategoryAdapterRecyclerView.ViewHolder holder, int position) {
        String modelName = categoryArray.get(position).itemName;
        TextView itemName = holder.itemView.findViewById(R.id.name_category);
        itemName.setText(modelName);
    }

    @Override
    public int getItemCount() {
        return categoryArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
