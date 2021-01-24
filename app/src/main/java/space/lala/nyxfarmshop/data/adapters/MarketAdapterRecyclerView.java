package space.lala.nyxfarmshop.data.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

import space.lala.nyxfarmshop.R;
import space.lala.nyxfarmshop.data.fragments.MarketFragment;
import space.lala.nyxfarmshop.model.MenuModel.MarketItem;
import space.lala.nyxfarmshop.model.MenuModel.SingleColumnMarketItem;
import space.lala.nyxfarmshop.model.MenuModel.TwoColumnsMarketItem;
import space.lala.nyxfarmshop.model.MenuModel.ViewPagerHeaderItem;

public class MarketAdapterRecyclerView extends RecyclerView.Adapter<MarketAdapterRecyclerView.BaseViewHolder> {

    private final static int VIEW_TYPE_HEADER = 0;
    private final static int VIEW_TYPE_ONE_COLUMN = 1;
    private final static int VIEW_TYPE_TWO_COLUMNS = 2;
    private ArrayList<MarketItem> marketItems;
    private final Resources resources;
    private OnCategoryListener onCategoryListener;
    MarketFragment marketFragment;

    public MarketAdapterRecyclerView(Context context, MarketFragment marketFragment, OnCategoryListener onCategoryListener) {
        this.marketFragment = marketFragment;
        this.resources = context.getResources();
        this.onCategoryListener = onCategoryListener;
    }

    public void setItems(ArrayList<MarketItem> items) {
        marketItems = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (marketItems.get(position) instanceof ViewPagerHeaderItem) {
            return VIEW_TYPE_HEADER;
        } else if (marketItems.get(position) instanceof SingleColumnMarketItem) {
            return VIEW_TYPE_ONE_COLUMN;
        } else {
            return VIEW_TYPE_TWO_COLUMNS;
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        int layoutId;

        if (viewType == VIEW_TYPE_HEADER) {
            layoutId = R.layout.view_pager_header;
        } else if (viewType == VIEW_TYPE_ONE_COLUMN) {
            layoutId = R.layout.single_column_market_item;
        } else {
            layoutId = R.layout.two_columns_market_item;
        }

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(layoutId, viewGroup, false);

        if (viewType == 0) {
            return new ViewPagerHeaderViewHolder(view);
        } else if (viewType == 1) {
            return new SingleColumnItemViewHolder(view, onCategoryListener);
        } else {
            return new TwoColumnsItemViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (holder instanceof SingleColumnItemViewHolder) {

            ImageView imageView = ((SingleColumnItemViewHolder) holder).itemView.findViewById(R.id.img_item_main);
            SingleColumnMarketItem singleColumnMarketItem = (SingleColumnMarketItem) marketItems.get(position);
            imageView.setImageDrawable(resources.getDrawable(singleColumnMarketItem.itemId));
            ((SingleColumnItemViewHolder) holder).nameItem.setText(singleColumnMarketItem.itemName);

        } else if (holder instanceof TwoColumnsItemViewHolder) {
            ImageView img1 = ((TwoColumnsItemViewHolder) holder).itemView.findViewById(R.id.left_img_item);
            ImageView img2 = ((TwoColumnsItemViewHolder) holder).itemView.findViewById(R.id.right_img_item);
            TwoColumnsMarketItem twoColumnsMarketItem = (TwoColumnsMarketItem) marketItems.get(position);
            img1.setImageDrawable(resources.getDrawable(twoColumnsMarketItem.itemId));
            img2.setImageDrawable(resources.getDrawable(twoColumnsMarketItem.itemId2));
            ((TwoColumnsItemViewHolder) holder).leftItem.setText(twoColumnsMarketItem.itemName);
            ((TwoColumnsItemViewHolder) holder).rightItem.setText(twoColumnsMarketItem.itemName2);
        } else {
            ViewPager2 viewPager = ((ViewPagerHeaderViewHolder) holder).itemView.findViewById(R.id.view_pager);

            FragmentStateAdapter pagerAdapter = new ScreenSlidePagerAdapter(marketFragment, 5);
            viewPager.setAdapter(pagerAdapter);
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

    public static class SingleColumnItemViewHolder extends BaseViewHolder implements View.OnClickListener {
        private final TextView nameItem;
        OnCategoryListener onCategoryListener;

        public SingleColumnItemViewHolder(@NonNull View itemView, OnCategoryListener onCategoryListener) {
            super(itemView);
            nameItem = itemView.findViewById(R.id.name_item);
            itemView.setOnClickListener(this);
            this.onCategoryListener = onCategoryListener;
        }

        @Override
        public void onClick(View view) {
            onCategoryListener.onCategoryClick(getAbsoluteAdapterPosition());
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

    public static class ViewPagerHeaderViewHolder extends BaseViewHolder {
        public ViewPagerHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface OnCategoryListener {
        void onCategoryClick(int position);
    }
}
