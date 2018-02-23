package food.restaurant.com.tastyfoods.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import food.restaurant.com.tastyfoods.Adapter.MenuRecyclerView;
import food.restaurant.com.tastyfoods.Model.Menu;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/6/2018.
 */

public class MenuFragment extends Fragment{
    View rootView;
    public MenuFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_main, container, false);
        ArrayList<Menu> users = new ArrayList<Menu>();
        users.add(new Menu("Sides","Guacamole, Tortilla Soup",R.drawable.menu_01,"5"));
        users.add(new Menu("Burgers","Palace Classic Burger (Beef),Bobby Blue Burger (Beef)",R.drawable.menu_02,"25"));
        users.add(new Menu("Qdoba Kids Meal","Kids Burrito Bowl, Kids Quesadilla",R.drawable.menu_04,"17"));
        users.add(new Menu("Qdoba Kids Meal","Kids Quesadilla, Kids Taco",R.drawable.menu_03,"8"));
        users.add(new Menu("Burritos","Grilled Chicken, Grilled Steak",R.drawable.menu_05,"13"));


        MenuRecyclerView adapter = new MenuRecyclerView(getActivity(), users);

        RecyclerView listView = (RecyclerView) rootView.findViewById(R.id.list_view);
        listView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager   mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        listView.setLayoutManager(mLayoutManager);
        listView.setAdapter(adapter);

        return rootView;
    }
}
