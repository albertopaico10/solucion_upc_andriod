package com.upc.ojociudadano.activity.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.upc.ojociudadano.activity.R;
import com.upc.ojociudadano.activity.common.BaseActivity;
import com.upc.ojociudadano.activity.ui.PublicActivity;
import com.upc.ojociudadano.activity.ui.register.RegisterComplaintActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by apaico on 01/09/16.
 */
public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.nav_view)
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_toolbar_private);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
        //TODO: Replace this temp logic to show the IntroFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_content_private, IntroFragment.newInstance()).commit();

        setupDrawerContent(navView);

    }

    private void setupDrawerContent(NavigationView navView) {
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });

    }

    private void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_denunce:
                startActivity(RegisterComplaintActivity.makeIntent(HomeActivity.this));
                break;
            case R.id.nav_my_denunce:
                Toast.makeText(HomeActivity.this,"Mis Datos - Pending", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_my_profile:
                Toast.makeText(HomeActivity.this,"Mis Datos - Pending", Toast.LENGTH_LONG).show();
               break;
            case R.id.nav_recomendation:
                Toast.makeText(HomeActivity.this,"Recomendaciones - Pending", Toast.LENGTH_LONG).show();
                break;
            default:
                startActivity(PublicActivity.makeIntent(HomeActivity.this));
        }
    }

    public static Intent makeIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
