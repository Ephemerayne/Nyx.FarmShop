package space.lala.nyxfarmshop.data.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import space.lala.nyxfarmshop.R;
import space.lala.nyxfarmshop.data.adapters.MarketAdapterRecyclerView;
import space.lala.nyxfarmshop.data.adapters.ScreenSlidePagerAdapter;
import space.lala.nyxfarmshop.database.ProductContract;
import space.lala.nyxfarmshop.database.ProductDBHelper;
import space.lala.nyxfarmshop.model.MenuModel.MarketItem;
import space.lala.nyxfarmshop.model.MenuModel.SingleColumnMarketItem;
import space.lala.nyxfarmshop.model.MenuModel.TwoColumnsMarketItem;
import space.lala.nyxfarmshop.model.ProductsModel.CucumberModel;
import space.lala.nyxfarmshop.model.ProductsModel.ProductModel;
import space.lala.nyxfarmshop.model.ProductsModel.TomatoModel;

public class MarketFragment extends Fragment {

    private static final int NUM_PAGES = 5;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    private RecyclerView recyclerView;
    private MarketAdapterRecyclerView recyclerViewAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_market, container, false);

        viewPager = view.findViewById(R.id.view_pager);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        pagerAdapter = new ScreenSlidePagerAdapter(this, NUM_PAGES);
        viewPager.setAdapter(pagerAdapter);

        recyclerViewAdapter = new MarketAdapterRecyclerView(getResources());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setItems(getMarketItems());

        return view;
    }

    private ArrayList<MarketItem> getMarketItems() {
        final ArrayList<MarketItem> marketItems = new ArrayList<>();
        marketItems.add(new SingleColumnMarketItem(getString(R.string.vegetables).toUpperCase(), R.drawable.item_vegetables));
        marketItems.add(new SingleColumnMarketItem(getString(R.string.fruits).toUpperCase(), R.drawable.item_fruits));
        marketItems.add(new SingleColumnMarketItem(getString(R.string.meat).toUpperCase(), R.drawable.item_meat));
        marketItems.add(new SingleColumnMarketItem(getString(R.string.grocery).toUpperCase(), R.drawable.item_milk_bread_eggs));
        return marketItems;
    }
}
