package space.lala.nyxfarmshop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MarketFragment extends Fragment {

    private static final int NUM_PAGES = 5;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_market, container, false);

        viewPager = view.findViewById(R.id.view_pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this, NUM_PAGES);
        viewPager.setAdapter(pagerAdapter);
        return view;
    }
}