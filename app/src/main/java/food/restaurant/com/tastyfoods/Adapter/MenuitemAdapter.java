package food.restaurant.com.tastyfoods.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.ItemDetailsActivity;
import food.restaurant.com.tastyfoods.Menuitem;
import food.restaurant.com.tastyfoods.Model.MenuItem;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/26/2018.
 */

public class MenuitemAdapter   extends RecyclerView.Adapter<MenuitemAdapter.ViewHolder> {
    private List<MenuItem> mModelList;
    private Activity mContext;

    public MenuitemAdapter(Activity context, List<MenuItem> list) {
        mModelList = list;
        mContext = context;
    }
    @Override
    public MenuitemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.menuitem_list_item, parent, false);

        // Return a new holder instance
        MenuitemAdapter.ViewHolder viewHolder = new MenuitemAdapter.ViewHolder(contactView);
        Calligrapher calligrapher = new Calligrapher(mContext);
        calligrapher.setFont(mContext, "Lato-Regular.ttf", true);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuitemAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        MenuItem list = mModelList.get(position);

        // Set item views based on your views and data model
        viewHolder.mTitle.setText(list.getName());
        viewHolder.mDesc.setText(list.getDesc());
        viewHolder.mImg.setImageResource(list.getImage());
        viewHolder.mPrice.setText(list.getPrice());
        //final String title=list.getName();
        viewHolder.mMenuitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, ItemDetailsActivity.class);
                mContext.startActivity(intent);
            }
        });

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
        private CardView mMenuitem;
        private Button mButton;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mDesc = (TextView) itemView.findViewById(R.id.description);
            mImg = (ImageView) itemView.findViewById(R.id.play_eq);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mMenuitem=(CardView) itemView.findViewById(R.id.cart_item);
            mButton=(Button) itemView.findViewById(R.id.add_to_cart);
        }
    }

}
