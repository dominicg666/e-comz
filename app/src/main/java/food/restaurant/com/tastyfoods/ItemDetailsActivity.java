package food.restaurant.com.tastyfoods;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import food.restaurant.com.tastyfoods.Adapter.CommentAdapter;
import food.restaurant.com.tastyfoods.Adapter.SliderAdapter;
import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.Model.Comment;
import food.restaurant.com.tastyfoods.Model.Slider;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Design-4 on 2/9/2018.
 */

public class ItemDetailsActivity extends AppCompatActivity {

    Toolbar toolbar = null;
    TextView textCartItemCount;
    int mCartItemCount = 3;

    private static ViewPager mPager;
    private static CircleIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.toolbar_back_button);

        ActionBar actionBar = getSupportActionBar(); // support.v7
        actionBar.setTitle("");
        TextView toolbar_title=(TextView) findViewById(R.id.toolbar_title);

        mPager = (ViewPager) findViewById(R.id.pager);
        indicator = (CircleIndicator) findViewById(R.id.indicator);

        ArrayList<Slider> slider = new ArrayList<Slider>();
        slider.add(new Slider(R.drawable.menu_01));
        slider.add(new Slider(R.drawable.menu_03));
        slider.add(new Slider(R.drawable.menu_05));
        mPager.setAdapter(new SliderAdapter(getApplicationContext(),slider));
        indicator.setViewPager(mPager);


        ArrayList<Comment> comments = new ArrayList<Comment>();
        comments.add(new Comment(R.drawable.comment_user02,"Amy Jackson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        comments.add(new Comment(R.drawable.comment_user01,"Emma Watson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        comments.add(new Comment(R.drawable.comment_user02,"Amy Jackson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        comments.add(new Comment(R.drawable.comment_user01,"Emma Watson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        comments.add(new Comment(R.drawable.comment_user02,"Amy Jackson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        comments.add(new Comment(R.drawable.comment_user01,"Emma Watson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        comments.add(new Comment(R.drawable.comment_user02,"Amy Jackson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        comments.add(new Comment(R.drawable.comment_user01,"Emma Watson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        comments.add(new Comment(R.drawable.comment_user02,"Amy Jackson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        comments.add(new Comment(R.drawable.comment_user01,"Emma Watson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        comments.add(new Comment(R.drawable.comment_user02,"Amy Jackson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        comments.add(new Comment(R.drawable.comment_user01,"Emma Watson","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));

        CommentAdapter adapter = new CommentAdapter(getApplicationContext(), comments);

        RecyclerView listView = (RecyclerView) findViewById(R.id.list_view);
        listView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager   mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //cart topbar
        final MenuItem menuItem = menu.findItem(R.id.action_cart);
        final MenuItem search = menu.findItem(R.id.action_settings);
        final MenuItem logout = menu.findItem(R.id.action_logout);
        logout.setVisible(false);
        search.setVisible(false);

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
            Toast.makeText(this, "#hello"  + " - " , Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
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