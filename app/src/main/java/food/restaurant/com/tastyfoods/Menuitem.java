package food.restaurant.com.tastyfoods;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

import food.restaurant.com.tastyfoods.Adapter.MenuRecyclerView;
import food.restaurant.com.tastyfoods.Adapter.MenuitemAdapter;
import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.Model.MenuItem;

/**
 * Created by Design-4 on 2/26/2018.
 */

public class Menuitem extends AppCompatActivity{

    Toolbar toolbar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.toolbar_back_button);

        ActionBar actionBar = getSupportActionBar(); // support.v7
        actionBar.setTitle("");
        TextView toolbar_title=(TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setText(getIntent().getStringExtra("category"));


        ArrayList<MenuItem> users = new ArrayList<MenuItem>();
        users.add(new MenuItem("Qdoba Kids Meal","Guacamole, Tortilla Soup","$10.3",R.drawable.menu_01));
        users.add(new MenuItem("Qdoba Kids Meal","Palace Classic Burger (Beef),Bobby Blue Burger (Beef)","$16.3",R.drawable.menu_02));
        users.add(new MenuItem("Qdoba Kids Meal","Kids Burrito Bowl, Kids Quesadilla","$12.3",R.drawable.menu_04));
        users.add(new MenuItem("Qdoba Kids Meal","Kids Quesadilla, Kids Taco","$20.4",R.drawable.menu_03));
        users.add(new MenuItem("Qdoba Kids Meal","Grilled Chicken, Grilled Steak","$12.3",R.drawable.menu_05));


        MenuitemAdapter adapter = new MenuitemAdapter(this, users);

        RecyclerView listView = (RecyclerView) findViewById(R.id.list_view);
        listView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager   mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listView.setLayoutManager(mLayoutManager);
        listView.setAdapter(adapter);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Lato-Regular.ttf", true);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
