package com.study.longl.main.feeds.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.study.longl.core.GifFun;
import com.study.longl.main.R;
import com.study.longl.main.common.ui.BaseActivity;
import com.study.longl.main.settings.ui.SettingsActivity;

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

    private DrawerLayout drawerLayout;

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
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            long now = System.currentTimeMillis();
            if (now - backPressTime > 2000) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                backPressTime = now;
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
       if(id == R.id.compose){  //发布趣图

       }else if(id == R.id.user_home){  //个人主页

       }else if(id == R.id.recommend_following){  //推荐关注

       }else if(id == R.id.draft){  //草稿箱

       }else if(id == R.id.settings){  //设置
           GifFun.getHandler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   SettingsActivity.actionStart(MainActivity.this);
               }
           },300);
       }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setupViews() {
        setupToolBar();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//        ViewPager viewPager = findViewById(R.id.viewpager);
//        setupViewPager(viewPager);
//        TabLayout tabLayout = findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);
        final NavigationView navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
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
        pagerAdapter = new Adapter(getSupportFragmentManager());
//        pagerAdapter.addFragment();
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

    public static void actionStart(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }
}
