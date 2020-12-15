package space.lala.nyxfarmshop.model.ProductsModel;

public abstract class ProductModel {

    public final double price;
    public final String name;
    public final int imageId;

    protected ProductModel(double price, String name, int imageId) {
        this.price = price;
        this.name = name;
        this.imageId = imageId;
    }
}
