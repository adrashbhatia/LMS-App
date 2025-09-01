package com.example.xgenlms;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

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

public class Navbotdailog extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbotdailog);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("XLMS");  // Clear the title
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            replaceFragment(new HomeFragment());
            navigationView.setCheckedItem(R.id.navhome);
        }

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.navhome) {
                replaceFragment(new HomeFragment());
            } else if (id == R.id.navsettings) {
                replaceFragment(new SettingsFragment());
            } else if (id == R.id.navabout) {
                replaceFragment(new AboutFragment());
            } else if (id == R.id.navlogout) {
                logoutUser();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.Home1) {
                replaceFragment(new HomeFragment());
                return true;
            } else if (item.getItemId() == R.id.Courses2) {
                replaceFragment(new CoursesFragment());
                return true;
            } else if (item.getItemId() == R.id.Notifications3) {
                replaceFragment(new NotificationsFragment());
                return true;
            } else if (item.getItemId() == R.id.Queries) {
                replaceFragment(new QueryFragment());
                return true;
            } else if (item.getItemId() == R.id.add_button) {
                showBottomDialog();
                return true;
            } else {
                return false;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }

    private void showBottomDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout videoLayout = dialog.findViewById(R.id.layoutVideo);
        LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
        LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);

        videoLayout.setOnClickListener(v -> {
            dialog.dismiss();
            Toast.makeText(Navbotdailog.this, "View Attendance is clicked", Toast.LENGTH_SHORT).show();
            replaceFragment(new AttendanceFragment());
        });

        shortsLayout.setOnClickListener(v -> {
            dialog.dismiss();
            Toast.makeText(Navbotdailog.this, "View Grades is clicked", Toast.LENGTH_SHORT).show();
            replaceFragment(new GradesFragment());
        });

        liveLayout.setOnClickListener(v -> {
            dialog.dismiss();
            Toast.makeText(Navbotdailog.this, "Download Materials is clicked", Toast.LENGTH_SHORT).show();
            replaceFragment(new DownloadMaterialsFragment());
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    // In your logout method
    private void logoutUser() {
        // Clear SharedPreferences to prevent auto-login
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();  // This clears all saved login data
        editor.apply();

        // Show toast message for successful logout
        Toast.makeText(this, "Logout successful", Toast.LENGTH_SHORT).show();
        // Navigate back to the login screen
        Intent intent = new Intent(Navbotdailog.this, student_login_screen.class);
        startActivity(intent);
        finish();  // Close the current activity to prevent back navigation
    }
}

