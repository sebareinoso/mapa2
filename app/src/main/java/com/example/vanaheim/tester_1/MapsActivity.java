package com.example.vanaheim.tester_1;

import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Circle circle = null;

    public MapsActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMyLocationEnabled(true);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Location locale = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);

        final LatLng localizacion = new LatLng(locale.getLatitude(), locale.getLongitude());

        Button botonRadio = (Button) findViewById(R.id.radioMetros);
        botonRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localizacion, 20));

                Circle circulo = getCirculoMetros();

                if (circulo == null) {
                    circulo = mMap.addCircle(new CircleOptions()
                            .center(localizacion)
                            .radius(40)
                            .strokeColor(Color.RED)
                            .fillColor(Color.argb(50, 255, 0, 0)));
                    circulo.setVisible(true);
                    setCirculoMetros(circulo);
                } else {
                    circulo.setVisible(false);
                    circulo.remove();
                    setCirculoMetros(null);
                }
            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng coordenada) {

                if (coordenada != localizacion) {
                    mMap.addMarker(new MarkerOptions().position(coordenada).title("Nueva localizacion"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordenada, 15));
                }
            }
        });

        Double latitudes[] = {-33.4501044, -70.6858881, -33.4497262, -70.6877551};

        for (int i = 0; i < latitudes.length; i = i + 2) {
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(latitudes[i], latitudes[i + 1]))
                    .title(Integer.toString(i))
            );
        }

        //LatLng usach = new LatLng(-33.4501044,-70.6858881);
        //mMap.addMarker(new MarkerOptions().position(usach).title("Usachita :3"));

        //LatLng usach2 = new LatLng(-33.4497262,-70.6877551);
        //mMap.addMarker(new MarkerOptions().position(usach2).title("Info"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localizacion, 15));
    }

    public Circle getCirculoMetros() {
        return this.circle;
    }

    public void setCirculoMetros(Circle circle) {
        this.circle = circle;
    }
}