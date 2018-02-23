package food.restaurant.com.tastyfoods.Model;

/**
 * Created by Design-4 on 2/12/2018.
 */

public class PaymentOption {
    public String paymentOption;
    public Integer icon;
    public PaymentOption(String paymentOption,Integer icon){
        this.paymentOption = paymentOption;
        this.icon=icon;
    }
    public String getAddress(){
        return this.paymentOption;
    }
    public void setAddress(String address){
        this.paymentOption=address;
    }
    public Integer getIcon(){
        return this.icon;
    }
    public void setIcon(Integer icon){
        this.icon=icon;
    }
}
