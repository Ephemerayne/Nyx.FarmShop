package space.lala.nyxfarmshop.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProductDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "productlist.db";
    public static final int DATABASE_VERSION = 3;

    public ProductDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_PRODUCTLIST_TABLE = "CREATE TABLE " +
                ProductContract.ProductEntry.TABLE_NAME + " (" +
                ProductContract.ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ProductContract.ProductEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_PRICE + " REAL NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_PRODUCT_ID + " INTEGER NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_IMAGE_ID + " INTEGER NOT NULL, " +
                ProductContract.ProductEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_PRODUCTLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ProductContract.ProductEntry.TABLE_NAME);
        onCreate(db);
    }
}
