package com.sigmarho.guideistanbul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity
    implements GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    ArrayList<place> places = new ArrayList<place>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        definePlaces();
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void definePlaces(){


        places.add(new place(new LatLng(30, 30), "Baslik", "T aciklama", "Detay Aciklama", new int[]{R.drawable.ic_launcher, R.drawable.dummy_pic2, R.drawable.dummy_pic}));
        places.add(new place(new LatLng(10, 10), "Baslik2", "T aciklama2", "Detay Aciklama2", new int[]{R.drawable.ic_launcher, R.drawable.dummy_pic2, R.drawable.dummy_pic}));
        places.add(new place(new LatLng(20, 20), "Baslik3", "T aciklama3", "Detay Aciklama3", new int[]{R.drawable.ic_launcher, R.drawable.dummy_pic2, R.drawable.dummy_pic}));


    }

    private place matchByPosition(ArrayList<place> listToMatch, LatLng positionToMatch){
        for (int i=0; i<listToMatch.size(); i++){
            if(listToMatch.get(i).getLatlon().equals(positionToMatch)) return listToMatch.get(i);
        }

        return null;
    }
    /**
     * This is where we can add places or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */





    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        mMap.setOnInfoWindowClickListener(this);
        for(int i=0; i< places.size(); i++){
            place markerIter = places.get(i);
            mMap.addMarker(new MarkerOptions().position(markerIter.getLatlon()).title(markerIter.getTitle()).snippet(markerIter.getBasDesc()));
        }


    }

    //TO DO: implement different type of places

    @Override
    public void onInfoWindowClick(Marker marker) {


        place placeI = matchByPosition(places,marker.getPosition());

        if (placeI != null) {
            Intent i = new Intent(getApplicationContext(), PlaceInfo.class);
            i.putExtra("title", placeI.getTitle());
            i.putExtra("bascDesc", placeI.getBasDesc());
            i.putExtra("detDesc", placeI.getDetDesc());

            //Need to implement en error mechanism here in case there are not 3 pics
            i.putExtra("pic0", placeI.getPics()[0]);
            i.putExtra("pic1", placeI.getPics()[1]);
            i.putExtra("pic2", placeI.getPics()[2]);
            startActivity(i);
        }

        //Need to implement an error mechanism here instead of print
        else {
            System.out.println("Ugur: place is null");
        }
    }
}