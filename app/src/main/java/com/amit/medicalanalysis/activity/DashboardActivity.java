package com.amit.medicalanalysis.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.amit.medicalanalysis.R;
import com.amit.medicalanalysis.fragment.BloodStatsFragment;
import com.amit.medicalanalysis.fragment.DashboardFragment;
import com.amit.medicalanalysis.fragment.HeartBeatFragment;
import com.amit.medicalanalysis.fragment.OxygenStatsFragment;
import com.amit.medicalanalysis.fragment.SugarStatsFragment;
import com.amit.medicalanalysis.fragment.TemperatureStatsFragment;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FrameLayout frameLayout;

    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        frameLayout = (FrameLayout) findViewById(R.id.frame);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        //load default Fragment
         fragmentManager = getSupportFragmentManager();
         fragmentTransaction = fragmentManager.beginTransaction();
         fragmentTransaction.add(R.id.frame, new DashboardFragment());
         fragmentTransaction.commit();


        //myToolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(myToolbar);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.blue));
        toggle.syncState();
    }

    //Toolbarc
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
                builder.setMessage("Do You Want To Log Out ?");
                builder.setCancelable(true);
                builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        finish();
                    }
                });
                builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void bloodMeasure(View view) {
        Intent i = new Intent(getBaseContext(), BloodPressureMeasure.class);
        startActivity(i);
    }

    public void OxygenMeasure(View view) {
        Intent j = new Intent(getBaseContext(), OxygenLevelMeasure.class);
        Log.i("dffjs","yess");
        startActivity(j);
        Log.i("dffjs","yess");

    }

    public void SugarMeasure(View view) {

        Intent i = new Intent(getBaseContext(), SugarLevelMeasure.class);
        startActivity(i);

    }

    public void HeartMeasure(View view) {
        Intent i = new Intent(getBaseContext(), HeartBeatMeasure.class);
        startActivity(i);

    }

    public void TempMeasure(View view) {
        Intent i = new Intent(getBaseContext(), BodyTemperatureMeasure.class);
        startActivity(i);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId() == R.id.heartbeatstats){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, new HeartBeatFragment());
            fragmentTransaction.commit();


        }
        if(item.getItemId() == R.id.bloodPressurestats){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, new BloodStatsFragment());
            fragmentTransaction.commit();

        }
        if(item.getItemId() == R.id.sugarstats){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, new SugarStatsFragment());
            fragmentTransaction.commit();

        }
        if(item.getItemId() == R.id.bodytemperaturestats){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, new TemperatureStatsFragment());
            fragmentTransaction.commit();

        }
        if(item.getItemId() == R.id.oxygenstats){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, new OxygenStatsFragment());
            fragmentTransaction.commit();

        }
        return true;
    }
}