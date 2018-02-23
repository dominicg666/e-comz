package food.restaurant.com.tastyfoods.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.Model.Address;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/12/2018.
 */

public class WrapAdapter extends ArrayAdapter<Address> {
    private Activity mActivity;
    private ArrayList<Address> mItems;

    public WrapAdapter(Activity context, ArrayList<Address> address) {
        super(context, 0, address);
        this.mActivity = context;
        this.mItems = address;
        Calligrapher calligrapher = new Calligrapher(context);
        calligrapher.setFont(mActivity, "Lato-Regular.ttf", true);
    }
    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Address address = mItems.get(position);
        ViewHolder viewHolder=new ViewHolder();
        convertView =  LayoutInflater.from(mActivity)
                .inflate(R.layout.address_spinner_item, parent, false);
        viewHolder.mTitle=(TextView)  convertView.findViewById(R.id.address_text);
        viewHolder.mTitle.setText(address.getAddress());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Address address = mItems.get(position);
        ViewHolder viewHolder=new ViewHolder();
        convertView =  LayoutInflater.from(mActivity)
                .inflate(R.layout.address_spinner_item, parent, false);
        viewHolder.mTitle=(TextView)  convertView.findViewById(R.id.address_text);
        viewHolder.mTitle.setText(address.getAddress());
        return convertView;
    }
    private static class ViewHolder {
        private TextView mTitle;
    }
}
