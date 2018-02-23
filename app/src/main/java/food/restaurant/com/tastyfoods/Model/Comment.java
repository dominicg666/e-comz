package food.restaurant.com.tastyfoods.Model;

/**
 * Created by Design-4 on 2/10/2018.
 */

public class Comment {
    public Integer userImg;
    public String userName;
    public String userComment;
    public Comment(Integer userImg, String userName, String userComment){
        this.userImg=userImg;
        this.userName=userName;
        this.userComment=userComment;

    }
    public Integer getUserImg(){
        return this.userImg;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getUserComment(){
        return this.userComment;
    }
    public void setUserImg(Integer userImg){
        this.userImg=userImg;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public void setUserComment(String userComment){
        this.userComment=userComment;
    }
}
