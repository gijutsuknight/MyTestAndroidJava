package my.test.androidjava;

import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DeviceInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_device_info);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Populate all device information fields
        populateDeviceInfo();
    }

    private void populateDeviceInfo() {
        // Device Information
        TextView deviceModelValue = findViewById(R.id.deviceModelValue);
        deviceModelValue.setText(Build.MODEL);

        TextView manufacturerValue = findViewById(R.id.manufacturerValue);
        manufacturerValue.setText(Build.MANUFACTURER);

        TextView brandValue = findViewById(R.id.brandValue);
        brandValue.setText(Build.BRAND);

        // System Information
        TextView androidVersionValue = findViewById(R.id.androidVersionValue);
        androidVersionValue.setText(Build.VERSION.RELEASE);

        TextView sdkVersionValue = findViewById(R.id.sdkVersionValue);
        sdkVersionValue.setText(String.valueOf(Build.VERSION.SDK_INT));

        TextView apiLevelValue = findViewById(R.id.apiLevelValue);
        apiLevelValue.setText(String.valueOf(Build.VERSION.SDK_INT));

        // Device Details
        TextView deviceIdValue = findViewById(R.id.deviceIdValue);
        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        deviceIdValue.setText(androidId != null ? androidId : "Unknown");

        TextView deviceNameValue = findViewById(R.id.deviceNameValue);
        deviceNameValue.setText(Build.DEVICE);

        TextView hardwareValue = findViewById(R.id.hardwareValue);
        hardwareValue.setText(Build.HARDWARE);

        TextView productValue = findViewById(R.id.productValue);
        productValue.setText(Build.PRODUCT);

        // Build Information
        TextView buildIdValue = findViewById(R.id.buildIdValue);
        buildIdValue.setText(Build.ID);

        TextView buildTypeValue = findViewById(R.id.buildTypeValue);
        buildTypeValue.setText(Build.TYPE);

        TextView fingerprintValue = findViewById(R.id.fingerprintValue);
        fingerprintValue.setText(Build.FINGERPRINT);
    }
}

