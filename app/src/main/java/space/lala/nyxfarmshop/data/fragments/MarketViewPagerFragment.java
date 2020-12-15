package space.lala.nyxfarmshop.data.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;

import space.lala.nyxfarmshop.R;

public class MarketViewPagerFragment extends Fragment {
    private static final String positionArg = "positionArg";
    private int position;
    ImageView imgMainFirst;

    public static MarketViewPagerFragment newInstance(int position) {
        MarketViewPagerFragment fragment = new MarketViewPagerFragment();
        Bundle args = new Bundle();
        args.putInt(positionArg, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_market_view_pager, container, false);
        imgMainFirst = view.findViewById(R.id.img1);

        if (getArguments() != null) {
           position = getArguments().getInt(positionArg);
        }
        switch (position) {
            case 0:
                imgMainFirst.setImageDrawable(getResources().getDrawable(R.drawable.main_img1));
                break;
            case 1:
                imgMainFirst.setImageDrawable(getResources().getDrawable(R.drawable.main_img2));
                break;
            case 2:
                imgMainFirst.setImageDrawable(getResources().getDrawable(R.drawable.main_img3));
                break;
            case 3:
                imgMainFirst.setImageDrawable(getResources().getDrawable(R.drawable.main_img4));
                break;
            case 4:
                imgMainFirst.setImageDrawable(getResources().getDrawable(R.drawable.item_cucumber));
                break;
        }

        return view;
    }
}