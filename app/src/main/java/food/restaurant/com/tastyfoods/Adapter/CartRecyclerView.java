package food.restaurant.com.tastyfoods.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import food.restaurant.com.tastyfoods.Model.Cart;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/7/2018.
 */

public class CartRecyclerView  extends RecyclerView.Adapter<CartRecyclerView.ViewHolder>  {
    private List<Cart> mModelList;
    private Context mContext;

    public CartRecyclerView(Context context, List<Cart> list) {
        mModelList = list;
        mContext = context;
    }
    @Override
    public CartRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.cart_list_item, parent, false);

        // Return a new holder instance
        CartRecyclerView.ViewHolder viewHolder = new CartRecyclerView.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CartRecyclerView.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Cart list = mModelList.get(position);

        // Set item views based on your views and data model
        viewHolder.mTitle.setText(list.getName());
        viewHolder.mDesc.setText(list.getDescription());
        viewHolder.mImg.setImageResource(list.getImage());
        viewHolder.mPrice.setText(Float.toString(list.getPrice()));
        viewHolder.mQty.setText("x "+list.getCartQty().toString());
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitle;
        private TextView mDesc;
        private ImageView mImg;
        private TextView mPrice;
        private TextView mQty;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mDesc = (TextView) itemView.findViewById(R.id.description);
            mImg = (ImageView) itemView.findViewById(R.id.play_eq);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mQty = (TextView) itemView.findViewById(R.id.qty);
        }
    }
}
