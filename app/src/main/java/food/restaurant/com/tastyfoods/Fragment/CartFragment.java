package food.restaurant.com.tastyfoods.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import food.restaurant.com.tastyfoods.Adapter.CardListAdapter;
import food.restaurant.com.tastyfoods.CheckoutActivity;
import food.restaurant.com.tastyfoods.Model.Cart;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/6/2018.
 */

public class CartFragment extends Fragment{
    View rootView;
    public CartFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_cart, container, false);
        ArrayList<Cart> cart = new ArrayList<Cart>();
        cart.add(new Cart("Sides","Guacamole, Tortilla Soup",R.drawable.menu_01,1,190));
        cart.add(new Cart("Burgers","Palace Classic Burger (Beef),Bobby Blue Burger (Beef)",R.drawable.menu_02,1,299));
        cart.add(new Cart("Qdoba Kids Meal","Kids Burrito Bowl, Kids Quesadilla",R.drawable.menu_04,3,70));
        cart.add(new Cart("Qdoba Kids Meal","Kids Quesadilla, Kids Taco",R.drawable.menu_03,1,200));
        cart.add(new Cart("Burritos","Grilled Chicken, Grilled Steak",R.drawable.menu_05,1,239));

        TextView priceText = (TextView) rootView.findViewById(R.id.totalPrice);
        TextView emptyCartMessage = (TextView) rootView.findViewById(R.id.emptyCartMessage);
        //cartCountTop.setText("20");

        CardView cardView=(CardView) rootView.findViewById(R.id.bottomCard);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), CheckoutActivity.class);
                startActivity(intent);
            }
        });

//        CartRecyclerView adapter = new CartRecyclerView(getActivity(), cart);
//        RecyclerView listView = (RecyclerView) rootView.findViewById(R.id.cart_list_view);
//        listView.setNestedScrollingEnabled(false);
//        RecyclerView.LayoutManager   mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        listView.setLayoutManager(mLayoutManager);
//        listView.setAdapter(adapter);
        CardListAdapter adapter = new CardListAdapter(getActivity(), cart,priceText,emptyCartMessage,cardView);
        ListView listView = (ListView) rootView.findViewById(R.id.cart_list_view);
        listView.setAdapter(adapter);

        return rootView;
    }
}
