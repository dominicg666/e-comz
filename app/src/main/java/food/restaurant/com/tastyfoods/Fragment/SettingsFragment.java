package food.restaurant.com.tastyfoods.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/6/2018.
 */

public class SettingsFragment extends Fragment {
    View rootView;
    private static final String TAG = "";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public SettingsFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_settings, container, false);


        viewPager = (ViewPager) rootView.findViewById(R.id.tab_viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        Calligrapher calligrapher = new Calligrapher(getActivity());
        calligrapher.setFont(getActivity(), "Lato-Regular.ttf", true);

        return rootView;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new MyaddressFragment(), "My Addresses");
        adapter.addFrag(new MyProfileFragment(), "My Profile");
        viewPager.setAdapter(adapter);
    }
    public static  class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
