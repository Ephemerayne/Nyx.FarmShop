package space.lala.nyxfarmshop.model.MenuModel;

public class SingleColumnMarketItem implements MarketItem {
    public String itemName;
    public int itemId;

    public SingleColumnMarketItem(String item, int id) {
        this.itemName = item;
        this.itemId = id;
    }
}