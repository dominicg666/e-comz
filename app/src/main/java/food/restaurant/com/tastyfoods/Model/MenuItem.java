package food.restaurant.com.tastyfoods.Model;

/**
 * Created by Design-4 on 2/27/2018.
 */

public class MenuItem {
    public String Name;
    public String Desc;
    public String Price;
    public Integer Image;
    public MenuItem(String name, String desc,String price, Integer image){
        Name=name;
        Desc=desc;
        Price=price;
        Image=image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public Integer getImage() {
        return Image;
    }

    public void setImage(Integer image) {
        Image = image;
    }



}
