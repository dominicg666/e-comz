package food.restaurant.com.tastyfoods;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.Fragment.CartFragment;
import food.restaurant.com.tastyfoods.Fragment.FavoriteFragment;
import food.restaurant.com.tastyfoods.Fragment.MenuFragment;
import food.restaurant.com.tastyfoods.Fragment.OffersFragment;
import food.restaurant.com.tastyfoods.Fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView textCartItemCount;
    int mCartItemCount = 3;
    NavigationView navigationView = null;
    Toolbar toolbar = null;
    Fragment fragment = null;
    TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set initialize fragment
        initializeFragment(MenuFragment.class);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar(); // support.v7
        actionBar.setTitle("");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Lato-Regular.ttf", true);
        cart();

        //initialize
        toolbar_title=(TextView) findViewById(R.id.toolbar_title);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //cart topbar
        final MenuItem menuItem = menu.findItem(R.id.action_cart);
        final MenuItem logout = menu.findItem(R.id.action_logout);
        logout.setVisible(false);

        View actionView = MenuItemCompat.getActionView(menuItem);
        textCartItemCount = (TextView) actionView.findViewById(R.id.cart_badge);
        setupBadge();

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_cart) {
            initializeFragment(CartFragment.class);
            toolbar_title.setText("My Cart");
            navigationView.getMenu().getItem(2).setChecked(true);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_menu) {

            initializeFragment(MenuFragment.class);
            toolbar_title.setText("Menu");

        } else if (id == R.id.nav_offer) {
            initializeFragment(OffersFragment.class);
            toolbar_title.setText("Offers");
        } else if (id == R.id.nav_cart) {

            initializeFragment(CartFragment.class);
            toolbar_title.setText("My Cart");

        } else if (id == R.id.nav_order) {
            toolbar_title.setText("Orders");

        } else if (id == R.id.nav_settings) {
            initializeFragment(SettingsFragment.class);
            toolbar_title.setText("Settings");

        } else if (id == R.id.nav_fav) {
            initializeFragment(FavoriteFragment.class);
            toolbar_title.setText("Favorite");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void cart(){
        Menu menu = navigationView.getMenu();
        MenuItem nav_login = menu.findItem(R.id.nav_cart);

        setMenuCounter(nav_login.getItemId(),mCartItemCount);
    }
    private void initializeFragment(Class fragmentClass){
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                .replace(R.id.fragment_container, fragment).commit();

    }
    private void setMenuCounter(@IdRes int itemId, int count) {

        TextView view = (TextView) navigationView.getMenu().findItem(itemId).getActionView();
        view.setText(count > 0 ? String.valueOf(count) : null);
    }

    private void setupBadge() {

        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
