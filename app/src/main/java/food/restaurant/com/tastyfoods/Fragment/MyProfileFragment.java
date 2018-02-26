package food.restaurant.com.tastyfoods.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import food.restaurant.com.tastyfoods.AddAddress;
import food.restaurant.com.tastyfoods.EditProfile;
import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/17/2018.
 */

public class MyProfileFragment extends Fragment {
    View rootView;
    Fragment fragment;
    public MyProfileFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_my_profile, container, false);


//        CardView add_new_address=(CardView) rootView.findViewById(R.id.bottomCard);
//        add_new_address.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                AddressBottomsheet bottomSheetDialogFragment = new AddressBottomsheet();
////                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
//                Intent intent =new Intent(getActivity(),EditProfile.class);
//                startActivity(intent);
//            }
//        });
        Calligrapher calligrapher = new Calligrapher(getActivity());
        calligrapher.setFont(getActivity(), "Lato-Regular.ttf", true);
        return rootView;
    }
}
