package space.lala.nyxfarmshop.model;

public abstract class ProductModel {

    public final double price;
    public final String name;

    protected ProductModel(double price, String name) {
        this.price = price;
        this.name = name;
    }
}
