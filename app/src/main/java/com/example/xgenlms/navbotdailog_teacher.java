package com.example.xgenlms;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class navbotdailog_teacher extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbotdailog_teacher);

        // Initialize Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout);

        // Set up ActionBarDrawerToggle for the DrawerLayout
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Initialize NavigationView
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        // Initialize BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onBottomNavigationItemSelected);

        // Load default fragment
        if (savedInstanceState == null) {
            loadFragment(new Home_teacher());
        }
    }

    // Handle Bottom Navigation item clicks
    private boolean onBottomNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        if (item.getItemId() == R.id.Home12) {
            fragment = new Home_teacher();
        } else if (item.getItemId() == R.id.myCourses2) {
            fragment = new My_course();
        } else if (item.getItemId() == R.id.attendance_t) {
            fragment = new attendance_teacher();
        } else if (item.getItemId() == R.id.uploadmatrial) {
            fragment = new upload_matrial_teacher();
        }

        if (fragment != null) {
            loadFragment(fragment);
        }

        return true;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    // Handle navigation item clicks
    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();

        if (itemId == R.id.navhome) {
            // Load Home Fragment or Activity
            fragment = new Home_teacher(); // You might want to replace this with the actual Home fragment
        } else if (itemId == R.id.navsettings) {
            // Load Settings Fragment
            fragment = new teacher_settings();
        } else if (itemId == R.id.navabout) {
            // Load About Fragment
            fragment = new teacher_about();
        } else if (itemId == R.id.navlogout) {
            // Handle Logout
            logoutUser();
            return true; // Ensure the drawer closes
        }

        if (fragment != null) {
            loadFragment(fragment);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logoutUser() {
        // Clear SharedPreferences to prevent auto-login
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();  // This clears all saved login data
        editor.apply();

        // Show toast message for successful logout
        Toast.makeText(this, "Logout successful", Toast.LENGTH_SHORT).show();

        // Navigate back to the login screen
        Intent intent = new Intent(navbotdailog_teacher.this, student_login_screen.class);
        startActivity(intent);
        finish();  // Close the current activity to prevent back navigation
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
