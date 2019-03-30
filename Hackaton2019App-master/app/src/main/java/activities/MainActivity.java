package activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import fragments.ProblemsFragment;
import com.example.hackaton2019.R;
import fragments.SectionsPageAdapter;
import fragments.SolvedFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextView test;
    private SectionsPageAdapter sectionsPageAdapter;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intentMaps = new Intent(MainActivity.this, CreateActivity.class);
                    startActivity(intentMaps);
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
        });

        FloatingActionButton fab_Maps = (FloatingActionButton) findViewById(R.id.fab_maps);
        fab_Maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intentMaps = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intentMaps);
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProblemsFragment(), "Problemy");
        adapter.addFragment(new SolvedFragment(), "Rozwiązane");
        viewPager.setAdapter(adapter);
    }

}

