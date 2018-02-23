package food.restaurant.com.tastyfoods;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import food.restaurant.com.tastyfoods.Utils.AddressBottomsheet;
import food.restaurant.com.tastyfoods.Utils.ChoosePhoto;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Design-4 on 2/17/2018.
 */

public class EditProfile extends AppCompatActivity {

    Toolbar toolbar = null;
    TextView textCartItemCount;
    int mCartItemCount = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.toolbar_back_button);

        ActionBar actionBar = getSupportActionBar(); // support.v7
        actionBar.setTitle("");
        TextView toolbar_title=(TextView) findViewById(R.id.toolbar_title);
        init();

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //cart topbar
        final MenuItem menuItem = menu.findItem(R.id.action_cart);
        final MenuItem search = menu.findItem(R.id.action_settings);
        final MenuItem logout = menu.findItem(R.id.action_logout);
        menuItem.setVisible(false);
        search.setVisible(false);
        logout.setVisible(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private  void init(){
        TextView textView10=(TextView) findViewById(R.id.textView10);
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ChoosePhoto bottomSheetDialogFragment = new ChoosePhoto();
                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
            }
        });

        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.linearLayout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
