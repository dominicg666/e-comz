package food.restaurant.com.tastyfoods.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import food.restaurant.com.tastyfoods.Adapter.AddressAdapter;
import food.restaurant.com.tastyfoods.AddAddress;
import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.Model.AddressList;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/16/2018.
 */

public class MyaddressFragment extends Fragment {
    View rootView;
    //cr end

    public MyaddressFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_address, container, false);

        ArrayList<AddressList> address=new ArrayList<AddressList>();
        address.add(new AddressList("American Consul General","Department of State 5520 Quebec Place Washington, DC 20521-5520"));
        address.add(new AddressList("The Honorable Charles W. Anderson (Dear Mr. Ambassador:)","Department of State 2050 Bamako Place Washington, DC 20521-2050"));


//        CartRecyclerView adapter = new CartRecyclerView(getActivity(), cart);
//        RecyclerView listView = (RecyclerView) rootView.findViewById(R.id.cart_list_view);
//        listView.setNestedScrollingEnabled(false);
//        RecyclerView.LayoutManager   mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        listView.setLayoutManager(mLayoutManager);
//        listView.setAdapter(adapter);
        AddressAdapter adapter = new AddressAdapter(getContext(), address);
        RecyclerView listView = (RecyclerView) rootView.findViewById(R.id.list_view);
        RecyclerView.LayoutManager   mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        listView.setLayoutManager(mLayoutManager);
        listView.setAdapter(adapter);

        CardView add_new_address=(CardView) rootView.findViewById(R.id.bottomCard);
        add_new_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AddressBottomsheet bottomSheetDialogFragment = new AddressBottomsheet();
//                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                Intent intent =new Intent(getActivity(),AddAddress.class);
                startActivity(intent);
            }
        });



        Calligrapher calligrapher = new Calligrapher(getActivity());
        calligrapher.setFont(getActivity(), "Lato-Regular.ttf", true);
        return rootView;
    }
}
