package space.lala.nyxfarmshop;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import space.lala.nyxfarmshop.data.fragments.BasketFragment;
import space.lala.nyxfarmshop.data.fragments.InfoFragment;
import space.lala.nyxfarmshop.data.fragments.MarketFragment;
import space.lala.nyxfarmshop.data.fragments.MenuFragment;
import space.lala.nyxfarmshop.data.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_NyxFarmShop);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        openFragment(new MarketFragment());
        bottomNavigation.setItemIconTintList(null);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_1:
                        openFragment(new MarketFragment());
                        break;
                    case R.id.item_2:
                        openFragment(new MenuFragment());
                        break;
                    case R.id.item_3:
                        openFragment(new BasketFragment());
                        break;
                    case R.id.item_4:
                        openFragment(new InfoFragment());
                        break;
                    case R.id.item_5:
                        openFragment(new LoginFragment());
                        break;
                }
                updateNavigationBarState(item.getItemId());
                return true;
            }
        });

    }

    private void updateNavigationBarState(int actionId){
        Menu menu = bottomNavigation.getMenu();

        for (int i = 0, size = menu.size(); i < size; i++) {
            MenuItem item = menu.getItem(i);
            item.setChecked(item.getItemId() == actionId);
        }
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
