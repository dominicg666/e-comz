package food.restaurant.com.tastyfoods.Model;

/**
 * Created by HG_DV3 on 2/7/2018.
 */

public class Favorite {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String description;
    public Integer img;
    public String price;

    public Favorite(String name,String description,Integer img,String price)
    {
        this.name=name;
        this.description=description;
        this.img=img;
        this.price=price;
    }
}
