package com.example.viewpager2;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class CubeOutTransformer implements ViewPager2.PageTransformer {
//https://www.loginworks.com/blogs/how-to-make-awesome-transition-effects-using-pagetransformer-in-android/

    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setPivotX( position < 0f ? page.getWidth() : 0f );
        page.setPivotY( page.getHeight() * 0.5f );
        page.setRotationY( 90f * position );
        MainActivity.mp.start();
    }
}