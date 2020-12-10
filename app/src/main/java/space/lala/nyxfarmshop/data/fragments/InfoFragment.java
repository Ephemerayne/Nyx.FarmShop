package space.lala.nyxfarmshop.data.fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import space.lala.nyxfarmshop.R;

public class InfoFragment extends Fragment {
    TextView numberTextView;

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
                        break;
                    case 1:
                        numberTextView.setText(getString(R.string.spb_number));
                        break;
                    case 2:
                        numberTextView.setText(getString(R.string.kazan_number));
                        break;
                    case 3:
                        numberTextView.setText(getString(R.string.novosibirsk_number));
                        break;
                    case 4:
                        numberTextView.setText(getString(R.string.sochi_number));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    public void onCall(View callView) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("8888"));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) getContext(),
                    new String[]{Manifest.permission.CALL_PHONE},
                    10);
            return;
        } else {
            try {
                startActivity(callIntent);  //call activity and make phone call
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getContext(), "yourActivity is not founded", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
