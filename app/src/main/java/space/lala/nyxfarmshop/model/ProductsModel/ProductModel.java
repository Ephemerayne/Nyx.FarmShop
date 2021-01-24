package space.lala.nyxfarmshop.model.ProductsModel;

public abstract class ProductModel {

    public final double price;
    public final int productId;
    public final String name;
    public final int imageId;
    public final String category;

    protected ProductModel(double price, int productId, String name, int imageId, String category) {
        this.price = price;
        this.productId = productId;
        this.name = name;
        this.imageId = imageId;
        this.category = category;
    }
}
