package com.example.laba19.utils;

import static android.content.Context.NOTIFICATION_SERVICE;
import static android.icu.number.NumberFormatter.with;
import static androidx.core.content.ContextCompat.getSystemService;
import static com.example.laba19.data.Constants.APP_CHANNEL_ID;
import static com.example.laba19.data.Constants.APP_MEASUREMENT_TYPE_DEGREES;
import static com.example.laba19.data.Constants.APP_MEASUREMENT_TYPE_GRADIANS;
import static com.example.laba19.data.Constants.APP_MEASUREMENT_TYPE_RADIANS;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.laba19.R;
import com.example.laba19.UI.MainActivity;
import com.example.laba19.UI.SecondaryActivity;
import com.example.laba19.UI.TertiaryActivity;

public class Utils {
    public static void convertToReadableNumber(EditText editText) {
        String num = editText.getText().toString();
        Log.d("EDITTEXT_CHECKER", num);
        if (num.isEmpty()) {
            return;
        }

        if (num.charAt(0) == '.') {
            if (num.length() == 1) {
                num = "";
            } else {
                num = "0" + num;
            }
        }

        editText.setText(num);
    }

    public static void moveToActivity(AppCompatActivity currActivity, int itemId) {
        Class newActivity;
        if (R.id.calcButton == itemId) {
            newActivity = MainActivity.class;
        } else if (R.id.equalButton == itemId) {
            newActivity = SecondaryActivity.class;
        } else if (R.id.trigButton == itemId) {
            newActivity = TertiaryActivity.class;
        } else {
            throw(new RuntimeException("Unknown menu button was pressed."));
        }

        if (currActivity.getClass() == newActivity) {
            Log.d("APP_DEBUGGER", "This activity is already active.");
            return;
        }
        Intent i = new Intent(currActivity.getApplicationContext(), newActivity);
        currActivity.startActivity(i);
        currActivity.finish();
    }

    public static int getMeasurementString(int measurementType) {
        if (measurementType == APP_MEASUREMENT_TYPE_DEGREES) {
            return R.string.measure_type_degree;
        } else if (measurementType == APP_MEASUREMENT_TYPE_RADIANS) {
            return R.string.measure_type_radian;
        } else if (measurementType == APP_MEASUREMENT_TYPE_GRADIANS) {
            return R.string.measure_type_gradian;
        } else {
            throw(new RuntimeException("Unknown measurement type was chosen."));
        }
    }

    public static void showNotification(String defaultText, String message, int icon, Context context, int notificationId) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, APP_CHANNEL_ID)
                .setSmallIcon(icon)
                .setContentTitle("Calculator notification")
                .setContentText(defaultText)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(message))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        Notification notification = builder.build();

        NotificationManager notificationManager = getSystemService(context, NotificationManager.class);
        assert notificationManager != null;
        notificationManager.notify(notificationId, notification);
    }
}
