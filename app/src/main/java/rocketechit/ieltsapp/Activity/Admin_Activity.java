package rocketechit.ieltsapp.Activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import rocketechit.ieltsapp.Fragment.Add_Question_For_Admin_Home_page;
import rocketechit.ieltsapp.Fragment.Add_Tutor;
import rocketechit.ieltsapp.Fragment.Admin_Home_Page;
import rocketechit.ieltsapp.Fragment.Tutor_question_Request;
import rocketechit.ieltsapp.R;

import android.view.Menu;
import android.view.MenuItem;

public class Admin_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton fab;
    Fragment fragment = null;

    String title = "Home";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        settoolbarTitle(title);
        setSupportActionBar(toolbar);
        fragment = new Admin_Home_Page();
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.show();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragment = new Add_Tutor();

                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                    fragmentTransaction.addToBackStack("");
                    fragmentTransaction.replace(R.id.screen_Area_Admin, fragment);
                    fragmentTransaction.commit();
                }

            }
        });

        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            fragmentTransaction.replace(R.id.screen_Area_Admin, fragment);
            fragmentTransaction.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            fragment = null;
            fragment = new Admin_Home_Page();
        } else if (id == R.id.nav_Add_Question) {
            // Handle the camera action
            fragment = null;
            fragment = new Add_Question_For_Admin_Home_page();
        } else if (id == R.id.nav_Add_Tutor) {

            fragment = null;
            fragment = new Add_Tutor();
        } else if (id == R.id.nav_Tutor_profile) {

            fragment = null;
            fragment = new Tutor_question_Request();

        } else if (id == R.id.nav_Speaking) {

            fragment = null;
//            fragment = new Add_Speaking_Question();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.replace(R.id.screen_Area_Admin, fragment);
            fragmentTransaction.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //set title bar
    public void settoolbarTitle(String title) {
        toolbar.setTitle(title);
    }

    //Show fab icon
    public void showFloatingActionButton() {
        fab.show();
    }

    //Hide fab icon
    public void hideFloatingActionButton() {
        fab.hide();
    }

    @Override
    protected void onPause() {
        super.onPause();
        showFloatingActionButton();
    }
}
