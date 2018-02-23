package food.restaurant.com.tastyfoods;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import food.restaurant.com.tastyfoods.Adapter.PaymentOptionAdapter;
import food.restaurant.com.tastyfoods.Adapter.WrapAdapter;
import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.Model.Address;
import food.restaurant.com.tastyfoods.Model.PaymentOption;
import food.restaurant.com.tastyfoods.Utils.AddressBottomsheet;

/**
 * Created by Design-4 on 2/12/2018.
 */

public class CheckoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.app_bar_header_custom);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.toolbar_back_button);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActionBar actionBar = getSupportActionBar(); // support.v7
        actionBar.setTitle("Ordering");

        ArrayList<Address> address=new ArrayList<Address>();
        address.add(new Address("India,Pennasylavya, 8129 Cherry, Street Rosevilla"));
        address.add(new Address("USA,Pennasylavya, 8129 Cherry, Street Rosevilla"));
        address.add(new Address("China,Pennasylavya, 8129 Cherry, Street Rosevilla"));

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setAdapter(new WrapAdapter(this, address));

        ArrayList<PaymentOption> payment_data=new ArrayList<PaymentOption>();
        payment_data.add(new PaymentOption("Card Payment",R.mipmap.ic_payment_online));
        payment_data.add(new PaymentOption("Cash on delivery",R.mipmap.ic_payment_cod));

        Spinner payment = (Spinner) findViewById(R.id.spinner2);
        payment.setAdapter(new PaymentOptionAdapter(this, payment_data));

        ArrayList<PaymentOption> order_type=new ArrayList<PaymentOption>();
        order_type.add(new PaymentOption("Delivery",R.mipmap.ic_delivery));
        order_type.add(new PaymentOption("Pickup",R.mipmap.ic_pickup));

        Spinner order_item = (Spinner) findViewById(R.id.spinner_order);
        order_item.setAdapter(new PaymentOptionAdapter(this, order_type));

        Button add_new_address=(Button) findViewById(R.id.add_new_address);
        add_new_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AddressBottomsheet bottomSheetDialogFragment = new AddressBottomsheet();
//                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                Intent intent =new Intent(CheckoutActivity.this,AddAddress.class);
                startActivity(intent);
            }
        });

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Lato-Regular.ttf", true);




    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
