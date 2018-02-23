package food.restaurant.com.tastyfoods.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.Model.PaymentOption;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/12/2018.
 */

public class PaymentOptionAdapter extends ArrayAdapter<PaymentOption> {
    private Activity mActivity;
    private ArrayList<PaymentOption> mItems;

    public PaymentOptionAdapter(Activity context, ArrayList<PaymentOption> address) {
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
        PaymentOption paymentOption = mItems.get(position);
        convertView =  LayoutInflater.from(mActivity)
                .inflate(R.layout.payment_item, parent, false);

        ViewHolder viewHolder=new ViewHolder();
        viewHolder.mTitle=(TextView)  convertView.findViewById(R.id.payment_text);
        viewHolder.mIcon=(ImageView)  convertView.findViewById(R.id.payment_icon);
        viewHolder.mIcon.setImageResource(paymentOption.getIcon());
        viewHolder.mTitle.setText(paymentOption.getAddress());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        PaymentOption paymentOption = mItems.get(position);
        convertView =  LayoutInflater.from(mActivity)
                .inflate(R.layout.payment_item, parent, false);

        ViewHolder viewHolder=new ViewHolder();
        viewHolder.mTitle=(TextView)  convertView.findViewById(R.id.payment_text);
        viewHolder.mIcon=(ImageView)  convertView.findViewById(R.id.payment_icon);
        viewHolder.mIcon.setImageResource(paymentOption.getIcon());
        viewHolder.mTitle.setText(paymentOption.getAddress());
        return convertView;
    }
    private static class ViewHolder {
        private TextView mTitle;
        private ImageView mIcon;
    }
}
