package com.dapo.softair;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dapo.softair.Utilidades.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Miperfil extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager1;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_miperfil, container, false);
    }



}