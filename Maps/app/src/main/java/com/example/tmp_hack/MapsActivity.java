package com.example.tmp_hack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    List<String> listTop10 = new ArrayList<String>();

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {



        listTop10.add(listTop10.size(),"53.128688/18.0209104");
        listTop10.add(listTop10.size(),"53.138698#18.0209104");
        listTop10.add(listTop10.size(),"53.148708#18.0209104");
        listTop10.add(listTop10.size(),"53.158718#18.0209104");
        listTop10.add(listTop10.size(),"53.168738#18.0209104");
        listTop10.add(listTop10.size(),"53.128748#18.0309104");
        listTop10.add(listTop10.size(),"53.128758#18.0409104");
        listTop10.add(listTop10.size(),"53.128768#18.0509104");
        listTop10.add(listTop10.size(),"53.128788#18.0609104");
        listTop10.add(listTop10.size(),"53.128788#18.0709104");

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        if (location != null)
        {


            LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
            mMap = googleMap;

            // Add a marker in Sydney and move the camera


            for(int i = 0 ; i<listTop10.size(); i++)
            {
                try {
                    int findSymbol = listTop10.get(i).indexOf("#");
                    Double getLatitude=Double.valueOf(listTop10.get(i).substring(0,findSymbol)).doubleValue();

                    Double getLongitude=Double.valueOf(listTop10.get(i).substring(findSymbol+1,listTop10.get(i).length())).doubleValue();

                    //Toast.makeText(getApplicationContext(), getLatitude.toString(),Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), getLongitude.toString(),Toast.LENGTH_SHORT).show();
                    LatLng position = new LatLng(getLatitude, getLongitude);
                    mMap.addMarker(new MarkerOptions().position(position));
                } catch(Exception e) {

                    //Toast.makeText(getApplicationContext(), aa,Toast.LENGTH_SHORT).show();
                }
            }


            mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 12));

        }


    }


}
