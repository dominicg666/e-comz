package food.restaurant.com.tastyfoods.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import android.os.Handler;

import food.restaurant.com.tastyfoods.ItemDetailsActivity;
import food.restaurant.com.tastyfoods.Model.Cart;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/8/2018.
 */

public class CardListAdapter extends ArrayAdapter<Cart> {
    ViewHolder viewHolder;
    Activity activity;
    ArrayList<Cart> cart;
    TextView priceText;
    TextView emptyCartMessage;

    TextView cartCountTop;
    TextView cartCountLeft;

    CardView cardView;

    public CardListAdapter(Activity activity, ArrayList<Cart> cart, TextView priceText,TextView emptyCartMessage, CardView cardView) {
        super(activity, 0, cart);
        this.activity = activity;
        this.cart = cart;
        this.priceText = priceText;
        this.emptyCartMessage=emptyCartMessage;
        this.cardView = cardView;

        cartCountTop = (TextView) activity.findViewById(R.id.cart_badge);
        cartCountLeft = (TextView) activity.findViewById(R.id.left_cartCount);

        totalPrice(cart);

    }
    private void totalPrice(ArrayList<Cart> cart){
        float price=0;
        for (int i=0;i<cart.size();i++){
            Cart itemCart=cart.get(i);
            price=price+(itemCart.getPrice()*itemCart.getCartQty());
        }
        priceText.setText(String.format("%.2f",price));
        cartCountTop.setText(Integer.toString(cart.size()));
        cartCountLeft.setText(Integer.toString(cart.size()));
        if(price<=0){
            cardView.setVisibility(View.GONE);
            emptyCartMessage.setVisibility(View.VISIBLE);
        }else{
            cardView.setVisibility(View.VISIBLE);
            emptyCartMessage.setVisibility(View.GONE);
        }
    }
    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Cart list = cart.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.cart_list_item, parent, false);
            viewHolder = new ViewHolder();
        }
        // Lookup view for data population
        viewHolder.mTitle = (TextView) convertView.findViewById(R.id.title);
        viewHolder.mDesc = (TextView) convertView.findViewById(R.id.description);
        viewHolder.mImg = (ImageView) convertView.findViewById(R.id.play_eq);
        viewHolder.mPrice = (TextView) convertView.findViewById(R.id.price);
        viewHolder.mQty = (TextView) convertView.findViewById(R.id.qty);
        viewHolder.mRemove = (Button) convertView.findViewById(R.id.imageRemoveCart);
        viewHolder.mCartIncrease = (Button) convertView.findViewById(R.id.increase);
        viewHolder.mCartDecrease = (Button) convertView.findViewById(R.id.decrease);
        viewHolder.mCard=(CardView) convertView.findViewById(R.id.cart_item);
        // Populate the data into the template view using the data object
        viewHolder.mTitle.setText(list.getName());
        viewHolder.mDesc.setText(list.getDescription());
        viewHolder.mImg.setImageResource(list.getImage());
        viewHolder.mPrice.setText(Float.toString(list.getPrice()));
        viewHolder.mQty.setText("x "+list.getCartQty().toString());

        final View itemView=convertView;
//        final Animation animation = AnimationUtils.loadAnimation(context,R.anim.slide_up);
//        itemView.startAnimation(animation);
        viewHolder.mRemove.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeListItem(itemView,position);
            }
        });

        viewHolder.mCartIncrease.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty=list.getCartQty();
                list.setCartQty(qty+1);
                totalPrice(cart);
                notifyDataSetChanged();
            }
        });
        viewHolder.mCartDecrease.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty=list.getCartQty();
                if(qty>1) {
                    list.setCartQty(qty - 1);
                    totalPrice(cart);
                    notifyDataSetChanged();
                }
            }
        });

        viewHolder.mCard.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, ItemDetailsActivity.class);
                activity.startActivity(intent);
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }
    protected void removeListItem(View rowView, final int positon) {
        final Animation animation = AnimationUtils.loadAnimation(activity, android.R.anim.slide_out_right);
        rowView.startAnimation(animation);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                cart.remove(positon);
                totalPrice(cart);
                notifyDataSetChanged();
                animation.cancel();
            }
        },100);
    }
    private static class ViewHolder {
        private TextView mTitle;
        private TextView mDesc;
        private ImageView mImg;
        private TextView mPrice;
        private TextView mQty;
        private Button mRemove;
        private Button mCartDecrease;
        private Button mCartIncrease;
        private CardView mCard;
    }
}
