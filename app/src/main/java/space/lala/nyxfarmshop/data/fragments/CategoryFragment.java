package space.lala.nyxfarmshop.data.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import space.lala.nyxfarmshop.R;
import space.lala.nyxfarmshop.data.adapters.VerticalMarketCategoryAdapterRecyclerView;
import space.lala.nyxfarmshop.model.MenuModel.VerticalMenuItemModel;

public class CategoryFragment extends Fragment {

    private RecyclerView recyclerViewVerticalMenuCategory;
    VerticalMarketCategoryAdapterRecyclerView verticalMarketCategoryAdapterRecyclerView;
    ArrayList<VerticalMenuItemModel> categoryItems = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerViewVerticalMenuCategory = view.findViewById(R.id.recycler_view_vertical_menu_category);
        verticalMarketCategoryAdapterRecyclerView = new VerticalMarketCategoryAdapterRecyclerView();
        populateItemsVerticalMenuCategory();

        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewVerticalMenuCategory.setLayoutManager(verticalLayoutManager);
        recyclerViewVerticalMenuCategory.setAdapter(verticalMarketCategoryAdapterRecyclerView);
        verticalMarketCategoryAdapterRecyclerView.setCategoryArray(categoryItems);

        return view;
    }

    private void populateItemsVerticalMenuCategory() {
        categoryItems.add(new VerticalMenuItemModel("item 1", 0));
        categoryItems.add(new VerticalMenuItemModel("item 2", 1));
        categoryItems.add(new VerticalMenuItemModel("item 3", 2));
        categoryItems.add(new VerticalMenuItemModel("item 4", 3));
        categoryItems.add(new VerticalMenuItemModel("item 5", 4));
        categoryItems.add(new VerticalMenuItemModel("item 6", 5));
    }
}