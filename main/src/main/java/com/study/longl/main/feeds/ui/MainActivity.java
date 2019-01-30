package com.study.longl.main.feeds.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.longl.main.R;
import com.study.longl.main.common.ui.BaseActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Adapter pagerAdapter;

    private TextView nicknameMe;

    private TextView descriptionMe;

    private ImageView avatarMe;

    private ImageView editImage;

    private float backPressTime = 0L;

    private int currentPagerPosition = 0;

    private boolean inNeedToRefresh = false;

//    private RequestListener<> navHeaderBgLoadListener = new RequestListener()
//

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkIsNeedToRefresh();
        initDatabase();
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void setupViews() {
        setupToolaBar();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        FloatingActionButton floatingActionButton = findViewById(R.id.composeFab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void checkIsNeedToRefresh() {

    }

    private void initDatabase() {

    }

    private void setupViewPager(ViewPager viewPager) {
//pagerAdapter = new Adapter
    }

    class Adapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> mFragment = new ArrayList<>();
        private ArrayList<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragment.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }

        
    }
}
