package food.restaurant.com.tastyfoods.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import food.restaurant.com.tastyfoods.Model.AddressList;
import food.restaurant.com.tastyfoods.Model.Comment;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/17/2018.
 */

public class AddressAdapter   extends RecyclerView.Adapter<AddressAdapter.ViewHolder>  {
    private ArrayList<AddressList> mModelList;
    private Context mContext;

    public AddressAdapter(Context context, ArrayList<AddressList> list) {
        mModelList = list;
        mContext = context;
    }
    @Override
    public AddressAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.address_list_item, parent, false);

        // Return a new holder instance
        AddressAdapter.ViewHolder viewHolder = new AddressAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AddressAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        AddressList list = mModelList.get(position);
        // Set item views based on your views and data model
        viewHolder.mAddress.setText(list.getmTitle());
        viewHolder.mSubAddress.setText(list.getmAddress());
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mAddress;
        private TextView mSubAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            mAddress = (TextView) itemView.findViewById(R.id.textViewaddress);
            mSubAddress = (TextView) itemView.findViewById(R.id.textViewsubtitle);
        }
    }
}
