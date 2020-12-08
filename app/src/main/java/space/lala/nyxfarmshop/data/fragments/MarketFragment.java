package space.lala.nyxfarmshop.data.fragments;

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
import space.lala.nyxfarmshop.model.MarketItem;
import space.lala.nyxfarmshop.model.SingleColumnMarketItem;
import space.lala.nyxfarmshop.model.TwoColumnsMarketItem;

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

        recyclerViewAdapter = new MarketAdapterRecyclerView();
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setItems(getMarketItems());

        return view;
    }

    private ArrayList<MarketItem> getMarketItems() {
        final ArrayList<MarketItem> marketItems = new ArrayList<>();
        marketItems.add(new SingleColumnMarketItem("item1", 1));
        marketItems.add(new TwoColumnsMarketItem("item2", 2, "item3", 3));
        marketItems.add(new SingleColumnMarketItem("item4", 1));
        marketItems.add(new TwoColumnsMarketItem("item5", 2, "item6", 3));
        marketItems.add(new TwoColumnsMarketItem("item7", 2, "item8", 3));
        return marketItems;
    }
}