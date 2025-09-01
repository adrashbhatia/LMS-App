package com.example.xgenlms;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class OTPScreen extends AppCompatActivity {

    private TextView textResendOTP;
    private CountDownTimer countDownTimer;
    private boolean isTimerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_screen);

        EditText inputCode1 = findViewById(R.id.inputcode1);
        EditText inputCode2 = findViewById(R.id.inputcode2);
        EditText inputCode3 = findViewById(R.id.inputcode3);
        EditText inputCode4 = findViewById(R.id.inputcode4);
        EditText inputCode5 = findViewById(R.id.inputcode5);
        EditText inputCode6 = findViewById(R.id.inputcode6);
        textResendOTP = findViewById(R.id.textresendOTP);
        AppCompatButton verifyButton = findViewById(R.id.getotp);

        addTextWatcher(inputCode1, inputCode2, null);
        addTextWatcher(inputCode2, inputCode3, inputCode1);
        addTextWatcher(inputCode3, inputCode4, inputCode2);
        addTextWatcher(inputCode4, inputCode5, inputCode3);
        addTextWatcher(inputCode5, inputCode6, inputCode4);
        addTextWatcher(inputCode6, null, inputCode5);

        setBackspaceListener(inputCode1, null);
        setBackspaceListener(inputCode2, inputCode1);
        setBackspaceListener(inputCode3, inputCode2);
        setBackspaceListener(inputCode4, inputCode3);
        setBackspaceListener(inputCode5, inputCode4);
        setBackspaceListener(inputCode6, inputCode5);

        // Resend OTP Click Listener
        textResendOTP.setOnClickListener(v -> {
            if (!isTimerRunning) {
                // Implement API call or functionality to resend OTP
                Toast.makeText(OTPScreen.this, "OTP resent", Toast.LENGTH_SHORT).show();
                // You might call an API to resend OTP here
                startTimer();
            } else {
                Toast.makeText(OTPScreen.this, "Please wait before requesting a new OTP", Toast.LENGTH_SHORT).show();
            }
        });

        // Verify OTP Button Click Listener
        verifyButton.setOnClickListener(v -> {
            String otpCode = inputCode1.getText().toString() + inputCode2.getText().toString()
                    + inputCode3.getText().toString() + inputCode4.getText().toString()
                    + inputCode5.getText().toString() + inputCode6.getText().toString();

            // Validate OTP and navigate to Navbotdailog screen
            if (isValidOTP(otpCode)) {
                Intent intent = new Intent(OTPScreen.this, Navbotdailog.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(OTPScreen.this, "Invalid OTP, try again", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to validate the OTP (replace with actual validation logic)
    private boolean isValidOTP(String otpCode) {
        return otpCode.length() == 6; // Example: Check if the OTP is 6 digits long
    }

    private void addTextWatcher(final EditText currentEditText, final EditText nextEditText, final EditText previousEditText) {
        currentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1 && nextEditText != null) {
                    nextEditText.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void setBackspaceListener(final EditText currentEditText, final EditText previousEditText) {
        currentEditText.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN && currentEditText.getText().length() == 0) {
                if (previousEditText != null) {
                    previousEditText.requestFocus();
                    previousEditText.setSelection(previousEditText.getText().length());
                }
                return true;
            }
            return false;
        });
    }

    private void startTimer() {
        isTimerRunning = true;
        textResendOTP.setTextColor(getResources().getColor(R.color.disabledColor)); // Change color to indicate disabled state
        countDownTimer = new CountDownTimer(60000, 1000) { // 60 seconds timer
            @Override
            public void onTick(long millisUntilFinished) {
                textResendOTP.setText("Resend OTP in " + millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                textResendOTP.setText("Resend OTP");
                textResendOTP.setTextColor(getResources().getColor(R.color.enabledColor)); // Restore color
                isTimerRunning = false;
            }
        }.start();
    }
}
