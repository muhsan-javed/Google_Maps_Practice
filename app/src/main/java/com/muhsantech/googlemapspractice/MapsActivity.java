package com.muhsantech.googlemapspractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.muhsantech.googlemapspractice.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.ArrayList;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
//        LatLng BrohilatLng = new LatLng(27.592707023074293, 67.99598586120044);
        LatLng MyHome = new LatLng(27.592707023074293, 67.99598586120044);
        LatLng Masjid = new LatLng(27.592954251471973, 67.99580040398358);

//        MarkerOptions markerOptions = new MarkerOptions().position(BrohilatLng).title("My Home");
//        mMap.addMarker(markerOptions);
        mMap.addMarker(new MarkerOptions().position(MyHome).title("My Home"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MyHome));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MyHome, 16f));


        //Circle
       /* mMap.addCircle(new CircleOptions()
                .center(MyHome)
                .radius(100)
                .fillColor(Color.GREEN)
                .strokeColor(Color.DKGRAY));*/

        // Polygon
        /*mMap.addPolygon(new PolygonOptions().add(new LatLng(27.592954251471973, 67.99580040398358),
                new LatLng(28.592954251471973, 68.99580040398358),
                new LatLng(27.592954251471973, 68.99580040398358),
                new LatLng(27.592954251471973, 67.99580040398358),
                new LatLng(27.592954251471973, 67.99580040398358))
                .fillColor(Color.YELLOW)
                .strokeColor(Color.BLUE));
*/
        // Image Overlay SetImage
//        mMap.addGroundOverlay(new GroundOverlayOptions().position(MyHome, 100f, 100f)
//                .image(BitmapDescriptorFactory.fromResource(R.drawable.premium))
//                .clickable(true));


        // You Can set Buttons Images setOnClickListeners
        /*mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMapType(GoogleMap.MAP_TYPE_NONE);*/

        //
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                mMap.addMarker(new MarkerOptions().position(latLng).title("Click here"));
                Geocoder geocoder = new Geocoder(MapsActivity.this);
                try {
                    ArrayList<Address> arrAdress = (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    Log.d("Addr", arrAdress.get(0).getAddressLine(0));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //GeoCode Class
        /*Geocoder geocoder = new Geocoder(this);
        try {
            ArrayList<Address> arrAdress = (ArrayList<Address>) geocoder.getFromLocation(27.592954251471973, 67.99580040398358, 1);
            Log.d("Addr", arrAdress.get(0).getAddressLine(0));

        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}