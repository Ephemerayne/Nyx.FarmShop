package space.lala.nyxfarmshop;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import space.lala.nyxfarmshop.model.MenuItemModel;
import space.lala.nyxfarmshop.ui.MenuAdapterRecyclerView;

public class MenuFragment extends Fragment {

    private RecyclerView recyclerViewMenu;
    MenuAdapterRecyclerView menuAdapterRecyclerView;
    ArrayList<MenuItemModel> items = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        recyclerViewMenu = view.findViewById(R.id.recycler_view_menu);
        populateItems();
        menuAdapterRecyclerView = new MenuAdapterRecyclerView();

        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewMenu.setLayoutManager(horizontalLayoutManager);
        recyclerViewMenu.setAdapter(menuAdapterRecyclerView);
        menuAdapterRecyclerView.setItems(items);

        return view;
    }

    private void populateItems() {
        items.add(new MenuItemModel("item 1", 0));
        items.add(new MenuItemModel("item 2", 1));
        items.add(new MenuItemModel("item 3", 2));
        items.add(new MenuItemModel("item 4", 3));
        items.add(new MenuItemModel("item 5", 4));
        items.add(new MenuItemModel("item 6", 5));
        items.add(new MenuItemModel("item 7", 6));
        items.add(new MenuItemModel("item 8", 7));
        items.add(new MenuItemModel("item 9", 8));
        items.add(new MenuItemModel("item 10", 9));

    }
}