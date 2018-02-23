package food.restaurant.com.tastyfoods.Model;

/**
 * Created by Design-4 on 2/12/2018.
 */

public class Address {
    public String address;
    public Address(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address=address;
    }
}
