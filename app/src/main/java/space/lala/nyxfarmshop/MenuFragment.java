package space.lala.nyxfarmshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import space.lala.nyxfarmshop.model.HorizontalMenuItemModel;
import space.lala.nyxfarmshop.model.VerticalMenuItemModel;
import space.lala.nyxfarmshop.ui.HorizontalMenuAdapterRecyclerView;

public class MenuFragment extends Fragment {

    private RecyclerView recyclerViewHorizontalMenu;
    private RecyclerView recyclerViewVerticalMenu;
    HorizontalMenuAdapterRecyclerView horizontalMenuAdapterRecyclerView;
    VerticalMenuAdapterRecyclerView verticalMenuAdapterRecyclerView;
    ArrayList<HorizontalMenuItemModel> horizontalItems = new ArrayList<>();
    ArrayList<VerticalMenuItemModel> verticalItems = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        recyclerViewHorizontalMenu = view.findViewById(R.id.recycler_view_horizontal_menu);
        recyclerViewVerticalMenu = view.findViewById(R.id.recycler_view_vertical_menu);
        populateItemsHorizontalMenu();
        populateItemsVerticalMenu();
        horizontalMenuAdapterRecyclerView = new HorizontalMenuAdapterRecyclerView();
        verticalMenuAdapterRecyclerView = new VerticalMenuAdapterRecyclerView();

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHorizontalMenu.setLayoutManager(horizontalLayoutManager);
        recyclerViewHorizontalMenu.setAdapter(horizontalMenuAdapterRecyclerView);
        horizontalMenuAdapterRecyclerView.setItems(horizontalItems);


        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
       recyclerViewVerticalMenu.setLayoutManager(verticalLayoutManager);
        recyclerViewVerticalMenu.setAdapter(verticalMenuAdapterRecyclerView);
        verticalMenuAdapterRecyclerView.setModelsArray(verticalItems);

        return view;
    }

    private void populateItemsHorizontalMenu() {
        horizontalItems.add(new HorizontalMenuItemModel("item 1", 0));
        horizontalItems.add(new HorizontalMenuItemModel("item 2", 1));
        horizontalItems.add(new HorizontalMenuItemModel("item 3", 2));
        horizontalItems.add(new HorizontalMenuItemModel("item 4", 3));
        horizontalItems.add(new HorizontalMenuItemModel("item 5", 4));
        horizontalItems.add(new HorizontalMenuItemModel("item 6", 5));
        horizontalItems.add(new HorizontalMenuItemModel("item 7", 6));
        horizontalItems.add(new HorizontalMenuItemModel("item 8", 7));
        horizontalItems.add(new HorizontalMenuItemModel("item 9", 8));
        horizontalItems.add(new HorizontalMenuItemModel("item 10", 9));

    }

    private void populateItemsVerticalMenu() {
        verticalItems.add(new VerticalMenuItemModel("position 1", 0));
        verticalItems.add(new VerticalMenuItemModel("position 2", 1));
        verticalItems.add(new VerticalMenuItemModel("position 3", 2));
        verticalItems.add(new VerticalMenuItemModel("position 4", 3));
        verticalItems.add(new VerticalMenuItemModel("position 5", 4));
        verticalItems.add(new VerticalMenuItemModel("position 6", 5));
        verticalItems.add(new VerticalMenuItemModel("position 7", 6));
        verticalItems.add(new VerticalMenuItemModel("position 8", 7));
    }
}