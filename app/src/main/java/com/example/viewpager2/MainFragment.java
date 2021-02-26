package com.example.viewpager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment extends Fragment{
    ViewPager2 viewPager2;
    Button mButton;
    int position;
    public static MainFragment newInstance(ViewPager2 mViewPager, int position) {
        MainFragment fragment = new MainFragment();
        fragment.viewPager2 = mViewPager;
        fragment.position = position;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //add to tablayout
        TabLayout tabLayout = getActivity().findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText("I am  " + (position + 1))
        ).attach();
        //assign response to button onclick
        mButton = view.findViewById(R.id.button_pressme);
        //set text to the current fragment's position number
        mButton.setText("Press Me "+position);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"toasty"+position, Toast.LENGTH_LONG).show();
            }
        });
        System.out.println("Testing: I created a new fragment"+position);
    }
}
