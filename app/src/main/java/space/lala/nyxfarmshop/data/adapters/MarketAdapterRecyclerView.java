package space.lala.nyxfarmshop.data.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import space.lala.nyxfarmshop.R;
import space.lala.nyxfarmshop.model.MarketItem;
import space.lala.nyxfarmshop.model.SingleColumnMarketItem;

public class MarketAdapterRecyclerView extends RecyclerView.Adapter<MarketAdapterRecyclerView.BaseViewHolder> {

    private final static int VIEW_TYPE_ONE_COLUMN = 0;
    private final static int VIEW_TYPE_TWO_COLUMNS = 1;

    private ArrayList<MarketItem> marketItems;

    public void setItems(ArrayList<MarketItem> items) {
        marketItems = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (marketItems.get(position) instanceof SingleColumnMarketItem) {
            return VIEW_TYPE_ONE_COLUMN;
        } else {
            return VIEW_TYPE_TWO_COLUMNS;
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        int layoutId;

        if (viewType == 0) {
            layoutId = R.layout.single_column_market_item;
        } else {
            layoutId = R.layout.two_columns_market_item;
        }

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(layoutId, viewGroup, false);

        if (viewType == 0) {
            return new SingleColumnItemViewHolder(view);
        } else  {
            return new TwoColumnsItemViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (holder instanceof SingleColumnItemViewHolder) {
            ((SingleColumnItemViewHolder) holder).nameItem.setText("single column");
        } else if (holder instanceof TwoColumnsItemViewHolder) {
            ((TwoColumnsItemViewHolder) holder).leftItem.setText("left item");
            ((TwoColumnsItemViewHolder) holder).rightItem.setText("right item");
         //   ((TwoColumnsItemViewHolder) holder).leftItem.setBackgroundResource(R.drawable.main_img1);
        }
    }

    @Override
    public int getItemCount() {
        return marketItems.size();
    }

    /**
     * Вьюхолдер
     */
    public static abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class SingleColumnItemViewHolder extends BaseViewHolder {
        private final TextView nameItem;

        public SingleColumnItemViewHolder(@NonNull View itemView) {
            super(itemView);
            nameItem = itemView.findViewById(R.id.name_item);
        }
    }

    public static class TwoColumnsItemViewHolder extends BaseViewHolder {
        private final TextView leftItem;
        private final TextView rightItem;

        public TwoColumnsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            leftItem = itemView.findViewById(R.id.left_name_item);
            rightItem = itemView.findViewById(R.id.right_name_item);
        }
    }

}
