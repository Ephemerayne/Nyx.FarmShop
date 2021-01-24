package space.lala.nyxfarmshop.data.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import space.lala.nyxfarmshop.R;
import space.lala.nyxfarmshop.database.ProductContract;
import space.lala.nyxfarmshop.database.ProductDBHelper;
import space.lala.nyxfarmshop.model.ProductsModel.ProductModel;

public class BasketFragment extends Fragment {

    private SQLiteDatabase mDatabase;
    ArrayList<ProductModel> products = new ArrayList<>();
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basket, container, false);

        textView = view.findViewById(R.id.text);

        ProductDBHelper dbHelper = new ProductDBHelper(getContext());
        mDatabase = dbHelper.getWritableDatabase();
      // addProduct();
    //    getProducts();
        return view;
    }

    private void addProduct(ProductModel productModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ProductContract.ProductEntry.COLUMN_NAME, productModel.name);
        contentValues.put(ProductContract.ProductEntry.COLUMN_PRODUCT_ID, productModel.productId);
        contentValues.put(ProductContract.ProductEntry.COLUMN_PRICE, productModel.price);
        contentValues.put(ProductContract.ProductEntry.COLUMN_CATEGORY_NAME, productModel.category);
        contentValues.put(ProductContract.ProductEntry.COLUMN_IMAGE_ID, productModel.imageId);

        mDatabase.insert(ProductContract.ProductEntry.TABLE_NAME, null, contentValues);
    }

  //  private void getProducts() {
//        final Cursor cursor = mDatabase.query(ProductContract.ProductEntry.TABLE_NAME, null, null, null, null, null, ProductContract.ProductEntry.COLUMN_TIMESTAMP + " DESC");
//        cursor.moveToFirst();
//
//        while (!cursor.isAfterLast()) {
//            String name;
//            double price;
//            int productId;
//
//            name = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_NAME));
//            price = cursor.getDouble(cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_PRICE));
//            productId = cursor.getInt(cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_PRODUCT_ID));
//
//            switch (productId) {
//                case CucumberModel.productId:
//                    products.add(new CucumberModel(price, name, R.drawable.item_cucumber));
//                    break;
//                case TomatoModel.productId:
//                    products.add(new TomatoModel(price, name, R.drawable.item_tomato));
//                    break;
//            }
//
//
//            cursor.moveToNext();
//        }
//        setProductsTextView();
//    }
//
//    private void setProductsTextView(){
//        for (ProductModel product: products) {
//            textView.append("\n" + product.name + " " + product.price);
//        }
//    }
}