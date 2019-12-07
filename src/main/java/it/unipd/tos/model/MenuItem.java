////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
    
    private ItemType type;
    private String name;
    private double price;
    
    public MenuItem(ItemType t, String n, double p)
    {
        this.type=t;
        this.name=n;
        this.price=p;
    }
    
    public ItemType getType() {
        return type;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }

}
