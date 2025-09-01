package com.example.xgenlms;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        // Initialize views
        TextView titleTextView = findViewById(R.id.tv_title); // This is your title in the layout
        EditText oldPasswordEditText = findViewById(R.id.et_old_password);
        EditText newPasswordEditText = findViewById(R.id.et_new_password);
        EditText confirmPasswordEditText = findViewById(R.id.et_confirm_password);
        Button changePasswordButton = findViewById(R.id.btn_change_password);

        // Set title text if needed (optional)
        titleTextView.setText("Update Your Password");

        // Handle password change logic
        changePasswordButton.setOnClickListener(v -> {
            String oldPassword = oldPasswordEditText.getText().toString();
            String newPassword = newPasswordEditText.getText().toString();
            String confirmPassword = confirmPasswordEditText.getText().toString();

            if (newPassword.equals(confirmPassword)) {
                // TODO: Implement password change logic here, such as API call to change password
                Toast.makeText(ChangePasswordActivity.this, "Password changed successfully", Toast.LENGTH_SHORT).show();
                finish(); // Close the activity after success
            } else {
                Toast.makeText(ChangePasswordActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
