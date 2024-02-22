package com.example.laba19.UI;

import static com.example.laba19.data.Constants.APP_DEFAULT_TEXT_CALCULATION;
import static com.example.laba19.utils.Utils.convertToReadableNumber;
import static com.example.laba19.utils.Utils.moveToActivity;
import static com.example.laba19.utils.Utils.showNotification;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.laba19.R;
import com.example.laba19.databinding.ActivityMainBinding;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sum.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doSum();
        });
        binding.sub.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doSub();
        });
        binding.mul.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doMul();
        });
        binding.div.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doDiv();
        });
        binding.pow.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doPow();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        moveToActivity(this, item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void doSum() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());
        float num2 = Float.parseFloat(binding.num2.getText().toString());

        String result = (num1 + " + " + num2 + " = " + (num1+num2));
        showNotification(APP_DEFAULT_TEXT_CALCULATION, result, R.drawable.baseline_calculate_24, this, R.id.sum);
        binding.result.setText(result);
    }

    private void doSub() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());
        float num2 = Float.parseFloat(binding.num2.getText().toString());

        String result = (num1 + " - " + num2 + " = " + (num1-num2));
        showNotification(APP_DEFAULT_TEXT_CALCULATION, result, R.drawable.baseline_calculate_24, this, R.id.sub);
        binding.result.setText(result);
    }

    private void doMul() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());
        float num2 = Float.parseFloat(binding.num2.getText().toString());

        String result = (num1 + " * " + num2 + " = " + (num1*num2));
        showNotification(APP_DEFAULT_TEXT_CALCULATION, result, R.drawable.baseline_calculate_24, this, R.id.mul);
        binding.result.setText(result);
    }

    private void doDiv() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());
        float num2 = Float.parseFloat(binding.num2.getText().toString());

        if (num2 == 0.0F) {
            Toast.makeText(this, "Can not divide by 0.", Toast.LENGTH_SHORT).show();
            return;
        }

        String result = (num1 + " / " + num2 + " = " + (num1/num2));
        showNotification(APP_DEFAULT_TEXT_CALCULATION, result, R.drawable.baseline_calculate_24, this, R.id.div);
        binding.result.setText(result);
    }

    private void doPow() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());
        float num2 = Float.parseFloat(binding.num2.getText().toString());

        String result = (num1 + "^" + num2 + " = " + Math.pow(num1, num2));
        showNotification(APP_DEFAULT_TEXT_CALCULATION, result, R.drawable.baseline_calculate_24, this, R.id.pow);
        binding.result.setText(result);
    }


    public void clearTextNum1(View view) {
        convertToReadableNumber(binding.num1);
    }

    public void clearTextNum2(View view) {
        convertToReadableNumber(binding.num2);
    }

    public void confirmNumbers() {
        clearTextNum1(binding.num1);
        clearTextNum2(binding.num2);
    }

    private boolean performEmptinessCheck() {
        if (binding.num1.getText().toString().isEmpty() || binding.num2.getText().toString().isEmpty()) {
            Toast.makeText(this, "At least one of the number fields is empty.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}