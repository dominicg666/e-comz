package food.restaurant.com.tastyfoods.Model;

/**
 * Created by Design-4 on 2/17/2018.
 */

public class AddressList {
    public String mTitle;
    public String mAddress;
    public AddressList(String mTitle,String mAddress){
        this.mTitle=mTitle;
        this.mAddress=mAddress;
    }
    public String getmTitle(){
        return this.mTitle;
    }
    public String getmAddress(){
        return this.mAddress;
    }
    public void setmTitle(String mTitle){
        this.mTitle=mTitle;
    }
    public void setmAddress(String mAddress){
        this.mAddress=mAddress;
    }
}
