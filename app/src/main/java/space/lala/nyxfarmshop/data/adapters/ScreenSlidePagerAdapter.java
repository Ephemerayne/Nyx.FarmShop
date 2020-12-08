package space.lala.nyxfarmshop.data.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import space.lala.nyxfarmshop.data.fragments.MarketViewPagerFragment;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    private int numPages;
    public ScreenSlidePagerAdapter(Fragment fragment, int numPages){
        super(fragment);
        this.numPages = numPages;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return MarketViewPagerFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return numPages;
    }
}
