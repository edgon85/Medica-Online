package com.edgon.medicahospitalaria.views.fragments;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.edgon.medicahospitalaria.R;
import com.edgon.medicahospitalaria.views.views.ListMedic;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.edgon.medicahospitalaria.R.id.map;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements OnMapReadyCallback {


    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;
    private int REQUESY_CODE = 1;

    private Context mContext;
    private SupportMapFragment supportMapFragment;
    private GoogleMap mMap;
    private MarkerOptions currentPositionMarker = null;
    private Marker currentLocationMarker;
    Place place;


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.btn_medico)
    Button btnMedico;
    Unbinder unbinder;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);
        showToolBar("Medica Online",false,view);


        ((SupportMapFragment) getChildFragmentManager().findFragmentById(map)).getMapAsync(this);
        /*SupportMapFragment mapFragment =
                (SupportMapFragment) getActivity()
                        .getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_medico)
    public void btnMedic() {
        Intent intent = new Intent(getActivity(), ListMedic.class);
        startActivity(intent);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        //mMap.addMarker(new MarkerOptions().position(new LatLng(19.432600, -99.135132)).title("Marker"));

        googleMap.clear();

        if (place != null){
            Log.e("MyLog","Entre");
            LatLng marker = new LatLng(place.getLatLng().latitude, place.getLatLng().longitude);
            googleMap.addMarker(new MarkerOptions().position(marker).title(place.getName() + ""));
            //  googleMap.addMarker(new MarkerOptions().position(new LatLng(19.432600, -99.135132)).title("Marker"));

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(marker)
                    .zoom(16).build();

            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }else{

            Log.e("MyLog","ELSE");
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUESY_CODE);
            }
        }
    }

    private void showToolBar(String title, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
