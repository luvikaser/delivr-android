package nhutlm.lamodafashion.ui.main;


import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.ui.promotions.core.PromotionsView;

/**
 * Created by Luvi Kaser on 5/23/2017.
 */

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;

    private int[] mTabsIcons = {
            R.drawable.favor,
            R.drawable.search,
            R.drawable.add,
            R.drawable.notification,
            R.drawable.info};
    private int[] mTabsIcons_selected = {
            R.drawable.favor_filled,
            R.drawable.search_filled,
            R.drawable.add_filled,
            R.drawable.notification_filled,
            R.drawable.info_filled};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup the viewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        if (viewPager != null)
            viewPager.setAdapter(pagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        if (mTabLayout != null) {
            mTabLayout.setupWithViewPager(viewPager);

            for (int i = 0; i < mTabLayout.getTabCount(); i++) {
                TabLayout.Tab tab = mTabLayout.getTabAt(i);
                if (tab != null)
                    tab.setCustomView(pagerAdapter.getTabView(i));
            }
            mTabLayout.getTabAt(2).select();
        }

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ((ImageView)view.findViewById(R.id.icon)).setImageResource(mTabsIcons_selected[tab.getPosition()]);
                tab.setCustomView(view);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ((ImageView)view.findViewById(R.id.icon)).setImageResource(mTabsIcons[tab.getPosition()]);
                tab.setCustomView(view);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public final int PAGE_COUNT = 5;

        private final String[] mTabsTitle = {"Favorites", "Search", "Add", "Notification", "Info"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public View getTabView(int position) {
            View view = null;
            if (position != 2) {
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_tab1, null);
                ImageView icon = (ImageView) view.findViewById(R.id.icon);
                icon.setImageResource(mTabsIcons[position]);
            } else{
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_tab2, null);
                ImageView icon = (ImageView) view.findViewById(R.id.icon);
                icon.setImageResource(mTabsIcons_selected[position]);
            }

            return view;
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {
                case 0:
                    return PromotionsView.newInstance(new PromotionsView(), null);
                case 1:
                    return PromotionsView.newInstance(new PromotionsView(), null);
                case 2:
                    return PromotionsView.newInstance(new PromotionsView(), null);
                case 3:
                    return PromotionsView.newInstance(new PromotionsView(), null);
                case 4:
                    return PromotionsView.newInstance(new PromotionsView(), null);
            }
            return null;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabsTitle[position];
        }
    }
}
