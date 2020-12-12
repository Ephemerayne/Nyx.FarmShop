package space.lala.nyxfarmshop.data.fragments;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.resources.MaterialResources;

import java.util.ArrayList;
import java.util.Objects;

import space.lala.nyxfarmshop.R;

public class LoginFragment extends Fragment {

    private EditText editTextNumber;
    private EditText editTextPassword;
    private ImageView imageViewProgressBar;

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
        ArrayList<Integer> imagesAnimation = new ArrayList<>();
        imagesAnimation.add(R.drawable.png_1);
        imagesAnimation.add(R.drawable.png_2);
        imagesAnimation.add(R.drawable.png_3);
        imagesAnimation.add(R.drawable.png_4);
        imagesAnimation.add(R.drawable.png_5);
        imagesAnimation.add(R.drawable.png_6);
        imagesAnimation.add(R.drawable.png_7);
        imagesAnimation.add(R.drawable.png_8);
        imagesAnimation.add(R.drawable.png_9);
        imagesAnimation.add(R.drawable.png_10);
        imagesAnimation.add(R.drawable.png_11);
        imagesAnimation.add(R.drawable.png_12);
        imageViewProgressBar = view.findViewById(R.id.loading);
        Button button = (Button) view.findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (editTextNumber.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()) {
//                    return;
//                }
               button.setEnabled(false);

                String number = editTextNumber.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                if (!number.isEmpty() && !password.isEmpty()) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();

                    //HIDE KEYBOARD
                    InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextPassword.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    //ANIMATION LOOP RUN
                    Handler handler = new Handler();
                    Runnable runnable = new Runnable() {
                        int i = 0;

                        @Override
                        public void run() {
                            System.out.println("debug: iteration: " + i);
                            imageViewProgressBar.setImageDrawable(getResources().getDrawable(imagesAnimation.get(i)));

                            i++;
                            if (i > imagesAnimation.size() - 1) {
                                Fragment fragProfile = new ProfileFragment();
                                activity.getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.fragment_container, fragProfile, "findThisFragment")
                                        .addToBackStack(null)
                                        .commit();
                                return;
                            }
                            handler.postDelayed(this, 100);
                        }
                    };
                    handler.postDelayed(runnable, 100);
                } else {
                    Toast toast = Toast.makeText(getContext(), "Заполните все поля", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 0, 600);
                    toast.show();
                }
            }
        });
        return view;
    }
}


