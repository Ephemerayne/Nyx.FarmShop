package space.lala.nyxfarmshop.database;

import android.provider.BaseColumns;

public class ProductContract {

    private ProductContract(){}

    public static final class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "productsList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_CATEGORY_NAME = "categoryName";
        public static final String COLUMN_PRODUCT_ID = "productId";
        public static final String COLUMN_IMAGE_ID = "imageId";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
