package space.lala.nyxfarmshop.data.fragments;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ReportFragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Objects;

import space.lala.nyxfarmshop.R;

public class LoginFragment extends Fragment {

    private EditText editTextNumber;
    private EditText editTextPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        editTextNumber = view.findViewById(R.id.usernumber);
        editTextPassword = view.findViewById(R.id.password);
        Button button = (Button) view.findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = editTextNumber.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                if (!number.isEmpty() && !password.isEmpty()) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                    Fragment fragProfile = new ProfileFragment();
//                    activity.getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.fragment_container, fragProfile, "findThisFragment")
//                            .addToBackStack(null)
//                            .commit();
                    InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextPassword.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    startAnimationProgressBar();
                } else {
                    Toast toast = Toast.makeText(getContext(), "Заполните все поля", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER, 0, 100);
                    toast.show();
                }
            }
        });
        return view;
    }

    private void startAnimationProgressBar() {
        ProgressBar progressBar = Objects.requireNonNull(getView()).findViewById(R.id.loading);
        @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = getResources().getDrawable(R.drawable.custom_progress);
progressBar.setProgressDrawable(drawable);
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", 100);
        progressAnimator.setDuration(10000);
        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.start();
    }
}


