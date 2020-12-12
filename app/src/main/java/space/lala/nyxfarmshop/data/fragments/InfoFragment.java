package space.lala.nyxfarmshop.data.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import space.lala.nyxfarmshop.R;

public class InfoFragment extends Fragment {
    TextView numberTextView;
    String callNumber = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        Spinner spinner = view.findViewById(R.id.spinner_city);
        numberTextView = view.findViewById(R.id.text_view_callnumber);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        numberTextView.setText(getString(R.string.moscow_number));
                        callNumber = getString(R.string.moscow_number);
                        break;
                    case 1:
                        numberTextView.setText(getString(R.string.spb_number));
                        callNumber = getString(R.string.spb_number);
                        break;
                    case 2:
                        numberTextView.setText(getString(R.string.kazan_number));
                        callNumber = getString(R.string.kazan_number);
                        break;
                    case 3:
                        numberTextView.setText(getString(R.string.novosibirsk_number));
                        callNumber = getString(R.string.novosibirsk_number);
                        break;
                    case 4:
                        numberTextView.setText(getString(R.string.sochi_number));
                        callNumber = getString(R.string.sochi_number);
                        break;
                }
                numberTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showBottomSheetDialog();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void showBottomSheetDialog() {
                FragmentTransaction transaction =
                        getActivity().getSupportFragmentManager().beginTransaction();

                CallBottomSheetFragment.newInstance(callNumber).show(transaction, "tag");

            }
        });

        return view;
    }
}
