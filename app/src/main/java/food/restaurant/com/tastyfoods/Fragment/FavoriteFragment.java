package food.restaurant.com.tastyfoods.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import food.restaurant.com.tastyfoods.Adapter.FavoriteRecyclerView;
import food.restaurant.com.tastyfoods.Model.Favorite;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/6/2018.
 */

public class FavoriteFragment extends Fragment {
    View rootView;
    public FavoriteFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_favorite, container, false);
        ArrayList<Favorite> users = new ArrayList<Favorite>();
        users.add(new Favorite("Sides","Guacamole, Tortilla Soup",R.drawable.menu_01,"$28.9"));
        users.add(new Favorite("Burgers","Palace Classic Burger (Beef),Bobby Blue Burger (Beef)",R.drawable.menu_02,"$57.9"));
        users.add(new Favorite("Qdoba Kids Meal","Kids Burrito Bowl, Kids Quesadilla",R.drawable.menu_04,"$18.54"));
        users.add(new Favorite("Qdoba Kids Meal","Kids Quesadilla, Kids Taco",R.drawable.menu_03,"$88.5"));
        users.add(new Favorite("Burritos","Grilled Chicken, Grilled Steak",R.drawable.menu_05,"$55.5"));


        FavoriteRecyclerView adapter = new FavoriteRecyclerView(getActivity(), users);

        RecyclerView listView = (RecyclerView) rootView.findViewById(R.id.list_view);
        RecyclerView.LayoutManager   mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        listView.setLayoutManager(mLayoutManager);
        listView.setAdapter(adapter);

        return rootView;
    }
}
