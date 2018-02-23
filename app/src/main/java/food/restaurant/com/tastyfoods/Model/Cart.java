package food.restaurant.com.tastyfoods.Model;

/**
 * Created by Design-4 on 2/7/2018.
 */

public class Cart {
    public String name;
    public String description;
    public Integer img;
    public Integer cartQty;
    public float price;

    public Cart(String name, String description,Integer img,Integer cartQty,float price){
        this.name = name;
        this.description = description;
        this.img=img;
        this.cartQty=cartQty;
        this.price=price;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getImage() {
        return img;
    }

    public Integer getCartQty() {
        return cartQty;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String surname) {
        this.description = surname;
    }

    public void setImage(Integer image) {
        this.img = image;
    }

    public void setCartQty(Integer menuQty) {
        this.cartQty = menuQty;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
