package com.example.android.popularmovie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //pindah fragment
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.layout_untuk_fragment, new PopularFragment())
                    .commit();
                    return true;
                case R.id.navigation_dashboard:
                    //pindah fragment
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.layout_untuk_fragment, new TopRatedFragment())
                            .commit();
                    return true;
                case R.id.navigation_notifications:
                    //pindah fragment
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.layout_untuk_fragment, new FavoriteFragment())
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_untuk_fragment, new PopularFragment())
                .commit();
    }

}
