package space.lala.nyxfarmshop.model.MenuModel;

public class VerticalMenuItemModel implements MarketItem {
    final public String itemName;
    final public int itemId;

    public VerticalMenuItemModel(String itemName, int itemId) {
        this.itemName = itemName;
        this.itemId = itemId;
    }
}

