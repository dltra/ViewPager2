package com.example.viewpager2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    ViewPager2 mViewPager;
    RecyclerView.Adapter mMyFragmentStateAdapter;
    final int NUM_ITEMS = 5;
    //https://developer.android.com/training/animation/vp2-migration
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign the instance of ViewPager
        mViewPager = findViewById(R.id.container);

        //create an adapter for the ViewPager
        mMyFragmentStateAdapter = new MyFragmentStateAdapter(this);

        //set the adapter for the ViewPager
        mViewPager.setAdapter(mMyFragmentStateAdapter);
    }
    public class MyFragmentStateAdapter extends FragmentStateAdapter{

        public MyFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }
        @NonNull
        @Override
        public MainFragment createFragment(int position) {
            //return a new instance of MainFragment
            return MainFragment.newInstance(mViewPager,position);
        }
        @Override
        public int getItemCount() {
            return NUM_ITEMS;//number of objects in ViewPager
        }
    }
}