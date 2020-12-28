package Lab.Mod;

public class GoodsM {
    private int GoodsID;
    private int Category;
    private float Price;
    private String Manufactor;

    public GoodsM() {}


    public GoodsM(String Manufactor, int Category, float Price) {
        this.Manufactor = Manufactor;
        this.Category = Category;
        this.Price = Price;
    }

    public void setGoodsID(int GoodsID) {this.GoodsID=GoodsID;}
    public int getGoodsID() {return GoodsID;}

    public void setManufactor(String Manufactor) {this.Manufactor=Manufactor;}
    public String getManufactor() {return Manufactor;}

    public void setPrice(float Price) {this.Price=Price;}
    public float getPrice() {return Price;}

    public void setCategory(int Category) {this.Category=Category;}
    public int getCategory() {return Category;}
}