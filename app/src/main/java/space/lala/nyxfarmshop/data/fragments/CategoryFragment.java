package space.lala.nyxfarmshop.data.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import space.lala.nyxfarmshop.R;
import space.lala.nyxfarmshop.data.adapters.VerticalMarketCategoryAdapterRecyclerView;
import space.lala.nyxfarmshop.database.ProductContract;
import space.lala.nyxfarmshop.database.ProductDBHelper;
import space.lala.nyxfarmshop.model.MenuModel.MarketItem;
import space.lala.nyxfarmshop.model.MenuModel.VerticalMenuItemModel;
import space.lala.nyxfarmshop.model.ProductsModel.ProductModel;

public class CategoryFragment extends Fragment {

    private static final String positionArg = "positionArg";
    private int position;

    private SQLiteDatabase mDatabase;
    ArrayList<ProductModel> products = new ArrayList<>();


    TextView categoryNameOne;
    TextView categoryNameTwo;
    ImageView imageCategoryOne;
    ImageView imageCategoryTwo;

    public static CategoryFragment newInstance(int position) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt(positionArg, position);
        fragment.setArguments(args);
        return fragment;
    }

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
        categoryNameOne = view.findViewById(R.id.name_category);
        categoryNameTwo = view.findViewById(R.id.name_category_two);
        imageCategoryOne = view.findViewById(R.id.img_category);
        imageCategoryTwo = view.findViewById(R.id.img_category_two);
        recyclerViewVerticalMenuCategory = view.findViewById(R.id.recycler_view_vertical_menu_category);
        verticalMarketCategoryAdapterRecyclerView = new VerticalMarketCategoryAdapterRecyclerView();
        getVegetableCategoryItems();

        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewVerticalMenuCategory.setLayoutManager(verticalLayoutManager);
        recyclerViewVerticalMenuCategory.setAdapter(verticalMarketCategoryAdapterRecyclerView);
        verticalMarketCategoryAdapterRecyclerView.setCategoryArray(categoryItems);

        ProductDBHelper dbHelper = new ProductDBHelper(getContext());
        mDatabase = dbHelper.getWritableDatabase();

        if (getArguments() != null) {
            position = getArguments().getInt(positionArg);
        }
        switch (position) {
            case 1:
                getVegetableCategoryItems();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }

        final Cursor cursor = mDatabase.query(ProductContract.ProductEntry.TABLE_NAME, null, null, null, null, null, ProductContract.ProductEntry.COLUMN_TIMESTAMP + " DESC");

        return view;
    }


//    private void addProduct(ProductModel productModel) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(ProductContract.ProductEntry.COLUMN_NAME, productModel.name);
//        contentValues.put(ProductContract.ProductEntry.COLUMN_PRODUCT_ID, productModel.productId);
//        contentValues.put(ProductContract.ProductEntry.COLUMN_PRICE, productModel.price);
//        contentValues.put(ProductContract.ProductEntry.COLUMN_CATEGORY_NAME, productModel.category);
//        contentValues.put(ProductContract.ProductEntry.COLUMN_IMAGE_ID, productModel.imageId);
//
//        mDatabase.insert(ProductContract.ProductEntry.TABLE_NAME, null, contentValues);
//    }

    private void populateItemsVerticalMenuCategory() {
        categoryItems.add(new VerticalMenuItemModel("item 1", 0));
        categoryItems.add(new VerticalMenuItemModel("item 2", 1));
        categoryItems.add(new VerticalMenuItemModel("item 3", 2));
        categoryItems.add(new VerticalMenuItemModel("item 4", 3));
        categoryItems.add(new VerticalMenuItemModel("item 5", 4));
        categoryItems.add(new VerticalMenuItemModel("item 6", 5));
    }

    private void getVegetableCategoryItems() {
        final ArrayList<MarketItem> vegetables = new ArrayList<>();
        categoryItems.add(new VerticalMenuItemModel("Помидоры", 0));
        categoryItems.add(new VerticalMenuItemModel("Огурцы", 1));
        categoryItems.add(new VerticalMenuItemModel("Картофель", 2));
        categoryItems.add(new VerticalMenuItemModel("Лук", 3));
        categoryItems.add(new VerticalMenuItemModel("Морковь", 4));
        categoryItems.add(new VerticalMenuItemModel("Капуста", 5));
        categoryItems.add(new VerticalMenuItemModel("Баклажан", 6));
        categoryItems.add(new VerticalMenuItemModel("Чеснок", 7));
        categoryItems.add(new VerticalMenuItemModel("Болгарский перец", 8));
        categoryItems.add(new VerticalMenuItemModel("Тыква", 9));


//    private void getVegetables() {
//        vegetables.add(new ProductModel("70.1", ) {
//        };
//
//        return vegetables;
//        final Cursor cursor = mDatabase.query(ProductContract.ProductEntry.TABLE_NAME, null, null, null, null, null, ProductContract.ProductEntry.COLUMN_TIMESTAMP + " DESC");
//        cursor.moveToFirst();
//    }
    }
}