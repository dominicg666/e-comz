package food.restaurant.com.tastyfoods.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import food.restaurant.com.tastyfoods.Adapter.CardPagerAdapter;
import food.restaurant.com.tastyfoods.Model.CardItem;
import food.restaurant.com.tastyfoods.R;
import food.restaurant.com.tastyfoods.Utils.ShadowTransformer;

/**
 * Created by Design-4 on 2/6/2018.
 */

public class OffersFragment extends Fragment{
    View rootView;
    Fragment fragment;
    CardPagerAdapter mCardAdapter;
    ShadowTransformer mCardShadowTransformer;
    ViewPager mViewPager;
    public OffersFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_offers, container, false);

        mViewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem("Classic double stffed", "Pizza",R.drawable.menu_01,"40%","$40.50"));
        mCardAdapter.addCardItem(new CardItem("Gold double stffed", "Burger",R.drawable.menu_02,"35%","$24.50"));
        mCardAdapter.addCardItem(new CardItem("Silver double stffed", "Pizza",R.drawable.menu_03,"50%","$12.50"));
        mCardAdapter.addCardItem(new CardItem("Classic double stffed", "Burger",R.drawable.menu_05,"20%","$30.50"));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        return rootView;
    }
}
