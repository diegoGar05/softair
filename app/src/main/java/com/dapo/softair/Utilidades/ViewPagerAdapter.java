package com.dapo.softair.Utilidades;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.dapo.softair.Cronograma;
import com.dapo.softair.Inicio;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return  new Inicio();
            case 1: return  new Cronograma();
            default: return new Inicio();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
