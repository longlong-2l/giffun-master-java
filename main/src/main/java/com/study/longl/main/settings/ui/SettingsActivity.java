package com.study.longl.main.settings.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.study.longl.main.R;
import com.study.longl.main.common.ui.BaseActivity;

/**
 * App设置界面的主Activity。
 *
 * @author lilong
 * @since 2019/2/1
 */
public class SettingsActivity extends BaseActivity {

    private String INTENT_SETTINGS_TYPE = "intent_settings_type";
    private int MAIN_SETTINGS = 0;
    private int GIF_SETTINGS = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);
        int settingsType = getIntent().getIntExtra(INTENT_SETTINGS_TYPE, MAIN_SETTINGS);
        gotoSettings(settingsType);
    }

    private void gotoSettings(int settingsType) {

        Fragment settingFragment = null;
        switch (settingsType) {
            case 0:
                settingFragment = new MainSettingsFragment();
                break;
//            case 1:
//                break;
        }

        if (settingFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.settingsFragmentLayout, settingFragment).addToBackStack(null).commit();
        }
    }

    public static void actionStart(Activity activity) {
        Intent intent = new Intent(activity, SettingsActivity.class);
        activity.startActivity(intent);
    }

    public void actionStartGIFSettings(Activity activity) {
        Intent intent = new Intent(activity, SettingsActivity.class);
        intent.putExtra(INTENT_SETTINGS_TYPE, GIF_SETTINGS);
        activity.startActivity(intent);
    }
}
