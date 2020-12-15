package space.lala.nyxfarmshop.model.MenuModel;

public class TwoColumnsMarketItem implements MarketItem {
    public String itemName;
    public int itemId;

    public String itemName2;
    public int itemId2;

    public TwoColumnsMarketItem(String item, int id, String item2, int id2) {
        this.itemName = item;
        this.itemName2 = item2;
        this.itemId = id;
        this.itemId2 = id2;
    }
}