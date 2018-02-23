package food.restaurant.com.tastyfoods.Model;

import android.widget.ImageView;

/**
 * Created by Design-4 on 2/6/2018.
 */

public class Menu {
    public String name;
    public String description;
    public Integer img;
    public String menuQty;

    public Menu(String name, String description,Integer img,String menuQty) {
        this.name = name;
        this.description = description;
        this.img=img;
        this.menuQty=menuQty;
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

    public String getmenuQty() {
        return menuQty;
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

    public void setmenuQty(String menuQty) {
        this.menuQty = menuQty;
    }

}
