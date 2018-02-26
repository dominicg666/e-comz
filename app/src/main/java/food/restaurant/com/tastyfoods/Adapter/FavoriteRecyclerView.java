package food.restaurant.com.tastyfoods.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import food.restaurant.com.tastyfoods.ItemDetailsActivity;
import food.restaurant.com.tastyfoods.Model.Favorite;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by HG_DV3 on 2/7/2018.
 */

public class FavoriteRecyclerView extends RecyclerView.Adapter<FavoriteRecyclerView.ViewHolder> {

    private List<Favorite> mModelList;
    private Context mContext;
    private Fragment fr;

    public FavoriteRecyclerView(Context context, List<Favorite> list) {
        mModelList = list;
        mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.favorite_list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        // Get the data model based on position
        Favorite list = mModelList.get(position);

        // Set item views based on your views and data model
        viewHolder.mTitle.setText(list.getName());
        viewHolder.mDesc.setText(list.getDescription());
        viewHolder.mImg.setBackgroundResource(list.getImg());
        viewHolder.mPrice.setText(list.getPrice());
        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                /*Toast toast = Toast.makeText(mContext, viewHolder.mTitle.getText().toString(), Toast.LENGTH_SHORT);
                toast.show();*/
                Intent intent=new Intent(mContext,ItemDetailsActivity.class);
                intent.putExtra("title",viewHolder.mTitle.getText().toString());
                mContext.startActivity(intent);



            }
        });
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModelList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, mModelList.size());
            }
        });

        viewHolder.carticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"added to cart",Toast.LENGTH_SHORT).show();
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
        private CardView cv;
        private Button delete;
        private ImageView carticon;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mDesc = (TextView) itemView.findViewById(R.id.description);
            mImg = (ImageView) itemView.findViewById(R.id.play_eq);
            mPrice=(TextView) itemView.findViewById(R.id.price);
            cv=(CardView)itemView.findViewById(R.id.cardview_f_id);
            delete=(Button) itemView.findViewById(R.id.delete);
            carticon=(ImageView) itemView.findViewById(R.id.carticon);


        }
    }

}
