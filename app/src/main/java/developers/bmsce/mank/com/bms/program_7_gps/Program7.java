package developers.bmsce.mank.com.bms.program_7_gps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import developers.bmsce.mank.com.bms.R;

public class Program7 extends AppCompatActivity {
    Button btnShowLocation;


    GPStrace gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program7);
        btnShowLocation = (Button) findViewById(R.id.Show_Location);
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPStrace(Program7.this);
                if (gps.getLocation() != null) {
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    Toast.makeText(getApplicationContext(), "Your Location is \nLat:" + latitude + "\nLong:" + longitude, Toast.LENGTH_LONG).show();
                } else { //
                    // gps.showSettingAlert();
                }
            }
        });
    }
}

