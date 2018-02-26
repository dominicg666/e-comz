package food.restaurant.com.tastyfoods.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import food.restaurant.com.tastyfoods.AddAddress;
import food.restaurant.com.tastyfoods.EditProfile;
import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/6/2018.
 */

public class SettingsFragment extends Fragment {
    public View rootView;
    private static final String TAG = "";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    TextView textView2;
    public SettingsFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_settings, container, false);


        viewPager = (ViewPager) rootView.findViewById(R.id.tab_viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        textView2=(TextView) rootView.findViewById(R.id.textView2);
        textView2.setText("ADD NEW ADDRESS");
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {

                switch (position){
                    case 0:
                        textView2.setText("ADD NEW ADDRESS");
                        break;
                    case 1:
                        textView2.setText("EDIT PROFILE");
                        break;
                    default:
                        textView2.setText("");
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        CardView add_new_address=(CardView) rootView.findViewById(R.id.bottomCard);
              add_new_address.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                AddressBottomsheet bottomSheetDialogFragment = new AddressBottomsheet();
//                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                    if(viewPager.getCurrentItem()==0) {
                        Intent intent = new Intent(getActivity(), AddAddress.class);
                        getActivity().startActivity(intent);
                    }else if(viewPager.getCurrentItem()==1){
                        Intent intent = new Intent(getActivity(), EditProfile.class);
                        getActivity().startActivity(intent);
                    }
                }
            });



        Calligrapher calligrapher = new Calligrapher(getActivity());
        calligrapher.setFont(getActivity(), "Lato-Regular.ttf", true);

        return rootView;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager(),rootView);
        adapter.addFrag(new MyaddressFragment(), "My Addresses","ADD NEW ADDRESS");
        adapter.addFrag(new MyProfileFragment(), "My Profile","EDIT PROFILE");
        viewPager.setAdapter(adapter);
    }
    public static  class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        View mView;
        private final List<String> mbTitle = new ArrayList<>();
        String mTitle;

        public ViewPagerAdapter(FragmentManager manager,View view) {
            super(manager);
            mView=view;

        }

        @Override
        public Fragment getItem(int position) {
            mTitle=mbTitle.get(position);
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title,String bTitle) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
            mbTitle.add(bTitle);
            //textView2.setText(mbTitle);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
