package com.study.longl.opensource;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.study.longl.main.init.ui.SplashActivity;

public class OpenSourceSplashActivity extends SplashActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logoView = findViewById(R.id.logo);
    }
}
