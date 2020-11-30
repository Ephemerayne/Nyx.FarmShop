package space.lala.nyxfarmshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MarketViewPagerFragment extends Fragment {
    private static final String positionArg = "positionArg";
    private int position;

    TextView positionTextView;

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
        if (getArguments() != null) {
           position = getArguments().getInt(positionArg);
        }

        positionTextView = view.findViewById(R.id.item_position);
        positionTextView.setText("Position: " + position);

        return view;
    }
}