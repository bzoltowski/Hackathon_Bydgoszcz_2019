//MainActivity
##########################################


import android.content.ContentResolver;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private LocationManager locationMangaer = null;
    private LocationListener locationListener = null;
    private Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = displayGpsStatus();
                if (flag) {

                    Toast.makeText(getApplicationContext(), "Wait..", Toast.LENGTH_SHORT).show();

                    locationListener = new MyLocationListener();

                    locationMangaer.requestLocationUpdates(LocationManager
                            .GPS_PROVIDER, 5000, 10, locationListener);

                } else {
                    Toast.makeText(getApplicationContext(), "Włącz lokalizacje!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        locationMangaer = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);

    }

    /*----Method to Check GPS is enable or disable ----- */
    private Boolean displayGpsStatus() {
        ContentResolver contentResolver = getBaseContext()
                .getContentResolver();
        boolean gpsStatus = Settings.Secure
                .isLocationProviderEnabled(contentResolver,
                        LocationManager.GPS_PROVIDER);
        if (gpsStatus) {
            return true;

        } else {
            return false;
        }
    }


    /*----------Listener class to get coordinates ------------- */
    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {


            String latitude= String.valueOf(loc.getLatitude());
            String longitude= String.valueOf(loc.getLongitude());
            String adres = null;
            /*----------to get City-Name from coordinates ------------- */
            String cityName=null;
            JSONObject jsonObject = new JSONObject();
            Geocoder gcd = new Geocoder(getBaseContext(),
                    Locale.getDefault());
            List<Address> addresses;
            Address address = null;
            try {
                addresses = gcd.getFromLocation(loc.getLatitude(), loc
                        .getLongitude(), 1);
                if (addresses.size() > 0)
                {
                    address = addresses.get(0);
                    adres = String.valueOf(address.getAddressLine(0));

                    jsonObject.put("Latitude",latitude);
                    jsonObject.put("Longitude",longitude);
                    jsonObject.put("Address",adres);
                }
                else
                {
                    jsonObject.put("Latitude",latitude);
                    jsonObject.put("Longitude",longitude);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(),jsonObject.toString(),Toast.LENGTH_LONG).show();

        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onStatusChanged(String provider,
                                    int status, Bundle extras) {
            // TODO Auto-generated method stub
        }
    }
}












##########################################

//Manifest

##########################################

<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
