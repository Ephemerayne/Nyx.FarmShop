package space.lala.nyxfarmshop;

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

import space.lala.nyxfarmshop.model.MarketItem;

public class MarketFragment extends Fragment {

    private static final int NUM_PAGES = 5;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    private RecyclerView recyclerView;
    private CustomAdapterRecyclerView recyclerViewAdapter;

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

        recyclerViewAdapter = new CustomAdapterRecyclerView();
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setItems(getMarketItems());

        return view;
    }

    private ArrayList<MarketItem> getMarketItems() {
        final ArrayList<MarketItem> marketItems = new ArrayList<>();
        marketItems.add(new MarketItem("item"));
        marketItems.add(new MarketItem("item"));
        marketItems.add(new MarketItem("item"));
        marketItems.add(new MarketItem("item"));
        marketItems.add(new MarketItem("item"));
        marketItems.add(new MarketItem("item"));
        marketItems.add(new MarketItem("item"));
        marketItems.add(new MarketItem("item"));
        marketItems.add(new MarketItem("item"));
        marketItems.add(new MarketItem("item"));
        return marketItems;
    }
}