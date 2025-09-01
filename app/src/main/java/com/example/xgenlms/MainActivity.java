package com.example.xgenlms;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            Intent i = new Intent(MainActivity.this, student_login_screen.class);
            startActivity(i);
            finish();
        }, 4000);
    }
}














//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    private EditText emailField;
//    private EditText passwordField;
//    private CheckBox rememberMeCheckBox;
//    private Button loginButton;
//    private TextView forgotPasswordTextView;
//    private Button googleButton;
//    private Button facebookButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main); // Replace with your XML file name
//
//        // Initialize UI components
//        emailField = findViewById(R.id.editTextTextEmailAddress);
//        passwordField = findViewById(R.id.editTextTextPassword);
//        rememberMeCheckBox = findViewById(R.id.rememberMe);
//        loginButton = findViewById(R.id.loginButton);
//        forgotPasswordTextView = findViewById(R.id.forgotPassword);
//        googleButton = findViewById(R.id.googleButton);
//        facebookButton = findViewById(R.id.facebookButton);
//
//        // Set onClick listener for the login button
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                performLogin();
//            }
//        });
//
//        // Set onClick listener for the forgot password text
//        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Navigate to Forgot Password Activity
//                Intent intent = new Intent(MainActivity.this, student_login_screen.class);
//                startActivity(intent);
//            }
//        });
//
//        // Set onClick listener for Google login button
//        googleButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle Google login
//                Toast.makeText(MainActivity.this, "Google Login clicked", Toast.LENGTH_SHORT).show();
//                // Implement Google sign-in logic here
//            }
//        });
//
//        // Set onClick listener for Facebook login button
//        facebookButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle Facebook login
//                Toast.makeText(MainActivity.this, "Facebook Login clicked", Toast.LENGTH_SHORT).show();
//                // Implement Facebook sign-in logic here
//            }
//        });
//    }
//
//    private void performLogin() {
//        // Get the input from the EditText fields
//        String email = emailField.getText().toString().trim();
//        String password = passwordField.getText().toString().trim();
//
//        // Validate input
//        if (TextUtils.isEmpty(email)) {
//            emailField.setError("Email is required");
//            emailField.requestFocus();
//            return;
//        }
//
//        if (TextUtils.isEmpty(password)) {
//            passwordField.setError("Password is required");
//            passwordField.requestFocus();
//            return;
//        }
//
//        // TODO: Implement your login logic here (e.g., call your API or authentication service)
//
//        // For demonstration purposes, we just show a success message
//        Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
//
//        // Optionally, navigate to the next activity after successful login
//        // Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//        // startActivity(intent);
//        // finish(); // Finish the current activity
//    }
//}



//<?xml version="1.0" encoding="utf-8"?>
//<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
//xmlns:app="http://schemas.android.com/apk/res-auto"
//xmlns:tools="http://schemas.android.com/tools"
//android:layout_width="match_parent"
//android:layout_height="match_parent"
//android:background="@drawable/background_with_overlay"
//tools:context="MainActivity">
//
//    <ImageView
//android:id="@+id/logoImage"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_marginTop="50dp"
//android:layout_marginLeft="10dp"
//app:layout_constraintTop_toTopOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//android:src="@drawable/ic_logo" />
//
//    <!-- Title TextView next to the logo -->
//    <TextView
//android:id="@+id/logoTitle"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:text="TeleTide"
//android:textSize="24sp"
//android:textColor="#ffffff"
//android:layout_marginStart="16dp"
//app:layout_constraintStart_toEndOf="@id/logoImage"
//app:layout_constraintTop_toTopOf="@id/logoImage" />
//
//
//
//    <!-- Title -->
//    <TextView
//android:id="@+id/title"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_marginRight="200dp"
//android:text="Get Started now"
//android:textSize="24sp"
//android:textColor="#ffffff"
//android:layout_marginTop="20dp"
//app:layout_constraintTop_toBottomOf="@+id/logoImage"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintEnd_toEndOf="parent"
//tools:ignore="DuplicateIds" />
//
//    <!-- Subtitle -->
//    <TextView
//android:id="@+id/subtitle"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_marginRight="50dp"
//android:text="Create an account or log in to explore about our app"
//android:textSize="14sp"
//android:textColor="#ffffff"
//android:layout_marginTop="10dp"
//app:layout_constraintTop_toBottomOf="@+id/title"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintEnd_toEndOf="parent"
//tools:ignore="DuplicateIds" />
//
//    <!-- LinearLayout for Input Fields and Buttons -->
//    <LinearLayout
//android:layout_width="match_parent"
//android:layout_height="0dp"
//android:layout_marginTop="95dp"
//android:orientation="vertical"
//android:padding="16dp"
//app:layout_constraintBottom_toBottomOf="parent"
//app:layout_constraintTop_toBottomOf="@+id/subtitle"
//app:layout_constraintVertical_bias="1.0"
//tools:layout_editor_absoluteX="16dp">
//
//        <!-- Email Input Field -->
//
//        <!-- Password Input Field -->
//        <EditText
//android:id="@+id/editTextTextEmailAddress"
//android:layout_width="match_parent"
//android:layout_height="57dp"
//android:layout_marginTop="16dp"
//android:layout_gravity="center"
//android:background="@drawable/edittext"
//android:drawableStart="@drawable/mail"
//android:drawablePadding="15dp"
//android:elevation="5dp"
//android:hint="Email"
//android:inputType="textEmailAddress"
//android:paddingStart="15dp"
//app:layout_constraintEnd_toEndOf="@+id/textView"
//app:layout_constraintStart_toStartOf="@+id/textView"
//app:layout_constraintTop_toBottomOf="@+id/textView" />
//
//        <EditText
//android:id="@+id/editTextTextPassword"
//android:layout_width="match_parent"
//android:layout_height="57dp"
//android:layout_gravity="center"
//android:layout_marginTop="16dp"
//android:background="@drawable/edittext"
//android:drawableStart="@drawable/lock"
//android:drawableEnd="@drawable/ic_eye_closed"
//android:drawablePadding="15dp"
//android:elevation="5dp"
//android:hint="Password"
//android:inputType="textPassword"
//android:paddingStart="15dp"
//android:paddingEnd="15dp"
//app:layout_constraintEnd_toEndOf="@+id/editTextTextEmailAddress"
//app:layout_constraintStart_toStartOf="@+id/editTextTextEmailAddress"
//app:layout_constraintTop_toBottomOf="@+id/editTextTextEmailAddress" />
//
//        <!-- Remember Me and Forgot Password Layout -->
//        <LinearLayout
//android:layout_width="match_parent"
//android:layout_height="wrap_content"
//android:layout_marginTop="10dp"
//android:gravity="center_vertical"
//android:orientation="horizontal">
//
//            <!-- Remember Me Checkbox -->
//            <CheckBox
//android:id="@+id/rememberMe"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:text="Remember me" />
//
//            <!-- Spacer -->
//            <View
//android:layout_width="0dp"
//android:layout_height="0dp"
//android:layout_weight="1" />
//
//            <!-- Forgot Password Text -->
//            <TextView
//android:id="@+id/forgotPassword"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:text="Forgot Password?"
//android:textColor="#CA96FF" />
//        </LinearLayout>
//
//        <!-- Login Button -->
//        <Button
//android:id="@+id/loginButton"
//android:layout_width="match_parent"
//android:layout_height="wrap_content"
//android:layout_marginTop="20dp"
//android:backgroundTint="#CA96FF"
//android:text="Log In"
//android:textColor="#ffffff" />
//
//        <!-- Or Divider -->
//        <TextView
//android:id="@+id/orDivider"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_gravity="center"
//android:layout_marginTop="20dp"
//android:gravity="center"
//android:text="Or"
//android:textColor="#888888" />
//
//        <!-- Google Login Button -->
//        <androidx.appcompat.widget.AppCompatButton
//android:id="@+id/googleButton"
//android:layout_width="match_parent"
//android:layout_height="wrap_content"
//android:layout_marginTop="10dp"
//android:backgroundTint="#ffffff"
//android:drawableStart="@drawable/google1"
//android:text="Continue with Google"
//android:background="@drawable/edittext"
//android:textColor="#000000"
//tools:ignore="VisualLintButtonSize" />
//
//        <!-- Facebook Login Button -->
//        <androidx.appcompat.widget.AppCompatButton
//android:id="@+id/facebookButton"
//android:layout_width="match_parent"
//android:layout_height="wrap_content"
//android:layout_marginTop="10dp"
//android:backgroundTint="#ffffff"
//android:background="@drawable/edittext"
//android:drawableStart="@drawable/facebook"
//android:text="Continue with Facebook"
//android:textColor="#000000"
//tools:ignore="VisualLintButtonSize" />
//    </LinearLayout>
//
//</androidx.constraintlayout.widget.ConstraintLayout>































//----------------------------------------------------------



//<?xml version="1.0" encoding="utf-8"?>
//<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
//xmlns:app="http://schemas.android.com/apk/res-auto"
//xmlns:tools="http://schemas.android.com/tools"
//android:id="@+id/main"
//android:background="#000000"
//android:layout_width="match_parent"
//android:layout_height="match_parent"
//tools:context=".MainActivity">
//
//    <!-- Replace LottieAnimationView with ImageView -->
//    <ImageView
//android:id="@+id/gifImageView"
//android:layout_width="173dp"
//android:layout_height="251dp"
//android:layout_marginTop="264dp"
//android:scaleType="centerCrop"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toTopOf="parent" />
//
//</androidx.constraintlayout.widget.ConstraintLayout>



//package com.example.xgenlms;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.widget.ImageView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.bumptech.glide.Glide;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Find ImageView by ID
//        ImageView gifImageView = findViewById(R.id.gifImageView);
//
//        // Use Glide to load and display the GIF
//        Glide.with(this)
//                .asGif()
//                .load(R.raw.teletide)  // replace 'your_gif_file' with the actual GIF name in res/raw
//                .into(gifImageView);
//
//        // Use Handler to delay moving to the next screen
//        Handler handler = new Handler(Looper.getMainLooper());
//        handler.postDelayed(() -> {
//            Intent i = new Intent(MainActivity.this, student_login_screen.class);
//            startActivity(i);
//            finish();
//        }, 4000); // 4 seconds delay
//    }
//}
//
//
