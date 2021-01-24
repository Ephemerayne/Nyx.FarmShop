package space.lala.nyxfarmshop.data.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import space.lala.nyxfarmshop.R;
import space.lala.nyxfarmshop.data.adapters.MarketAdapterRecyclerView;
import space.lala.nyxfarmshop.model.MenuModel.MarketItem;
import space.lala.nyxfarmshop.model.MenuModel.SingleColumnMarketItem;
import space.lala.nyxfarmshop.model.MenuModel.ViewPagerHeaderItem;

public class MarketFragment extends Fragment implements MarketAdapterRecyclerView.OnCategoryListener {

    private RecyclerView recyclerView;
    private MarketAdapterRecyclerView recyclerViewAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_market, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerViewAdapter = new MarketAdapterRecyclerView(getContext(), this, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setItems(getMarketItems());

        return view;
    }

    private ArrayList<MarketItem> getMarketItems() {
        final ArrayList<MarketItem> marketItems = new ArrayList<>();
        marketItems.add(new ViewPagerHeaderItem());
        marketItems.add(new SingleColumnMarketItem(getString(R.string.vegetables).toUpperCase(), R.drawable.item_vegetables));
        marketItems.add(new SingleColumnMarketItem(getString(R.string.fruits).toUpperCase(), R.drawable.item_fruits));
        marketItems.add(new SingleColumnMarketItem(getString(R.string.meat).toUpperCase(), R.drawable.item_meat));
        marketItems.add(new SingleColumnMarketItem(getString(R.string.grocery).toUpperCase(), R.drawable.item_milk_bread_eggs));
        return marketItems;
    }

    @Override
    public void onCategoryClick(int position) {
        getMarketItems().get(position);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, CategoryFragment.newInstance(position));
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
