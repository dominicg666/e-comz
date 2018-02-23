package food.restaurant.com.tastyfoods.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import food.restaurant.com.tastyfoods.Model.Menu;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/6/2018.
 */

public class MenuRecyclerView  extends RecyclerView.Adapter<MenuRecyclerView.ViewHolder> {
    private List<Menu> mModelList;
    private Context mContext;

    public MenuRecyclerView(Context context, List<Menu> list) {
        mModelList = list;
        mContext = context;
    }
    @Override
    public MenuRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.menu_list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuRecyclerView.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Menu list = mModelList.get(position);

        // Set item views based on your views and data model
        viewHolder.mTitle.setText(list.getName());
        viewHolder.mDesc.setText(list.getDescription());
        viewHolder.mImg.setImageResource(list.getImage());
        viewHolder.mCategory.setText(list.getmenuQty());
    }
    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitle;
        private TextView mDesc;
        private ImageView mImg;
        private  TextView mCategory;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mDesc = (TextView) itemView.findViewById(R.id.description);
            mImg = (ImageView) itemView.findViewById(R.id.play_eq);
            mCategory = (TextView) itemView.findViewById(R.id.countCategory);
        }
    }

}
