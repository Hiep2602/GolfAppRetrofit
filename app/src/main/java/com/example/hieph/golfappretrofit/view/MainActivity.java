package com.example.hieph.golfappretrofit.view;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import com.example.hieph.golfappretrofit.R;


import com.example.hieph.golfappretrofit.view.fragment.course.FragmentCourse;
import com.example.hieph.golfappretrofit.view.fragment.discovery.FragmentDiscovery;
import com.example.hieph.golfappretrofit.view.fragment.notifications.FragmentNotifications;
import com.example.hieph.golfappretrofit.view.fragment.profile.FragmentProfile;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FragmentPager fragmentPager;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentPager = new FragmentPager(getSupportFragmentManager());
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(fragmentPager);
        tabLayout.setupWithViewPager(viewPager);
        Icontab();
    }
    private void Icontab(){
        tabLayout.getTabAt(0).setIcon(R.drawable.course_tabbar_s_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.discovery_tabbar_n_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.notification_tabbar_n_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.profile_tabbar_n_icon);
        tabLayout.setSelectedTabIndicatorHeight(0);
        tabLayout.setTabTextColors(Color.parseColor("#637282"),Color.parseColor("#637282"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.colorPrimary);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.colorAccent);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



    class FragmentPager extends FragmentPagerAdapter{
        public FragmentPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new FragmentCourse();
            }else if (position == 1){
                return new FragmentDiscovery();
            }else if (position == 2){
                return new FragmentNotifications();
            }else if (position == 3){
                return new FragmentProfile();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "course";
                case 1:
                    return "discovery";
                case 2:
                    return "notifications";
                case 3:
                    return "profile";
            }
            return super.getPageTitle(position);
        }
    }
}

