package food.restaurant.com.tastyfoods.Model;

/**
 * Created by Design-4 on 2/23/2018.
 */
public class CardItem {

    private String mTextResource;
    private String mTitleResource;
    private Integer mImage;
    private String mOffer;
    private String mPrice;

    public CardItem(String title, String text,Integer image,String offer,String price) {
        mTitleResource = title;
        mTextResource = text;
        mImage=image;
        mOffer=offer;
        mPrice=price;
    }

    public String getText() {
        return mTextResource;
    }

    public String getTitle() {
        return mTitleResource;
    }
    public Integer getmImage(){
        return mImage;
    }
    public String getmOffer(){
        return mOffer;
    }
    public String getmPrice(){
        return mPrice;
    }
}
