package com.example.laba19.UI;

import static com.example.laba19.data.Constants.APP_DEFAULT_TEXT_LOGARITHMIC;
import static com.example.laba19.data.Constants.APP_DEFAULT_TEXT_TRIGONOMETRIC;
import static com.example.laba19.data.Constants.APP_MEASUREMENT_DEGREES_TO_PI_RADIANS;
import static com.example.laba19.data.Constants.APP_MEASUREMENT_GRADIANS_TO_PI_RADIANS;
import static com.example.laba19.data.Constants.APP_MEASUREMENT_TYPES_COUNT;
import static com.example.laba19.data.Constants.APP_MEASUREMENT_TYPE_DEGREES;
import static com.example.laba19.data.Constants.APP_MEASUREMENT_TYPE_GRADIANS;
import static com.example.laba19.data.Constants.APP_MEASUREMENT_TYPE_RADIANS;
import static com.example.laba19.utils.Utils.getMeasurementString;
import static com.example.laba19.utils.Utils.moveToActivity;
import static com.example.laba19.utils.Utils.convertToReadableNumber;
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
import com.example.laba19.databinding.ActivityTertiaryBinding;

@SuppressLint("SetTextI18n")
public class TertiaryActivity extends AppCompatActivity {
    private ActivityTertiaryBinding binding;

    private int currentMeasurementType = APP_MEASUREMENT_TYPE_DEGREES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTertiaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sin.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doSin();
        });
        binding.cos.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doCos();
        });
        binding.tg.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doTg();
        });
        binding.ctg.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doCtg();
        });
        binding.arcsin.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doArcSin();
        });
        binding.arctg.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doArcTg();
        });
        binding.lg.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doLg();
        });
        binding.ln.setOnClickListener(view -> {
            if (!performEmptinessCheck()) {
                return;
            }
            confirmNumbers();
            doLn();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.measurement_menu, menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.degreesButton) {
            currentMeasurementType = (currentMeasurementType + 1) % APP_MEASUREMENT_TYPES_COUNT;
            item.setTitle(getString(getMeasurementString(currentMeasurementType)));
        } else {
            moveToActivity(this, item.getItemId());
        }
        return super.onOptionsItemSelected(item);
    }

    public void clearTextNum1(View view) {
        convertToReadableNumber(binding.num1);
    }

    private void doSin() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());

        float actualVal = getValueBasedOnMeasurementType(num1, true);

        String result = ("sin(" + num1 + ") = " + Math.sin(actualVal) + " (" + getString(getMeasurementString(currentMeasurementType)) + ")");
        showNotification(APP_DEFAULT_TEXT_TRIGONOMETRIC, result, R.drawable.baseline_view_in_ar_24, this, R.id.sin);
        binding.result.setText(result);
    }

    private void doCos() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());

        float actualVal = getValueBasedOnMeasurementType(num1, true);

        String result = ("cos(" + num1 + ") = " + Math.cos(actualVal) + " (" + getString(getMeasurementString(currentMeasurementType)) + ")");
        showNotification(APP_DEFAULT_TEXT_TRIGONOMETRIC, result, R.drawable.baseline_view_in_ar_24, this, R.id.cos);
        binding.result.setText(result);
    }

    private void doTg() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());

        float actualVal = getValueBasedOnMeasurementType(num1, true);

        String result = ("tg(" + num1 + ") = " + Math.tan(actualVal) + " (" + getString(getMeasurementString(currentMeasurementType)) + ")");
        showNotification(APP_DEFAULT_TEXT_TRIGONOMETRIC, result, R.drawable.baseline_view_in_ar_24, this, R.id.tg);
        binding.result.setText(result);
    }

    private void doCtg() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());

        float actualVal = getValueBasedOnMeasurementType(num1, true);

        String result = ("ctg(" + num1 + ") = " + Math.pow(Math.tan(actualVal), -1) + " (" + getString(getMeasurementString(currentMeasurementType)) + ")");
        showNotification(APP_DEFAULT_TEXT_TRIGONOMETRIC, result, R.drawable.baseline_view_in_ar_24, this, R.id.ctg);
        binding.result.setText(result);
    }

    private void doArcSin() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());

        float num2 = (float) Math.asin(num1);
        num2 = getValueBasedOnMeasurementType(num2, false);

        String result = ("arcsin(" + num1 + ") = " + num2 + " (" + getString(getMeasurementString(currentMeasurementType)) + ")");
        showNotification(APP_DEFAULT_TEXT_TRIGONOMETRIC, result, R.drawable.baseline_view_in_ar_24, this, R.id.arcsin);
        binding.result.setText(result);
    }

    private void doArcTg() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());

        float num2 = (float) Math.atan(num1);
        num2 = getValueBasedOnMeasurementType(num2, false);

        String result = ("arctg(" + num1 + ") = " + num2 + " (" + getString(getMeasurementString(currentMeasurementType)) + ")");
        showNotification(APP_DEFAULT_TEXT_TRIGONOMETRIC, result, R.drawable.baseline_view_in_ar_24, this, R.id.arctg);
        binding.result.setText(result);
    }

    private void doLg() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());

        String result = ("lg(" + num1 + ") = " + Math.log10(num1));
        showNotification(APP_DEFAULT_TEXT_LOGARITHMIC, result, R.drawable.baseline_view_in_ar_24, this, R.id.lg);
        binding.result.setText(result);
    }

    private void doLn() {
        float num1 = Float.parseFloat(binding.num1.getText().toString());

        String result = ("ln(" + num1 + ") = " + Math.log(num1));
        showNotification(APP_DEFAULT_TEXT_LOGARITHMIC, result, R.drawable.baseline_view_in_ar_24, this, R.id.ln);
        binding.result.setText(result);
    }

    public void confirmNumbers() {
        clearTextNum1(binding.num1);
        if (Float.parseFloat(binding.num1.getText().toString()) < 0) {
            Toast.makeText(this, "This activity can not accept negative numbers.", Toast.LENGTH_SHORT).show();
            binding.num1.setText("0");
        }
    }

    private float getValueBasedOnMeasurementType(float val, boolean functionInput) {
        if (currentMeasurementType == APP_MEASUREMENT_TYPE_RADIANS) {
            return val;
        } else {
            int toPiRadiansCoefficient;
            if (currentMeasurementType == APP_MEASUREMENT_TYPE_DEGREES) {
                toPiRadiansCoefficient = APP_MEASUREMENT_DEGREES_TO_PI_RADIANS;
            } else if (currentMeasurementType == APP_MEASUREMENT_TYPE_GRADIANS) {
                toPiRadiansCoefficient = APP_MEASUREMENT_GRADIANS_TO_PI_RADIANS;
            } else {
                throw(new RuntimeException("Unknown measurement type."));
            }

            if (functionInput) {
                return ((float)(val * Math.PI / toPiRadiansCoefficient));
            } else {
                return ((float)(val * toPiRadiansCoefficient / Math.PI));
            }
        }
    }

    private boolean performEmptinessCheck() {
        if (binding.num1.getText().toString().isEmpty()) {
            Toast.makeText(this, "The number field is empty.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}